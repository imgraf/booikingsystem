import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public BookDAO() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("Buchverwaltungssystem");
        collection = database.getCollection("buecher");
    }

    public void save_book(Book book) {

        /**
         Store a book in the database. The given book object is converted into a document and inserted into the database.
         The properties of the book (title, author, publisher, publication year, ISBN) are transferred to the document.
         */

        Document bookDocument = new Document();
        bookDocument.append("title", book.getTitle());
        bookDocument.append("author", book.getAuthor());
        bookDocument.append("publisher", book.getPublisher());
        bookDocument.append("year_of_publication", book.getYear_of_publication());
        bookDocument.append("isbn", book.getIsbn());

        collection.insertOne(bookDocument);
    }

    public void delete_book(String title) {
        /**
         Delete a book from the database based on the title.
         The book with the given title is removed from the database.
         */

        Document filter = new Document("title", title);
        collection.deleteOne(filter);
    }

    public List<Book> view_all_books() {

        /**
         Retrieve all books from the database.
         All existing books in the database are retrieved and returned as a list of book objects.

         @return A list of all books in the database.
         */

        List<Book> books = new ArrayList<>();
        FindIterable<Document> documents = collection.find();

        for (Document document : documents) {
            Book book = new Book(
                    document.getString("title"),
                    document.getString("author"),
                    document.getString("publisher"),
                    document.getString("year_of_publication"),
                    document.getString("isbn")
            );
            books.add(book);
        }

        return books;
    }

    public List<Book> search_book(String searcb_term) {

        /**
         Searches for books based on a search term.
         It looks for books whose titles contain the specified search term.

         @param search term: The term to search for.
         @return A list of found books that contain the search term.
         */

        List<Book> books = new ArrayList<>();
        Bson filter = Filters.regex("title", searcb_term);
        FindIterable<Document> documents = collection.find(filter);

        for (Document document : documents) {
            Book book = new Book(
                    document.getString("title"),
                    document.getString("author"),
                    document.getString("publisher"),
                    document.getString("year_of_publication"),
                    document.getString("isbn")
            );
            books.add(book);
        }

        return books;
    }
}
