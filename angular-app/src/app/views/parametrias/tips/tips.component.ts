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

  configuracion = {};

  constructor() {}

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

}
