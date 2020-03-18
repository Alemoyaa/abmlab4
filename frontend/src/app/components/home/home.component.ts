import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmpresaService } from '../../services/empresa.service';
import { Empresa } from 'src/app/models/empresa';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private eService: EmpresaService, private route: ActivatedRoute) { }
  public empresa: Empresa =
    {
      id: 0,
      denominacion: '',
      telefono: '',
      horario: '',
      quienesSomos: '',
      latitud: 0,
      longitud: 0,
      domicilio: '',
      email: ''
    };

  ngOnInit(): void {
    const idEmpresa = this.route.snapshot.params['id'];
    this.getOne(idEmpresa);
  }

  getOne(id: number) {
    this.eService.getOne(id).subscribe(data => {
      this.empresa = data;
    }

    );
  }
}
