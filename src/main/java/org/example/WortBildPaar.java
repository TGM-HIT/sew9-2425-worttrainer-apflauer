package org.example;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class WortBildPaar {
    private String wort;
    private String bild;

    public WortBildPaar(String bild, String wort) throws MalformedURLException, URISyntaxException, IllegalAccessException {
        setBild(bild);
        setWort(wort);
    }

    public String getBild() {
        return bild;
    }

    public void setBild(String bild) throws IllegalAccessException, MalformedURLException, URISyntaxException {
        if (bild == null) throw new IllegalAccessException("Bild darf nicht null sein");
        URL u = new URL(bild);
        u.toURI();  // does the extra checking required for validation of URI
        this.bild = bild;
    }
    public void setWort(String wort) throws IllegalAccessException {
        if (wort == null) throw new IllegalAccessException("Wort darf nicht null sein");
        this.wort = wort;
    }

    public String getWort() {
        return this.wort;
    }
}
