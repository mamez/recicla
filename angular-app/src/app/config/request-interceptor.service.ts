
import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class RequestInterceptorService implements HttpInterceptor {

  constructor() { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    // add a custom header
    const customReq = request.clone({
      headers: request.headers.set('app-language', 'it')
    });

    // pass on the modified request object
    return next.handle(customReq);
  }
}
