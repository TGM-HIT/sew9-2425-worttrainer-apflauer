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

```yaml
name: Build and Upload JAR

on:
  push:
    branches:
      - main
  pull_request:
    branches:
      - main

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v2

      - name: Set up JDK 11
        uses: actions/setup-java@v2
        with:
          java-version: '11'
          distribution: 'adopt'

      - name: Grant execute permission for gradlew
        run: chmod +x gradlew

      - name: Build with Gradle
        run: ./gradlew build

      - name: Jar with Gradle
        run: ./gradlew jar


      - name: Upload JAR file
        uses: actions/upload-artifact@v4.4.0
        with:
          name: my-app
          path: build/libs/*.jar
```

## Dritte Aufgabe

fix#2 - Markus hat eine Github Issue erstellt die ich behoben habe.