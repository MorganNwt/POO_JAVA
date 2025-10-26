package module5_heritage.TP;

import module5_heritage.TP.Adresse;

public class Personne {
    protected String nom;
    protected String prenom;
    protected String numeroDeTelephone;
    protected Adresse adresse;

    public Personne(String nom, String prenom, String numeroDeTelephone, Adresse adresse){
        this.nom = nom.toUpperCase();
        this.prenom = prenom;
        this.numeroDeTelephone = numeroDeTelephone;
        this.adresse = adresse;
    }

    public void afficher(){
        System.out.printf("%s %s%nTéléphone : %s%n",
            this.nom, 
            this.prenom, 
            this.numeroDeTelephone
        );
    }
}
