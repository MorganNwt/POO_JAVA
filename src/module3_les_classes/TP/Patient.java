package module3_les_classes.TP;

import java.time.LocalDate;

public class Patient {

    private String nom;
    private String prenom;
    private String tel;
    private char genre;
    private long numeroDeSecuriteSociale;
    private LocalDate birday;
    private String allergies;

    // le constructeur
    public Patient(String nom, String prenom, String tel, char genre, long numeroDeSecuriteSociale, LocalDate birday, String allergies)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.genre = genre;
        this.numeroDeSecuriteSociale = numeroDeSecuriteSociale;
        this.birday = birday;
        this.allergies = allergies;
    }

    // les GETTERS
    public String getNom()
    {
        return this.nom;
    }

     public String getPrenom()
    {
        return this.prenom;
    }

     public String getTel()
    {
        return this.tel;
    }

     public char getGenre()
    {
        return this.genre;
    }

     public long getNumeroDeSecuriteSociale()
    {
        return this.numeroDeSecuriteSociale;
    }

     public LocalDate getBirday()
    {
        return this.birday;
    }

    public String getAllergies()
    {
        return this.allergies;
    }

    public void afficher(){
        System.out.println(
            "Patient : " + this.nom + 
            " " + this.prenom + 
            "\nTel : " + this.tel + 
            " \nSexe : " + (this.genre == 'F'? "Féminin" : "Masculin" )+ 
            " \nNuméro de sécurité sociale : " + this.numeroDeSecuriteSociale +
            "\nDate d'anniversaire :" + this.birday +
            " \nAllergies : " +  (this.allergies == null ? "Aucune allérgie": this.allergies)
        );
    }

}
