  package module5_heritage.TP;

public class Medecin extends Personne{
    public static final int MAX_CRENEAU = 15;
    
    protected Creneau[] creneaux = new Creneau[MAX_CRENEAU];

    public Medecin(String nom, String prenom, String numeroDeTelephone, Adresse adresse){
        super(nom, prenom, numeroDeTelephone, adresse);
    }

    public String getNumeroDeTelephone(){
        return this.numeroDeTelephone;
    }

    public void setNumeroDeTelephone(String numeroDeTelephone){
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public String getNom(){
        return this.nom;
    }

    public void afficherAdresseEtCreneaux(){
        System.out.println("Adresse :");
        this.adresse.afficher();

        System.out.println("Créneaux :");
        for(int i = 0 ; i < this.creneaux.length ; i++){
            if (this.creneaux[i] != null) {
                this.creneaux[i].afficher();
            }
        }
    }

    void ajouterCreneau(Creneau creneauAAjouter){
        if(this != creneauAAjouter.getMedecin()){
            System.err.println("Ce créneau ne peut être associé à ce médecin car il est déjà associé à un autre.");
        }
        else{
            int pos = 0;
            while (pos < this.creneaux.length && this.creneaux[pos] != null) {
                pos++;
            }

            if (pos == this.creneaux.length) {
                System.err.println("Trop de creneaux sont affectés à ce médecin.");
            }
            else{
                this.creneaux[pos] = creneauAAjouter;
            }
        }
    }
}
