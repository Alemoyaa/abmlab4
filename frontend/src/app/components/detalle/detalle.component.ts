import { Empresa } from "./../../models/empresa";
import { EmpresaService } from "./../../services/empresa.service";
import { Noticia } from "./../../models/noticia";
import { NoticiaService } from "./../../services/noticia.service";
import { Component, OnInit, ViewChild } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-detalle",
  templateUrl: "./detalle.component.html",
  styleUrls: ["./detalle.component.css"]
})
export class DetalleComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private noticiaService: NoticiaService,
    private empresaService: EmpresaService
  ) {}

  empresa: Empresa = {
    id: 0,
    denominacion: "",
    telefono: "",
    horario: "",
    quienesSomos: "",
    latitud: 0,
    longitud: 0,
    domicilio: "",
    email: ""
  };

  noticia: Noticia = {
    id: 0,
    titulo: "",
    resumen: "",
    imagen: "",
    html: "",
    publicada: 0,
    fecha: "",
    idEmpresa: 0
  };

  ngOnInit(): void {
    const idNoticia = this.route.snapshot.params["id"];
    console.log(idNoticia);
    this.getNoticia(idNoticia);
  }

  getNoticia(id: number) {
    this.noticiaService.getOne(id).subscribe(data => {
      this.noticia = data;
    });
    this.getEmpresa(this.noticia.idEmpresa);
  }

  getEmpresa(id: number) {
    this.empresaService.getOne(id).subscribe(data => {
      this.empresa = data;
    });
  }
}
