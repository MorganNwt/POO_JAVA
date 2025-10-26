package module2_POO;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Class TestGregorianCalendar qui represente une serie de test sur
 * le calendrier grégorian dans le cadre de la POO.
 */
public class TestGregorianCalendar {
    /**
     * Methode main - Fonction principale qui permet l'exécution du
     * code "automatiquement"
     * 
     * @param args
     */
    public static void main(String[] args) {
        // déclarer une variable de type GrégorianCalandar
        GregorianCalendar revolutionFrancaise;
        // Instancier un objet GregorianCalendar en faisant appel au constructeur de la classe GregorianCalendar
        revolutionFrancaise = new GregorianCalendar(1789, 6, 14);

        // Affichage de la date avec la méthode d'instance 
        afficherDate(revolutionFrancaise);
        System.out.printf("%02d/%02d/%d%n", 
            revolutionFrancaise.get(GregorianCalendar.DAY_OF_MONTH),
            revolutionFrancaise.get(GregorianCalendar.MONTH) + 1,
            revolutionFrancaise.get(GregorianCalendar.YEAR)
        );

        // Ajout de 6 mois
        revolutionFrancaise.add(GregorianCalendar.MONTH, 6);
        afficherDate(revolutionFrancaise);

    }


    private static void afficherDate(GregorianCalendar date ){
        System.out.printf("%02d %s %d%n", 
            date.get(GregorianCalendar.DAY_OF_MONTH),
            date.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG_FORMAT, Locale.FRANCE ),
            date.get(GregorianCalendar.YEAR)
        );
    }
}
