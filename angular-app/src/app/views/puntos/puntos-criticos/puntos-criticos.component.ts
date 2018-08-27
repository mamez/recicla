import { Component, OnInit, ViewChild } from '@angular/core';
import { PuntosCriticosModel } from '../../../model/puntos-criticos-model';
import { AlertModel, alertType } from '../../../model/alert-model';
import { PuntosCriticosService } from '../../../services/puntos-criticos.service';

@Component({
  selector: 'app-puntos-criticos',
  templateUrl: './puntos-criticos.component.html',
  styles: []
})
export class PuntosCriticosComponent implements OnInit {
  title = 'Lista de puntos criticos';
  lat = 4.6567173;
  lng = -74.0572354;
  zoom = 14;

  order: string;
  configuracion: any = {};
  listData: Array<PuntosCriticosModel>;
  context: Map<string, string>;
  alertas: any = [];
  alert: AlertModel;

  @ViewChild("modalDetalle") modal: any;

  puntoCritico: PuntosCriticosModel = new PuntosCriticosModel();

  constructor(private puntosCriticosService: PuntosCriticosService) { }

  ngOnInit() {
    this.getLista();
  }

  openModal(data: any) {
   this.puntoCritico = data;
   this.modal.show();
  }

  public atender(): void {
    this.puntosCriticosService.atenderPunto(this.puntoCritico.id, this.puntoCritico.observacionAdmin).subscribe(data => {
      this.getLista();
      this.alert = new AlertModel('Se ha atendido el punto critico', true, alertType.SUCCESS);
      this.alertas.push({
        type: this.alert.type,
        msg: this.alert.msg,
        timeout: 5000
      });
    });
  }

  public rechazar(): void {
    this.puntosCriticosService.CancelarPunto(this.puntoCritico.id, this.puntoCritico.observacionAdmin).subscribe(data => {
      this.getLista();
      this.alert = new AlertModel('Se ha cancelado el punto critico', true, alertType.SUCCESS);
      this.alertas.push({
        type: this.alert.type,
        msg: this.alert.msg,
        timeout: 5000
      });
    });
  }

  private getLista() {
    this.puntosCriticosService.getList().subscribe(data => {
      this.listData = data._embedded.puntosCriticos;
      this.modal.hide();
    });
  }



}
