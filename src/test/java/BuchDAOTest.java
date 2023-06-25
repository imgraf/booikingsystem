import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuchDAOTest {

    private BuchDAO buchDAO;

    @BeforeEach
    public void setup() {
        // Setze den Log-Level auf WARN
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);

        buchDAO = new BuchDAO();
    }

    @Test
    public void testBuchHinzufuegen() {
        // Create a Buch object with test data
        Buch buch = new Buch("Titel", "Autor", "Verlag", "2022", "ISBN");

        // Execute the method
        buchDAO.buchSpeichern(buch);

        // Get all books from the DAO
        List<Buch> buecher = buchDAO.alleBuecherAbrufen();

        Assertions.assertEquals("Titel", buch.getTitel()); // Check the title
        Assertions.assertEquals("Autor", buch.getAutor()); // Check the author
        Assertions.assertEquals("Verlag", buch.getVerlag()); // Check the publisher
        Assertions.assertEquals("2022", buch.getErscheinungsjahr()); // Check the publication year
        Assertions.assertEquals("ISBN", buch.getIsbn()); // Check the ISBN
    }

    @Test
    public void testBuchEntfernen() {
        // Create a Buch object with test data
        Buch buch = new Buch("Harry Potter", "J.K. Rowling", "Carlsen", "1997", "9783551551675");

        // Save the book in the DAO
        buchDAO.buchSpeichern(buch);

        // Get the initial number of books in the DAO
        int initialAnzahl = buchDAO.alleBuecherAbrufen().size();

        // Execute the method to remove the book
        buchDAO.buchLoeschen(buch.getTitel());

        // Get the final number of books in the DAO
        int finalAnzahl = buchDAO.alleBuecherAbrufen().size();

        // Assertions
        Assertions.assertEquals(initialAnzahl - 1, finalAnzahl); // Check if the number of books is reduced by 1
    }

    @Test
    public void testBuchSuchen() {
        // Create some Buch objects with test data
        Buch buch1 = new Buch("Harry Potter", "J.K. Rowling", "Carlsen", "1997", "9783551551675");
        Buch buch2 = new Buch("Der Herr der Ringe", "J.R.R. Tolkien", "Klett-Cotta", "1954", "9783608939633");
        Buch buch3 = new Buch("Game of Thrones", "George R.R. Martin", "Bantam Spectra", "1996", "9780553103540");

        // Save the books in the DAO
        buchDAO.buchSpeichern(buch1);
        buchDAO.buchSpeichern(buch2);
        buchDAO.buchSpeichern(buch3);

        // Execute the method to search for books with the keyword "Harry"
        List<Buch> suchergebnisse = buchDAO.buchSuchen("Harry");

        // Assertions
        Assertions.assertEquals("Harry Potter", suchergebnisse.get(0).getTitel()); // Check if the book title matches the search keyword
    }
}
