import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ContenidoComponent } from "../../utils/contenido/contenido.component";
import { ParametriasRoutingModule } from "./parametrias-routing.module";
import { PromocionesComponent } from "./promociones/promociones.component";
import { TipoRevciclajeComponent } from "./tipo-revciclaje/tipo-revciclaje.component";
import { TipsComponent } from "./tips/tips.component";
import { HttpClientModule } from "../../../../node_modules/@angular/common/http";
import { UtilsModule } from "../../utils/utils.module";
import { ModalModule} from 'ngx-bootstrap/modal';
import { FormBuilder, FormsModule, ReactiveFormsModule } from "../../../../node_modules/@angular/forms";
import { AlertModule } from 'ngx-bootstrap/alert';
import { TipsCrearComponent } from './tips/tips-crear/tips-crear.component';

@NgModule({
  imports: [CommonModule, ParametriasRoutingModule, FormsModule, ReactiveFormsModule,
    HttpClientModule, UtilsModule, ModalModule.forRoot(), AlertModule.forRoot()],
  declarations: [
    PromocionesComponent,
    TipoRevciclajeComponent,
    TipsComponent,
    TipsCrearComponent
  ],
  providers: [FormBuilder]
})
export class ParametriasModule {}
