package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public interface SpeicherStrategie {
    void speichern(List<WortBildPaar> wortBildPaarList, int anzahlRichitg, int anzahlFalsch, String dateiPfad) throws IOException;
    JSONObject laden(String dateiPfad) throws IOException;
}
