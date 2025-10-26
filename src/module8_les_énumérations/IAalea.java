package module8_les_énumérations;

import java.util.Random;

public class IAalea implements Joueur{
    private static Random r = new Random();

    @Override
    public int[] jouer(PlateauOthello p, Pion couleur) {
        int[] coord = new int[2];

        do {
            coord[LIGNE] = r.nextInt(PlateauOthello.TAILLE);
            coord[COLONNE] = r.nextInt(PlateauOthello.TAILLE);
        } while (p.tester(couleur, coord[LIGNE], coord[COLONNE]) == 0);

        return coord;
    }

    @Override
    public String getNom() {
       return "IA Aléatoire";
    }


}