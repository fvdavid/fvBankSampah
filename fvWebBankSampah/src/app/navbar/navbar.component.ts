import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

	title = "Aplikas Bank Sampah";

  	constructor() { }

  	ngOnInit() { }

  	logout() : void {
	  	// this.authService.logout();
		// this.router.navigate(['login']);
  	}

}
