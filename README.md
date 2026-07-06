<div align="center">

# 🎮 Tic-Tac-Toe
### Konsolenbasiertes Strategiespiel mit KI-Gegner

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=java)
![Version](https://img.shields.io/badge/Version-1.0-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Produktionsreif-green?style=for-the-badge)
![Institution](https://img.shields.io/badge/BFI-Leoben-red?style=for-the-badge)

</div>

---

## 📋 Projektinformationen

| Feld                   | Inhalt                                                                        |
|------------------------|-------------------------------------------------------------------------------|
| **Projektname**        | Tic-Tac-Toe                                                                   |
| **Beschreibung**       | Konsolenbasiertes Tic-Tac-Toe mit KI-Gegner und Zwei-Spieler-Modus           |
| **Typ**                | Schulaufgabe / JAVA – Anwendung                                               |
| **Programmiersprache** | Java                                                                          |
| **Version**            | 1.0                                                                           |
| **Status**             | ✅ Produktionsreife                                                            |
| **Datum**              | 2026                                                                          |
| **Entwickler**         | Bashar Salmo                                                                  |
| **Lehrer**             | G. Jarz                                                                       |
| **Institution**        | BFI-Leoben                                                                    |

---

## 📁 Projektstruktur

```
TicTacToe/
└── src/
    └── com/
        └── company/
            ├── Main.java   → Spielfluss, Menüs, Benutzereingaben
            └── t_game.java → Gesamte Spiellogik & KI
```

### Klassenbeschreibung

| Klasse | Verantwortung |
|--------|---------------|
| `Main.java` | Einstiegspunkt, Menüführung, Spielerauswahl, Schwierigkeitswahl, Spielschleifen |
| `t_game.java` | Spielbrett, Zugvalidierung, Gewinnprüfung, KI-Logik (Random & Minimax) |

---

## 🕹️ Spielmodi

| Modus | Beschreibung | Schwierigkeit |
|-------|--------------|---------------|
| 👥 **Spieler vs. Spieler** | Zwei Spieler teilen sich dasselbe Terminal | — |
| 🎲 **Spieler vs. Computer (Normal)** | Computer setzt zufällige Züge | Leicht |
| 🤖 **Spieler vs. Computer (Experte)** | Minimax-Algorithmus — Computer ist unschlagbar | Sehr schwer |

---

## ✅ Features

- 🔢 **Numpad-Layout (1–9)** — Intuitive Eingabe wie auf einer Tastatur
- 🔄 **Live-Spielfeld** — Zahlen werden nach jedem Zug durch `X` oder `O` ersetzt
- 🛡️ **Vollständige Eingabevalidierung** — Ungültige Eingaben und belegte Felder werden abgefangen
- 🔁 **„Nochmal spielen?"** — Nach jedem Spiel kann direkt neu gestartet werden
- 🇩🇪 **Deutschsprachige Oberfläche** — Alle Ausgaben auf Deutsch
- 🏆 **Automatische Erkennung** — Gewinner und Unentschieden werden sofort erkannt
- 🧹 **Saubere Architektur** — Spiellogik strikt von der Benutzerführung getrennt

---

## 🖥️ Spielfeld

Das Spielfeld orientiert sich am Numpad-Layout der Tastatur:

```
-------------        Eingabe:    7 = oben links
| 7 | 8 | 9 |                    5 = mitte
-------------                    1 = unten links
| 4 | 5 | 6 |                    usw.
-------------
| 1 | 2 | 3 |
-------------
```

Nach Zügen werden Zahlen durch `X` (Spieler) oder `O` (Computer) ersetzt:

```
-------------
| X | 8 | 9 |
-------------
| 4 | O | 6 |
-------------
| 1 | 2 | X |
-------------
```

---

## 🚀 Programmablauf

```
Programmstart
      │
      ▼
┌─────────────────┐
│   Hauptmenü     │  (1) Neues Spiel
│                 │  (2) Spiel beenden
└────────┬────────┘
         │ (1) Neues Spiel
         ▼
┌─────────────────┐
│  Gegnerwahl     │  (1) Computer
│                 │  (2) Spieler
│                 │  (3) Beenden
└────────┬────────┘
         │
    ┌────┴────┐
    │         │
    ▼         ▼
Computer    Spieler
    │         │
    ▼         │
┌───────────┐ │
│ Schwierig-│ │
│ keitsgrad │ │
│ Normal /  │ │
│ Experte   │ │
└─────┬─────┘ │
      └───────┘
         │
         ▼
┌─────────────────────────────────┐
│           Spielschleife         │
│  1. Brett anzeigen              │
│  2. Zug eingeben / berechnen    │
│  3. Gewinner prüfen             │
│  4. Unentschieden prüfen        │
│  5. Spieler wechseln            │
│  6. Wiederholen                 │
└────────────────┬────────────────┘
                 │ Spiel beendet
                 ▼
        „Nochmal spielen?"
         Ja ──► Neues Spiel
         Nein ─► Hauptmenü
```

---

## 🧠 Technische Konzepte

| Konzept | Anwendung im Projekt |
|---------|----------------------|
| **2D-Array** `char[3][3]` | Darstellung des Spielbretts |
| **Verschachtelte Schleifen** | Brett initialisieren, durchsuchen, ausgeben |
| **try-catch / Exception Handling** | Robuste Eingabevalidierung |
| **Ternary Operator** `? :` | Kompakter Spielerwechsel |
| **do-while Schleife** | „Nochmal spielen?" — läuft mindestens einmal |
| **Rekursion** | Minimax-Algorithmus |
| **Method Overloading** | `checkWinner()` und `checkWinner(char symbol)` |
| **OOP / Klassentrennung** | Spiellogik in `t_game`, Ablauf in `Main` |
| **Character-Methoden** | `Character.isDigit()` für Zellenprüfung |

---

## 🤖 Minimax-Algorithmus (Experte-Modus)

Der Experte-Modus verwendet den **Minimax-Algorithmus** — einen klassischen KI-Algorithmus für Zwei-Spieler-Spiele:

### Funktionsweise

```
minimax(isComputerTurn):
    wenn Computer gewonnen → return +10
    wenn Spieler gewonnen  → return -10
    wenn Unentschieden     → return  0

    wenn Computer am Zug:
        probiere jeden leeren Zug mit 'O'
        wähle den Zug mit dem HÖCHSTEN Score

    wenn Spieler am Zug:
        probiere jeden leeren Zug mit 'X'
        wähle den Zug mit dem NIEDRIGSTEN Score
```

### Bewertungsschema

| Ergebnis | Score |
|----------|-------|
| 🤖 Computer gewinnt | `+10` |
| ❌ Unentschieden | `0` |
| 👤 Spieler gewinnt | `-10` |

> **Resultat:** Der Computer analysiert jeden möglichen Spielverlauf und wählt stets den optimalen Zug.
> Er kann **nicht verlieren** — bestenfalls ist ein Unentschieden möglich.

---

## ▶️ Installation & Verteilung

Es gibt **zwei Möglichkeiten**, eine Java-Anwendung zu verteilen:

| Methode | Java erforderlich? | Dateityp | Geeignet für |
|---------|-------------------|----------|--------------|
| **Methode 1 — JAR-Datei** | ✅ Ja | `.jar` | Entwickler / Technische Benutzer |
| **Methode 2 — Native App** | ❌ Nein | `.dmg` / `.exe` / `.deb` | Endbenutzer |

> ℹ️ **Hinweis:** Tic-Tac-Toe ist eine **Konsolenanwendung** und benötigt Terminal-Eingabe. Auf **macOS** öffnet die DMG-App bei Doppelklick (ohne angehängtes Terminal) automatisch ein Terminal-Fenster und startet das Spiel darin neu; gelingt das nicht (z. B. Automation-Berechtigung verweigert), erscheint ein Hinweisdialog. Auf **Windows/Linux** zeigt die EXE/DEB-App bei Doppelklick nur einen Hinweisdialog — dort wird **Methode 1 (JAR)** über ein Terminal/Eingabeaufforderung empfohlen.

---

## 🍎 macOS (Apple Silicon & Intel)

### Methode 1 — JAR-Datei

**Schritt 1 — JAR in IntelliJ erstellen:**
```
File → Project Structure → Artifacts → + → JAR → From modules with dependencies
Main Class: com.company.Main → OK
Build → Build Artifacts → Build
```

**Schritt 2 — Im Terminal ausführen:**
```bash
java -jar /Pfad/zu/TicTacToe.jar
```

---

### Methode 2 — DMG (Mac App, kein Java erforderlich)

**Schritt 1 — Build-Script erstellen:**

Eine Datei namens `build-dmg.sh` im Projektverzeichnis erstellen:
```bash
#!/bin/bash
jpackage --input /Users/mbp/IdeaProjects/TicTacToe/out/artifacts/TicTacToe_jar/ \
         --name TicTacToe \
         --main-jar TicTacToe.jar \
         --main-class com.company.Main \
         --type dmg \
         --dest /Users/mbp/Desktop/ \
         --app-version 1.0
```

**Schritt 2 — Script ausführbar machen (nur einmal):**
```bash
chmod +x build-dmg.sh
```

**Schritt 3 — Script ausführen:**
```bash
./build-dmg.sh
```

**Schritt 4 — `TicTacToe-1.0.dmg` auf dem Desktop öffnen:**
- Doppelklick auf die `.dmg`-Datei
- `TicTacToe` in den Applications-Ordner ziehen ✅

> ✅ Funktioniert auf Apple Silicon (M1/M2/M3/M4) und Intel Macs

---

## 🪟 Windows

### Methode 1 — JAR-Datei

**Schritt 1 — JAR in IntelliJ erstellen** (wie macOS oben)

**Schritt 2 — Eingabeaufforderung öffnen:**
```
Win + R → cmd → Enter
```

**Schritt 3 — JAR ausführen:**
```cmd
java -jar C:\Pfad\zu\TicTacToe.jar
```

---

### Methode 2 — EXE (Windows App, kein Java erforderlich)

**Schritt 1 — Build-Script erstellen:**

Eine Datei namens `build-exe.bat` im Projektverzeichnis erstellen:
```bat
jpackage --input "C:\Pfad\zu\out\artifacts\TicTacToe_jar\" ^
         --name TicTacToe ^
         --main-jar TicTacToe.jar ^
         --main-class com.company.Main ^
         --type exe ^
         --dest "C:\Users\Name\Desktop\" ^
         --app-version 1.0
```

**Schritt 2 — Doppelklick auf `build-exe.bat`**

**Schritt 3 — `TicTacToe-1.0.exe` auf dem Desktop installieren:**
- Doppelklick → Installation wie ein normales Windows-Programm
- Über das Startmenü starten ✅

> ⚠️ Java 17+ muss auf dem **Entwickler-PC** installiert sein

---

## 🐧 Linux

### Methode 1 — JAR-Datei

**Schritt 1 — JAR in IntelliJ erstellen** (wie macOS oben)

**Schritt 2 — Im Terminal ausführen:**
```bash
java -jar /Pfad/zu/TicTacToe.jar
```

---

### Methode 2 — DEB-Paket (Linux App, kein Java erforderlich)

**Schritt 1 — Build-Script erstellen:**

Eine Datei namens `build-deb.sh` im Projektverzeichnis erstellen:
```bash
#!/bin/bash
jpackage --input /Pfad/zu/out/artifacts/TicTacToe_jar/ \
         --name TicTacToe \
         --main-jar TicTacToe.jar \
         --main-class com.company.Main \
         --type deb \
         --dest ~/Desktop/ \
         --app-version 1.0
```

**Schritt 2 — Script ausführbar machen:**
```bash
chmod +x build-deb.sh
```

**Schritt 3 — Script ausführen:**
```bash
./build-deb.sh
```

**Schritt 4 — DEB-Paket installieren:**
```bash
sudo dpkg -i TicTacToe-1.0.deb
```
✅ App ist systemweit installiert

---

## 📊 Plattformvergleich

| Funktion | 🍎 macOS | 🪟 Windows | 🐧 Linux |
|---------|---------|-----------|---------|
| JAR funktioniert | ✅ | ✅ | ✅ |
| Native Paketart | `.dmg` | `.exe` | `.deb` |
| Build-Script | `.sh` | `.bat` | `.sh` |
| Kein Java nötig | ✅ DMG | ✅ EXE | ✅ DEB |
| jpackage integriert | ✅ Java 17+ | ✅ Java 17+ | ✅ Java 17+ |
| Für Konsolenanwendungen | ✅ DMG (Auto-Terminal) | ⚠️ JAR empfohlen | ⚠️ JAR empfohlen |

---

### Eingabe-Referenz

```
Numpad-Layout:
  7 | 8 | 9   →   oben
  4 | 5 | 6   →   mitte
  1 | 2 | 3   →   unten

Menü-Eingaben: Zahlen entsprechend der angezeigten Optionen
Nochmal spielen: j (Ja) / n (Nein)
```

---

## 👨‍💻 Entwickler

| | |
|--|--|
| **Name** | Bashar Salmo |
| **Lehrer** | G. Jarz |
| **Institution** | BFI-Leoben |
| **Jahr** | 2026 |
| **GitHub** | https://github.com/itsmrroot/TicTacToe |

---

<div align="center">

*Entwickelt als Schulprojekt im Rahmen des Faches Applikationsentwicklung — BFI-Leoben 2026*

</div>