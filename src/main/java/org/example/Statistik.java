package org.example;

import org.json.JSONObject;

public class Statistik {
    private int anzahlRichtig;
    private int anzahlFalsch;
    private int anzahlGesamt;

    public Statistik() {
        this.anzahlRichtig = 0;
        this.anzahlFalsch = 0;
    }

    public static Statistik fromJSONObject(JSONObject statistik) {
        Statistik s = new Statistik();
        s.anzahlRichtig = statistik.getInt("anzahlRichtig");
        s.anzahlFalsch = statistik.getInt("anzahlFalsch");
        s.anzahlGesamt = statistik.getInt("anzahlGesamt");
        return s;
    }

    public void erhoeheRichtig() {
        this.anzahlRichtig++;
        this.anzahlGesamt++;
    }

    public void erhoeheFalsch() {
        this.anzahlFalsch++;
        this.anzahlGesamt++;
    }

    public int getAnzahlRichtig() {
        return this.anzahlRichtig;
    }

    public int getAnzahlFalsch() {
        return this.anzahlFalsch;
    }

    public int getAnzahlGesamt() {
        return this.anzahlGesamt;
    }

    public double getProzentRichtig() {
        return (double) this.anzahlRichtig / this.anzahlGesamt * 100;
    }
}
