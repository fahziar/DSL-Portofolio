/**
 * Created by fahziar on 30/11/2015.
 */
class Keahlian {
	String nama;
    String deskripsi;
	
	Keahlian() {
        deskripsi = ""
        nama = ""
    }

    def namaKeahlian(String nama){
        this.nama = nama;
    }

    def deskripsiKeahlian(String deskripsi){
    	this.deskripsi = deskripsi;
    }
}
