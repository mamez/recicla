import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgmCoreModule } from '@agm/core';
import { UtilsModule } from "../../utils/utils.module";
import { AgmSnazzyInfoWindowModule } from '@agm/snazzy-info-window';

import { PuntosRoutingModule } from './puntos-routing.module';
import { PuntosCriticosComponent } from './puntos-criticos/puntos-criticos.component';
import { PuntosRecUsuariosComponent } from './puntos-rec-usuarios/puntos-rec-usuarios.component';
import { PuntosRecPublicoComponent } from './puntos-rec-publico/puntos-rec-publico.component';
import { PrCrearComponent } from './puntos-rec-publico/pr-crear/pr-crear.component';
import { PrModificarComponent } from './puntos-rec-publico/pr-modificar/pr-modificar.component';
import { PrEliminarComponent } from './puntos-rec-publico/pr-eliminar/pr-eliminar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ModalModule } from 'ngx-bootstrap/modal';
import { AlertModule } from 'ngx-bootstrap/alert';
import { DataTablesModule } from 'angular-datatables';


@NgModule({
  imports: [
    CommonModule,
    UtilsModule ,
    FormsModule,
    DataTablesModule,
    ReactiveFormsModule,
    PuntosRoutingModule,
    ModalModule.forRoot(),
    AlertModule.forRoot(),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDJ_l02eBc3mby0IwBry9r0CU5nPuonSow'
    }),
    AgmSnazzyInfoWindowModule
  ],
  declarations: [PuntosCriticosComponent, PuntosRecUsuariosComponent, PuntosRecPublicoComponent, PrCrearComponent,
    PrModificarComponent, PrEliminarComponent]
})
export class PuntosModule { }
