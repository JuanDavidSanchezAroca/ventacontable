import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomModalComponent } from './components/custom-modal/custom-modal.component';
import { MatIconModule } from '@angular/material/icon';


@NgModule({
  declarations: [
    CustomModalComponent
  ],
  imports: [
    CommonModule,
    MatIconModule
  ]
})
export class SharedModule { }
