package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.List;

public class JSONSpeicherStrategie implements SpeicherStrategie {

    @Override
    public void speichern(List<WortBildPaar> wortBildPaarList, int anzahlRichtig, int anzahlFalsch, String dateiPfad) throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(dateiPfad));
        JSONObject session = new JSONObject();

        // Erstelle ein JSONArray für die WortBildPaar-Objekte
        JSONArray wordBildPaareArray = new JSONArray();

        for (WortBildPaar paar : wortBildPaarList) {
            // Erstelle ein JSONObject für jedes WortBildPaar
            JSONObject wordBildPaarObject = new JSONObject();
            wordBildPaarObject.put("bild", paar.getBild());
            wordBildPaarObject.put("wort", paar.getWort());

            // Füge das JSONObject dem JSONArray hinzu
            wordBildPaareArray.put(wordBildPaarObject);
        }

        // Füge das JSONArray dem JSON-Objekt hinzu
        session.put("wordBildPaare", wordBildPaareArray);
        session.put("aktuellesWordBildPaar", "Irrelevant");
        session.put("richtige Antworten", anzahlRichtig);
        session.put("falsche Antworten", anzahlFalsch);

        // Schreibe das JSON-Objekt in die Datei
        writer.write(session.toString(4)); // "4" sorgt für eine schön formatierte Ausgabe
        writer.flush();
        writer.close();
    }


    @Override
    public JSONObject laden(String dateiPfad) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dateiPfad));
        String tmp = reader.readLine();
        String out = tmp;
        while(tmp != null) {
            tmp = reader.readLine();
            out += tmp;
        }
        reader.close();
        JSONObject jsonObject = new JSONObject(out);
        return jsonObject;
    }
}
