import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TourComponent } from './tour/tour.component';
import { SupervisionComponent } from './supervision/supervision.component';
import { IndexComponent } from './index/index.component';
import { NavComponent } from './nav/nav.component';
import { AuthentificationComponent } from './authentification/authentification.component';
import { AccueilComponent } from './supervision/accueil/accueil.component';
import { MessageComponent } from './message/message.component';
import { CreateMessageComponent } from './message/create-message/create-message.component';
import { UpdateMessageComponent } from './message/update-message/update-message.component';
import { UserComponent } from './user/user.component';
import { ListUserComponent } from './user/list-user/list-user.component';
import { CreateUserComponent } from './user/create-user/create-user.component';
import { UpdateUserComponent } from './user/update-user/update-user.component';
import { TourMessageComponent } from './tour/tour-message/tour-message.component';

const routes: Routes = [
  { path: '', redirectTo: 'portail-message/authentification', pathMatch: 'full' },
  { path: 'portail-message', redirectTo: 'portail-message/authentification', pathMatch: 'full' },
  { path: 'portail-message/supervision', redirectTo: 'portail-message/supervision/accueil', pathMatch: 'full' },
  { path: 'portail-message/supervision/message/nouveau/back'
    , redirectTo: 'portail-message/supervision/message', pathMatch: 'full' },
  { path: 'portail-message', component: IndexComponent, children: [
    { path: 'authentification', component: AuthentificationComponent },
    { path: 'accueil', component: AccueilComponent },
    { path: 'supervision', component: SupervisionComponent, children: [
      { path: 'accueil', component: AccueilComponent },
      { path: 'user', component: UserComponent, children: [ 
        { path: 'list', component: ListUserComponent },
        { path: 'nouveau', component: CreateUserComponent },
        { path: 'modifier/:id', component: UpdateUserComponent },
      ] },      
      { path: 'tournee', component: TourComponent },
      { path: 'tournee/:id', component: TourMessageComponent },
      { path: 'message', component: MessageComponent, },
      { path: 'message/nouveau', component: CreateMessageComponent },
      { path: 'message/modifier/:id', component: UpdateMessageComponent },
    ]}
  ]},
]


@NgModule({

  imports: [RouterModule.forRoot(routes)],

  exports: [RouterModule]
})
export class AppRoutingModule { }