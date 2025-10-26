package module5_heritage.TP;

public class MedecinSpecialiste extends Medecin{
    private String specialite;
    private int tarif;

    public MedecinSpecialiste(String nom, String prenom, String numeroDeTelephone, Adresse adresse, String specialite, int tarif){
        super(nom, prenom, numeroDeTelephone, adresse);
        this.specialite = specialite;
        this.tarif = tarif;
    }

    @Override
    public void afficher(){
        super.afficher();
        System.out.printf("Spécialités : %s%nTarif : %d%n", this.specialite, this.tarif);
        this.afficherAdresseEtCreneaux();
    }
}
