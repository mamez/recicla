import { CommonModule } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { DataTablesModule } from 'angular-datatables';
import { ErrorInterceptorService } from '../../config/error-interceptor.service';
import { RequestInterceptorService } from '../../config/request-interceptor.service';
import { ResponceInterceptorService } from '../../config/responce-interceptor.service';
import { PruebaService } from '../../services/prueba.service';
import { ContenidoComponent } from '../../utils/contenido/contenido.component';
import { DataTableComponent } from '../../utils/data-table/data-table.component';
import { FileUploadComponent } from '../../utils/file-upload/file-upload.component';
import { GmapsComponent } from '../../utils/gmaps/gmaps.component';
import { UsuariosListarComponent } from './usuarios-listar/usuarios-listar.component';
import { UsuariosRoutingModule } from './usuarios-routing.module';
import { UtilsModule } from '../../utils/utils.module';



@NgModule({
  imports: [
    CommonModule,
    UsuariosRoutingModule,
    HttpClientModule,
    DataTablesModule,
    UtilsModule
  ],
    declarations: [UsuariosListarComponent],
  providers: [
  PruebaService
  ]
})
export class UsuariosModule { }
