/**
 * Created by fahziar on 30/11/2015.
 */
class Kontak {
    String facebook;
    String twitter;
    String telepon;
    String github;
    String linkedin;
    String email;

    Kontak() {
        facebook = ""
        twitter = ""
        telepon = ""
        github = ""
        linkedin = ""
        email = ""
    }

    def linkFacebook(String facebook){
        this.facebook = facebook;
    }

    def linkTwitter(String twitter){
    	this.twitter = twitter;
    }

    def nomorTelepon(String telepon){
    	this.telepon = telepon;
    }

    def linkGithub(String github){
    	this.github = github;
    }

    def linkLinkedin(String linkedin){
    	this.linkedin = linkedin;
    }

    def alamatEmail(String email){
    	this.email = email;
    }

}
