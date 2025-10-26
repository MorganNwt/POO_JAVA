package module1_rappel;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FichierText {

    public static void main(String[] args) {
        double[ ]valeurs = {10.5, 20.3, 40.1, 50.555955};

        /***************************************
         * l'écriture dans un fichier texte
         *******************************************/
        // Exemple 1 - L'écriture de données dans un fichier 
            // try{
            // FileWriter f = null;

            // try{
            //         f = new FileWriter("./valeur.txt");

            //         for( int i = 0 ; i < valeurs.length ; i++){
            //         f.write(String.format("%.2f%n", valeurs[i]));
            //         }
            //         System.err.println("Enregistrement terminé avec succès");
            // }
            // finally{
            //         if( f != null){
            //             f.close();
            //         }
            // }

            // } catch (IOException e) {
            //     System.err.println("Ecriture impossible");
            // }

        // Exemple 2 - Ecriture de donnée dans un fichier avec gestion automatique des ressources
        try (FileWriter f = new FileWriter("./valeurs.txt")) {
            for(int i = 0 ; i < valeurs.length ; i++ ){
                f.write(String.format("%.2f%n", valeurs[i]));
            }
            System.err.println("Enregistrement terminé avec succès");

        } catch (IOException e) {
            System.err.println("Ecriture impossible");
        }



    //     // Exemple 1 - La lecture de données dans un fichier
    //     try {
    //         FileInputStream fichier = null;
    //         Scanner scanner = null;

    //         try {
    //             fichier = new FileInputStream("./valeurs.txt");
    //             scanner = new Scanner(fichier);
                
    //             while (scanner.hasNextLine()) {
    //                 System.out.println(scanner.nextLine());

    //             }
    //              System.out.println("Lecture terminé avec succès");
    //         }
    //         finally{
    //             if(scanner != null ){
    //                 scanner.close();
    //             }
    //             if(fichier != null) {
    //                 scanner.close();
    //             }
    //         }
    //     } catch (IOException e) {
    //         System.err.println("Lecture impossible");
    //     }

        // Exemple 2 - La lecture de données dans un fichier avec gestion automatique des ressources
        try (FileInputStream fichier = new FileInputStream("./valeurs.txt");
        Scanner scanner = new Scanner(fichier))
        {
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            System.out.println("Lecture terminé avec succès");
        } catch ( IOException e) {
            System.err.println("Ecriture impossible");
        }
    }
}
