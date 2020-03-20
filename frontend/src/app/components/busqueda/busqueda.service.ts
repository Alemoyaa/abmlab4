import { NoticiaService } from './../../services/noticia.service';
import { Noticia } from './../../models/noticia';
import {Injectable, PipeTransform} from '@angular/core';

import {BehaviorSubject, Observable, of, Subject} from 'rxjs';

import {DecimalPipe} from '@angular/common';
import {debounceTime, delay, switchMap, tap} from 'rxjs/operators';
import {SortDirection} from './sortable.directive';

interface SearchResult {
  total: number;
  noticia: Noticia[];
}

interface State {
  page: number;
  pageSize: number;
  searchTerm: string;
  sortColumn: string;
  sortDirection: SortDirection;
}

const compare = (v1: string, v2: string) => v1 < v2 ? -1 : v1 > v2 ? 1 : 0;

function sort(noticias: Noticia[], column: string, direction: string): Noticia[] {
  if (direction === '') {
    return noticias;
  } else {
    return [...noticias].sort((a, b) => {
      const res = compare(a[column], b[column]);
      return direction === 'asc' ? res : -res;
    });
  }
}

function matches(noticia: Noticia, term: string, pipe: PipeTransform) {
  return noticia.titulo.toLowerCase().includes(term.toLowerCase())
    || pipe.transform(noticia.fecha).includes(term);
}

@Injectable({providedIn: "root"})

export class BusquedaService {

  noticias: Noticia[];

  private _loading$ = new BehaviorSubject<boolean>(true);
  private _search$ = new Subject<void>();
  private _noticias$ = new BehaviorSubject<Noticia[]>([]);
  private _total$ = new BehaviorSubject<number>(0);

  private _state: State = {
    page: 1,
    pageSize: 4,
    searchTerm: '',
    sortColumn: '',
    sortDirection: ''
  };

  constructor(private pipe: DecimalPipe, private nService: NoticiaService) {
    this._search$.pipe(
      tap(() => this._loading$.next(true)),
      debounceTime(200),
      switchMap(() => this._search()),
      delay(200),
      tap(() => this._loading$.next(false))
    ).subscribe(result => {
      this._noticias$.next(result.noticia);
      this._total$.next(result.total);
    });

    nService.getAll().subscribe(datos => {
      this.noticias = datos
    });

    this._search$.next();
  }

  private _set(patch: Partial<State>) {
    Object.assign(this._state, patch);
    this._search$.next();
  }

  private _search(): Observable<SearchResult> {
    const {sortColumn, sortDirection, pageSize, page, searchTerm} = this._state;

    // 1. sort
    let noticia = sort(this.noticias, sortColumn, sortDirection); // para ordenarlo

    // 2. filter
    noticia = noticia.filter(noticia =>
      matches(noticia, searchTerm, this.pipe)
    );
    const total = noticia.length;

    // 3. paginate
    noticia = noticia.slice((page - 1) * pageSize, (page - 1) * pageSize + pageSize);
    return of({noticia, total});
  }

  get noticias$() { return this._noticias$.asObservable(); }
  get total$() { return this._total$.asObservable(); }
  get loading$() { return this._loading$.asObservable(); }
  get page() { return this._state.page; }
  get pageSize() { return this._state.pageSize; }
  get searchTerm() { return this._state.searchTerm; }

  set page(page: number) { this._set({page}); }
  set pageSize(pageSize: number) { this._set({pageSize}); }
  set searchTerm(searchTerm: string) { this._set({searchTerm}); }
  set sortColumn(sortColumn: string) { this._set({sortColumn}); }
  set sortDirection(sortDirection: SortDirection) { this._set({sortDirection}); }
}
