package module8_les_énumérations;

/**
 * Interface qui représente un joueur de Othello
 */
public interface Joueur {
    static final int LIGNE = 0;
    static final int COLONNE = 1;

    /**
     * Méthode qui retourne les coordonnées où le joueur souhaite positionner son pion.
     * 
     * @param p | Le plateau de jeu (la seule méthode d'instance public qu'il est possible d'appeler est la méthode tester() qui indique la possiblité de poser son pion et le gain associé)
     * @param couleur | la couleur du pion du joueur
     * 
     * @return un couple de coordonnées : la case de coordonnées {@code LIGNE} contient la ligne choisie et la case de coordonnées {@code COLONNE} contient la colonne choisie. Ces coordonnées sont basées à partir de 0.
     */
    int[] jouer(PlateauOthello p, Pion couleur);

    /**
     * Donne le nom du joueur.
     * 
     * @return le nom du joueur
     */
    String getNom();
}
