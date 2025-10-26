package module5_heritage.TP;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Creneau {
    private LocalTime heureDebut;
    private int duree;
    private Medecin medecin;

    public Creneau(LocalTime heureDebut, int duree, Medecin medecin){
        this.heureDebut = heureDebut;
        this.duree = duree;
        this.medecin = medecin;
        medecin.ajouterCreneau(this);
    }

    public void afficher(){
        System.out.printf("%s - %s (%d minutes)%n",
            this.heureDebut.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
            this.heureDebut.plusMinutes(this.duree).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
            this.duree    
        );
    }

    public Medecin getMedecin(){
        return this.medecin;
    }
}
