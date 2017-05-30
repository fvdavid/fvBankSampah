import { Component, OnInit } from '@angular/core';

import { AppService } from '../app.service';

import { Jual } from '../jual/jual.model';
import { Transfer } from '../transfer/transfer.model';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

	showHide: boolean = true;
	transfershow: boolean = false;

  	juals: Jual[];
  	transfers: Transfer[];

  	today: number = Date.now();

  	constructor(private appService: AppService) {  		
 		this.appService.getTransfer().then(transfer => this.transfers = transfer);
  	}

 	ngOnInit() {
 		this.appService.getJuals().then(hasil => this.juals = hasil);
 	}
 	
 	changeShowStatus() {
 		this.transfershow = !this.transfershow;
 	}
}
