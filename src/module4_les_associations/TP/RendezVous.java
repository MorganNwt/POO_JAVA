package module4_les_associations.TP;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class RendezVous {
    private Creneau creneau;
    private Patient patient;
    private LocalDate date;

    public RendezVous(Creneau creneau, Patient patient, LocalDate date){
        this.creneau = creneau;
        this.patient = patient;
        this.date = date;
    }

    public void afficher(){
        System.out.printf("Rendez-vous du %s ",
            this.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))
        );
        
        this.creneau.afficher();

        System.out.printf("avec le Dr %s%nPour ",
            this.creneau.getMedecin().getNom()
        );

        this.patient.afficher();
    }
}
