import { Component, EventEmitter, OnDestroy, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ObservableService } from 'src/app/shared/services/sesion/observable.service';
import { SesionService } from '../../services/session.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit, OnDestroy{

  @Output() toggleEvent = new EventEmitter<void>();

  mostrarInformacionMenu!: Subscription;
  mostrarMenu = false;

  constructor(
    private readonly navbarService: ObservableService,
    private readonly router: Router,
    private readonly sesionService: SesionService){}

  cerrarSesion(){
    this.navbarService.mostrarInformacion(false);
    this.sesionService.cerrarSesion();
    this.router.navigate(['/login'])
  }


  ngOnInit() {
    this.mostrarInformacionMenu = this.navbarService.montrarMenu.subscribe(
      (data) => {
        this.mostrarMenu = data;
      }
    );
  }

  ngOnDestroy(): void {
    this.mostrarInformacionMenu.unsubscribe();
  }
}
