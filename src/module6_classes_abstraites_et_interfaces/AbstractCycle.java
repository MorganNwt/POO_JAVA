package module6_classes_abstraites_et_interfaces;

import java.time.LocalDate;

public abstract class AbstractCycle {

    protected LocalDate dateAchat;
    protected String marque;
    protected String modele;

    public AbstractCycle(LocalDate dateAchat, String marque, String modele)
    {
        this.dateAchat = dateAchat;
        this.marque = marque;
        this.modele = modele;
    }

    public int age()
    {
        int age = dateAchat.until(LocalDate.now()).getYears();
        return age;
    }

    public abstract double getTarifLocationHeure();

    @Override
    public String toString()
    {
        int age = this.age();
        return String.format("%s %s %s (%dan%s)",
            this.getClass().getSimpleName(),
            this.marque,
            this.modele,
            age,
            age > 1 ? "s" : ""
        );
    }
}
