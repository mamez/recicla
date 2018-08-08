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

// import notificatiosns services
import {NotificationsModule, NotificationsService} from 'angular4-notify';


// Import 3rd party components
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { LoguinComponent } from './loguin/loguin.component';
import { DataTablesModule } from '../../node_modules/angular-datatables';
import { UtilsModule } from './utils/utils.module';
import { HTTP_INTERCEPTORS } from '../../node_modules/@angular/common/http';
import { ErrorInterceptorService } from './config/error-interceptor.service';
import { ResponceInterceptorService } from './config/responce-interceptor.service';
import { RequestInterceptorService } from './config/request-interceptor.service';

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
    UtilsModule,
    NotificationsModule
  ],
  declarations: [
    AppComponent,
    ...APP_CONTAINERS,
    LoguinComponent
  ],
  providers: [
    NotificationsService,
    {
    provide: LocationStrategy,
    useClass: HashLocationStrategy,
  },
  { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptorService, multi: true },
  { provide: HTTP_INTERCEPTORS, useClass: ResponceInterceptorService, multi: true },
  { provide: HTTP_INTERCEPTORS, useClass: RequestInterceptorService, multi: true }
],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
