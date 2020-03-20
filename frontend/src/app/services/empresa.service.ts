import { Empresa } from "./../models/empresa";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class EmpresaService {
  constructor(private http: HttpClient) {}

  miUrl: string = "http://localhost:8080/api/v1/empresa/";

  getAll(): Observable<Empresa[]> {
    return this.http.get<Empresa[]>(this.miUrl);
  }

  getOne(id: number): Observable<Empresa> {
    return this.http.get<Empresa>(this.miUrl + id); //lo casteo para que me traiga personas
  }

  delete(id: number): Observable<any> {
    //De tipo number
    //console.log(id);
    return this.http.delete(this.miUrl + id);
  }

  post(empresa: Empresa): Observable<Empresa> {
    return this.http.post<Empresa>(this.miUrl, empresa);
  }

  put(id: number, empresa: Empresa): Observable<Empresa> {
    return this.http.put<Empresa>(this.miUrl + id, empresa);
  }
}
