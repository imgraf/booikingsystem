import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDAOTest {

    private BookDAO bookDAO;

    @BeforeEach
    public void setup() {
        // Setze den Log-Level auf WARN
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);

        bookDAO = new BookDAO();
    }

    @Test
    public void testBuchHinzufuegen() {
        // Create a Buch object with test data
        Book buch = new Book("Titel", "Autor", "Verlag", "2022", "ISBN");

        // Execute the method
        bookDAO.save_book(buch);

        // Get all books from the DAO
        List<Book> buecher = bookDAO.view_all_books();

        Assertions.assertEquals("Titel", buch.getTitle()); // Check the title
        Assertions.assertEquals("Autor", buch.getAuthor()); // Check the author
        Assertions.assertEquals("Verlag", buch.getPublisher()); // Check the publisher
        Assertions.assertEquals("2022", buch.getYear_of_publication()); // Check the publication year
        Assertions.assertEquals("ISBN", buch.getIsbn()); // Check the ISBN
    }

    @Test
    public void testBuchEntfernen() {
        // Create a Buch object with test data
        Book buch = new Book("Harry Potter", "J.K. Rowling", "Carlsen", "1997", "9783551551675");

        // Save the book in the DAO
        bookDAO.save_book(buch);

        // Get the initial number of books in the DAO
        int initialAnzahl = bookDAO.view_all_books().size();

        // Execute the method to remove the book
        bookDAO.delete_book(buch.getTitle());

        // Get the final number of books in the DAO
        int finalAnzahl = bookDAO.view_all_books().size();

        // Assertions
        Assertions.assertEquals(initialAnzahl - 1, finalAnzahl); // Check if the number of books is reduced by 1
    }

    @Test
    public void testBuchSuchen() {
        // Create some Buch objects with test data
        Book buch1 = new Book("Harry Potter", "J.K. Rowling", "Carlsen", "1997", "9783551551675");
        Book buch2 = new Book("Der Herr der Ringe", "J.R.R. Tolkien", "Klett-Cotta", "1954", "9783608939633");
        Book buch3 = new Book("Game of Thrones", "George R.R. Martin", "Bantam Spectra", "1996", "9780553103540");

        // Save the books in the DAO
        bookDAO.save_book(buch1);
        bookDAO.save_book(buch2);
        bookDAO.save_book(buch3);

        // Execute the method to search for books with the keyword "Harry"
        List<Book> suchergebnisse = bookDAO.search_book("Harry");

        // Assertions
        Assertions.assertEquals("Harry Potter", suchergebnisse.get(0).getTitle()); // Check if the book title matches the search keyword
    }
}
