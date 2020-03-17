import { NoticiaService } from "./../../services/noticia.service";
import { PostPayLoad } from "./post-payload";
import { FormControl, FormGroup } from "@angular/forms";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-tiny",
  templateUrl: "./tiny.component.html",
  styleUrls: ["./tiny.component.css"]
})
export class TinyComponent implements OnInit {
  addPostForm: FormGroup;
  postPayload: PostPayLoad;
  title = new FormControl("");
  body = new FormControl("");

  constructor(private noticiaService: NoticiaService) {
    this.addPostForm = new FormGroup({
      title: this.title,
      body: this.body
    });
    this.postPayload = {
      id: "",
      content: "",
      title: ""
    };
  }

  ngOnInit(): void {}

  mostrarHTML() {
    alert(this.addPostForm.get("body").value);
  }

  addPost() {
    this.postPayload.content = this.addPostForm.get("body").value;
    this.postPayload.title = this.addPostForm.get("title").value;
    // this.noticiaService.addNoticia(this.postPayload).subscribe(
    //   data => {
    //     console.log("Noticia creada");
    //   },
    //   error => {
    //     console.log("algo salio mal");
    //   }
    // );
  }
}
