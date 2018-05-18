import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TourneeComponent } from './tournee/tournee.component';
import { SupervisionComponent } from './supervision/supervision.component';
import { IndexComponent } from './index/index.component';
import { NavComponent } from './nav/nav.component';
import { AuthentificationComponent } from './authentification/authentification.component';
import { AccueilComponent } from './accueil/accueil.component';

const routes: Routes = [
  { path: '', redirectTo: 'portail-message/authentification', pathMatch: 'full' },
  { path: 'portail-message', redirectTo: 'portail-message/authentification', pathMatch: 'full' },
  { path: 'portail-message', component: IndexComponent, children : [
    { path: 'authentification', component: AuthentificationComponent},
    { path: 'accueil', component: AccueilComponent},
    { path: 'supervision', component: SupervisionComponent, children : [
      { path: 'accueil', component: AccueilComponent},
    ]}
  ]},  
]


@NgModule({

  imports: [ RouterModule.forRoot(routes) ],
  
  exports: [ RouterModule ]
})
export class AppRoutingModule { }