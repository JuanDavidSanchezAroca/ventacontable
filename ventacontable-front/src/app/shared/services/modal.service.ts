import { Injectable } from "@angular/core";
import { MatDialog, MatDialogConfig, MatDialogRef } from "@angular/material/dialog";
import { CustomModalComponent } from "../components/custom-modal/custom-modal.component";
import { ModalType } from "../enums/modal-type";
import { CustomModal } from "../models/CustomModal";

@Injectable()
export class ModalService {

    constructor(private dialog: MatDialog) { }

    private modalError: CustomModal = {
        type: ModalType.ERROR,
        panelClass: ['bg-error'],
        cssClass: 'bg-error',
    };

    abrirModal(type: ModalType, modalMessage?: string | string[], modalConfig?: any): MatDialogRef<CustomModalComponent> {
        return this.abrirModalConTitulo(type, "", modalMessage, modalConfig)
    }

    abrirModalConTitulo(type: ModalType, title: string, message?: string | string[], modalConfig?: any): MatDialogRef<CustomModalComponent> {
        const config = this.obtenerDefaultConfig(type);
        const data = Object.assign(
            {
                type,
                title,
                message,
                autoFocus: false
            },
            config,
            modalConfig
        );
        const dialogConfig = new MatDialogConfig();
        dialogConfig.autoFocus = false;
        dialogConfig.data = data;
        dialogConfig.panelClass = config.panelClass;
        return this.dialog.open(CustomModalComponent, dialogConfig);
    }

    private obtenerDefaultConfig(type: ModalType): CustomModal {
        return this.modalError;
    }
}