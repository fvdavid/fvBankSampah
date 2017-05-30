export class Jual {

	id: number;
	username: string;
	// public jenis: string;
	// public harga: number;
	// public jumlah: number;
	// public total: number;

	constructor(public jenis: string, public harga: number,
		public jumlah: number){}

	getJenis(): number {
		if(this.jenis == 'plastik') {
			return 2200;
		} else if(this.jenis == 'karet') {
			return 1000;
		} else if(this.jenis == 'botol kaca') {
			return 500;
		} else if(this.jenis == 'kertas') {
			return 1500;
		}
	}

	getTotal(): number {
		if(this.jenis == 'plastik') {
			return 2200 * this.jumlah;
		} else if(this.jenis == 'karet') {
			return 1000 * this.jumlah;
		} else if(this.jenis == 'botol kaca') {
			return 500 * this.jumlah;
		} else if(this.jenis == 'kertas') {
			return 1500 * this.jumlah;
		}
		
	}

	
}