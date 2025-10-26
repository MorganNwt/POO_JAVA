package module2_POO;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/**
 * Classe qui représente un calendrier simple
 */
public class TpCalendrier {
    /***********************************************
     * 1 - Les attributs/propriétés de la classe       * 
     *************************************************/
    private static Scanner scanner = new Scanner(System.in);

    /*************************************************************
     * 2 - Les méthodes/(fonction et/ou procédures) de la classe  * 
     ***********************************************************/
    /**
     * Procédure afficherMois() qui affiche un mois précis selon deux paramètres. Elle prend en paramètre deux entiers pour l'année en premier, puis le mois
     * 
     * @param int annee | L'année voulue
     * @param int mois | Le mois voulu
     * 
     * @return void
     */
    private static void afficherMois(int annee, int mois){
        // Aujourd'hui, je suis au 1er septembre 2025)
        GregorianCalendar jour = new GregorianCalendar(annee, mois, 1);

        // Afficher le mois de l'année courante
        System.out.format(" * %s %d *%n", 
            jour.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG_FORMAT,
            Locale.FRANCE),
            annee
        );

        // Afficher les jours de la semaine
        System.out.println("L  Ma Me J  V  S  D");

        // Afficher les numeros des jours au bon endroit
        // 1 - Prevoir un decalage (int)
        int decalage = 0;

        switch (jour.get(GregorianCalendar.DAY_OF_WEEK)) {
            case GregorianCalendar.TUESDAY:
                decalage = 1;
                break;
            case GregorianCalendar.WEDNESDAY:
                decalage = 2;
                break;
            case GregorianCalendar.THURSDAY:
                decalage = 3;
                break;
            case GregorianCalendar.FRIDAY:
                decalage = 4;
                break;
            case GregorianCalendar.SATURDAY:
                decalage = 5;
                break;
            case GregorianCalendar.SUNDAY:
                decalage = 6;
                break;
        }

        for(int i = 0 ; i < decalage ; i++){
            System.out.print("   ");
        }

        // getActualMaximum(GregorianCalendar.DAY_OF_MONTH) = Sa valeur sera la limite de la boucle for lors de l'affichage entre 1 et cette limite
        int nbJoursDansLeMois = jour.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        // DAY_OF_WEEK
        for (int i = 1; i <= nbJoursDansLeMois; i++) {
            System.out.format("%02d ", jour.get(GregorianCalendar.DAY_OF_MONTH));
            jour.add(GregorianCalendar.DAY_OF_MONTH, 1);

            // Penser au retour chariot à la fin de chaque semaine
            if(jour.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY){
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Fonction main() qui est appeler "automatiquement lors de l'exécution de cette ressource (ce fichier qui est une classe Java)
     * @param args
     */
    public static void main(String[] args) {
        GregorianCalendar date = new GregorianCalendar();
        String saisie;

        do{
            afficherMois(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH));

            System.out.println("Entrez '-' pour le mois précédent, '+' pour le mois suivant, 'd' pour une date personnalisée ou 'q' pour quitter.");
            saisie = scanner.nextLine();

            switch (saisie) {
                case "-":
                    date.add(GregorianCalendar.MONTH, -1);
                    break;
                case "+":
                    date.add(GregorianCalendar.MONTH, 1);
                    break;
                case "d":
                    System.out.println("Quelle année ?");
                    int annee = scanner.nextInt();
                    scanner.nextLine();   // Consommer la ligne
                    System.out.println("Quelle mois (1-12) ?"); // Ajouste l'index du mois
                    int mois = scanner.nextInt() - 1;
                    scanner.nextLine();   // Consommer la ligne
                    date.set(annee, mois, 1);
                    break;
                case "q":
                    System.out.println("Au revoir !!");
                    break;
                default:
                    System.err.println("Saisie incorrecte !");
                    break;
            }

        }while(!saisie.equals("q"));



    }
}
