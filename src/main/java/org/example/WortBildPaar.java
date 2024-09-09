package org.example;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class WortBildPaar {
    private String wort;
    private String bild;

    public WortBildPaar(String wort, String bild) {
        this.wort = wort;
        this.bild = bild;
    }

    public String getBild() {
        return bild;
    }
    public String getWort() {
        return wort;
    }
    public void setBild(String bild) throws IllegalAccessException, MalformedURLException, URISyntaxException {
        if (this.bild == null) throw new IllegalAccessException("Bild darf nicht null sein");
        URL u = new URL(bild); // this would check for the protocol
        u.toURI();  // does the extra checking required for validation of URI
        this.bild = bild;
    }
    public void setWort(String wort) throws IllegalAccessException {
        if (this.wort == null) throw new IllegalAccessException("Wort darf nicht null sein");
        this.wort = wort;
    }
}
