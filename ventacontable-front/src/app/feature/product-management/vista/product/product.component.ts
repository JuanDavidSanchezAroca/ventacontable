import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Category } from '../../shared/interfaces/category';
import { MatTableDataSource } from '@angular/material/table';
import { CategoryService } from '../../shared/services/category.service';
import { MatPaginator } from '@angular/material/paginator';
import { ProductService } from '../../shared/services/product.service';
import { Product } from '../../shared/interfaces/product';
import { ModalService } from 'src/app/shared/services/modal.service';
import { ModalType } from 'src/app/shared/enums/modal-type';
import { tap } from 'rxjs';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})

export class ProductComponent implements OnInit, AfterViewInit {

  formulario!: FormGroup;
  step = 0;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  displayedColumns: string[] = ['select', 'nombre', 'descripcion'];
  categoryList = new MatTableDataSource<Category>([]);
  selectedItems: Category[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private categoryService: CategoryService,
    private productService: ProductService,
    private modalService: ModalService,
  ) { }

  ngOnInit(): void {
    this.inicializarFormulario();
    this.getListCategories();
  }

  ngAfterViewInit() {
    this.categoryList.paginator = this.paginator;
  }

  inicializarFormulario(): void {
    this.formulario = this.formBuilder.group({
      codigo: ['', Validators.required],
      nombre: ['', Validators.required],
      descripcion: ['', Validators.required],
      precioMinimo: ['', Validators.required],
      precioMaximo: ['', Validators.required],
      precioBase: ['', Validators.required],
      cantidadDisponible: ['', Validators.required],
      talla: [''],
      color: ['']
    });
  }

  getControl(name: string) {
    return this.formulario.get(name);
  }

  submitFormulario(): void {
    if (this.formulario.valid) {
      const formData = this.formulario.value;

      const categoryIds: number[] = this.selectedItems
        .map(category => category.id)
        .filter(id => id !== undefined) as number[];

      const product: Product = {
        codigo: formData.codigo,
        nombre: formData.nombre,
        descripcion: formData.descripcion,
        precioMinimo: formData.precioMinimo,
        precioMaximo: formData.precioMaximo,
        precioBase: formData.precioBase,
        talla: formData.talla,
        color: formData.color,
        cantidadDisponible: formData.cantidadDisponible,
        categorias: categoryIds
      };

      this.productService.createProduct(product).pipe(tap({
        next: () => {
          this.modalService.abrirModal(ModalType.SUCCESS,
            [
              'Registro exitoso.\n',
            ]);
        },
        error: (error) => {
          this.modalService.abrirModal(ModalType.ERROR,
            [
              'El producto no se pudo crear.\n',
              error.error.mensaje
            ],
            {
              colorIcon: 'red',
              height: '250px',
              width: '291px',
            })
        }
      })
      )
        .subscribe();
    }
  }

  isAllSelected(): boolean {
    return this.selectedItems.length === this.categoryList.data.length;
  }

  masterToggle(): void {
    if (this.isAllSelected()) {
      this.selectedItems = [];
    } else {
      this.selectedItems = [...this.categoryList.data];
    }
  }

  getListCategories() {
    this.categoryService.listarCategorias().subscribe(
      result => {
        this.categoryList.data = result.valor.slice();
      }
    )
  }

  toggleSelect(item: Category): void {
    const index = this.selectedItems.indexOf(item);
    if (index === -1) {
      this.selectedItems.push(item);
    } else {
      this.selectedItems.splice(index, 1);
    }
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.categoryList.filter = filterValue.trim().toLowerCase();
  }

  setStep(index: number) {
    this.step = index;
  }

  nextStep() {
    this.step++;
  }

  prevStep() {
    this.step--;
  }

}
