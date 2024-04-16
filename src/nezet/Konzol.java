package nezet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modell.Dolgozo;
import modell.Ember;
import modell.Epulet;
import modell.Latogato;
import modell.NyugdijCompare;

public class Konzol {

    private Epulet epulet;
    private List<Dolgozo> dolgozok;
    private List<Latogato> latogatok;
    private Map<String, Integer> teruletek;

    public Konzol() {
        epulet = new Epulet();
        dolgozok = new ArrayList<>();
        latogatok = new ArrayList<>();
        szetvalogat();
    }

    public void feladatok() throws Exception {
        epuletbenLevoEmberekKonzolon();
        epuletbenLevoEmberekFajlban();
        dolgozokNevSorban();
        dolgozokNyugdijig();
        latogatokTeruletSzerint();
        System.out.println("Fajlbeolvasva: ");
        fajlBeolvas();
    }

    private void szetvalogat() {
        for (Ember ember : epulet.getEmberek()) {
            if (ember instanceof Dolgozo) {
                dolgozok.add((Dolgozo) ember);
            } else if (ember instanceof Latogato) {
                latogatok.add((Latogato) ember);
            }
        }
    }

    private void epuletbenLevoEmberekKonzolon() {
        System.out.println("Dolgozok: ");
        kiir(dolgozok);

        System.out.println("\nLatogatok");
        kiir(latogatok);
    }

    private <T> void kiir(List<T> lista) {
        for (Object object : lista) {
            System.out.println(object);
        }
    }

    private void epuletbenLevoEmberekFajlban() throws Exception {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ember.txt"));
            oos.writeObject(epulet);
            oos.close();

        } catch (FileNotFoundException ex) {
            throw new Exception("Hiba a fájl beolvasása közben!");
        } catch (IOException ex) {
            throw new Exception("Hiba a fájl beolvasása közben!");
        }

    }

    private void dolgozokNevSorban() {
        Collections.sort(dolgozok);
        kiir(dolgozok);
    }

    private void dolgozokNyugdijig() {
        Collections.sort(dolgozok, new NyugdijCompare());
        kiir(dolgozok);
    }

    private void latogatokTeruletSzerint() {

        teruletek = new HashMap<>();
        for (Latogato l : latogatok) {

            teruletek.put(l.getTerulet(), teruletek.getOrDefault(l.getTerulet(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : teruletek.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " -> " + value + "db");

        }
    }

    private void fajlBeolvas() throws Exception {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ember.txt"));
            System.out.println(ois.readObject());
            ois.close();
        } catch (FileNotFoundException ex) {
            throw new Exception("Hiba a fájl beolvasása közben!");
        } catch (IOException ex) {
            throw new Exception("Hiba a fájl beolvasása közben!");
        }
    }

}
