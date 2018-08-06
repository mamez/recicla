import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { HttpClientModule } from "../../../node_modules/@angular/common/http";
import { DataTablesModule } from "../../../node_modules/angular-datatables";
import { ContenidoComponent } from "./contenido/contenido.component";
import { DataTableComponent } from "./data-table/data-table.component";
import { FileUploadComponent } from "./file-upload/file-upload.component";
import { GmapsComponent } from "./gmaps/gmaps.component";

@NgModule({
  imports: [CommonModule, DataTablesModule, HttpClientModule],
  declarations: [
    ContenidoComponent,
    DataTableComponent,
    FileUploadComponent,
    GmapsComponent
  ],
  exports: [
    ContenidoComponent,
    DataTableComponent,
    FileUploadComponent,
    GmapsComponent
  ]
})
export class UtilsModule {}
