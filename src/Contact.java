
/**
 * CONSTANT Lorvenson
 */

import java.util.List;



public class Contact {
    private String nom;
    private String prenom;
    private String email;
    private String adresseRue;
    private String adresseRueExtra;
    private String ville;
    private String pays;


    public Contact(String nom, String prenom, String email, String adresseRue, String adresseRueExtra, String ville, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresseRue = adresseRue;
        this.adresseRueExtra = adresseRueExtra;
        this.ville = ville;
        this.pays = pays;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresseRue() {
        return adresseRue;
    }

    public String getAdresseRueExtra() {
        return adresseRueExtra;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
    }

}

