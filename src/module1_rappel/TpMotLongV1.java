package module1_rappel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TpMotLongV1 {
    public static final String FICHIER_MOTS = "./dictionnaire.txt";
    public static final int NB_MOTS = 22506;
    public static Random random = new Random();
    

    /**
     * Retourne un tableau de char contenant les lettres d'un mot tiré aléatoirement dans un fichier texte (dictionnaire.txt).
     * 
     * @return un tableau de char contenant les lettres d'un mot tiré aléatoirement dans un fichier texte (dictionnaire.txt).
     * 
     * @throws IOException - Si une erreur d'entrée/sortie survient lors de la lecture du fichier (dictionnaire.txt).
     */
    private static char[] tirerMotAleatoirement() throws IOException{
        System.out.println("1");
        int numMot = random.nextInt(NB_MOTS);
        System.out.println(numMot);
        try(FileInputStream fichier = new FileInputStream(FICHIER_MOTS);
            Scanner scanner = new Scanner(fichier)
        ){
            System.out.println("2");
            for(int i = 1; i <= numMot; i++){
                scanner.nextLine();
            }
            return scanner.nextLine().toUpperCase().toCharArray();
        }   
    }


    /**
     * Retourne un tableau de char contenant les lettres d'un mot mélangé.
     * 
     * @param mot - Le tableau de char contenant les lettres du mot à mélanger.
     * @return melange - Un tableau de char contenant les lettres du mot mélangé.
     */
    private static char[] melanger(char[] mot){
        // Cloner le tableau
        char[] melange = new char[mot.length];
        for(int i = 0; i < melange.length; i++){
            melange[i] = mot[i];
        }

        // Echanges de position de caractères
        for(int i = 0; i < melange.length * 4; i++){
            int pos1 = random.nextInt(melange.length);
            int pos2 = random.nextInt(melange.length);

            char temp = melange[pos1];
            melange[pos1] = melange[pos2];
            melange[pos2] = temp;
        }
        return melange;
    }

    /**
     * Affiche les caractères d'un tableau de char.
     * @param mot - Le mot à afficher
     */
    private static void afficher(char[] mot){
        for(int i = 0; i < mot.length; i++){
            System.out.print(mot[i]);
        }
        System.out.println();
    }

    public static final char VIDE = ' ';
    /**
     * Vérifie si la proposition de l'utilisateur peut être formée avec les lettres du tirage.
     * @param prop - La proposition de l'utilisateur
     * @param tirage - Le tirage de lettres
     * @return - true si la proposition peut être formée avec les lettres du tirage, false sinon.
     */
    public static boolean bonnesLettres(char[] prop, char[] tirage){
        // Cloner le tirage
        char[] copie = new char[tirage.length];
        for(int i = 0; i < copie.length; i++){
            copie[i] = tirage[i];
        }
        // Vérifier chaque lettre de la proposition
        int j = 0;
        boolean ok = true;
        while(ok && j < prop.length){
            int k = 0;
            while (k < copie.length && prop[j] != copie[k]) {
                k++;
            }
            if(k == copie.length){
                ok = false;
            }
            else{
                copie[k] = VIDE;
                j++;
            }
        }
        return ok;
    }

    /**
     * Vérifie si la proposition de l'utilisateur est dans le dictionnaire.
     * 
     * @param prop - Le premier tableau de char à vérifier
     * 
     * @return true - Si le mot est présent dans le dictionnaire
     * 
     * @throws IOException - Si une erreur d'entrée/sortie survient lors de la lecture du fichier (dictionnaire.txt).
     */
    private static boolean dansLeDico(char[] prop) throws IOException{
        boolean trouve = false;
        try(FileInputStream fichier = new FileInputStream(FICHIER_MOTS);
            Scanner scanner = new Scanner(fichier);
        ){
            char[] motDico;
            while(!trouve && scanner.hasNext()){
                motDico = scanner.nextLine().toUpperCase().toCharArray();
                trouve = TpMotLongV1.sontIdentiques(prop, motDico);
            }
        }
        return trouve;
    }

    /**
     * Vérifie si deux tableaux de char sont identiques.
     * @param mot1
     * @param mot2
     * @return true - Si les deux tableaux sont identiques
     */
    private static boolean sontIdentiques(char[] mot1, char[] mot2){
        boolean ok = mot1.length == mot2.length;
        if (ok) {
            int i = 0;
            while (ok && i < mot1.length) {
                ok = mot1[i] == mot2[i];
                i++;
            }
        }
        return ok;
    }

    public static void main(String[] args) {
        try{
            char[] mot = tirerMotAleatoirement();
            char[] tirage = melanger(mot);

            System.out.println("Voici le tirage : ");
            afficher(tirage);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Quel est le mot caché dans ce tirage ? ");

            char[] prop = scanner.nextLine().toUpperCase().toCharArray();
            
            if(!bonnesLettres(prop, tirage)){
                System.out.println("Lettres incorrectes !");
            }
            else{
                if(!dansLeDico(prop)){
                    System.out.println("Mot inexistant dans le dictionnaire !");
                }
                else{
                    System.out.printf("Bravo, vous avez trouvé le mot !%nVous avez marqué %d points.%n", prop.length);
                }
            }

            afficher(mot);
            scanner.close();
        }
        catch(IOException e){
            System.err.println("Erreur d'entrée/sortie dans le dictionnaire");
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace());
        }
    }
}
