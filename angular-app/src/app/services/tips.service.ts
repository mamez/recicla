import { Injectable } from "@angular/core";
import { HttpClient } from "../../../node_modules/@angular/common/http";
import { Observable, Subject } from "../../../node_modules/rxjs";
import { TipsModel } from "../model/tips-model";

@Injectable({
  providedIn: "root"
})
export class TipsService {
  private URL_BASE = "/jobGreen/tips";
  public contextoService: Subject<Map<string, any>> = new Subject<Map<string, any>>();

  constructor(private http: HttpClient) {}

  public getListTips(): Observable<Array<TipsModel>> {
    return this.http.get<Array<TipsModel>>(this.URL_BASE);
  }

  public getTipsById(id: string): Observable<TipsModel> {
    return this.http.get<TipsModel>(this.URL_BASE + "/" + id);
  }

  public saveTips(tips: TipsModel): Observable<TipsModel> {
    return this.http.post<TipsModel>(this.URL_BASE, tips);
  }

  public updateTips(tips: TipsModel): Observable<TipsModel> {
    return this.http.put<TipsModel>(this.URL_BASE + "/" + tips.id, tips);
  }

  public deleteTips(id: number): Observable<any> {
    return this.http.delete<any>(this.URL_BASE + "/" + id);
  }
}
