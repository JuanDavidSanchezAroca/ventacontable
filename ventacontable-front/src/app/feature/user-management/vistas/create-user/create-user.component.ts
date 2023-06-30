import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GenderType } from '../../shared/interfaces/gender-type';
import { TypeDoc } from '../../shared/interfaces/type-doc';



@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss']
})
export class CreateUserComponent  implements OnInit{
  
  formulario!: FormGroup;
  typesDocuments: TypeDoc[] = [
    { value: "CC", viewValue: "Cédula de Ciudadanía (CC)"},
    { value: "TI", viewValue: "Tarjeta de Identidad (TI)"},
    { value: "CE", viewValue: "Cédula de Extranjería (CE)"},
    { value: "PASS", viewValue: "Pasaporte (PASS)"}
  ]

  genderType: GenderType[] = [
    { value: "MASCULINO", viewValue:"Masculino"},
    { value: "FEMENINO", viewValue:"Femenino"}
  ]

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.inicializarFormulario();
  }

  inicializarFormulario(): void {
    this.formulario = this.formBuilder.group({
      identificacion: ['', Validators.required],
      nombre: ['', Validators.required],
      apellido: ['', Validators.required]
    });
  }

  submitFormulario(): void {
    if (this.formulario.valid) {
      // Aquí puedes enviar los datos del formulario al servidor o realizar otras acciones
      console.log(this.formulario.value);
    }
  }

}
