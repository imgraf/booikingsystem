import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuchTest {
    @Test
    public void testGetTitel() {
        Buch buch = new Buch("Harry Potter", "J.K. Rowling", "Bloomsbury", "1997", "9780747532699");
        Assertions.assertEquals("Harry Potter", buch.getTitel());
    }

    @Test
    public void testGetAutor() {
        Buch buch = new Buch("Harry Potter", "J.K. Rowling", "Bloomsbury", "1997", "9780747532699");
        Assertions.assertEquals("J.K. Rowling", buch.getAutor());
    }

    @Test
    public void testGetVerlag() {
        Buch buch = new Buch("Harry Potter", "J.K. Rowling", "Bloomsbury", "1997", "9780747532699");
        Assertions.assertEquals("Bloomsbury", buch.getVerlag());
    }

    @Test
    public void testGetErscheinungsjahr() {
        Buch buch = new Buch("Harry Potter", "J.K. Rowling", "Bloomsbury", "1997", "9780747532699");
        Assertions.assertEquals("1997", buch.getErscheinungsjahr());
    }

    @Test
    public void testGetIsbn() {
        Buch buch = new Buch("Harry Potter", "J.K. Rowling", "Bloomsbury", "1997", "9780747532699");
        Assertions.assertEquals("9780747532699", buch.getIsbn());
    }
}
