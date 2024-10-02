package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class JSONSpeicherStrategie implements SpeicherStrategie {

    @Override
    public void speichern(List<WortBildPaar> wortBildPaarList, int anzahlRichtig, int anzahlFalsch, String dateiPfad) throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(dateiPfad));
        JSONObject session = new JSONObject();

        JSONArray wordBildPaareArray = new JSONArray();

        for (WortBildPaar paar : wortBildPaarList) {
            JSONObject wordBildPaarObject = new JSONObject();
            wordBildPaarObject.put("bild", paar.getBild());
            wordBildPaarObject.put("wort", paar.getWort());

            wordBildPaareArray.put(wordBildPaarObject);
        }

        session.put("wordBildPaare", wordBildPaareArray);
        session.put("aktuellesWordBildPaar", "Irrelevant");
        session.put("richtige Antworten", anzahlRichtig);
        session.put("falsche Antworten", anzahlFalsch);

        writer.write(session.toString(4)); // "4" sorgt für eine schön formatierte Ausgabe
        writer.flush();
        writer.close();
    }


    @Override
    public JSONObject laden(String dateiPfad) throws IOException, URISyntaxException, IllegalAccessException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dateiPfad));
            String tmp = reader.readLine();
            String out = tmp;
            while (tmp != null) {
                tmp = reader.readLine();
                out += tmp;
            }
            reader.close();
            JSONObject jsonObject = new JSONObject(out);
            return jsonObject;

        } catch (FileNotFoundException e) {
            JSONObject session = new JSONObject();
            WortBildPaar wortBildPaar1 = new WortBildPaar("https://www.wwf.at/wp-content/uploads/2021/05/2final_wwf-at_Loewe_Bruellen_cSteveMorello.jpg", "löwe");
            WortBildPaar wortBildPaar2 = new WortBildPaar("https://s1.1zoom.me/big7/392/Dogs_Australian_499239.jpg","hund");
            ArrayList<WortBildPaar> wortBildPaarList = new ArrayList<>();
            wortBildPaarList.add(wortBildPaar1);
            wortBildPaarList.add(wortBildPaar2);

            JSONArray wordBildPaareArray = new JSONArray();

            for (WortBildPaar paar : wortBildPaarList) {
                JSONObject wordBildPaarObject = new JSONObject();
                wordBildPaarObject.put("bild", paar.getBild());
                wordBildPaarObject.put("wort", paar.getWort());
                wordBildPaareArray.put(wordBildPaarObject);
            }
            session.put("wordBildPaare", wordBildPaareArray);
            session.put("aktuellesWordBildPaar", "Irrelevant");
            session.put("richtige Antworten", 0);
            session.put("falsche Antworten", 0);
            return session;
        }
    }
}
