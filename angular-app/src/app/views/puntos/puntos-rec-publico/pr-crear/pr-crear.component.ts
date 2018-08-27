import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { PrPublicoModel } from '../../../../model/pr-publico-model';
import { environment } from '../../../../../environments/environment';
import { PrpublicoService } from '../../../../services/prpublico.service';
import { AlertModel, alertType } from '../../../../model/alert-model';

@Component({
  selector: 'app-pr-crear',
  templateUrl: './pr-crear.component.html',
  styles: []
})
export class PrCrearComponent implements OnInit {
  public titulo = "Crear punto recoleccion publico";
  public forPrCrear: FormGroup;
  public lat: number;
  public long: number;
  public zoom: number;
  alertas: any = [];
  alert: AlertModel;

  constructor(private formBuilder: FormBuilder,  private prpublicoService: PrpublicoService) {
    this.lat = environment.lat;
    this.long = environment.long;
    this.zoom = environment.zoom;
  }

  ngOnInit() {
   this.iniciarFormulario();
  }

  private iniciarFormulario() {
    this.forPrCrear = this.formBuilder.group({
      nombre: ["", [Validators.required]],
      descripcion: ["", [Validators.required]],
      direccion: ['', Validators.required]
    });
  }

  public crear(formValue: any) {
    const prPublico: PrPublicoModel = new PrPublicoModel();
    prPublico.nombre = formValue.nombre;
    prPublico.descripcion = formValue.descripcion;
    prPublico.direccion = formValue.direccion;
    prPublico.lat = this.lat;
    prPublico.lng = this.long;
    this.prpublicoService.save(prPublico).subscribe( data => {
      this.alert = new AlertModel('Registro creado con éxito', true, alertType.SUCCESS);
      this.iniciarFormulario();
      this.alertas.push({
        type: this.alert.type,
        msg: this.alert.msg,
        timeout: 5000
      });
    });
  }

  public buscar(formValue: any) {
    this.prpublicoService.getCoordenadas(formValue.direccion).subscribe( data => {
      const status = data.status;
      if (status === 'OK') {
          const resultado = data.results[0].geometry.location;
          this.lat = resultado.lat;
          this.long = resultado.lng;
      } else {
        this.alert = new AlertModel('Error al buscar la direccion', true, alertType.DANGER);
        this.alertas.push({
        type: this.alert.type,
        msg: this.alert.msg,
        timeout: 5000
      });
      }
    }
    );
  }

}
