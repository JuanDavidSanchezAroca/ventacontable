import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ModalCreateCategoryComponent } from '../../shared/components/modal-create-category/modal-create-category.component';
import { Category } from '../../shared/interfaces/category';
import { CategoryService } from '../../shared/services/category.service';

@Component({
  selector: 'app-create-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit , AfterViewInit{

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  displayedColumns: string[] = ['id', 'nombre', 'descripcion'];
  categoryList = new MatTableDataSource<Category>([]);

  constructor(
    private categoryService: CategoryService,
    public dialog: MatDialog
    ){}

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

  openDialog(): void {
    const dialogRef = this.dialog.open(ModalCreateCategoryComponent);

    dialogRef.afterClosed().subscribe(() => {
      this.getListCategories();
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.categoryList.filter = filterValue.trim().toLowerCase();
  }

}
