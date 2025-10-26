package module6_classes_abstraites_et_interfaces;

import java.time.LocalDate;

public class Velo  extends AbstractCycle{

    private int nbVitesse;

    public Velo(LocalDate dateAchat, String marque, String modele, int nbVitesse){

        super(dateAchat, marque, modele);
        this.nbVitesse = nbVitesse;
    }

    @Override
    public double getTarifLocationHeure()
    {
        return 4.90;
    }

    @Override
    public String toString()
    {
        return String.format(
            "%s ",
            super.toString(),
            this.nbVitesse,
            this.nbVitesse > 1 ? "s" : ""
        );
    }


}
