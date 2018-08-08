import { Injectable } from '@angular/core';
import { Subject, Observable } from '../../../node_modules/rxjs';
import { HttpClient } from '../../../node_modules/@angular/common/http';
import { TipoReciclajeModel } from '../model/tipo-reciclaje-model';

@Injectable({
  providedIn: 'root'
})
export class TipoReciclajeService {
  private URL_BASE = "/jobGreen/tipoReciclaje";
  public contextoService: Subject<Map<string, any>> = new Subject<Map<string, any>>();

  constructor(private http: HttpClient) { }

  public getUrlBse(): string {
    return this.URL_BASE;
  }

  public getList(): Observable<Array<TipoReciclajeModel>> {
    return this.http.get<Array<TipoReciclajeModel>>(this.URL_BASE);
  }

  public getById(id: string): Observable<TipoReciclajeModel> {
    return this.http.get<TipoReciclajeModel>(this.URL_BASE + "/" + id);
  }

  public save(tips: TipoReciclajeModel): Observable<TipoReciclajeModel> {
    return this.http.post<TipoReciclajeModel>(this.URL_BASE, tips);
  }

  public update(tips: TipoReciclajeModel): Observable<TipoReciclajeModel> {
    return this.http.put<TipoReciclajeModel>(this.URL_BASE + "/" + tips.id, tips);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete<any>(this.URL_BASE + "/" + id);
  }

}
