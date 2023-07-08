import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { map, Observable } from "rxjs";
import { ConstantLogin } from "../constants/path-constants-login";
import { Login } from "../models/interface/login";
import { RestService } from "./rest.service";

export const TOKEN_NAME = 'usuario';

@Injectable({
    providedIn: 'root',
})
export class SesionService extends RestService {

    public tieneSesion: boolean = false;

    constructor(
        protected override http: HttpClient,
        public router: Router) {
        super(http);
        this.tieneSesion = this.obtenerToken() != null;
    }

    get isLoggedIn(): boolean {
        return this.tieneSesion;
    }

    iniciarSesion(body: Login): Observable<any> {
        return this.doPost(ConstantLogin.API_LOGIN, body)
            .pipe(
                map((response: any) => {
                    this.tieneSesion = response.valor;
                    localStorage.setItem(TOKEN_NAME, this.tieneSesion + '');
                    return response;
                })
            );
    }

    cerrarSesion() {
        localStorage.clear();
        this.tieneSesion = false;
        this.router.navigate(['']);
    }

    obtenerToken(): any {
        return localStorage.getItem(TOKEN_NAME);
    }
}