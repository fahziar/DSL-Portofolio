@Grab(group='org.freemarker', module='freemarker', version='2.3.23')

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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

    def static buat(Closure buatPortofolio){
        Portofolio portofolio = new Portofolio();
        buatPortofolio.delegate = portofolio;
        buatPortofolio()

        //Freemarker configuration object
        Configuration cfg = new Configuration();
        try {
            //Load template from source folder
            Template template = cfg.getTemplate("index.ftl");
            
            // Build the data-model
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("namaPemilik", portofolio.namaPemilik);
            data.put("deskripsi", portofolio.deskripsi);
            data.put("foto", portofolio.foto);
            data.put("kontakPemilik", portofolio.kontakPemilik);
            data.put("daftarKeahlian", portofolio.daftarKeahlian);
            data.put("daftarPekerjaan", portofolio.daftarPekerjaan);

            //Copy file
            Util.copyFolder(new File(System.getProperty("user.dir") + "/templates/template-front-end"), new File(System.getProperty("user.dir") + "/output"));

            // File output
            Writer file = new FileWriter (new File(System.getProperty("user.dir") + "/output/index.html"));
            template.process(data, file);
            file.flush();
            file.close();

            println "Sukses membuat portofolio"
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
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
