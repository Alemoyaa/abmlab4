import { NoticiaService } from './services/noticia.service';
import { EmpresaService } from './services/empresa.service';
import { HttpClientModule } from "@angular/common/http";
import { EditorModule } from "@tinymce/tinymce-angular";
import { AppRoutingModule } from "./app-routing.module";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

import { AppComponent } from "./app.component";
import { HomeComponent } from "./components/home/home.component";
import { IndexComponent } from "./components/index/index.component";
import { DetalleComponent } from "./components/detalle/detalle.component";
import { BusquedaComponent } from "./components/busqueda/busqueda.component";

import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { TinyComponent } from "./components/tiny/tiny.component";
import { NotFoundComponent } from "./components/not-found/not-found.component";

import { GoogleMapsModule } from "@angular/google-maps";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    IndexComponent,
    DetalleComponent,
    BusquedaComponent,
    TinyComponent,
    NotFoundComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    EditorModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    GoogleMapsModule
  ],
  providers: [
    EmpresaService,
    NoticiaService],
  bootstrap: [AppComponent]
})
export class AppModule {}
