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
            ├── Main.java                  → Spielfluss, Menüs, Benutzereingaben
            ├── t_game.java                → Gesamte Spiellogik & KI
            └── InvalidInputException.java → Eigene Exception-Klasse
```

### Klassenbeschreibung

| Klasse | Verantwortung |
|--------|---------------|
| `Main.java` | Einstiegspunkt, Menüführung, Spielerauswahl, Schwierigkeitswahl, Spielschleifen |
| `t_game.java` | Spielbrett, Zugvalidierung, Gewinnprüfung, KI-Logik (Random & Minimax) |
| `InvalidInputException.java` | Eigene Runtime-Exception für ungültige Benutzereingaben |

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
| **Eigene Exception** | `InvalidInputException extends RuntimeException` |
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

## ▶️ Installation & Distribution

There are **two ways** to distribute a Java application:

| Method | Java Required? | File Type | Best For |
|--------|---------------|-----------|----------|
| **Method 1 — JAR file** | ✅ Yes | `.jar` | Developers / Technical users |
| **Method 2 — Native App** | ❌ No | `.dmg` / `.exe` / `.deb` | End users |

---

## 🍎 macOS (Apple Silicon & Intel)

### Method 1 — JAR file

**Step 1 — Build JAR in IntelliJ:**
```
File → Project Structure → Artifacts → + → JAR → From modules with dependencies
Main Class: com.company.Main → OK
Build → Build Artifacts → Build
```

**Step 2 — Run in Terminal:**
```bash
java -jar /path/to/TicTacToe.jar
```

---

### Method 2 — DMG (Mac App, no Java needed)

**Step 1 — Create a build script:**

Create a file called `build-dmg.sh` in your project with this content:
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

**Step 2 — Make it executable (only once):**
```bash
chmod +x build-dmg.sh
```

**Step 3 — Run the script:**
```bash
./build-dmg.sh
```

**Step 4 — Find `TicTacToe-1.0.dmg` on your Desktop:**
- Double-click the `.dmg`
- Drag `TicTacToe` into Applications
- Launch from Applications ✅

> ✅ Works on both Apple Silicon (M1/M2/M3/M4) and Intel Macs

---

## 🪟 Windows

### Method 1 — JAR file

**Step 1 — Build JAR in IntelliJ** (same as Mac above)

**Step 2 — Open Command Prompt:**
```
Press Win + R → type cmd → Enter
```

**Step 3 — Run the JAR:**
```cmd
java -jar C:\path\to\TicTacToe.jar
```

---

### Method 2 — EXE (Windows App, no Java needed)

**Step 1 — Create a build script:**

Create a file called `build-exe.bat` in your project:
```bat
jpackage --input "C:\path\to\out\artifacts\TicTacToe_jar\" ^
         --name TicTacToe ^
         --main-jar TicTacToe.jar ^
         --main-class com.company.Main ^
         --type exe ^
         --dest "C:\Users\YourName\Desktop\" ^
         --app-version 1.0
```

**Step 2 — Double-click `build-exe.bat` to run it**

**Step 3 — Find `TicTacToe-1.0.exe` on your Desktop:**
- Double-click to install like a normal Windows program
- Launch from Start Menu ✅

> ⚠️ Requires Java 17+ installed on the **developer's** machine to build

---

## 🐧 Linux

### Method 1 — JAR file

**Step 1 — Build JAR in IntelliJ** (same as Mac above)

**Step 2 — Open Terminal:**
```bash
java -jar /path/to/TicTacToe.jar
```

---

### Method 2 — DEB package (Linux App, no Java needed)

**Step 1 — Create a build script:**

Create a file called `build-deb.sh` in your project:
```bash
#!/bin/bash
jpackage --input /path/to/out/artifacts/TicTacToe_jar/ \
         --name TicTacToe \
         --main-jar TicTacToe.jar \
         --main-class com.company.Main \
         --type deb \
         --dest ~/Desktop/ \
         --app-version 1.0
```

**Step 2 — Make it executable:**
```bash
chmod +x build-deb.sh
```

**Step 3 — Run the script:**
```bash
./build-deb.sh
```

**Step 4 — Install the `.deb` file:**
```bash
sudo dpkg -i TicTacToe-1.0.deb
```
✅ App is now installed system-wide

---

## 📊 Platform Comparison

| Feature | 🍎 macOS | 🪟 Windows | 🐧 Linux |
|---------|---------|-----------|---------|
| JAR works | ✅ | ✅ | ✅ |
| Native package | `.dmg` | `.exe` | `.deb` |
| Build script | `.sh` | `.bat` | `.sh` |
| No Java needed | ✅ DMG | ✅ EXE | ✅ DEB |
| jpackage built-in | ✅ Java 17+ | ✅ Java 17+ | ✅ Java 17+ |

---

### Eingabe-Referenz

```
Numpad-Layout:
  7 | 8 | 9   →   top
  4 | 5 | 6   →   middle
  1 | 2 | 3   →   bottom

Menu input:   numbers shown on screen
Play again:   j (Yes) / n (No)
```

---

## 👨‍💻 Entwickler

| | |
|--|--|
| **Name** | Bashar Salmo |
| **Lehrer** | G. Jarz |
| **Institution** | BFI-Leoben |
| **Jahr** | 2026 |

---

<div align="center">

*Entwickelt als Schulprojekt im Rahmen des Faches Applikationsentwicklung — BFI-Leoben 2026*

</div>