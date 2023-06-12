import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InicioComponent } from './vistas/inicio/inicio.component';
import { MatCardModule } from '@angular/material/card';
import { HomeRoutingModule } from './home-routing.module';
import { MatButtonModule } from '@angular/material/button';



@NgModule({
  declarations: [
    InicioComponent,
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatButtonModule,
    HomeRoutingModule
  ]
})
export class HomeModule { }
