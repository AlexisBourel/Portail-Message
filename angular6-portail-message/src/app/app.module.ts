import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { MessageComponent } from './message/message.component';
import { TourComponent } from './tour/tour.component';
import { UserComponent } from './user/user.component';
import { MaterialAppModule } from './ng6material.module';
import { AppRoutingModule } from './app-routing.module';
import { TourService } from './tour/tour.service';
import { SupervisionComponent } from './supervision/supervision.component';
import { NavComponent } from './nav/nav.component';
import { IndexComponent } from './index/index.component';
import { UserService } from './user/user.service';
import { AuthentificationComponent } from './authentification/authentification.component';
import { AccueilComponent } from './accueil/accueil.component';
import { MessageService } from './message/message.service';
import { CreateMessageComponent } from './message/create-message/create-message.component';

@NgModule({
  declarations: [
    AppComponent,
    MessageComponent,
    TourComponent,
    UserComponent,
    SupervisionComponent,
    NavComponent,    
    IndexComponent,
    AuthentificationComponent,
    AccueilComponent,
    CreateMessageComponent
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialAppModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule.forRoot(),
  ],
  providers: [ TourService, UserService, MessageService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
