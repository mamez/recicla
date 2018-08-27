import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AlertModel, alertType } from '../../../../model/alert-model';
import { PrpublicoService } from '../../../../services/prpublico.service';
import { PrPublicoModel } from '../../../../model/pr-publico-model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pr-modificar',
  templateUrl: './pr-modificar.component.html',
  styles: []
})
export class PrModificarComponent implements OnInit, OnDestroy {
  public titulo = "Modificar punto recoleccion publico";
  public forPrModificar: FormGroup;
  public lat: number;
  public lng: number;
  public zoom = 14;
  alertas: any = [];
  alert: AlertModel;
  public model: PrPublicoModel;
  private sub: any;

  constructor(private formBuilder: FormBuilder,  private prpublicoService: PrpublicoService, private route: ActivatedRoute) {
   }

  ngOnInit() {
    this.forPrModificar = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      descripcion: ['', [Validators.required]],
      direccion: ['', Validators.required]
    });
   this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
             this.prpublicoService.getById(id).subscribe(data => {
              this.model = data;
              this.lat = Number.parseFloat('' + this.model.lat);
              this.lng = Number.parseFloat('' + this.model.lng);
              this.forPrModificar.controls['nombre'].setValue(this.model.nombre);
              this.forPrModificar.controls['descripcion'].setValue(this.model.descripcion);
              this.forPrModificar.controls['direccion'].setValue(this.model.direccion);
            });
          });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  public modificar(formValue: any) {
    const prPublico: PrPublicoModel = new PrPublicoModel();
    prPublico.nombre = formValue.nombre;
    prPublico.descripcion = formValue.descripcion;
    prPublico.direccion = formValue.direccion;
    prPublico.lat = this.lat;
    prPublico.lng = this.lng;
    prPublico.id = this.model.id;
    this.prpublicoService.update(prPublico).subscribe( data => {
      this.alert = new AlertModel('Registro modificado con éxito', true, alertType.SUCCESS);
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
          this.lng = resultado.lng;
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
     console.log(formValue);
  }

}
