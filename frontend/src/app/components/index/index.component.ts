import { Component, OnInit } from '@angular/core';
import { EmpresaService } from '../../services/empresa.service';
import { Observable } from 'rxjs';
import { Empresa } from 'src/app/models/empresa';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor(private eService: EmpresaService, private route: Router) { }

  empresas: Observable<Empresa[]>;

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.empresas = this.eService.getAll();
  }

  
}
