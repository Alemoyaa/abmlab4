import { TinyComponent } from './components/tiny/tiny.component';
import { DetalleComponent } from './components/detalle/detalle.component';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './components/index/index.component';

const routes: Routes = [
  {
    path: 'home', component: HomeComponent
  },
  {
    path: 'home/:id', component: HomeComponent
  },
  {
    path: 'index', component: IndexComponent
  },
  {
    path: 'detalle', component: DetalleComponent
  },
  {
    path: 'tiny', component: TinyComponent
  },
  {
    path: '', component: IndexComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
