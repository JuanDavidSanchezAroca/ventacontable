import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { RestService } from "src/app/core/services/rest.service";
import { Product } from "../interfaces/product";
import { ConstantProduct } from "../constants/path-constants-ptoduct";
import { Observable, map } from "rxjs";

@Injectable({
    providedIn: 'root',
})
export class ProductService extends RestService {

    constructor(
        protected override http: HttpClient) {
        super(http);
    }

    createProduct(body:Product): Observable<any>{
        return this.doPost(ConstantProduct.API_PRODUCT,body)
        .pipe(
            map((response: any) => {
                return response;
            })
        );
    }
}