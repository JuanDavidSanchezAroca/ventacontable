import { ModalType } from "../enums/modal-type";

export interface CustomModal {
    type: ModalType;
    colorIcon?: string;
    width?: string;
    height?: string;
    cssClass?: string;
    panelClass?: string[] | string;
    title?: string;
    message?: string;
  }