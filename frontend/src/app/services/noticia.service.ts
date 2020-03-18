import { PostPayLoad } from "./../components/tiny/post-payload";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Empresa } from "../models/empresa";
import { Noticia } from "../models/noticia";

@Injectable({
  providedIn: "root"
})

export class NoticiaService {
  constructor(private httpClient: HttpClient) {}

  miUrl: string = "localhost:8080/api/v1/noticia/";

  getAll(): Observable<Empresa[]> {
    return this.httpClient.get<Empresa[]>(this.miUrl);
  }

  getOne(id: number): Observable<Noticia> {
    return this.httpClient.get<Noticia>(this.miUrl + id); //lo casteo para que me traiga personas
  }

  delete(id: number): Observable<any> {
    //De tipo number
    //console.log(id);
    return this.httpClient.delete(this.miUrl + id);
  }

  post(noticia: Noticia): Observable<Noticia> {
    return this.httpClient.post<Noticia>(this.miUrl, noticia);
  }

  put(id: number, noticia: Noticia): Observable<Noticia> {
    return this.httpClient.put<Noticia>(this.miUrl + id, noticia);
  }
}
