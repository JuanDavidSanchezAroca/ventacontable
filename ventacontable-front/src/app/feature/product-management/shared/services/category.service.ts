import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Observable } from "rxjs";
import { RestService } from "src/app/core/services/rest.service";
import { Categoria } from "src/app/feature/user-management/shared/interfaces/category";
import { DataResponseCategory } from "../interfaces/category";

@Injectable({
    providedIn: 'root',
})
export class CategoryService extends RestService {

    constructor(
        protected override http: HttpClient) {
        super(http);
    }

    listarCategorias(): Observable<DataResponseCategory> {
        return this.doGet<DataResponseCategory>("/api/ventacontable/categoria")
            .pipe(
                map((response: DataResponseCategory) => {
                    return response;
                })
            );
    }

    crearCategoria(body:Categoria): Observable<any>{
        return this.doPost("/api/ventacontable/categoria",body)
        .pipe(
            map((response: any) => {
                return response;
            })
        );
    }
}