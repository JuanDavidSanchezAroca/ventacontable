import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs";
import { RestService } from "src/app/core/services/rest.service";
import { ConstantUser } from "../constants/path-constants-user";
import { Persona } from "../interfaces/user";

@Injectable({
    providedIn: 'root',
})
export class PersonaService extends RestService {

    constructor(
        protected override http : HttpClient){
            super(http);
    }

    registrar(body: Persona): Promise<any> {
        return new Promise((resolve, reject) => {
          this.doPost(ConstantUser.API_USER, body)
            .pipe(
              catchError(error => {
                reject(error); 
                return error;
              })
            )
            .subscribe(response => {
              resolve(response); 
            });
        });
    }
}