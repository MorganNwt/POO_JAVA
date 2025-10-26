package module3_les_classes;

import java.io.EOFException;
import java.util.Random;

public class Dice {

    // Attribut d'instance avec une visibilité, un type et un nom
    // 2 attributs d'instance
    private int nbFaces;
    private int faceTiree;

    // 1 attribut de classe (static)
    private static Random random = new Random();

    // // Un constructeur
    public Dice(int nbFaces) throws Exception
    {
        this.setNbFaces(nbFaces);
        this.lancer();
    }

    // surcharge du constructeur
    public Dice() throws Exception
    {
        this.setNbFaces(6);
        this.lancer();

        // Appeller le er constructeur avec this()
        // this(6);
    }

    // Un GETTER ou accéder à la valeur de l'attribut d'instance nbFaces
    public int getNbFaces()
    {
        // Accès à l'attribut d'instance nbFaces avec le mot-clé this
        return this.nbFaces;
    }

    // // Un SETTER pour affecter une valeur à l'attribut d'une instance nbFaces
    // public void setNbFaces(int nbFaces)
    // {
    //     this.nbFaces = nbFaces;
    // }

    public int lancer()
    {
        return this.faceTiree = Dice.random.nextInt(this.nbFaces) + 1;
    }

    public int getFaceTiree()
    {
        return this.faceTiree;
    }

    private static void verifNbFaces(int nbFaces) throws Exception
    {
        if (nbFaces <= 1) {
            throw new EOFException("Un dé doit avoir au moins deux faces");
        }
    }

    public void setNbFaces(int nbFaces) throws Exception
    {
        Dice.verifNbFaces(nbFaces);
        this.nbFaces = nbFaces;
    }

}
