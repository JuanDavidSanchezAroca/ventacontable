import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './vistas/login/login.component';
import { LoginRoutingModule } from './login-routing.module';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import { ModalService } from 'src/app/shared/services/modal.service';
import { MatDialogModule } from '@angular/material/dialog';



@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,
    MatCardModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatButtonModule
  ],
  providers:[
    ModalService
  ]
})
export class LoginModule { }
