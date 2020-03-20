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
    path: "home",
    component: HomeComponent
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
    path: "detalle",
    component: DetalleComponent
  },
  {
    path: "post",
    component: TinyComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
