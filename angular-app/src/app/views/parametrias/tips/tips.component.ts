import { Component, OnInit } from "@angular/core";
import { environment } from "../../../../environments/environment";
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: "app-tips",
  templateUrl: "./tips.component.html",
  styles: []
})
export class TipsComponent implements OnInit {
  titulo = "Tips";
  public formularioTips: FormGroup;
  configuracion = {};

  constructor(private formBuilder: FormBuilder) {
    this.formularioTips = this.formBuilder.group({
      titulo: ['',
              [ Validators.required, Validators.email ]],
      descripcion: ['',
              [Validators.required]]
    });
  }

  ngOnInit() {
    const apiUrl = environment.api + '/tips';
    this.configuracion = {
      url: apiUrl,
      showDelete: false,
      showEdit: true,
       map: [
         {data: 'id', cab: 'Id'},
         {data: 'titulo', cab: 'Titulo'},
         {data: 'descripcion', cab: 'descripcion'},
         {data: 'imagen', cab: 'NombreImagen'}
       ]
    };
  }


  public crear(formValue: any) {
    console.log(formValue);
    // { email:'info@angular.io' }
  }
}
