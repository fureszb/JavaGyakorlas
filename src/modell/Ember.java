package modell;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Ember implements Serializable {

    private String nev;

    public enum Oltozetek {
        elegáns, sportos, megfelelő, szakadt
    }

    private Set<Oltozetek> viselet;

    @Override
    public String toString() {
        return "Ember{" + "nev=" + nev + ", viselet=" + viselet + '}';
    }

    public Ember(String nev, Oltozetek viselet) {
        this.viselet = new HashSet<>();
        this.nev = nev;
        setViselet(viselet);
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) throws NevExp {
        if (nev.length() < 3) {
            throw new NevExp("Nem lehet 3-nal rövidebb a nev");
        }
        char elsobetu = nev.charAt(0);
        char nagybetu = Character.toUpperCase(elsobetu);
        if (elsobetu != nagybetu) {
            this.nev = nagybetu + nev.substring(1);
        } else {
            this.nev = nev;
        }

    }

    public Set<Oltozetek> getViselet() {
        return viselet;
    }

    public void setViselet(Oltozetek viselet) {
        this.viselet.add(viselet);
    }

}
