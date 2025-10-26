package module6_classes_abstraites_et_interfaces;

import java.time.LocalDate;

public abstract class AbstractCycleElectrique extends AbstractCycle{

    protected int autonomieKm;

    public AbstractCycleElectrique(LocalDate dateAchat, String marque, String modele, int autonomieKm)
    {
        super(dateAchat, marque, modele);
        this.autonomieKm = autonomieKm;

    }

    @Override
    public String toString()
    {
        return String.format(
            "%s %d km d'autonomie",
            super.toString(),
            this.autonomieKm
        );
    }
}
