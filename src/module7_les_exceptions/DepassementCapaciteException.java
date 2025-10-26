package module7_les_exceptions;

public class DepassementCapaciteException extends Exception{
    public DepassementCapaciteException(){
        super("Le résultat dépasse la capacité de la calculatrice.");
    }
}
