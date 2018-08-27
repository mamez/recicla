import { CommonModule } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { DataTablesModule } from 'angular-datatables';
import { ContenidoComponent } from '../../utils/contenido/contenido.component';
import { DataTableComponent } from '../../utils/data-table/data-table.component';
import { FileUploadComponent } from '../../utils/file-upload/file-upload.component';
import { GmapsComponent } from '../../utils/gmaps/gmaps.component';
import { UsuariosRoutingModule } from './usuarios-routing.module';
import { UtilsModule } from '../../utils/utils.module';
import { CrearUsuarioComponent } from './crear-usuario/crear-usuario.component';
import { ListarUsuarioComponent } from './listar-usuario/listar-usuario.component';
import { ModificarUsuarioComponent } from './modificar-usuario/modificar-usuario.component';
import { EliminarUsuarioComponent } from './eliminar-usuario/eliminar-usuario.component';
import { DetalleUsuarioComponent } from './detalle-usuario/detalle-usuario.component';
import { ReactiveFormsModule } from '../../../../node_modules/@angular/forms';
import { ModalModule } from '../../../../node_modules/ngx-bootstrap/modal';
import { AlertModule } from '../../../../node_modules/ngx-bootstrap/alert';
import { EstoUsuarioPipe } from '../../pipe/esto-usuario.pipe';
import { TipoUsuarioPipe } from '../../pipe/tipo-usuario.pipe';



@NgModule({
  imports: [
    CommonModule,
    UsuariosRoutingModule,
    HttpClientModule,
    DataTablesModule,
    UtilsModule,
    ReactiveFormsModule,
    ModalModule.forRoot(),
    AlertModule.forRoot()
  ],
    declarations: [ CrearUsuarioComponent, ListarUsuarioComponent,
      ModificarUsuarioComponent, EliminarUsuarioComponent, DetalleUsuarioComponent, EstoUsuarioPipe, TipoUsuarioPipe],
  providers: [

  ]
})
export class UsuariosModule { }
