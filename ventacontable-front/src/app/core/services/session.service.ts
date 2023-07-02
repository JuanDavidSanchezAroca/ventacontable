import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Observable } from "rxjs";
import { Login } from "../models/interface/login";
import { RestService } from "./rest.service";

@Injectable({
    providedIn: 'root',
})
export class SesionService extends RestService {

    public tieneSesion: boolean = false;

    constructor(
        protected override http: HttpClient) {
            super(http);
    }

    get isLoggedIn(): boolean {
        return this.tieneSesion;
    }

    iniciarSesion(body: Login): Observable<any> {
        return this.doPost("/api/ventacontable/usuario/validar", body)
            .pipe(
                map((response: any) => {
                    this.tieneSesion = response.valor;
                    console.log(this.tieneSesion)
                    return response;
                })
            );
    }
}