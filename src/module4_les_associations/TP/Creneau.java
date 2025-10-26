package module4_les_associations.TP;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Creneau {
    private LocalTime heureDebut;
    private int duree;
    private MedecinGeneraliste medecin;

    // Cas particulier - Lorsqu'une instance créneau est créé, je veux tout de suite l'ajouter au médecin (ajouterCreneau()).
    public Creneau(LocalTime heureDebut, int duree, MedecinGeneraliste medecin){
        this.heureDebut = heureDebut;
        this.duree = duree;
        this.medecin = medecin;
        this.medecin.ajouterCreneau(this);
    }

    public void afficher(){
        System.out.printf("%s - %s (%d minutes)%n",
            this.heureDebut.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
            this.heureDebut.plusMinutes(this.duree).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
            this.duree
        );
    }

    public MedecinGeneraliste getMedecin(){
        return this.medecin;
    }
}
