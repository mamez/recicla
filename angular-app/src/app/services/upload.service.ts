import { Injectable } from '@angular/core';
import { HttpClient } from '../../../node_modules/@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UploadService {
  private URL_BASE = "/jobGreen/";

  constructor(private http: HttpClient) { }
}
