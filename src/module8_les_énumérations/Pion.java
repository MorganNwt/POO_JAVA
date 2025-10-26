package module8_les_énumérations;

public enum Pion {
    // Les trois valeurs (etats possibles)
    LIBRE, BLANC, NOIR;

    // Nombre de pions par couleur en début de partie
    private int nombre = 2;

    // Joueur associé au pion
    private Joueur joueur;

    /**
     * Le Getter
     * 
     * @return le joueur associé au pion
     */
    public Joueur getJoueur(){
        return this.joueur;
    }

    public void choixJoueur(){
        String m = String.format("Quel joueur pour les pions %s ?%n 1 - Humain%n 2 - Ordinateur", this.getSymbole());
        int c = Outils.saisie(m, 1, 2);

        if (c == 1) {
            this.joueur = new JoueurHumain();
        }
        else{
            this.joueur = new IAalea();
        }
    }

    /**
     * Getter pour nombre.
     * 
     * @return le nombre de pions de cette couleur
     */
    public int getNombre(){
        return this.nombre;
    }

    /**
     * Donne le symbole utilisé pour asfficher ce pion.
     * 
     * @return le symbole utilisé pour afficher ce pion
     */
    public char getSymbole(){
        char ret;

        switch (this) {
            case BLANC:
                ret = 'o';
                break;
            case NOIR:
                ret = 'x';
                break;
            default:
                ret = '.';
                break;
        }
        return ret;
    }

    /**
     * Méthode pour connaitre le pion opposé :
     * Blanc pour NOIR et NOIR pour BLANC
     * 
     * @return le pion opposé
     */
    public Pion autrePrion(){
        Pion autre;

        switch (this) {
            case BLANC:
                autre = Pion.NOIR;
                break;
            case NOIR:
                autre = Pion.BLANC;
                break;
            default:
                autre = Pion.LIBRE;
                break;
        }

        return autre;
    }

    /**
     * Méthode qui modifie l'attribut nombre pour ajouter le nombre de pions acquis grâce au coup joué par le joueur.
     * L'adversaire perd le même nombre de pions.
     * L'attribut nombre de ce pion est augmenté de 1 en raison du pion posé par le joureur.
     * 
     * @param int nombre | Le nombre de pions qui changent de couleur suite à un coup effectué par un joueur
     */
    public void gagne(int nombre){
        // J'ajoute (nombre + 1) à/dans lui-même
        // ATTENTION : NE PAS OUBLIER le + 1 à la fin car le joueur qui joue (joue son pion en plus).
        this.nombre += nombre + 1;
        this.autrePrion().nombre -= nombre;
    }
}
