package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RechtschreibTrainerTest {

    @org.junit.jupiter.api.BeforeAll
    static void testLaden() throws IOException, URISyntaxException, IllegalAccessException {
        WortBildPaar wortBildPaarDummy = new WortBildPaar("https://static.turbosquid.com/Preview/2019/02/18__04_59_25/Crash_Test_Dummy_Rigged_mb_00.jpg5B1ADE98-2892-494F-9EB2-F0B49A1BE375DefaultHQ.jpg", "Dummy");
        WortBildPaar wortBildPaarDummy2 = new WortBildPaar("https://static.turbosquid.com/Preview/2019/02/18__04_59_25/Crash_Test_Dummy_Rigged_mb_00.jpg5B1ADE98-2892-494F-9EB2-F0B49A1BE375DefaultHQ.jpg", "Dummy2");
        JSONSpeicherStrategie jsonSpeicherStrategie = new JSONSpeicherStrategie();
        jsonSpeicherStrategie.speichern(List.of(wortBildPaarDummy, wortBildPaarDummy2), 0, 0, "Junitest.json");
    }

    @org.junit.jupiter.api.Test
    void testCountAnwsers() throws IOException, URISyntaxException, IllegalAccessException {
        RechtschreibTrainer trainer = new RechtschreibTrainer(new JSONSpeicherStrategie());
        trainer.laden("Junitest.json");

        trainer.countAnswers("Dummy");
        assertEquals(1, trainer.getAnzahlRichtig());
        assertEquals(0, trainer.getAnzahlFalsch());

        trainer.countAnswers("FalschesWort");
        assertEquals(1, trainer.getAnzahlRichtig());
        assertEquals(1, trainer.getAnzahlFalsch());
    }

    @org.junit.jupiter.api.Test
    void testSetNewRandomPaar() throws IOException, URISyntaxException, IllegalAccessException {
        RechtschreibTrainer trainer = new RechtschreibTrainer(new JSONSpeicherStrategie());
        trainer.laden("Junitest.json");

        trainer.setNewRandomPaar(new Random());
        assertNotNull(trainer.getAktuellesPaar());
    }

}

class WortBildPaarTest {

    @org.junit.jupiter.api.Test
    void testBildURL() throws IOException, URISyntaxException, IllegalAccessException {
        WortBildPaar wortBildPaar = new WortBildPaar("https://static.turbosquid.com/Preview/2019/02/18__04_59_25/Crash_Test_Dummy_Rigged_mb_00.jpg5B1ADE98-2892-494F-9EB2-F0B49A1BE375DefaultHQ.jpg", "Dummy");

        String incorrectURL1 = "htt://static.turbosquid.com/Preview/2019/02/18__04_59_25/Crash_Test_Dummy_Rigged_mb_00.jpg5B1ADE98-2892-494F-9EB2-F0B49A1BE375DefaultHQ.jpg";
        String incorrectURL2 = "https:/static.turbosquid.com/Preview/2019/02/18__04_59_25/Crash_Test_Dummy_Rigged_mb_00.jpg5B1ADE98-2892-494F-9EB2-F0B49A1BE375DefaultHQ.jpg";
        String incorrectURL3 = "http//static.turbosquid.com/Preview/2019/02/18__04_59_25/Crash_Test_Dummy_Rigged_mb_00.jpg5B1ADE98-2892-494F-9EB2-F0B49A1BE375DefaultHQ.jpg";
        String incorrectURL4 = "https://static.turbosquid.com/Preview/2019/02/18__04_59_25/Crash_Test_Dummy_Rigged_mb_00.jpg5B1ADE98-2892-494F-9EB2-F0B49A1BE375DefaultHQ.jp";

        assertThrows(Exception.class, () -> { new WortBildPaar(incorrectURL1, "Dummy");});
        assertThrows(Exception.class, () -> { new WortBildPaar(incorrectURL2, "Dummy");});
        assertThrows(Exception.class, () -> { new WortBildPaar(incorrectURL3, "Dummy");});
        assertThrows(Exception.class, () -> { new WortBildPaar(incorrectURL4, "Dummy");});

    }

}