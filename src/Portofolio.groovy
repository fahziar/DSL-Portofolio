import javax.sound.sampled.Port

/**
 * Created by fahziar on 30/11/2015.
 */
class Portofolio {
    String namaPemilik;
    String deskripsi;
    String foto;
    Kontak kontakPemilik;
    List<Keahlian> daftarKeahlian;
    List<Pekerjaan> daftarPekerjaan;

    def static make(Closure buatPortofolio){
        Portofolio portofolio = new Portofolio();
        buatPortofolio.delegate = portofolio;
        buatPortofolio()
        println buatPortofolio.delegate;
    }

    Portofolio(){
        daftarKeahlian = new ArrayList<>()
        daftarPekerjaan = new ArrayList<>()
    }

    def nama(String namaPemilik){
        this.namaPemilik = namaPemilik;
    }

    def deskripsiDiri(String deskripsi){
        this.deskripsi = deskripsi;
    }

    def linkFoto(String foto){
        this.foto = foto;
    }

    def kontak(Closure buatKontak){
        Kontak kontakPemilik = new Kontak();
        buatKontak.delegate = kontakPemilik;
        buatKontak()
        this.kontakPemilik = kontakPemilik;
    }

    def keahlian(Closure tambahKeahlian){
        Keahlian tmp = new Keahlian();
        tambahKeahlian.delegate = tmp;
        tambahKeahlian()
        this.daftarKeahlian.push(tmp);
    }

    def pekerjaan(Closure tambahPekerjaan){
        Pekerjaan tmp = new Pekerjaan();
        tambahPekerjaan.delegate = tmp;
        tambahPekerjaan();
        this.daftarPekerjaan.push(tmp);

    }
}
