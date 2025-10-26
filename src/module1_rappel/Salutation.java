package module1_rappel;

import java.util.Scanner;

public class Salutation {
    // Créer la fonction principal main()
    public static void main(String[] args) {
        salutation();
    }


    /**
     * Documentation de la procédur afficherSalutation
     * Procédure qui affiche un prénom donné en paramètre
     * 
     * @param String prenom ! Le paramètre à renseigner
     * @return 
     */
    private static void afficherSalutation(String prenom){

        System.out.println("Bonjour " + prenom + " !");
    }

    /**
     * La doc...
     *  @return String prenom | le prenom qui est retourné en tant que "résultat"
     */
    private static String saisirPrenom(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez votre prénom : ");
        String prenom = scanner.nextLine();
        scanner.close();

        return prenom;
    }

    private static void salutation(){
        String prenom = saisirPrenom();
        afficherSalutation(prenom);
    }

}
