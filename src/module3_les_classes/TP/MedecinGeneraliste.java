package module3_les_classes.TP;

public class MedecinGeneraliste {

    private String nom;
    private String prenom;
    private String numeroDeTelephone;
    private static int tarif = 0;

    /**
     * Le constructeur : il prend le nom, prénom et le téléphone en paramètre
     * 
     * @param nom
     * @param prenom
     * @param numeroDeTelephone
     */
    public MedecinGeneraliste(  String nom, String prenom, String numeroDeTelephone)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDeTelephone = numeroDeTelephone;
    }

    // Les GETTERS
    public String getNom()
    {
        return this.nom;
    }

    public String getPrenom()
    {
        return this.prenom;
    } 

    public String getNumeroDeTelephone()
    {
        return this.numeroDeTelephone;
    }   

    public static int getTarif()
    {
        return MedecinGeneraliste.tarif;
    }

    // lES SETTERS
    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public void setNumeroDeTelephone(String numeroDeTelephone)
    {
        this.numeroDeTelephone = numeroDeTelephone;
    }
    

    // Fonction static
    public static void setTarif(int tarif)
    {
        MedecinGeneraliste.tarif = tarif;
    }

    //Fonction afficher

    public void afficher()
    {
      System.out.println( "Dr" + this.prenom + " " + this.nom + "\nNuméro de téléphone : " + this.numeroDeTelephone + "\nLe nouveau tarif est de : " + tarif + " €");
    }
}
