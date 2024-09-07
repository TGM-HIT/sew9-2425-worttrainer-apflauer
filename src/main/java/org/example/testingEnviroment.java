package org.example;

import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class testingEnviroment {


    public static void main(String[] args) throws IOException {
        String dateipfad = "/Users/zen/IdeaProjects/Worttrainer/SpeicherformateTest/test1.json";
        Writer writer = new BufferedWriter(new FileWriter(dateipfad));
        speichern(dateipfad, writer);

        laden(dateipfad);
    }

    public static void speichern(String dateiPfad, Writer w) throws IOException {
        JSONObject session = new JSONObject();
        session.put("wordBildPaare", new ArrayList<>(List.of("TestWert1", "TestWert2")));
        session.put("aktuellesWordBildPaar", new Object()); // Beispiel-Objekt, kann angepasst werden
        session.put("statistik", 0);
        w.write(session.toString());
        w.close();
    }

    public static void laden(String dateiPfad) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dateiPfad));
        System.out.println(reader.readLine());
        reader.close();
    }
}