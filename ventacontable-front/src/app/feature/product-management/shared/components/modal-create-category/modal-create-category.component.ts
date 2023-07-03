import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { tap } from 'rxjs';
import { Categoria } from 'src/app/feature/user-management/shared/interfaces/category';
import { ModalType } from 'src/app/shared/enums/modal-type';
import { ModalService } from 'src/app/shared/services/modal.service';
import { CategoryService } from '../../services/category.service';

@Component({
  selector: 'app-modal-create-category',
  templateUrl: './modal-create-category.component.html',
  styleUrls: ['./modal-create-category.component.scss']
})
export class ModalCreateCategoryComponent implements OnInit {

  categoryForm!: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<ModalCreateCategoryComponent>,
    private formBuilder: FormBuilder,
    private categoryService: CategoryService,
    private modalService: ModalService
  ) { }

  ngOnInit() {
    this.categoryForm = this.obtenerFormulario();
  }

  private obtenerFormulario() {
    return this.formBuilder.group({
      nombre: ['', Validators.required],
      descripcion: ['', Validators.required],
    });
  }

  getControl(name: string) {
    return this.categoryForm.get(name);
  }


  onSubmit() {
    if(this.categoryForm.valid){
      const formData = this.categoryForm.value;
      const categoria: Categoria = {
        nombre: formData.nombre,
        descripcion: formData.descripcion
      };
      this.categoryService.crearCategoria(categoria).pipe(tap({
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
    
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
