import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PromocionService {
  private URL_BASE = "/jobGreen/api/promocion";
  public contextoService: Subject<Map<string, any>> = new Subject<Map<string, any>>();

  constructor(private http: HttpClient) { }

  public getUrlBse(): string {
    return this.URL_BASE;
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
