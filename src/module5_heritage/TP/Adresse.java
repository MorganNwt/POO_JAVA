package module5_heritage.TP;

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
        this(null, numero, complNumero, rue, cp, ville);
    }

    public void afficher(){
        if(this.mentionsCompl != null){
            System.out.println(mentionsCompl);
        }
        System.out.printf("%d%s %s%n%05d %s%n", this.numero, this.complNumero != null ? this.complNumero : "", this.rue, this.cp, this.ville);
    }
}
