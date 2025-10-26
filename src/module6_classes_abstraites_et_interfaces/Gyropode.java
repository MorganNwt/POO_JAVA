package module6_classes_abstraites_et_interfaces;

import java.time.LocalDate;

public class Gyropode extends AbstractCycleElectrique {

    private int tailleMinCm;

    public Gyropode(LocalDate dateAchat, String marque, String modele, int autonomieKm, int tailleMinCm)
    {
        super(dateAchat, marque, modele, autonomieKm);
        this.tailleMinCm = tailleMinCm;
    }

    @Override
    public double getTarifLocationHeure()
    {
        return 29.9;
    }

    @Override
    public String toString()
    {
        return String.format(
            "%s [%dm %dmin]",
            super.toString(),
            this.tailleMinCm/100,
            this.tailleMinCm%100
        );
    }
}
