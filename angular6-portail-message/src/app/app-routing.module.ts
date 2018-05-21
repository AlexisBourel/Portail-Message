import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TourComponent } from './tour/tour.component';
import { SupervisionComponent } from './supervision/supervision.component';
import { IndexComponent } from './index/index.component';
import { NavComponent } from './nav/nav.component';
import { AuthentificationComponent } from './authentification/authentification.component';
import { AccueilComponent } from './accueil/accueil.component';
import { MessageComponent } from './message/message.component';
import { CreateMessageComponent } from './message/create-message/create-message.component';

const routes: Routes = [
  { path: '', redirectTo: 'portail-message/authentification', pathMatch: 'full' },
  { path: 'portail-message', redirectTo: 'portail-message/authentification', pathMatch: 'full' },
  { path: 'portail-message/supervision', redirectTo: 'portail-message/supervision/accueil', pathMatch: 'full' },
  { path: 'portail-message', component: IndexComponent, children: [
    { path: 'authentification', component: AuthentificationComponent },
    { path: 'accueil', component: AccueilComponent },
    { path: 'supervision', component: SupervisionComponent, children: [
      { path: 'accueil', component: AccueilComponent },
      { path: 'tour', component: TourComponent },
      { path: 'message', component: MessageComponent, },
      { path: 'message/create', component: CreateMessageComponent, },
      { path: 'message/create/back', redirectTo: 'portail-message/supervision/message', pathMatch: 'full' }
    ]}
  ]},
]


@NgModule({

  imports: [RouterModule.forRoot(routes)],

  exports: [RouterModule]
})
export class AppRoutingModule { }