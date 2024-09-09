package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public interface SpeicherStrategie {
    void speichern(List<WortBildPaar> wortBildPaarList, Statistik statistik, String dateiPfad) throws IOException;
    JSONObject laden(String dateiPfad) throws IOException;
}
