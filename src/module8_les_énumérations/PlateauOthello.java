package module8_les_énumérations;

/**
 * Classe qui modélise un plateau de jeu du Othello/Reversi
 */
public class PlateauOthello {
    public static final int TAILLE = 8;
    private Pion[][] plateau;

    /**
     * Le constructeur : Initialise le plateau de jeu à l'état du début de partie.
     */
    private PlateauOthello(){
        // Initiale le plateau vide, de 8 par 8
        this.plateau = new Pion[TAILLE][TAILLE];

        // Positionne des Pion.LIBRE sur tout le plateau
        for(int j = 0 ; j < TAILLE ; j++){
            for(int i = 0 ; i < TAILLE ; i++){
                plateau[j][i] = Pion.LIBRE;
            }
        }
        
        // Positionne les deux Pion.BLANC et deux Pion.NOIR
        this.plateau[TAILLE / 2][TAILLE / 2] = Pion.BLANC;
        this.plateau[TAILLE / 2 - 1][TAILLE / 2] = Pion.NOIR;
        this.plateau[TAILLE / 2][TAILLE / 2 - 1] = Pion.NOIR;
        this.plateau[TAILLE / 2 - 1][TAILLE / 2 - 1] = Pion.BLANC;
    }

    /**
     * Méthode qui permet d'effectuer une partie
     */
    private void jouer(){
        Pion.NOIR.choixJoueur();
        Pion.BLANC.choixJoueur();

        Pion courant = Pion.NOIR;
        int nbPasseTour = 0;

        while (nbPasseTour < 2 && Pion.BLANC.getNombre() + Pion.NOIR.getNombre() < TAILLE * TAILLE) {
            System.out.printf("Au tour de %s (%s)...%n",courant.getJoueur().getNom(), courant.getSymbole());
            
            int nbRetournes = 0;
            boolean ok = false; 

            do {
                this.afficher();
                System.out.println(this.peutJouer(courant));
                if (this.peutJouer(courant)) {
                    System.out.println("PASSER");
                    // int ligne = Outils.saisie("Ligne ?", 1, TAILLE) - 1;
                    // int colonne = Outils.saisie("Colonne ?", 1, TAILLE) - 1;
                    int[] coord = courant.getJoueur().jouer(this, courant);
                    nbRetournes = this.tester(courant, coord[Joueur.LIGNE], coord[Joueur.COLONNE]);

                    if (nbRetournes > 0) {
                        this.poser(courant, coord[Joueur.LIGNE], coord[Joueur.COLONNE]);
                        courant.gagne(nbRetournes);
                        nbPasseTour = 0;
                        ok = true;
                    }
                    else{
                        System.out.println("Position illégale !!!");
                    }
                }
                else{
                    System.out.printf("%s n'a aucune position où poser un de ses pions. Il passe son tour.%n", courant.getSymbole());
                    nbPasseTour++;
                    ok = true;
                }

            } 
            while (!ok);

            // Changer de joueur
            courant = courant.autrePrion();
        }

        if (Pion.BLANC.getNombre() > Pion.NOIR.getNombre()) {
            System.out.printf("%s gagne !%n", Pion.BLANC.getSymbole());
        } 
        else if(Pion.BLANC.getNombre() < Pion.NOIR.getNombre()){
            System.out.printf("%s gagne !%n", Pion.NOIR.getSymbole());
        }
        else{
            System.out.println("Egalité !%n");
        }

        this.afficher();
    }

    /**
     * Pose un pion sur le plateau et change la couleur des pions nouvellement encadrés entre ce pion et un autre pion de la même couleur dans toutes les directions.
     * 
     * @param couleur | couleur du pion à poser
     * @param y | ligne où poser le pion
     * @param x | colonne où poser le pion
     */
    private void poser(Pion couleur, int y, int x) {
        this.plateau[y][x] = couleur;
        int nbPions;

        for(int dy = -1 ; dy <= 1 ; dy++){
            for(int dx = -1 ; dx <= 1 ; dx++){
                nbPions = 0;

                if(dx != 0 || dy != 0){
                    nbPions += testerDirection(couleur, y, x, dy, dx);
                    
                    for(int k = 1 ; k <= nbPions ; k++){
                        this.plateau[y + dy * k][x + dx * k] = couleur;
                    }
                }
            }
        }
    }

    /**
     * Indique le nombre de pions qui vont changer de couleur.
     * Si le joueur ayant les pions de la couleur passée en paramètre pose un pion sur la case dont les coordonnées sont passée en paramètre pour une direction donnée avec les paramètre dx et dy.
     * 
     * @param couleur | couleur utilisée par le joueur courant
     * @param y | le numéro de ligne pour le pion
     * @param x | le numéro de colonne pour le pion
     * @param dy | -1 pour indiquer le décalage vers la gauche, 1 vers la droite et 0 pas de décalage
     * @param dx | -1 pour indiquer le décalage vers le haut, 1 vers le bas et 0 pas de décalage
     * 
     * @return le nombre de pions qui changeraient de couleur
     */
    private int testerDirection(Pion couleur, int y, int x, int dy, int dx) {
        Pion couleurOpp = couleur.autrePrion();
        int nbAutres = 0;
        int i = x + dx;
        int j = y + dy;

        while ( 0 <= i &&
                i < TAILLE &&
                0 <= j &&
                j < TAILLE &&
                this.plateau[j][i] == couleurOpp
        ) {
            nbAutres++;
            i += dx;
            j += dy;
        }

        if (
            i < 0 ||
            i >= TAILLE ||
            j < 0 ||
            j >= TAILLE ||
            this.plateau[j][i] != couleur
        ) {
            nbAutres = 0;
        }
        return nbAutres;
    }

    /**
     * Cherche s'il y a au moins une case sur laquelle le joueur passé en paramètre peut jouer.
     * 
     * @param joueur | le joueur dont c'est le tour de jeu
     * 
     * @return s'il y a au moins une case sur laquelle le joueur (passé en paramètre) le peut jouer
     */
    private boolean peutJouer(Pion joueur) {
        boolean positionJouable = false;
        int j = 0;

        while (j < TAILLE && !positionJouable) {
            int i = 0;

            while (i < TAILLE && !positionJouable) {
                positionJouable = tester(joueur, j, i) > 0;
                i++;
            }
            j++;
        }

        return positionJouable;
    }

    /**
     * Indique le nombre de pions changeant de couleur.
     * Si le joueur ayant les pions de la couleur passée en paramètre pose un pion sur la case dont les coordonnées sont passée en paramètre.
     * TODO : FINIR la phrase, c'est bien :)
     * 
     * @param couleur | couleur du pion qui serait posé
     * @param y | ligne pour le pion
     * @param x | la colonne pour le pion
     * 
     * @return le nombre de pions qui changeraient de couleur
     */
    int tester(Pion couleur, int y, int x) {
        int nbPions = 0;

        if(plateau[y][x] == Pion.LIBRE){
            for(int dy = -1 ; dy <= 1 ; dy++){
                for(int dx = -1 ; dx <= 1 ; dx++){
                    if(dx != 0 || dy != 0){
                        nbPions += testerDirection(couleur, y, x, dy, dx);
                    }
                }
            }
        }
        return nbPions;
    }

    private void afficher(){
        // Afficher les scores
        System.out.printf("%2d %s%n%2d %s%n", Pion.NOIR.getNombre(), Pion.NOIR.getSymbole(), Pion.BLANC.getNombre(), Pion.BLANC.getSymbole());

        // Afficher le plateau
        System.out.print(" ");

        for(int i = 1 ; i <= TAILLE ; i++){
            System.out.printf("%d ", i);
        }

        System.out.println();

        for(int j = 0 ; j < TAILLE ; j++){
            System.out.printf("%d ", j + 1);

            for(int i = 0 ; i < TAILLE ; i++){
                System.out.printf("%s ", plateau[j][i].getSymbole());
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        PlateauOthello p = new PlateauOthello();
        p.jouer();
    }

}


