import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuchTest {
    @Test
    public void testGetTitel() {
        Book buch = new Book("Harry Potter", "J.K. Rowling", "Bloomsbury", "1997", "9780747532699");
        Assertions.assertEquals("Harry Potter", buch.getTitle());
    }

    @Test
    public void testGetAutor() {
        Book buch = new Book("Harry Potter", "J.K. Rowling", "Bloomsbury", "1997", "9780747532699");
        Assertions.assertEquals("J.K. Rowling", buch.getAuthor());
    }

    @Test
    public void testGetVerlag() {
        Book buch = new Book("Harry Potter", "J.K. Rowling", "Bloomsbury", "1997", "9780747532699");
        Assertions.assertEquals("Bloomsbury", buch.getPublisher());
    }

    @Test
    public void testGetErscheinungsjahr() {
        Book buch = new Book("Harry Potter", "J.K. Rowling", "Bloomsbury", "1997", "9780747532699");
        Assertions.assertEquals("1997", buch.getYear_of_publication());
    }

    @Test
    public void testGetIsbn() {
        Book buch = new Book("Harry Potter", "J.K. Rowling", "Bloomsbury", "1997", "9780747532699");
        Assertions.assertEquals("9780747532699", buch.getIsbn());
    }
}
