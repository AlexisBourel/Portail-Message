import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TourneeComponent } from './tournee/tournee.component';
import { SupervisionComponent } from './supervision/supervision.component';
import { IndexComponent } from './index/index.component';

const routes: Routes = [
  { path: '', redirectTo: 'portail-message', pathMatch: 'full' },
  { path: 'portail-message', component: IndexComponent, children : [
    { path: 'select-tournee', component: TourneeComponent},
    { path: 'supervision', component: SupervisionComponent}
  ]},
  { path: 'supervision', component: SupervisionComponent}
  
]


@NgModule({

  imports: [ RouterModule.forRoot(routes) ],
  
  exports: [ RouterModule ]
})
export class AppRoutingModule { }