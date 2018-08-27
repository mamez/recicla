import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { AlertModule } from "ngx-bootstrap/alert";
import { ModalModule } from "ngx-bootstrap/modal";
import { HttpClientModule } from "@angular/common/http";
import {
  FormBuilder,
  FormsModule,
  ReactiveFormsModule
} from "@angular/forms";
import { DataTablesModule } from "angular-datatables";
import { UtilsModule } from "../../utils/utils.module";
import { ParametriasRoutingModule } from "./parametrias-routing.module";
import { PromocionesComponent } from "./promociones/promociones.component";
import { TipoRevciclajeComponent } from "./tipo-revciclaje/tipo-revciclaje.component";
import { TipsCrearComponent } from "./tips/tips-crear/tips-crear.component";
import { TipsComponent } from "./tips/tips.component";
import { TipsEliminarComponent } from './tips/tips-eliminar/tips-eliminar.component';
import { TipsModificarComponent } from './tips/tips-modificar/tips-modificar.component';
import { TipoRecCrearComponent } from './tipo-revciclaje/tipo-rec-crear/tipo-rec-crear.component';
import { TipoRecModificatComponent } from './tipo-revciclaje/tipo-rec-modificat/tipo-rec-modificat.component';
import { TipoRecEliminarComponent } from './tipo-revciclaje/tipo-rec-eliminar/tipo-rec-eliminar.component';
import { PromocionCrearComponent } from './promociones/promocion-crear/promocion-crear.component';
import { PromocionModificarComponent } from './promociones/promocion-modificar/promocion-modificar.component';
import { PromocionEliminarComponent } from './promociones/promocion-eliminar/promocion-eliminar.component';

@NgModule({
  imports: [
    CommonModule,
    ParametriasRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    DataTablesModule,
    UtilsModule,
    ModalModule.forRoot(),
    AlertModule.forRoot()
  ],
  declarations: [
    PromocionesComponent,
    TipoRevciclajeComponent,
    TipsComponent,
    TipsCrearComponent,
    TipsEliminarComponent,
    TipsModificarComponent,
    TipoRecCrearComponent,
    TipoRecModificatComponent,
    TipoRecEliminarComponent,
    PromocionCrearComponent,
    PromocionModificarComponent,
    PromocionEliminarComponent
  ],
  providers: [FormBuilder]
})
export class ParametriasModule {}
