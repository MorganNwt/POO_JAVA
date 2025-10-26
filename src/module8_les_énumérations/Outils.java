package module8_les_énumérations;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe utilisaire qui propose des méthodes pour simplifier la saisies des valeurs
 */
public class Outils {
    private static Scanner s = new Scanner(System.in);

    /**
     * Fait saisir à l'utilisateur une valeur comprise entre {@code min} et {@code max} passées en paramètre.
     * En cas d'erreur, l'utilisateur devra ressaisir jusqu'à ce que la valeur soit correcte.
     * 
     * @param message | message à afficher pour inviter l'utilisateur à saisir
     * @param min | valeur minimale acceptable incluse
     * @param max | valeur maximale acceptable incluse
     * 
     * @return la valeur saisie par l'utilisateur
     */
    public static int saisie(String message, int min, int max){
        System.out.printf("%s ", message);
        int val = 0;
        boolean ok;

        do {
            try {
                val = Outils.s.nextInt();
                ok = val >= min && val <= max;
            } 
            catch (InputMismatchException e) {
                ok = false;
            }
            finally{
                Outils.s.nextLine();
            }

            if (!ok) {
                System.err.printf("La valeur doit être comprise entre %d et %d%nRessaissez une valeur...", min, max);
            }
        } 
        while (!ok);

        return val;
    }

    /**
     * La doc :)
     * @param message
     * @return
     */
    public static String saisie(String message){
        System.out.println(message);
        return Outils.s.nextLine();
    }
}
