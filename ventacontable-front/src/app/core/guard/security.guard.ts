import { Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { SesionService } from '../services/session.service';
import { ObservableService } from 'src/app/shared/services/sesion/observable.service';

@Injectable({
    providedIn: 'root'
})

export class SecurityGuard  {

    constructor(
        private sessionService: SesionService,
        private navbar: ObservableService,
        private router: Router,
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (this.sessionService.isLoggedIn) {
            this.navbar.mostrarInformacion(true);
            return true;
        }
        this.router.navigate(['/login']);
        return false;
    }
}