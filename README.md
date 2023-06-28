# Buchverwaltungssystem
Das Buchverwaltungssystem ist eine Java-Anwendung, die entwickelt wurde, um Benutzern die Verwaltung ihrer Buchsammlung zu ermöglichen. Mit diesem Programm können Benutzer Bücher hinzufügen, löschen, anzeigen und nach Büchern suchen. Es basiert auf einer MongoDB-Datenbank, die als Backend für die Speicherung und Abfrage von Buchdaten verwendet wird.

## Funktionalitäten
1. Book hinzufügen: Der Benutzer kann die Informationen zu einem Book eingeben, einschließlich Titel, Autor, Verlag, Erscheinungsjahr und ISBN. Das Programm erfasst diese Daten und erstellt ein neues Buchobjekt, welches dann in der MongoDB-Datenbank gespeichert wird.
2. Book löschen: Wenn ein Benutzer ein Book aus seiner Sammlung entfernen möchte, kann er den Titel des Buches angeben. Das Programm sucht nach dem Book in der Datenbank und löscht es dauerhaft.
3. Alle Bücher anzeigen: Durch Auswahl dieser Option werden alle gespeicherten Bücher aufgelistet und detaillierte Informationen zu jedem Book angezeigt, einschließlich Titel, Autor, Verlag, Erscheinungsjahr und ISBN.
4. Book suchen: Der Benutzer kann nach Büchern anhand eines Suchbegriffs im Titel suchen. Das Programm durchsucht die Datenbank nach Übereinstimmungen und zeigt die entsprechenden Bücher an.

## Voraussetzungen
Damit das Programm ordnungsgemäß ausgeführt werden kann, müssen einige Voraussetzungen erfüllt sein:

1. MongoDB: Stelle sicher, dass MongoDB auf deinem System installiert und ausgeführt wird. Du kannst die offizielle MongoDB-Website besuchen und die Anweisungen befolgen, um MongoDB herunterzuladen und zu installieren.
2. Java Development Kit (JDK): Du benötigst eine installierte JDK-Version, um das Programm auszuführen. Überprüfe, ob Java auf deinem System installiert ist, indem du den Befehl `java -version` im Terminal ausführst. Wenn Java nicht installiert ist, lade die neueste JDK-Version von der offiziellen Oracle-Website herunter und installiere sie.
3. Entwicklungsumgebung (optional): Du kannst eine Java-Entwicklungsumgebung wie Eclipse, IntelliJ IDEA oder NetBeans verwenden, um den Quellcode zu bearbeiten und das Programm auszuführen. Wenn du keine Entwicklungsumgebung verwendest, kannst du den Quellcode mit einem Texteditor bearbeiten und ihn über die Befehlszeile kompilieren und ausführen.

## Programmausführung
Folge diesen Schritten, um das Programm auszuführen:

1. Starte MongoDB: Öffne ein Terminalfenster und starte den MongoDB-Dienst mit dem Befehl mongod. Stelle sicher, dass MongoDB auf dem Standardport (27017) läuft.
2. Öffne ein Terminalfenster oder eine Befehlszeile und navigiere zum Verzeichnis, in dem sich der Programmquellcode befindet.
3. Kompiliere den Quellcode mit dem Befehl `javac *.java`.
4. Führe das Programm mit dem Befehl java Benutzerschnittstelle aus.

Nachdem das Programm gestartet ist, kannst du die verfügbaren Funktionen nutzen, indem du den Anweisungen auf der Benutzeroberfläche folgst.

## Autor
Graf, Raul