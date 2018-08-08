import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {NotificationsService} from 'angular4-notify';

@Injectable()
export class ErrorInterceptorService implements HttpInterceptor {

  constructor(protected notificationsService: NotificationsService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(catchError(err => {
        if (err.status === 401) {
            // Aqui mandamos el servicio para logout
            location.reload(true);
        } else if ( err.status >= 500) {
          this.notificationsService.addError('Error de operacion en el servidor');
        }
        const error = err.error.message || err.statusText;
        return throwError(error);
    }));
  }
}
