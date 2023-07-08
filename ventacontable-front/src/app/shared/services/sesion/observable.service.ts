import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable } from "rxjs";

@Injectable({
    providedIn: 'root',
  })
export class ObservableService {

  private readonly mostrarInformacionMenu: BehaviorSubject<boolean>;
  private readonly mostrarInformacionMenuObservable: Observable<boolean>;

  get montrarMenu() {
    return this.mostrarInformacionMenuObservable;
  }

  constructor() {
    this.mostrarInformacionMenu = new BehaviorSubject<boolean>(true);
    this.mostrarInformacionMenuObservable = this.mostrarInformacionMenu.asObservable();
  }

  public mostrarInformacion(mostrar: boolean) {
    this.mostrarInformacionMenu.next(mostrar);
  }
  
}