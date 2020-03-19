import { Noticia } from "./../../models/noticia";
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
  noticia: Noticia = {
    id: null,
    titulo: null,
    resumen: null,
    imagen: null,
    html: null,
    publicada: null,
    fecha: null,
    idEmpresa: null
  };
  titulo = new FormControl("");
  body = new FormControl("");
  resumen = new FormControl("");
  imagen = new FormControl("");
  idEmpresa = new FormControl("");

  constructor(private noticiaService: NoticiaService) {
    this.addPostForm = new FormGroup({
      titulo: this.titulo,
      body: this.body,
      resumen: this.resumen,
      img: this.imagen,
      idEmpresa: this.idEmpresa
    });
  }

  ngOnInit(): void {}

  mostrarHTML() {
    alert(this.addPostForm.get("body").value);
  }

  postNoticia() {
    let noticiaData = {
      id: null,
      titulo: null,
      resumen: null,
      imagen: null,
      html: null,
      publicada: null,
      fecha: null,
      idEmpresa: null
    };

    let date = new Date();
    let fechaActual =
      date.getDate() + "/" + date.getMonth() + 1 + "/" + date.getFullYear();

    console.log(fechaActual);

    noticiaData.titulo = this.addPostForm.get("titulo").value;
    noticiaData.resumen = this.addPostForm.get("resumen").value;
    noticiaData.imagen = this.addPostForm.get("img").value;
    noticiaData.html = this.addPostForm.get("body").value;
    noticiaData.publicada = 1;
    noticiaData.fecha = fechaActual;
    noticiaData.idEmpresa = this.addPostForm.get("idEmpresa").value;
    this.noticiaService.post(noticiaData).subscribe(
      data => {
        console.log("Noticia creada");
      },
      error => {
        console.log("algo salio mal");
      }
    );
  }
}
