import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalType } from 'src/app/shared/enums/modal-type';
import { ModalService } from 'src/app/shared/services/modal.service';
import { GenderType } from '../../shared/interfaces/gender-type';
import { DataResponseRol } from '../../shared/interfaces/rol';
import { TypeDoc } from '../../shared/interfaces/type-doc';
import { Persona, Usuario } from '../../shared/interfaces/user';
import { PersonaService } from '../../shared/services/persona.service';
import { RolService } from '../../shared/services/rol.service';



@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss']
})
export class CreateUserComponent implements OnInit {

  formulario!: FormGroup;
  typesDocuments: TypeDoc[] = [
    { value: "CC", viewValue: "Cédula de Ciudadanía (CC)" },
    { value: "TI", viewValue: "Tarjeta de Identidad (TI)" },
    { value: "CE", viewValue: "Cédula de Extranjería (CE)" },
    { value: "PASS", viewValue: "Pasaporte (PASS)" }
  ]

  genderType: GenderType[] = [
    { value: "MASCULINO", viewValue: "Masculino" },
    { value: "FEMENINO", viewValue: "Femenino" }
  ]

  typeRoles!: DataResponseRol;

  constructor(
    private formBuilder: FormBuilder,
    private rolService: RolService,
    private personaService: PersonaService,
    private modalService: ModalService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.getListRoles()
    this.inicializarFormulario();
  }

  inicializarFormulario(): void {
    this.formulario = this.formBuilder.group({
      identificacion: ['', Validators.required],
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      tipoDocumento: ['', Validators.required],
      fechaNacimiento: ['', Validators.required],
      genero: ['', Validators.required],
      telefono: ['', Validators.required],
      direccion: ['', Validators.required],
      correo: ['', [Validators.required, Validators.email]],
      tipoRol: ['', Validators.required]
    });
  }

  getListRoles() {
    this.rolService.listarRoles().subscribe(
      result => {
        this.typeRoles = result
      }
    )
  }

  getControl(name: string) {
    return this.formulario.get(name);
  }

  submitFormulario(): void {
    if (this.formulario.valid) {
      const formData = this.formulario.value;

      const usuario: Usuario = {
        correo: formData.correo
      };

      const persona: Persona = {
        identificacion: formData.identificacion,
        nombre: formData.nombre,
        apellido: formData.apellido,
        fechaNacimiento: new Date(formData.fechaNacimiento).toISOString().slice(0, 10).toString(),
        tipoDocumento: formData.tipoDocumento,
        telefono: formData.telefono,
        genero: formData.genero,
        usuario: usuario,
        direccion: formData.direccion,
        rol: formData.tipoRol
      };

      this.personaService.registrar(persona).then(() => {
        this.modalService.abrirModal(ModalType.SUCCESS,
          ['Usuario registrado',]);
        this.router.navigate(['/home']);
      }).catch((error) => {
        this.modalService.abrirModal(ModalType.ERROR,
          [
            'Error en la creacion del usuario\n',
          ],
          {
            colorIcon: 'red',
            height: '250px',
            width: '291px',
          })
      })
    }
  }
}
