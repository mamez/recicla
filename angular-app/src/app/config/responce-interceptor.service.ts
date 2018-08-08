import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpResponse,
  HttpHandler,
  HttpEvent
} from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/do';

@Injectable()
export class ResponceInterceptorService implements HttpInterceptor {

  constructor() { }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next
      .handle(request)
      .do((ev: HttpEvent<any>) => {
        if (ev instanceof HttpResponse) {
         // console.log('processing response', ev);
        }
      });
  }

}
