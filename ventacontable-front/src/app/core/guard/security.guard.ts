import { Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { SesionService } from '../services/session.service';
import { ObservableService } from 'src/app/shared/services/sesion/observable.service';
import { CookieService } from 'ngx-cookie-service';

export const TOKEN_NAME = 'token';

@Injectable({
    providedIn: 'root'
})
export class SecurityGuard  {

    constructor(
        private sessionService: SesionService,
        private navbar: ObservableService,
        private router: Router,
        private cookieService: CookieService,
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (this.sessionService.isLoggedIn && !this.sessionService.esTokenExpirado()) {
            this.navbar.mostrarInformacion(true);
            return true;
        }
        this.cookieService.delete(TOKEN_NAME);
        this.router.navigate(['/login']);
        return false;
    }
}