/**
 * Created by fahziar on 30/11/2015.
 */
class Portofolio {
    String nama;
    String deskripsi;
    String foto;
    String email;
    Keahlian[] keahlian;



    def static make(Closure closure){
        closure.delegate = new Portofolio(                         );
        closure()
        println closure.delegate;

    }
}
