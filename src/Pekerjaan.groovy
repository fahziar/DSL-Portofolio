/**
 * Created by fahziar on 30/11/2015.
 */
class Pekerjaan {
    String judul;
    String deskripsi;
    String gambar;

    Pekerjaan() {
        judul = ""
        deskripsi = ""
        gambar = ""
    }

    def judulPekerjaan(String judul){
        this.judul = judul;
    }

    def deskripsiPekerjaan(String deskripsi){
    	this.deskripsi = deskripsi;
    }

    def gambarPekerjaan(String gambar){
    	this.gambar = gambar;
    }
}
