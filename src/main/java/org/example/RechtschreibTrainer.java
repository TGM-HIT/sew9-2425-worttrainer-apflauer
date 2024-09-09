package org.example;

import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RechtschreibTrainer {

    private List<WortBildPaar> paare;
    private WortBildPaar aktuellesPaar;
    private Statistik statistik;
    private SpeicherStrategie speicherStrategie;

    public RechtschreibTrainer(SpeicherStrategie speicherStrategie) {
        this.speicherStrategie = speicherStrategie;
    }

    public void laden(String dateiPfad) throws IOException {
        JSONObject jsonObject = this.speicherStrategie.laden(dateiPfad);
        this.paare = (List<WortBildPaar>) jsonObject.get("wordBildPaare");
        this.statistik = (Statistik) jsonObject.get("statistik");
        Random r = new Random();
        this.aktuellesPaar = this.paare.get(r.nextInt(this.paare.size()-1));
    }

    public void display() {
        JOptionPane.showMessageDialog(null, "Das Bild: " + this.aktuellesPaar.getBild() + " zeigt das Wort: " + this.aktuellesPaar.getWort());
    }

}
