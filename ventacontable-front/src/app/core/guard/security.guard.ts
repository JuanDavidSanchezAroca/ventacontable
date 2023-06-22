import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { SesionService } from '../services/session.service';

@Injectable({
    providedIn: 'root'
})

export class SecurityGuard implements CanActivate {

    constructor(
        private sessionService: SesionService,
        private router: Router,
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (this.sessionService.isLoggedIn) {
            return true;
        }
        this.router.navigate(['/login']);
        return false;
    }
}