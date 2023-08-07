import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { tap } from 'rxjs';
import { Categoria } from 'src/app/feature/user-management/shared/interfaces/category';
import { ModalType } from 'src/app/shared/enums/modal-type';
import { ModalService } from 'src/app/shared/services/modal.service';
import { Category } from '../../interfaces/category';
import { ModalCategory } from '../../interfaces/modal.category';
import { CategoryService } from '../../services/category.service';

@Component({
  selector: 'app-modal-category',
  templateUrl: './modal-category.component.html',
  styleUrls: ['./modal-category.component.scss']
})
export class ModalCategoryComponent implements OnInit {

  categoryForm!: FormGroup;
  title: string = "";
  titleButton: string = "";
  modalCategory!: ModalCategory;

  constructor(
    public dialogRef: MatDialogRef<ModalCategoryComponent>,
    private formBuilder: FormBuilder,
    private categoryService: CategoryService,
    private modalService: ModalService,
    @Inject(MAT_DIALOG_DATA) public data: ModalCategory
  ) {
    this.modalCategory = data;
  }

  ngOnInit() {
    this.categoryForm = this.obtenerFormulario();
    this.preLoadInfo();
  }

  private obtenerFormulario() {
    return this.formBuilder.group({
      nombre: ['', Validators.required],
      descripcion: ['', Validators.required],
    });
  }

  preLoadInfo() {
    if (this.data.add) {
      this.title = "Crear categoria";
      this.titleButton = "Agregar";
    } else if (this.data.updated) {
      this.title = "Actualizar categoria";
      this.titleButton = "Actualizar";
    } else {
      this.title = "Eliminar categoria";
      this.titleButton = "Eliminar";
    }
  }

  getControl(name: string) {
    return this.categoryForm.get(name);
  }


  onSubmit() {
    if (this.categoryForm.valid) {
      const formData = this.categoryForm.value;
      const categoria: Category = {
        id: this.modalCategory.category?.id,
        nombre: formData.nombre,
        descripcion: formData.descripcion
      };
      if(this.modalCategory.add){
        this.createCategory(categoria);
      }else if(this.modalCategory.updated){
        this.updateCategory(categoria);
      }else {

      }
    }

  }


  createCategory(category: Category) {
    this.categoryService.crearCategoria(category).pipe(tap({
      next: () => {
        this.modalService.abrirModal(ModalType.SUCCESS,
          [
            'Registro exitoso.\n',
          ]);
        this.dialogRef.close();
      },
      error: (error) => {
        this.modalService.abrirModal(ModalType.ERROR,
          [
            'La categoria no se pudo crear.\n',
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

  updateCategory(category: Category) {
    this.categoryService.updateCategory(category).pipe(tap({
      next: () => {
        this.modalService.abrirModal(ModalType.SUCCESS,
          [
            'Registro exitoso.\n',
          ]);
        this.dialogRef.close();
      },
      error: (error) => {
        this.modalService.abrirModal(ModalType.ERROR,
          [
            'La categoria no se pudo crear.\n',
          ],
          {
            colorIcon: 'red',
            height: '250px',
            width: '291px',
          })
      }
    })).subscribe();
  }



  onNoClick(): void {
    this.dialogRef.close();
  }
}
