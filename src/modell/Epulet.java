package modell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Epulet implements Serializable {

    private List<Ember> emberek;

    public Epulet() {
        emberek = new ArrayList<>();
        emberek.add(new Dolgozo("Sanyi",10, Ember.Oltozetek.megfelelő));
        emberek.add(new Dolgozo("Tacsi", Ember.Oltozetek.megfelelő));
        emberek.add(new Latogato("beni", "Kék", Ember.Oltozetek.megfelelő));
        emberek.add(new Latogato("sari", "Kék", Ember.Oltozetek.megfelelő));
        emberek.add(new Latogato("Pista", "Sárga", Ember.Oltozetek.megfelelő));
    }

    @Override
    public String toString() {
        return "Epulet{" + "emberek=" + emberek + '}';
    }

    public List<Ember> getEmberek() {
        return emberek;
    }

    public void setEmberek(Ember emberek) {
        this.emberek.add(emberek);
    }

}
