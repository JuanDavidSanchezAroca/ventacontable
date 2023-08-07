import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Observable } from "rxjs";
import { RestService } from "src/app/core/services/rest.service";
import { Categoria } from "src/app/feature/user-management/shared/interfaces/category";
import { ConstantCategory } from "../constants/path-constants-category";
import { Category, DataResponseCategory } from "../interfaces/category";

@Injectable({
    providedIn: 'root',
})
export class CategoryService extends RestService {

    constructor(
        protected override http: HttpClient) {
        super(http);
    }

    listarCategorias(): Observable<DataResponseCategory> {
        return this.doGet<DataResponseCategory>(ConstantCategory.API_CATEGORY)
            .pipe(
                map((response: DataResponseCategory) => {
                    return response;
                })
            );
    }

    crearCategoria(body:Category): Observable<any>{
        return this.doPost(ConstantCategory.API_CATEGORY,body)
        .pipe(
            map((response: any) => {
                return response;
            })
        );
    }

    updateCategory(body:Category): Observable<any>{
        const url = `${ConstantCategory.API_CATEGORY}/${body.id}`;

        return this.doPut(url, body).pipe(
            map((response: any) => response)
        );
    }
}