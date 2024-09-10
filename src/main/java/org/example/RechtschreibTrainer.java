package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RechtschreibTrainer {

    private List<WortBildPaar> paare;
    private WortBildPaar aktuellesPaar;
    private int anzahlRichtig = 0;
    private int anzahlFalsch = 0;

    private SpeicherStrategie speicherStrategie;

    public RechtschreibTrainer(SpeicherStrategie speicherStrategie) {
        this.speicherStrategie = speicherStrategie;
    }

    public void laden(String dateiPfad) throws IOException, URISyntaxException, IllegalAccessException {
        this.paare = new ArrayList<>();
        JSONObject jsonObject = this.speicherStrategie.laden(dateiPfad);

        // Lade das JSONArray aus dem JSON-Objekt
        JSONArray wordBildPaareArray = jsonObject.getJSONArray("wordBildPaare");

        // Iteriere über das JSONArray und erstelle WortBildPaar-Objekte
        for (int i = 0; i < wordBildPaareArray.length(); ++i) {
            JSONObject wordBildPaarObject = wordBildPaareArray.getJSONObject(i);

            // Lade die "bild" URL
            String bildUrl = wordBildPaarObject.getString("bild");

            // Extrahiere das "wort" aus dem Bild-URL (letzter Abschnitt vor der Dateiendung)
            String wort = bildUrl.substring(bildUrl.lastIndexOf("/") + 1, bildUrl.lastIndexOf("."));

            // Erstelle das WortBildPaar-Objekt
            WortBildPaar wortBildPaar = new WortBildPaar(bildUrl, wort);

            // Füge das WortBildPaar zur Liste hinzu
            this.paare.add(wortBildPaar);
        }

        // Wähle ein zufälliges Paar aus
        Random r = new Random();
        this.aktuellesPaar = this.paare.get(r.nextInt(this.paare.size()));
    }

    public void display() throws IOException {
        Image image = ImageIO.read(new URL(this.aktuellesPaar.getBild()));
        image.getScaledInstance(400, 400, Image.SCALE_DEFAULT);

        JOptionPane.showInputDialog(null, "Rechtschreibtrainer", "AktuellesBild", JOptionPane.QUESTION_MESSAGE, new ImageIcon(image), null, null);

    }

}
