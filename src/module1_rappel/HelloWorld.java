package module1_rappel;

public class HelloWorld {

    public static final double TVA = 20.0/100;

    public static void main(String[] args) {
        System.out.println("Hello World!!");

        String nom = "DR FD";

        System.out.printf("%s a été créée en %d et est situé à %.1f km de la ville de Valence. %n", "DR FD", 2022, 1.1 );
        System.out.printf("%s a été créée en %d et est situé à %.1f km de la ville de Valence. %n", nom, 2022, 1.1 );

        double prixHt = 17.85;
        System.out.printf("Prix TTC du produit : %.2f€%n", prixHt*(1 + TVA));

        System.out.println("Morgan");
        System.out.println("Nawrot");

        System.out.print("Morgan ");
        System.out.print("Nawrot");
        
    }
}
