import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { DataTablesModule } from 'angular-datatables';

import { UsuariosRoutingModule } from './usuarios-routing.module';
import { UsuariosListarComponent } from './usuarios-listar/usuarios-listar.component';
import { ContenidoComponent } from '../../utils/contenido/contenido.component';
import { ErrorInterceptorService } from '../../config/error-interceptor.service';
import { ResponceInterceptorService } from '../../config/responce-interceptor.service';
import { PruebaService } from '../../services/prueba.service';
import { RequestInterceptorService } from '../../config/request-interceptor.service';
import { GmapsComponent } from '../../utils/gmaps/gmaps.component';
import { DataTableComponent } from '../../utils/data-table/data-table.component';
import { FileUploadComponent } from '../../utils/file-upload/file-upload.component';


@NgModule({
  imports: [
    CommonModule,
    UsuariosRoutingModule,
    HttpClientModule,
    DataTablesModule
  ],
    declarations: [UsuariosListarComponent, ContenidoComponent, GmapsComponent, DataTableComponent,
      FileUploadComponent
    ],
  providers: [
  PruebaService,
  { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptorService, multi: true },
  { provide: HTTP_INTERCEPTORS, useClass: ResponceInterceptorService, multi: true },
  { provide: HTTP_INTERCEPTORS, useClass: RequestInterceptorService, multi: true }
  ]
})
export class UsuariosModule { }
