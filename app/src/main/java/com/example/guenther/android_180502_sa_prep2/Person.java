package com.example.guenther.android_180502_sa_prep2;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;

/**
 * Created by guenther on 02.05.2018.
 */

public class Person implements Serializable{

    private String vorname, nachname;
    private Date gebDatum;
    private URL url;


    public Person(String vorname, String nachname, Date gebDatum, URL url) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.gebDatum = gebDatum;
        this.url = url;

    }

    public URL getUrl() {
        return url;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public Date getGebDatum() {
        return gebDatum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (vorname != null ? !vorname.equals(person.vorname) : person.vorname != null)
            return false;
        if (nachname != null ? !nachname.equals(person.nachname) : person.nachname != null)
            return false;
        return gebDatum != null ? gebDatum.equals(person.gebDatum) : person.gebDatum == null;
    }

    @Override
    public int hashCode() {
        int result = vorname != null ? vorname.hashCode() : 0;
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        result = 31 * result + (gebDatum != null ? gebDatum.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Vorname: " + vorname + " Nachname: " + nachname + " GebDatum: " + gebDatum.toString() + " URL: " + url.toString();
    }
}
