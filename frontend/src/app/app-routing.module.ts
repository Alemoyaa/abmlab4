import { NotFoundComponent } from './components/not-found/not-found.component';
import { BusquedaComponent } from "./components/busqueda/busqueda.component";
import { TinyComponent } from "./components/tiny/tiny.component";
import { DetalleComponent } from "./components/detalle/detalle.component";
import { HomeComponent } from "./components/home/home.component";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { IndexComponent } from "./components/index/index.component";

const routes: Routes = [
  {
    path: "",
    component: IndexComponent
  },
  {
    path: "home/:id",
    component: HomeComponent
  },
  {
    path: "index",
    component: IndexComponent
  },
  {
    path: "detalle/:id",
    component: DetalleComponent
  },
  {
    path: "post",
    component: TinyComponent
  },
  {
    path: "busqueda/:id",
    component: BusquedaComponent
  },
  {
    path: "**",
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
