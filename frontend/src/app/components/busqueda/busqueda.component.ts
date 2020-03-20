import { DecimalPipe } from '@angular/common';
import { NgbdSortableHeader, SortEvent } from './sortable.directive';
import { Noticia } from './../../models/noticia';
import { Observable } from 'rxjs';
import { Component, OnInit, ViewChildren, QueryList } from '@angular/core';
import { BusquedaService } from './busqueda.service';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css'],
  providers: [BusquedaService, DecimalPipe]
})
export class BusquedaComponent implements OnInit {

  noticias$: Observable<Noticia[]>;
  total$: Observable<number>;

  @ViewChildren(NgbdSortableHeader) headers: QueryList<NgbdSortableHeader>;

  constructor(public service: BusquedaService) {
    this.noticias$ = service.noticias$;
    this.total$ = service.total$;
  }

  ngOnInit():void{

  }

  onSort({column, direction}: SortEvent) {
    // resetting other headers
    this.headers.forEach(header => {
      if (header.sortable !== column) {
        header.direction = '';
      }
    });

    this.service.sortColumn = column;
    this.service.sortDirection = direction;
  }

}
