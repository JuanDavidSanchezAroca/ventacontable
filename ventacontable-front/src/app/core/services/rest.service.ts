import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

export interface Options {
  headers?: HttpHeaders;
  params?: HttpParams;
}

@Injectable({
  providedIn: 'root',
})
export class RestService {
  constructor(private http: HttpClient) {}

  protected createDefaultOptions(): Options {
    return {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    };
  }

  protected createOptions(opts?: Options): Options {
    const defaultOpts: Options = this.createDefaultOptions();
    if (opts) {
      opts = {
        ...defaultOpts,
        ...opts
      };
      if (!opts.headers?.has('Content-Type')) {
        opts.headers = opts.headers?.set('Content-Type', defaultOpts.headers!.get('Content-Type') || '');
      }
    }
    return opts || defaultOpts;
  }

  doGet<T>(serviceUrl: string, opts?: Options): Observable<T> {
    const ropts = this.createOptions(opts);
    return this.http.get(serviceUrl, ropts).pipe(
      map(response => response as T)
    );
  }

  doPost<T, R>(serviceUrl: string, body: T, opts?: Options): Observable<R> {
    const ropts = this.createOptions(opts);
    return this.http.post(serviceUrl, body, ropts).pipe(
      map(response => response as R)
    );
  }

  doGetParameters<T>(serviceUrl: string, parametros: HttpParams, opts?: Options): Observable<T> {
    const ropts = this.createOptions(opts);
    const options = parametros !== null ? {
      headers: ropts.headers,
      params: parametros
    } : ropts;
    return this.http.get(serviceUrl, options).pipe(
      map(response => response as T)
    );
  }
}