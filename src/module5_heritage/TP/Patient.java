package module5_heritage.TP;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Patient extends Personne{
    private char sexe;
    private long numSecu;
    private LocalDate dateNaissance;
    private String commentaires;
    private Adresse adresse;

    public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numSecu, LocalDate dateNaissance, String commentaires, Adresse adresse){
        super(nom, prenom, numeroDeTelephone, adresse);
        this.sexe = sexe;
        this.numSecu = numSecu;
        this.dateNaissance = dateNaissance;
        this.commentaires = commentaires;
    }

    public void afficher(){
        super.afficher();
        System.out.printf("Sexe : %s%nNuméro de Sécurité Sociale : %d%nDate de naissance : %s%nCommentaires : %s%nAdresse :%n", 
        this.sexe == 'F' ? "Féminin" : "Masculin", 
        this.numSecu, 
        this.dateNaissance.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), 
        this.commentaires != null ? this.commentaires : "[Aucun commentaire]");
        this.adresse.afficher();
    }
}
