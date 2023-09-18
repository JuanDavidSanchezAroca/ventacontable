import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductManagementRoutingModule } from './product-management-routing.module';
import { CategoryComponent } from './vista/category/category.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { ModalCategoryComponent } from './shared/components/modal-category/modal-category.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { ModalService } from 'src/app/shared/services/modal.service';
import { MatTabsModule } from '@angular/material/tabs';
import { InicioComponent } from './vista/inicio/inicio.component';
import { ProductComponent } from './vista/product/product.component';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatExpansionModule } from '@angular/material/expansion';



@NgModule({
  declarations: [
    CategoryComponent,
    ModalCategoryComponent,
    InicioComponent,
    ProductComponent
  ],
  imports: [
    CommonModule,
    ProductManagementRoutingModule,
    MatTableModule,
    MatPaginatorModule,
    MatCardModule,
    MatButtonModule,
    MatDividerModule,
    MatIconModule,
    MatDialogModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatTabsModule,
    MatCheckboxModule,
    MatExpansionModule
  ],
  providers:[
    ModalService
  ]
})
export class ProductManagementModule { }
