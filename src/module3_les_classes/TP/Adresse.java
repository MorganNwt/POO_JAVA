package module3_les_classes.TP;

public class Adresse {
    private String mentionsCompl;
    private int numero;
    private String complNumero;
    private String rue;
    private int cp;
    private String ville;

    public Adresse(String mentionsCompl, int numero, String complNumero, String rue, int cp, String ville){
        this.mentionsCompl = mentionsCompl;
        this.numero = numero;
        this.complNumero = complNumero;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
    }

    public Adresse(int numero, String complNumero, String rue, int cp, String ville){
        // Ici, this() fait directement référence au premier contructeur (lignes 11 à 18) 
        this(null, numero, complNumero, rue, cp, ville);
    }

    public void afficher(){
        if (this.mentionsCompl != null) {
            System.out.println(this.mentionsCompl);
        }
        System.out.printf("%d%s %s%n%05d %s%n",
            this.numero,
            // Ici, je fais une opération ternaire qui...
            this.complNumero != null ? this.complNumero : "",
            // ... est EXACTEMENT équivalent à 
            // if(this.complNumero != null){
            //     this.complNumero;
            // }
            // else{
            //     "";
            // }
            this.rue,
            this.cp,
            this.ville
        );

    }
}
