import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, Subject } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class TipsService {
  private URL_BASE = "/jobGreen/api/tips";
  public contextoService: Subject<Map<string, any>> = new Subject<Map<string, any>>();

  constructor(private http: HttpClient) {}

  public getListTips(): Observable<any> {
    return this.http.get<Array<any>>(this.URL_BASE);
  }

  public getTipsById(id: string): Observable<any> {
    return this.http.get<any>(this.URL_BASE + "/" + id);
  }

  public saveTips(tips: any): Observable<any> {
    return this.http.post<any>(this.URL_BASE, tips);
  }

  public updateTips(tips: any): Observable<any> {
    return this.http.put<any>(this.URL_BASE + "/" + tips.id, tips);
  }

  public deleteTips(id: number): Observable<any> {
    return this.http.delete<any>(this.URL_BASE + "/" + id);
  }
}
