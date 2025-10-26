package module6_classes_abstraites_et_interfaces;

import java.time.LocalDate;

public class Gyroroue extends AbstractCycleElectrique{

    public Gyroroue(LocalDate dateAchat, String marque, String modele, int autonomieKm)
    {
        super(dateAchat, marque, modele, autonomieKm);
    }

    @Override
    public double getTarifLocationHeure()
    {
        return 18.9;
    }
}
