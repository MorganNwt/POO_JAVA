package module8_les_énumérations;

public class JoueurHumain implements Joueur{
    private String nom;

    /**
     * Le constructeur
     */
    public JoueurHumain(){
        this.nom = Outils.saisie("Nom du joueur ?");
    }

    /**
     * {@inheritDoc}
     * 
     * @see TP.Joueur.jouer()
     */
    @Override
    public int[] jouer(PlateauOthello p, Pion couleur) {
        int[] coordonnees = new int[2];
        coordonnees[LIGNE] = Outils.saisie("Ligne ? ", 1, PlateauOthello.TAILLE) - 1;
        coordonnees[COLONNE] = Outils.saisie("Colonne ? ", 1, PlateauOthello.TAILLE) - 1;

        return coordonnees;
    }

    /**
     * TODO : la doc selon résultat juste au dessus !!!!!!
     */
    @Override
    public String getNom() {
        return this.nom;
    }

    
}
