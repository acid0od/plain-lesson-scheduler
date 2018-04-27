import { Inject, Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { DOCUMENT } from '@angular/common';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ApiService {
  constructor(private http: HttpClient,
              @Inject(DOCUMENT) private document: any) {
  }

  public getApiUrl(): string {
    if (!environment.production) {
      return environment.apiUrl;
    } else {
      const nativeWindow = document;
      return nativeWindow.location.protocol + '//' +
        nativeWindow.location.host + nativeWindow.location.pathname;
    }
  }

  public get<T>(path: string, params: HttpParams = new HttpParams()): Observable<T> {
    return this.http.get<T>(this.getApiUrl() + path, {headers: this.setHeaders(), params});
  }

  public put<T>(path: string, body: Object = {}): Observable<T> {
    return this.http.put<T>(this.getApiUrl() + path,
      JSON.stringify(body),
      {headers: this.setHeaders()}
    );
  }

  public post<T>(path: string, body: Object = {}): Observable<T> {
    return this.http.post<T>(this.getApiUrl() + path,
      JSON.stringify(body),
      {headers: this.setHeaders()}
    );
  }

  public delete<T>(path): Observable<T> {
    return this.http.delete<T>(
      this.getApiUrl() + path,
      {headers: this.setHeaders()}
    );
  }

  private setHeaders(): HttpHeaders {
    const headersConfig = {
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    };

    return new HttpHeaders(headersConfig);
  }
}
