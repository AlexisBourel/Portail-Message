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
import { SupervisionComponent } from './supervision/supervision.component';
import { NavComponent } from './nav/nav.component';
import { IndexComponent } from './index/index.component';
import { AuthentificationComponent } from './authentification/authentification.component';
import { AccueilComponent } from './supervision/accueil/accueil.component';
import { CreateMessageComponent } from './message/create-message/create-message.component';
import { UpdateMessageComponent } from './message/update-message/update-message.component';
import { MessageService } from './services/message.service';
import { TourService } from './services/tour.service';
import { UserService } from './services/user.service';
import { ListUserComponent } from './user/list-user/list-user.component';
import { CreateUserComponent } from './user/create-user/create-user.component';
import { UpdateUserComponent } from './user/update-user/update-user.component';
import { TourMessageComponent } from './tour/tour-message/tour-message.component';

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
    CreateMessageComponent,
    UpdateMessageComponent,
    ListUserComponent,
    CreateUserComponent,
    UpdateUserComponent,
    TourMessageComponent
    
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
