import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.ArrayList;
import java.util.List;

public class BuchDAO {
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public BuchDAO() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("Buchverwaltungssystem");
        collection = database.getCollection("buecher");
    }

    public void buchSpeichern(Buch buch) {

        /**
         Speichert ein Buch in der Datenbank. Das übergebene Buchobjekt wird in ein Dokument umgewandelt und in
         der Datenbank eingefügt. Dabei werden die Eigenschaften des Buches (Titel, Autor, Verlag, Erscheinungsjahr,
         ISBN) in das Dokument übertragen.
         */

        Document buchDocument = new Document();
        buchDocument.append("titel", buch.getTitel());
        buchDocument.append("autor", buch.getAutor());
        buchDocument.append("verlag", buch.getVerlag());
        buchDocument.append("erscheinungsjahr", buch.getErscheinungsjahr());
        buchDocument.append("isbn", buch.getIsbn());

        collection.insertOne(buchDocument);
    }

    public void buchLoeschen(String titel) {
        /**
         Löscht ein Buch aus der Datenbank anhand des Titels.
         Das Buch mit dem übergebenen Titel wird aus der Datenbank entfernt.
         */

        Document filter = new Document("titel", titel);
        collection.deleteOne(filter);
    }

    public List<Buch> alleBuecherAbrufen() {

        /**
         Ruft alle Bücher aus der Datenbank ab.
         Alle vorhandenen Bücher in der Datenbank werden abgerufen und als Liste von Buch-Objekten zurückgegeben.

         @return Eine Liste aller Bücher in der Datenbank.
         */

        List<Buch> buecher = new ArrayList<>();
        FindIterable<Document> documents = collection.find();

        for (Document document : documents) {
            Buch buch = new Buch(
                    document.getString("titel"),
                    document.getString("autor"),
                    document.getString("verlag"),
                    document.getString("erscheinungsjahr"),
                    document.getString("isbn")
            );
            buecher.add(buch);
        }

        return buecher;
    }

    public List<Buch> buchSuchen(String suchbegriff) {

        /**
         Sucht nach Büchern anhand eines Suchbegriffs.
         Es wird nach Büchern gesucht, deren Titel den angegebenen Suchbegriff enthalten.

         @param suchbegriff: Der Suchbegriff, nach dem gesucht werden soll.
         @return Eine Liste der gefundenen Bücher, die den Suchbegriff enthalten.
         */

        List<Buch> buecher = new ArrayList<>();
        Bson filter = Filters.regex("titel", suchbegriff);
        FindIterable<Document> documents = collection.find(filter);

        for (Document document : documents) {
            Buch buch = new Buch(
                    document.getString("titel"),
                    document.getString("autor"),
                    document.getString("verlag"),
                    document.getString("erscheinungsjahr"),
                    document.getString("isbn")
            );
            buecher.add(buch);
        }

        return buecher;
    }
}
