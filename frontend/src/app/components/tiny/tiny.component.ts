import { Empresa } from "./../../models/empresa";
import { EmpresaService } from "./../../services/empresa.service";
import { Noticia } from "./../../models/noticia";
import { NoticiaService } from "./../../services/noticia.service";
import { FormControl, FormGroup } from "@angular/forms";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-tiny",
  templateUrl: "./tiny.component.html",
  styleUrls: ["./tiny.component.css"]
})
export class TinyComponent implements OnInit {
  addPostForm: FormGroup;
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
  empresas: Empresa[];

  constructor(
    private noticiaService: NoticiaService,
    private empresaService: EmpresaService
  ) {
    this.addPostForm = new FormGroup({
      titulo: this.titulo,
      body: this.body,
      resumen: this.resumen,
      img: this.imagen,
      idEmpresa: this.idEmpresa
    });
  }

  ngOnInit(): void {
    this.getEmpresas();
  }

  mostrarHTML() {
    alert(this.addPostForm.get("body").value);
    alert(this.empresas);
  }

  getEmpresas() {
    this.empresaService.getAll().subscribe(data => {
      this.empresas = data;
    });
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
        console.log("algo salio mal", error);
      }
    );
  }
}
