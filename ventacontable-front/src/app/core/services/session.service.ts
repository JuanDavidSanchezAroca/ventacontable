import { Injectable } from "@angular/core";
import { map, Observable } from "rxjs";
import { Login } from "../models/interface/login";
import { RestService } from "./rest.service";

@Injectable({
    providedIn: 'root',
})
export class SesionService {

    public tieneSesion: boolean = false;

    constructor(
        private restService: RestService) {
    }

    get isLoggedIn(): boolean {
        return this.tieneSesion;
    }

    iniciarSesion(body: Login): Observable<any> {
        return this.restService.doPost("/api/ventacontable/usuario/validar", body)
            .pipe(
                map((response: any) => {
                    this.tieneSesion = response.valor;
                    console.log(this.tieneSesion)
                    return response;
                })
            );
    }
}