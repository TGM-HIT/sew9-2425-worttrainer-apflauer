## Erste Aufgabe

Das Einbinden einer externen Library in Gradle war relativ einfach. Unter dependencies im build.gradle konnt man sehr einfach
die JSON library einbauen die ich für den Worttrainer brauche. 

```gradle
dependencies {
    implementation("org.json:json:20210307")           // JSON library included 1. EK task
}
```

## Zweite Aufgabe

Die zweite Aufgabe war das Erstellen einer Github action. Damit das Möglich ist, musste ich die Main Klasse in dem gradle.build
definieren.
    
```gradle
tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "org.example.testingEnviroment"
        )
    }
}
```

Danach habe ich ein yaml file erstellt, dass den Worttrainer als ein jar bei jedem push baut und als Artifakt abspeichert. 
Dieses skript wurde in den github/workflows Ordner gespeichert. 
Später als ich die Github Issue bearbeitet habe musste ich das Skript anpassen, sodass ein jar hochgeladen wird bei dem ALLE libraries und dependencies dabei sind.

## Dritte Aufgabe

fix#2 - Markus hat eine Github Issue erstellt die ich behoben habe.

Wie? - Siehe dokumentationsdoc