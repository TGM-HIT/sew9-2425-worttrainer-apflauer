package org.example;

import org.json.JSONObject;

import java.io.*;
import java.util.List;

public class JSONSpeicherStrategie implements SpeicherStrategie {

    private Reader reader;
    private Writer writer;

    @Override
    public void speichern(List<WortBildPaar> wortBildPaarList, Statistik statistik, String dateiPfad) throws IOException {
        JSONObject session = new JSONObject();
        session.put("wordBildPaare", wortBildPaarList);
        session.put("aktuellesWordBildPaar", "Irrelevant");
        session.put("statistik", statistik);
        this.writer.write(session.toString());
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
