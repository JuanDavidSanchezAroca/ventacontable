import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ModalCategoryComponent } from '../../shared/components/modal-category/modal-category.component';
import { Category } from '../../shared/interfaces/category';
import { ModalCategory } from '../../shared/interfaces/modal.category';
import { CategoryService } from '../../shared/services/category.service';

@Component({
  selector: 'app-create-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit, AfterViewInit {

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  displayedColumns: string[] = ['id', 'nombre', 'descripcion'];
  categoryList = new MatTableDataSource<Category>([]);
  selectedElement: Category | undefined;

  constructor(
    private categoryService: CategoryService,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.getListCategories();
  }

  ngAfterViewInit() {
    this.categoryList.paginator = this.paginator;
  }

  getListCategories() {
    this.categoryService.listarCategorias().subscribe(
      result => {
        this.categoryList.data = result.valor.slice();
      }
    )
  }

  openDialog(updateCategory: boolean, deleteCategory: boolean, addCategory: boolean): void {
    const datos: ModalCategory  = {
      category: this.selectedElement,
      updated: updateCategory,
      delete: deleteCategory,
      add: addCategory
    }
    const dialogRef = this.dialog.open(ModalCategoryComponent, {data: datos});

    dialogRef.afterClosed().subscribe(() => {
      this.getListCategories();
      this.selectedElement = undefined;
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.categoryList.filter = filterValue.trim().toLowerCase();
  }

  selectElement(element: Category) {
    this.selectedElement = element;
  }

}
