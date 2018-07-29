import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-contenido',
  templateUrl: './contenido.component.html',
  styles: []
})
export class ContenidoComponent implements OnInit {

  @Input() titulo;


  constructor() { }

  ngOnInit() {
  }

}
