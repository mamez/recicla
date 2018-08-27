import { Injectable } from '@angular/core';
import { Subject, Observable, observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PrpublicoService {

  private URL_BASE = "/jobGreen/api/puntosPublicos";

  public contextoService: Subject<Map<string, any>> = new Subject<Map<string, any>>();

  constructor(private http: HttpClient) { }

  public getUrlBse(): string {
    return this.URL_BASE;
  }

  public getCoordenadas(direccion: string): Observable<any> {
    const params = new HttpParams();
    params.set('key', environment.googleKey);
    params.set('address', 'colombia bogota ' + direccion);
    return this.http.get<any>(environment.apiGoolge + '?address=colombia bogota ' + direccion + '&key=' + environment.googleKey);
  }

  public getList(): Observable<any> {
    return this.http.get<any>(this.URL_BASE);
  }

  public getById(id: string): Observable<any> {
    return this.http.get<any>(this.URL_BASE + "/" + id);
  }

  public save(tips: any): Observable<any> {
    return this.http.post<any>(this.URL_BASE, tips);
  }

  public update(tips: any): Observable<any> {
    return this.http.put<any>(this.URL_BASE + "/" + tips.id, tips);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete<any>(this.URL_BASE + "/" + id);
  }
}
