package org.example;

import org.json.JSONObject;

import java.io.*;
import java.util.List;

public class JSONSpeicherStrategie implements SpeicherStrategie {

    @Override
    public void speichern(List<WortBildPaar> wortBildPaarList, int anzahlRichtig, int anzahlFalsch, String dateiPfad) throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(dateiPfad));
        JSONObject session = new JSONObject();
        session.put("wordBildPaare", wortBildPaarList);
        session.put("aktuellesWordBildPaar", "Irrelevant");
        session.put("richtige Antworten", anzahlRichtig);
        session.put("falsche Antworten", anzahlFalsch);
        writer.write(session.toString());
        writer.flush();
        writer.close();
    }

    @Override
    public JSONObject laden(String dateiPfad) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dateiPfad));
        String tmp = reader.readLine();
        reader.close();
        JSONObject jsonObject = new JSONObject(tmp);
        return jsonObject;
    }
}
