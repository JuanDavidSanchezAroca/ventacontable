import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

export interface Options {
  headers?: HttpHeaders;
  params?: HttpParams;
}

export class RestService {


  constructor(protected http: HttpClient) { }

  protected createDefaultOptions(): Options {
    return {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
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

  protected doGet<T>(serviceUrl: string, opts?: Options): Observable<T> {
    const ropts = this.createOptions(opts);
    return this.http.get<T>(serviceUrl, ropts).pipe(
      map(response => response as T)
    );
  }

  protected doPost<T, R>(serviceUrl: string, body: T, opts?: Options): Observable<{ response: R, headers: HttpHeaders }> {
    const ropts = this.createOptions(opts);

    return this.http.post<R>(serviceUrl, body, { ...ropts, observe: 'response' }).pipe(
      map((response: HttpResponse<R>) => {
        const headers: HttpHeaders = response.headers;
        return { response: response.body as R, headers };
      })
    );
  }

  protected doPut<T, R>(serviceUrl: string, body: T, opts?: Options): Observable<{ response: R, headers: HttpHeaders }> {
    const ropts = this.createOptions(opts);

    return this.http.put<R>(serviceUrl, body, { ...ropts, observe: 'response' }).pipe(
      map((response: HttpResponse<R>) => {
        const headers: HttpHeaders = response.headers;
        return { response: response.body as R, headers };
      })
    );
  }

  protected doGetParameters<T>(serviceUrl: string, parametros: HttpParams, opts?: Options): Observable<T> {
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