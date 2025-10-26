package module1_rappel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SaisieException {

    public static void main(String[] args) throws Exception {
        int valeur = saisir("Saisissez une valeur comprise entre 0 et 20 : ", 0, 20);
        verifNbFaces(valeur);
    
    }

    public static int saisir(String message, int min, int max){

        Scanner scanner = new Scanner(System.in);

        System.out.printf("%s ", message);
        int val = 0;
        boolean ok;

        do{
            try{
                val = scanner.nextInt();
                ok = (val >= min && val <= max);
            }
            catch(InputMismatchException e){
                ok = false;
            }
            finally{
                scanner.nextLine();
                System.out.printf("Bravo la valeur est validé ! ");
            }

            if(!ok){
                System.out.printf("Erreur : valeur incorrect, recommencez (%d %d)%n", min, max);
            }
        }while(!ok);
                scanner.close();
        
        return val;
    }

    private static void verifNbFaces(int nbFaces) throws Exception
    {
        if(nbFaces <= 1){
            throw new Exception("un dé doit avoir au moins deux faces.");
        }
    }
}
