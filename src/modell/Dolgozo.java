package modell;

import java.util.Random;
import java.util.UUID;

public class Dolgozo extends Ember implements Comparable<Dolgozo> {

    private final UUID uuid = UUID.randomUUID();
    private int nyugdijigEv;
    private Random rnd;

    @Override
    public String toString() {
        return "Dolgozo{" + "uuid=" + uuid + ", nyugdijigEv=" + nyugdijigEv + '}';
    }

    public Dolgozo(String nev, int nyugdijigEv, Oltozetek viselet) {
        super(nev, viselet);
        setNyugdijigEv(nyugdijigEv);
    }

    public Dolgozo(String nev, Oltozetek viselet) {
        super(nev, viselet);
        rnd = new Random();
        this.nyugdijigEv = rnd.nextInt(1, 11);
    }

    public int getNyugdijigEv() {
        return nyugdijigEv;
    }

    public void setNyugdijigEv(int nyugdijigEv) {
        this.nyugdijigEv = nyugdijigEv;
    }

    @Override
    public int compareTo(Dolgozo o) {
        return this.getNev().compareTo(o.getNev());
    }

}
