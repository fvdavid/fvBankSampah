import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

import { Jual } from './jual.model';
import { AppService } from '../app.service';

@Component({
  selector: 'app-jual',
  templateUrl: './jual.component.html',
  styleUrls: ['./jual.component.css']
})
export class JualComponent implements OnInit {

	jual: Jual = new Jual('plastik', 2200, 1);

	jenisSampah = [
		{ name: "plastik" },
		{ name: "karet" },
		{ name: "botol kaca" },
		{ name: "kertas" }
	];

	constructor(private appService: AppService, private router: Router) { }

	ngOnInit() { }

  sampah(): void {
  	if(this.jual.jenis == 'plastik') {
  		this.jual.harga = 2200;
 
 		} else if(this.jual.jenis == 'karet') {
 			this.jual.harga = 1000;
  			
 		} else if(this.jual.jenis == 'botol kaca') {
 			this.jual.harga = 500;
  		
 		} else if(this.jual.jenis == 'kertas') {
 			this.jual.harga = 1500;
 		}
  		
 		console.log("menyimpan transaksi penjualan sampah: " + JSON.stringify(this.jual)); 		
 	}

	jualSampah(): void {
		this.appService.jualSampah(this.jual).then(hasil => {
			console.log("penjualan berhasil disimpan dengan:: ");

			if(hasil) {
    			this.router.navigate(['/']);
    		
    		} else {
    			console.log("login gagal");
    		}
		});
	}

}
