import { Injectable } from '@angular/core';
import { AuthHttp } from 'angular2-jwt';

import { Jual } from './jual/jual.model';
import { Transfer } from './transfer/transfer.model';

@Injectable()
export class AppService {

  	juals: Jual[];
  	transfer: Transfer[];

	constructor(private authHttp: AuthHttp) { }

  	getJuals(): Promise<Jual[]> {
    	let url: string = "/api/jual/";

    	return this.authHttp.get(url).toPromise()
    		.then(res => this.juals = res.json().content as Jual[])
      		.catch(this.handleError);
  	}

  	getTransfer(): Promise<Transfer[]> {
  		let url: string = "/api/transfer/";

  		return this.authHttp.get(url).toPromise()
  			.then(hasil => this.transfer = hasil.json().content as Transfer[])
  			.catch(this.handleError);
  	}

  	private handleError(error: any): Promise<any> {
    	console.error('An error occurred: ', error); // for demo only
    	return Promise.reject(error.message || error);
  	}

	// getAllJual(): Promise<any> {
	// 	let url: string = "/api/jual/";
	// 	this.authHttp.get(url).subscribe(
	// 		data => console.log("data jual:: " + data.json().content),
	// 		error => console.log("error data jual:: " + error),
	// 		() => console.log('Request Complete!')
	// 	);

	// 	return Promise.resolve();

	// 	// console.log("menyimpan transaksi penjualan sampah: " 
	// 		// + JSON.stringify(jual));

	// 	// let url: string = "/api/jual/";
	// 	// this.authHttp.post(url, jual).toPromise().then(hasil => hasil.status)
	// 	// 	.catch(error => console.log(error));

	// 	// return Promise.resolve("sukses");
	// }

	jualSampah(jual: Jual): Promise<string> {
		jual.username = "fvsaddam";
		
		if(jual.jenis == 'plastik') {
			jual.harga = 2200;
			
		} else if(jual.jenis == 'karet') {
			jual.harga = 1000;
				
		} else if(jual.jenis == 'botol kaca') {
			jual.harga = 500;
			
		} else if(jual.jenis == 'kertas') {
			jual.harga = 1500;
		}

		console.log("menyimpan transaksi penjualan sampah: " + JSON.stringify(jual));

		let url: string = "/api/jual/";
		this.authHttp.post(url, jual).toPromise().then(hasil => hasil.status)
			.catch(error => console.log(error));

		return Promise.resolve("sukses");
	}

	private extractData(res: Response) {
        let body = res.json();
        return body || {};
    }

}
