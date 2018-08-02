import { Component, OnInit, OnDestroy } from '@angular/core';
import { PruebaService } from '../../../services/prueba.service';
import { first } from 'rxjs/operators';
import { Subject } from 'rxjs';


@Component({
  selector: 'app-usuarios-listar',
  templateUrl: './usuarios-listar.component.html',
  styleUrls: ['./usuarios-listar.component.scss']
})
export class UsuariosListarComponent implements  OnInit {
titulo = 'lista usuario';
configuracion = {};
service = '';

  constructor(private pruebaService: PruebaService) { }

  ngOnInit() {
    this.configuracion = {
      url: 'https://jsonplaceholder.typicode.com/posts ',
      showDelete: false,
      showEdit: true,
       map: [
         {data: 'id', cab: 'Id'},
         {data: 'title', cab: 'user'}
       ]
    };
  }

  refreshImages(status) {
    if (status === true) {
      console.log( 'Uploaded successfully!');
    }
  }

  eliminarUsuario(usuario): void {
   console.log(usuario);
  }

  editatUsuario(usuario): void {
    console.log(usuario);
   }



}
