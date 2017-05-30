import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Http, HttpModule, RequestOptions } from '@angular/http';
import { SharedModule } from './shared/shared.module';
import { RouterModule, Routes } from "@angular/router";

import { AppComponent } from './app.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './shared/login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';

import { HistoryComponent } from './history/history.component';
import { TransferComponent } from './transfer/transfer.component';

import { JualComponent } from './jual/jual.component';

import { AppService } from './app.service';

import { AuthHttp, AuthConfig } from 'angular2-jwt';

export function authHttpServiceFactory(http: Http, options: RequestOptions) {
  return new AuthHttp(new AuthConfig({
      tokenName: 'access_token'
    }), http, options);
}

const routingApplikasi: Routes = [
  {
    path: "login", component: LoginComponent,
  },
  {
    path: "about", component: AboutComponent
  },
  {
    path: "jual", component: JualComponent
  },
  {
    path: "transfer", component: TransferComponent
  },
  {
    path: "history", component: HistoryComponent
  },
  {
    path: "**", component: WelcomeComponent
  }
];


@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    NavbarComponent,
    AboutComponent,
    WelcomeComponent,
    JualComponent,
    HistoryComponent,
    TransferComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    SharedModule,
    RouterModule.forRoot(routingApplikasi)
  ],
  providers: [
    AppService,
    {
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [Http, RequestOptions]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
