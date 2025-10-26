package module5_heritage.TP;

public class MedecinGeneraliste extends Medecin{
    
    private static int tarif = 25;

    public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse){
        super(nom, prenom, numeroDeTelephone, adresse);
    }

    public static int getTarif(){
        return MedecinGeneraliste.tarif;
    }

    public static void setTarif(int tarif){
        MedecinGeneraliste.tarif = tarif;
    }

    @Override
    public void afficher(){
        super.afficher();

        System.out.printf("Tarif : %d€%nAdresse :",  
            MedecinGeneraliste.getTarif()
        );

        this.afficherAdresseEtCreneaux();
    }
}
