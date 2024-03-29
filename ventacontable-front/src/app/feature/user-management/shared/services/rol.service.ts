import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Observable } from "rxjs";
import { RestService } from "src/app/core/services/rest.service";
import { ConstantRol } from "../constants/path-constants-rol";
import { DataResponseRol } from "../interfaces/rol";

@Injectable({
    providedIn: 'root',
})
export class RolService extends RestService {

    constructor(
        protected override http : HttpClient){
            super(http);
    }

    listarRoles(): Observable<DataResponseRol> {
        return this.doGet<DataResponseRol>(ConstantRol.API_ROL)
            .pipe(
                map((response: DataResponseRol) => {
                    return response;
                })
            );
    }
}