# Bilder-Wort-Ratespiel

## Übersicht

Dieses Java-Programm zeigt Bilder an, zu denen der Benutzer das richtige Wort erraten muss. Die Bilder und Wörter werden aus einer JSON-Datei geladen. Dank des **Strategy Patterns** lässt sich das Programm leicht erweitern, um auch andere Dateiformate (z.B. XML, CSV) zu unterstützen.

Zudem gibt es zwei Schaltflächen zum **Speichern** und **Laden** des Spielfortschritts. Am unteren Rand werden die **Spielstatistiken** wie Punkte und Versuche angezeigt.

## Installation und Setup

1. Repository klonen:
    ```bash
    git clone https://github.com/TGM-HIT/sew9-2425-worttrainer-TarnocziRaphael.git
    cd [Ordner]
    ```

2. Projekt mit einer Java-IDE oder der Kommandozeile kompilieren:
    ```bash
    javac -cp . testEnvironment.java
    ```

3. Die JSON-Datei im richtigen Verzeichnis platzieren, z.B.:
    ```json
    {
      "falsche Antworten": 15,
      "richtige Antworten": 5,
      "wordBildPaare": [
        {
          "bild": "path/to/image1.png",
          "wort": "Apfel"
        },
        {
          "url": "path/to/image2.png",
          "word": "Banane"
        }    
      ]  
    }
    ```


4. Programm ausführen:
    ```bash
    java testEnvironment
    ```

## Nutzung

- **Raten:** Ein Bild erscheint, und der Benutzer muss das passende Wort eingeben.
- **Speichern/Laden:** Spielstand speichern oder wiederherstellen.
- **Statistiken:** Punkte und Versuche unten angezeigt.

## Erweiterung

Dank des **Strategy Patterns** kann das Laden von Daten einfach auf andere Formate (z.B. XML, CSV) angepasst werden. Dazu einfach eine neue Klasse für das gewünschte Format implementieren, die das `StrategyStorage`-Interface umsetzt.

## Autor

- **Name:** Luca Tarnoczi
- **Klasse:** 5AHIT
- **Datum:** 23. September 2024
