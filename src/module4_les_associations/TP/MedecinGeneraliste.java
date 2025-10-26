package module4_les_associations.TP;

/**
 * Class MedecinGeneraliste qui représente un médecin su cabinet médical.....
 */
public class MedecinGeneraliste {
    /*
     * ICI ZONE RESERVE AUX ATTRIBUTS ET CONSTANTES
     */
    // final veut dire que la "variable" sera une CONSTANTE !!!
    // ATTENTION : Les constantes doivent TOUJOURS avoir une valeur dès leur déclaration !!!!!
    private final int MAX_CRENEAUX = 15;
    // 1 - J'ai déclaré 3 attributs d'instance (donc PAS de portée static)
    private String nom;
    private String prenom;
    private String numeroDeTelephone;
    private Adresse adresse;
    private Creneau[] creneaux = new Creneau[MAX_CRENEAUX];

    //  2 - J'ai déclaré 1 attribut de class (donc avec la portée static)
    private static int tarif = 25;

    /*
     * ICI ZONE RESERVE AUX METHODES
     */
    //  1 - Le constructeur
    /**
     * Constructeur de la classe MedecinGeneraliste, Il prend en param-ètre les 3 attributs d'instance de la class.
     * @param nom | Le nom du nouveau médecin
     * @param prenom | Le prénom du nouveau médecin
     * @param numeroDeTelephone | Le téléphone du nouveau médecin
     */
    public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse){
        // J'utilise this. pour accéder à l'instance qui sera en cours de manipulation, afin d'accéder à ses attributs (d'instance)
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDeTelephone = numeroDeTelephone;
        this.adresse = adresse;
    }

    public String getNom(){
        return this.nom;
    }

    public String getNumeroDeTelephone(){
        return this.numeroDeTelephone;
    }

    public void setNumeroDeTelephone(String numeroDeTelephone){
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public static int getTarif(){
        return MedecinGeneraliste.tarif;
    }

    public static void setTarif(int tarif){
        MedecinGeneraliste.tarif = tarif;
    }

    public void afficher(){
        System.out.printf("%s %s%nTéléphone : %s%nTarif : %d euros%n", 
            this.nom, 
            this.prenom, 
            this.numeroDeTelephone, 
            MedecinGeneraliste.tarif
        );

        this.adresse.afficher();

        for (int i = 0 ; i < this.creneaux.length; i++) {
            if (this.creneaux[i] != null) {
                this.creneaux[i].afficher();
            }
        }
    }

    void ajouterCreneau(Creneau creneauAAjouter){
        // 1 - Verifier que l'instance de MedecinGeneraliste (this) est celui du creneauAAjouter (creneauAAjouter.medecin)
        if(this != creneauAAjouter.getMedecin()){
            System.err.println("Ce créneau ne peut être associé à ce médecin car il est déjà associé à un autre.");
        }
        else{
            // 2 - Si c'est le bon médecin, vérifier si celui-ci possède encore des créneaux disponible (15 max)
            int pos = 0;
            while (pos < this.creneaux.length && this.creneaux[pos] != null) {
                pos++;
            }
            if(pos == this.creneaux.length){
                System.err.println("trop de créneaux sont affectés à ce médecin");
            }
            else{
                this.creneaux[pos] = creneauAAjouter;
            }
        }
        // 3 - S'il reste au moins 1 créneau de dispo, faire l'ajout


        // creneaux[indice] = creneauAAjouter
        // indice doit être de type integer inclus entre 0 et 14 selon le premier indice disponible (sans valeur)
    }
}
