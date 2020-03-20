import { Noticia } from "./../models/noticia";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class NoticiaService {
  constructor(private http: HttpClient) {}

  miUrl: string = "http://localhost:8080/api/v1/noticia/";

  getAll(): Observable<Noticia[]> {
    return this.http.get<Noticia[]>(this.miUrl);
  }

  getOne(id: number): Observable<Noticia> {
    return this.http.get<Noticia>(this.miUrl + id); //lo casteo para que me traiga personas
  }

  delete(id: number): Observable<any> {
    //De tipo number
    //console.log(id);
    return this.http.delete(this.miUrl + id);
  }

  post(noticia: Noticia): Observable<Noticia> {
    return this.http.post<Noticia>(this.miUrl, noticia);
  }

  put(id: number, noticia: Noticia): Observable<Noticia> {
    return this.http.put<Noticia>(this.miUrl + id, noticia);
  }
}
