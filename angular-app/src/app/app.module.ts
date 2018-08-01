import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';

import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';
import { PERFECT_SCROLLBAR_CONFIG } from 'ngx-perfect-scrollbar';
import { PerfectScrollbarConfigInterface } from 'ngx-perfect-scrollbar';

const DEFAULT_PERFECT_SCROLLBAR_CONFIG: PerfectScrollbarConfigInterface = {
  suppressScrollX: true
};

import { AppComponent } from './app.component';

// Import containers
import { DefaultLayoutComponent } from './containers';


const APP_CONTAINERS = [
  DefaultLayoutComponent
];

import {
  AppAsideModule,
  AppBreadcrumbModule,
  AppHeaderModule,
  AppFooterModule,
  AppSidebarModule,
} from '@coreui/angular';

// Import routing module
import { AppRoutingModule } from './app.routing';

// Import 3rd party components
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { LoguinComponent } from './loguin/loguin.component';
import { PruebaService } from './services/prueba.service';
import { DataTablesModule } from '../../node_modules/angular-datatables';
import { FileUploadComponent } from './utils/file-upload/file-upload.component';
import { ContenidoComponent } from './utils/contenido/contenido.component';
import { DataTableComponent } from './utils/data-table/data-table.component';
import { UtilsModule } from './utils/utils.module';

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    AppAsideModule,
    AppBreadcrumbModule.forRoot(),
    AppFooterModule,
    AppHeaderModule,
    AppSidebarModule,
    PerfectScrollbarModule,
    BsDropdownModule.forRoot(),
    TabsModule.forRoot(),
    ChartsModule,
    DataTablesModule,
    UtilsModule
  ],
  declarations: [
    AppComponent,
    ...APP_CONTAINERS,
    LoguinComponent
  ],
  providers: [
    PruebaService,
    {
    provide: LocationStrategy,
    useClass: HashLocationStrategy,
  }
],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
