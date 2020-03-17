import { PostPayLoad } from "./../components/tiny/post-payload";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: "root"
})
export class NoticiaService {
  constructor(private httpClient: HttpClient) {}

  addNoticia(postPayload: PostPayLoad) {
    return this.httpClient.post(
      "http://localhost:8080/api/v1/noticia/",
      postPayload
    );
  }
}
