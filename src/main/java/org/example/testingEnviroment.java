package org.example;

import org.json.JSONObject;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class testingEnviroment {


    public static void main(String[] args) throws IOException, URISyntaxException, IllegalAccessException {
        /*String dateipfad = "test1.json";
        Writer writer = new BufferedWriter(new FileWriter(dateipfad));
        speichern(dateipfad, writer);

        laden(dateipfad);*/
        WortBildPaar wortBildPaar1 = new WortBildPaar("https://www.wwf.at/wp-content/uploads/2021/05/2final_wwf-at_Loewe_Bruellen_cSteveMorello.jpg", "löwe");
        WortBildPaar wortBildPaar2 = new WortBildPaar("https://s1.1zoom.me/big7/392/Dogs_Australian_499239.jpg","hund");
        JSONSpeicherStrategie jsonSpeicherStrategie = new JSONSpeicherStrategie();
        ArrayList<WortBildPaar> wortBildPaars = new ArrayList<>();
        wortBildPaars.add(wortBildPaar1);
        wortBildPaars.add(wortBildPaar2);

        jsonSpeicherStrategie.speichern(wortBildPaars, 0,0, "test1.json");

        RechtschreibTrainer trainer = new RechtschreibTrainer(jsonSpeicherStrategie);
        trainer.laden("test1.json");

        trainer.display();
    }

    /*public static void speichern(String dateiPfad, Writer w) throws IOException {
        JSONObject session = new JSONObject();
        session.put("wordBildPaare", new ArrayList<>(List.of("TestWert1", "TestWert2")));
        session.put("aktuellesWordBildPaar", new Object()); // Beispiel-Objekt, kann angepasst werden
        session.put("statistik", 0);
        w.write(session.toString());
        w.flush();
        w.close();
    }*/

    /*public static void laden(String dateiPfad) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dateiPfad));
        System.out.println(reader.readLine());
        reader.close();
    }*/
}