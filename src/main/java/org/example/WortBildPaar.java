package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class WortBildPaar {
    private String wort;
    private String bild;

    public WortBildPaar(String bild, String wort) throws IOException, URISyntaxException, IllegalAccessException {
        setBild(bild);
        setWort(wort);
    }

    public String getBild() {
        return bild;
    }

    private void setBild(String bild) throws IllegalAccessException, MalformedURLException, URISyntaxException, IOException {
        if (bild == null) {
            throw new IllegalAccessException("Bild darf nicht null sein");
        }

        URL u = new URL(bild);
        u.toURI();  // does the extra checking required for validation of URI

        if (!isImageLink(u)) {
            throw new IllegalArgumentException("Die angegebene URL ist kein Bild");
        }

        this.bild = bild;
    }

    private boolean isImageLink(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        String contentType = connection.getContentType();

        // Check if the content type is an image type
        return contentType != null && contentType.startsWith("image/");
    }
    private void setWort(String wort) throws IllegalAccessException {
        if (wort == null) throw new IllegalAccessException("Wort darf nicht null sein");
        this.wort = wort;
    }

    public String getWort() {
        return this.wort;
    }
}
