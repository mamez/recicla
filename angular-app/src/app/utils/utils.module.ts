import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContenidoComponent } from './contenido/contenido.component';
import { DataTableComponent } from './data-table/data-table.component';
import { FileUploadComponent } from './file-upload/file-upload.component';
import { GmapsComponent } from './gmaps/gmaps.component';
import { DataTablesModule } from '../../../node_modules/angular-datatables';

@NgModule({
  imports: [
    CommonModule,
    DataTablesModule
  ],
  declarations: [
    ContenidoComponent, DataTableComponent, FileUploadComponent, GmapsComponent
  ],
  exports : [
    ContenidoComponent, DataTableComponent, FileUploadComponent, GmapsComponent
  ]
})
export class UtilsModule { }
