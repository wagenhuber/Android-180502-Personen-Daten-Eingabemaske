package com.example.guenther.android_180502_sa_prep2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guenther on 02.05.2018.
 */

public class Personen implements Serializable {

    private List<Person> personenListe;

    public Personen() {
        personenListe = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personenListe.add(person);
    }

    public Person getPerson(int index) {
        return personenListe.get(index);
    }

    public int anzahlPersonen() {
        return personenListe.size();
    }

    public List<Person> getPersonenListe() {
        return personenListe;
    }

}
