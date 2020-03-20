import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmpresaService } from '../../services/empresa.service';
import { Empresa } from 'src/app/models/empresa';
import { MapMarker, MapInfoWindow } from '@angular/google-maps';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  @ViewChild(MapInfoWindow, { static: false }) info: MapInfoWindow;

  constructor(private eService: EmpresaService, private route: ActivatedRoute) { }

  zoom = 18;
  center: google.maps.LatLngLiteral;
  options: google.maps.MapOptions = {
    zoomControl: true,
    scrollwheel: false,
    disableDoubleClickZoom: true,
    mapTypeId: "roadmap"
  };
  markers = [];
  infoContent = "";

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
        console.log(data);
        this.center = {
          lat: data.latitud,
          lng: data.longitud
        };
        this.markers.push({
          position: {
            lat: data.latitud,
            lng: data.longitud
          },
          label: {
            color: "white",
            text: data.id
          },
            title: data.denominacion
        });
      }
    );
  }
  openInfo(marker: MapMarker, info) {
    this.infoContent = info;
    this.info.open(marker);
  }
}
