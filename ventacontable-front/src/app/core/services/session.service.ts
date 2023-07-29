import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { CookieService } from "ngx-cookie-service";
import { map, Observable } from "rxjs";
import { ConstantLogin } from "../constants/path-constants-login";
import { Login } from "../models/interface/login";
import { RestService } from "./rest.service";

export const TOKEN_NAME = 'token';
export const HEADER_AUTHORIZATION = 'Authorization';

@Injectable({
    providedIn: 'root',
})
export class SesionService extends RestService {

    public tieneSesion: boolean = false;

    constructor(
        protected override http: HttpClient,
        private cookieService: CookieService,
        public router: Router) {
        super(http);
        this.tieneSesion = this.obtenerToken() != "";
    }

    get isLoggedIn(): boolean {
        return this.tieneSesion;
    }

    iniciarSesion(body: Login): Observable<any> {
        return this.doPost(ConstantLogin.API_LOGIN, body)
            .pipe(
                map((response: any) => {
                    const headers = response.headers;
                    this.cookieService.set(TOKEN_NAME,headers.get(HEADER_AUTHORIZATION))
                    this.tieneSesion = true;
                    return response.response;
                })
            );
    }

    cerrarSesion() {
        this.cookieService.delete(TOKEN_NAME);
        this.tieneSesion = false;
        this.router.navigate(['']);
    }

    obtenerToken(): any {
        return this.cookieService.get(TOKEN_NAME).trim();
    }
}