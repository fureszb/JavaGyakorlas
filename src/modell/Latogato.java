package modell;

public class Latogato extends Ember {

    private String terulet;

    public Latogato(String nev, String terulet, Oltozetek viselet) {
        super(nev, viselet);
        setTerulet(terulet);
    }

    public String getTerulet() {
        return terulet;
    }

    @Override
    public String toString() {
        return "Latogato{" + "terulet=" + terulet + '}';
    }

    public void setTerulet(String terulet) {
        this.terulet = terulet;
    }

}
