import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryComponent } from './vista/category/category.component';
import { InicioComponent } from './vista/inicio/inicio.component';
import { ProductComponent } from './vista/product/product.component';

const routes: Routes = [
  {
    path: '',
    component: InicioComponent,
  },
  {
    path: 'category',
    component: CategoryComponent,
  },
  {
    path: 'product',
    component: ProductComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductManagementRoutingModule { }