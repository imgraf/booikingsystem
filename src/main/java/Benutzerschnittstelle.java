import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Benutzerschnittstelle {
    private static BuchDAO buchDAO;
    private static Scanner scanner;

    public static void main(String[] args){
        // Setze den Log-Level auf WARN
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);

        buchDAO = new BuchDAO();
        scanner = new Scanner(System.in);

        boolean weiter = true;

        while(weiter) {
            System.out.println("\n===== Buchverwaltung =====");
            System.out.println("1. Buch hinzufügen");
            System.out.println("2. Buch suchen");
            System.out.println("3. Alle Bücher anzeigen");
            System.out.println("4. Buch entfernen");
            System.out.println("5. Beenden");
            System.out.println("==========================");
            System.out.print("Ihre Option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> buchHinzufuegen();
                case 2 -> buchSuchen();
                case 3 -> alleBuecherAnzeigen();
                case 4 -> buchEntfernen();
                case 5 -> weiter = false;
                default -> {
                    System.out.println("Ungültige Option. Bitte wählen Sie erneut.");
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            }
        }
        scanner.close();
    }

    public static void buchHinzufuegen(){

        /**
         Fügt ein neues Buch hinzu, indem der Benutzer nach den erforderlichen Informationen gefragt wird.
         Die Funktion fordert den Benutzer auf, den Titel, Autor, Verlag, Erscheinungsjahr und die ISBN des Buches einzugeben.
         Es wird überprüft, ob alle erforderlichen Informationen eingegeben wurden. Wenn Informationen fehlen,
         wird der Benutzer erneut aufgefordert, die fehlenden Daten einzugeben.
         Das Buch wird dann mit den eingegebenen Informationen erstellt und in der Datenbank gespeichert.
         Am Ende wird eine Erfolgsmeldung angezeigt.
        */

        System.out.println("===== Buch hinzufügen =====");
        String titel = "";
        String autor = "";
        String verlag = "";
        String erscheinungsjahr = "";
        String isbn = "";


        while (titel.isEmpty() || autor.isEmpty() || verlag.isEmpty() || erscheinungsjahr.isEmpty() || isbn.isEmpty()) {
            System.out.print("Titel: ");
            titel = scanner.nextLine();

            System.out.print("Autor: ");
            autor = scanner.nextLine();

            System.out.print("Verlag: ");
            verlag = scanner.nextLine();

            System.out.print("Erscheinungsjahr: ");
            erscheinungsjahr = scanner.nextLine();

            System.out.print("ISBN: ");
            isbn = scanner.nextLine();

            if (titel.isEmpty() || autor.isEmpty() || verlag.isEmpty() || erscheinungsjahr.isEmpty() || isbn.isEmpty()) {
                System.out.println("Fehlende Informationen. Buch konnte nicht hinzugefügt werden.");
            }
        }

        Buch buch = new Buch(titel, autor, verlag, erscheinungsjahr, isbn);
        buchDAO.buchSpeichern(buch);
        System.out.println("Buch wurde erfolgreich hinzugefügt.");
    }

    public static void buchSuchen(){

        /**
         Sucht nach Büchern basierend auf einem angegebenen Suchbegriff. Der Benutzer wird aufgefordert,
         einen Suchbegriff einzugeben. Anschließend werden die Bücher in der Datenbank nach dem Suchbegriff durchsucht
         und die entsprechenden Suchergebnisse angezeigt. Für jedes gefundene Buch werden der Titel, Autor, Verlag,
         Erscheinungsjahr und die ISBN ausgegeben.
         */

        System.out.println("===== Buch suchen =====");
        System.out.print("Geben Sie den Suchbegriff ein: ");
        String suchbegriff = scanner.nextLine();

        if (suchbegriff.isEmpty()) {
            System.out.println("Kein Suchbegriff eingegeben. Die Suche wird abgebrochen.");
            return; // Die Methode wird hier beendet, da kein Suchbegriff vorhanden ist.
        }

        System.out.println("Suchergebnisse:");

        for (Buch buch: buchDAO.buchSuchen(suchbegriff)) {
            System.out.println("--------------------------");
            System.out.println("Titel: " + buch.getTitel());
            System.out.println("Autor: " + buch.getAutor());
            System.out.println("Verlag: " + buch.getVerlag());
            System.out.println("Erscheinungsjahr: " + buch.getErscheinungsjahr());
            System.out.println("ISBN: " + buch.getIsbn());
            System.out.println("--------------------------");
        }
    }

    public static void alleBuecherAnzeigen() {

        /**
         Zeigt alle Bücher in der Datenbank an. Ruft alle Bücher aus der Datenbank ab und gibt sie nacheinander aus.
         Für jedes Buch werden der Titel, Autor, Verlag, Erscheinungsjahr und die ISBN angezeigt.
         */

        System.out.println("\n===== Alle Bücher anzeigen =====");
        List<Buch> buecher = buchDAO.alleBuecherAbrufen();

        for (Buch buch:buecher) {
            System.out.println("--------------------------");
            System.out.println("Titel: " + buch.getTitel());
            System.out.println("Autor: " + buch.getAutor());
            System.out.println("Verlag: " + buch.getVerlag());
            System.out.println("Erscheinungsjahr: " + buch.getErscheinungsjahr());
            System.out.println("ISBN: " + buch.getIsbn());
            System.out.println("--------------------------");
        }
    }

    public static void buchEntfernen() {

        /**
         Entfernt ein Buch aus der Datenbank.
         Der Benutzer wird aufgefordert, den Titel des zu entfernenden Buches einzugeben.
         Anhand des Titels wird das Buch in der Datenbank gesucht und entfernt.
         Wenn das Buch gefunden und erfolgreich entfernt wurde, wird eine Bestätigung ausgegeben.
         Andernfalls wird eine Fehlermeldung angezeigt, dass das Buch nicht gefunden wurde.
         */

        System.out.println("===== Buch entfernen =====");
        System.out.print("Geben Sie den Titel des Buches ein: ");
        String titel = scanner.nextLine();

        if (titel.isEmpty()) {
            System.out.println(" - Kein Titel eingegeben. Die Suche wird abgebrochen.");
            return; // Die Methode wird hier beendet, da kein Suchbegriff vorhanden ist.
        }


        List<Buch> suchergebnisse = buchDAO.buchSuchen(titel);

        if(!suchergebnisse.isEmpty()) {
            Buch buch = suchergebnisse.get(0);
            buchDAO.buchLoeschen(buch.getTitel());
            System.out.println("Buch erfolgreich entfernt: " + buch.getTitel());
        }else{
            System.out.println("Buch nicht gefunden.");
        }
    }
}
