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

        JSONArray wordBildPaareArray = jsonObject.getJSONArray("wordBildPaare");
        for (int i = 0; i < wordBildPaareArray.length(); ++i) {
            JSONObject wordBildPaarObject = wordBildPaareArray.getJSONObject(i);
            String bildUrl = wordBildPaarObject.getString("bild");
            String wort = wordBildPaarObject.getString("wort");
            WortBildPaar wortBildPaar = new WortBildPaar(bildUrl, wort);
            this.paare.add(wortBildPaar);
        }

        Random r = new Random();
        this.aktuellesPaar = this.paare.get(r.nextInt(this.paare.size()));
    }

    public void display() throws IOException {
        // Initialisiere Random für die Zufallsauswahl
        Random random = new Random();

// Wähle das erste Paar zufällig aus
        this.aktuellesPaar = this.paare.get(random.nextInt(this.paare.size()));

// Iteriere über die Paare
        while (!this.paare.isEmpty()) {
            Image image = ImageIO.read(new URL(this.aktuellesPaar.getBild()));
            image = image.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            String antwort = (String) JOptionPane.showInputDialog(null, "Was ist auf dem Bild zu sehen? (case sensetive)", "AktuellesBild", JOptionPane.QUESTION_MESSAGE, new ImageIcon(image), null, null);
            if (this.aktuellesPaar.getWort().equals(antwort)) {
                this.anzahlRichtig++;
            } else {
                this.anzahlFalsch++;
            }
            this.paare.remove(this.aktuellesPaar);
            if (this.paare.isEmpty()) {
                break;
            }
            this.aktuellesPaar = this.paare.get(random.nextInt(this.paare.size()));
        }
        JOptionPane.showMessageDialog(null, statistikMSG());
    }

    public String statistikMSG() {
        return "Anzahl richtiger Antworten: " + this.anzahlRichtig + "\n" +
                "Anzahl falscher Antworten: " + this.anzahlFalsch;
    }
}
