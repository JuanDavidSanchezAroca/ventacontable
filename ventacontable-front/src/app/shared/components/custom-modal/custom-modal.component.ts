import { Component, Inject, NgModule } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ModalType } from '../../enums/modal-type';
import { CustomModal } from '../../models/CustomModal';
import { MODAL_MESSAGE } from './constants';


@Component({
  selector: 'app-custom-modal',
  templateUrl: './custom-modal.component.html',
  styleUrls: ['./custom-modal.component.scss']
})
export class CustomModalComponent {
  
  modalMessage = MODAL_MESSAGE;
  customModalType = ModalType;
  dataModal: CustomModal;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<CustomModalComponent>) {
    this.dataModal = data;
  }

  close() {
    this.dialogRef.close();
  }

  isList(value: any) {
    return value instanceof Array;
  }

}

