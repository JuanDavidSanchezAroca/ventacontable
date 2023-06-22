import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SecurityGuard } from './core/guard/security.guard';

const routes: Routes = [
  {
    path: 'login',
    loadChildren: () => import('./feature/login/login.module').then((m) => m.LoginModule)
  },
  {
    path: 'home',
    loadChildren: () =>
      import('./feature/home/home.module').then((m) => m.HomeModule),
    canActivate: [SecurityGuard]
  },
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  { path: './src/app', loadChildren: () => import('./shared/shared.module').then(m => m.SharedModule) },
  { path: '**', redirectTo: 'login', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
