package org.example;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class testingEnviroment {


    public static void main(String[] args) throws IOException, URISyntaxException, IllegalAccessException {
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
}