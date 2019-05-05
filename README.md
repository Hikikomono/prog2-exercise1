# Prog2-Exercise1

***Programmieren 2 Übung 1***

**Ziel der Übung**
* Einsetzen von Design Patterns 

**Hintergrund**

Eines der ältesten und bekanntesten Simulationsspiele von primitivem Leben (Wachstum von Zellkulturen) ist das "Game of Life", 
das von dem Mathematiker John H. Conway [Con71] vorgeschlagen wurde. 

Game of Life wird auf einem rechteckigen Spielfeld mit einer festen Anzahl Zellen gespielt. Jedes Element des Spielfelds 
enthält eine Zelle, die entweder tot ist oder lebt. Der Anfangszu-stand des Spielfelds wird per Zufallszahlengenerator ermittelt 
oder vom Benutzer vorgegeben. Ein Folgezustand wird für die komplette Population auf Basis der folgenden Regeln bestimmt: 
* Hat eine tote Zelle exakt drei lebende Nachbarn (von acht möglichen), so wird sie in der nächsten Generation lebendig sein. Andernfalls bleibt sie tot. 
* Hat eine lebende Zelle weniger als zwei oder mehr als drei lebende Nachbarn, so wird sie in der nächsten Generation tot sein, andernfalls bleibt sie lebendig. (Im ersten Fall stirbt sie an Vereinsamung, im zweiten an Überbevölkerung). 

**Hinweise**
*  Analysieren Sie gegebene objektorientierte Struktur (CellGrid, Cell)
*  Das Design ist so aufgebaut sein, dass es der Größe des Spielfeldes angepasst wer-den kann.
*  Das Spielfeld kann per File oder per Zufall initialisiert werden.
*  Das Gerüst der Methoden steht zur Verfügung
*  Laden Sie eine Struktur aus einem Textfile um das Spielfeld zu initialisieren 
(X = Zelle lebt, O= Zelle ist tot)
*  Ein Testfile befindet sich im Unterverzeichnis fields, weitere können angelegt werden.

Die GameOfLifeGUI Klasse bietet das Grundgerüst für das Spielfeld. Die Logik und die Events müssen ergänzt werden.

GUI Funktionen:
*  Clear: Löscht das Spielfeld
*  Next: Berechnet die nächste Generation und zeigt diese an (manueller Mode)
*  Start: Berechnet Generation automatisch 
*  Speed: Geschwindigkeit der Berechnung
*  Rows und Cols: Definiert die Dimension des Spielfeldes und kann mit Resize gesetzt werden
*  File
    *  Load: lädt ein Spielfeld
    *  Save: speichert ein Spielfeld
*  Projekt kann runtergeladen oder geforkt werden oder in die die kopiert.
*  Projekt steht auf fh gitlab zur Verfügung und ist als maven Projekt aufgesetzt (mvn compile)
*  Im Code sind die Stellen, wo Code programmiert werden soll mit ToDo markiert.

**Aufgaben**
1.  Die Controller Klasse (GameOfLife) ist als Singleton Pattern umzubauen.
2.  Das Graphical User Interface (GameOfLifeGUI.java) mit dem Logik Schicht (Cell-Grid.java) mittels Observer Pattern verbinden.
3.  Die Darstellung der Zellen erfolgt über die Klasse JButton. Finden Sie eine Lösung um den Observer Pattern zu implementieren. Das Pattern soll implementiert werden und nicht Java Library Klassen verwenden.
4.  Erkennung von stabilen oder zyklischen Zellkulturen. Finden Sie ein Pattern für diese Aufgabe.
