package module3_les_classes;

public class TestDice {

    public static void main(String[] args) {
        
        // Avec le mot clef new, je fait appel au constructeur de la class Dice afin
        // de créer une instance
        try{
             Dice monDe = new Dice();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
       

        // monDe.setNbFaces(6);
        // Dice monDe = new Dice(6);


        // do{
        //      System.err.println("Le dé à fait un " + monDe.lancer());
        // } while (monDe.getFaceTiree() != 6);
           
    }
}
