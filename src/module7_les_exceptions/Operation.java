package module7_les_exceptions;

public class Operation {
    public static int ajouter(int a, int b) throws DepassementCapaciteException {
        long resLong = (long) a + b;
        int resInt = a + b;
        
        if (resLong != resInt){
            throw new DepassementCapaciteException();
        }

        return resInt;
    }

    public static int soustraire(int a, int b) throws DepassementCapaciteException {
        long resLong = (long) a - b;
        int resInt = a - b;
        
        if (resLong != resInt){
            throw new DepassementCapaciteException();
        }
        
        return resInt;
    }

    public static int multiplier(int a, int b) throws DepassementCapaciteException {
        long resLong = (long) a * b;
        int resInt = a * b;

        if (resLong != resInt){
            throw new DepassementCapaciteException();
        }
        
        return resInt;
    }
}
