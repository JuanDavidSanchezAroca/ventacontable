import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { tap } from 'rxjs';
import { Login } from 'src/app/core/models/interface/login';
import { SesionService } from 'src/app/core/services/session.service';
import { ModalType } from 'src/app/shared/enums/modal-type';
import { ModalService } from 'src/app/shared/services/modal.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm!: FormGroup;


  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private sesionService: SesionService,
    private modalService: ModalService) { }

  ngOnInit() {
    this.loginForm = this.obtenerFormulario();
  }

  private obtenerFormulario() {
    return this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  getControl(name: string) {
    return this.loginForm.get(name);
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const login: Login = {
        correo: this.loginForm.value.username,
        password: this.loginForm.value.password
      };
      this.sesionService.iniciarSesion(login).pipe(tap({
        next: () => {
          localStorage.setItem('user', 'true');
          this.router.navigate(['/home']);
        },
        error: (error) => {
          this.modalService.abrirModal(ModalType.WARNING,
            [
              'Tu usuario es inválido, verifica que tu mail y password estén correctos.\n',
              'Si aún no puedes ingresar dirigete a soporte.',
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

}
