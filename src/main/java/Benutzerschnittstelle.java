import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Benutzerschnittstelle {
    private static BookDAO bookDAO;
    private static Scanner scanner;

    public static void main(String[] args){
        // Set log-level to WARN
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);

        bookDAO = new BookDAO();
        scanner = new Scanner(System.in);

        boolean state = true;

        while(state) {
            System.out.println("\n===== Book management =====");
            System.out.println("1. Add book");
            System.out.println("2. Search for book");
            System.out.println("3. Show all books");
            System.out.println("4. Delete book");
            System.out.println("5. Cancel");
            System.out.println("==========================");
            System.out.print("Your Option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addBook();
                case 2 -> searchBook();
                case 3 -> viewAllBooks();
                case 4 -> deleteBook();
                case 5 -> state = false;
                default -> {
                    System.out.println("Wrong option. Please make a choice again.");
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            }
        }
        scanner.close();
    }

    public static void addBook(){

        /**
         Add a new book by prompting the user for the required information.
         The function prompts the user to enter the title, author, publisher, publication year, and ISBN of the book.
         It checks if all the required information has been entered. If any information is missing,
         the user is prompted again to enter the missing data.
         The book is then created with the entered information and stored in the database.
         A success message is displayed at the end.
        */

        System.out.println("===== Buch hinzufügen =====");
        String title = "";
        String author = "";
        String publisher = "";
        String year_of_pulication = "";
        String isbn = "";


        while (title.isEmpty() || author.isEmpty() || publisher.isEmpty() || year_of_pulication.isEmpty() || isbn.isEmpty()) {
            System.out.print("Title: ");
            title = scanner.nextLine();

            System.out.print("Author: ");
            author = scanner.nextLine();

            System.out.print("Publisher: ");
            publisher = scanner.nextLine();

            System.out.print("Year of publication: ");
            year_of_pulication = scanner.nextLine();

            System.out.print("ISBN: ");
            isbn = scanner.nextLine();

            if (title.isEmpty() || author.isEmpty() || publisher.isEmpty() || year_of_pulication.isEmpty() || isbn.isEmpty()) {
                System.out.println("Fehlende Informationen. Buch konnte nicht hinzugefügt werden.");
            }
        }

        Book book = new Book(title, author, publisher, year_of_pulication, isbn);
        bookDAO.save_book(book);
        System.out.println("Book added successfully.");
    }

    public static void searchBook(){

        /**
         Searches for books based on a specified search term. The user is prompted to enter a search term.
         Subsequently, the books in the database are searched for the search term, and the corresponding search results
         are displayed. For each found book, the title, author, publisher, publication year, and ISBN are output.
         */

        System.out.println("===== Search for book =====");
        System.out.print("Please enter search term: ");
        String suchbegriff = scanner.nextLine();

        if (suchbegriff.isEmpty()) {
            System.out.println("No search term entered. Search was canceled.");
            return; // Die Methode wird hier beendet, da kein Suchbegriff vorhanden ist.
        }

        System.out.println("Results:");

        for (Book book: bookDAO.search_book(suchbegriff)) {
            System.out.println("--------------------------");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("Year of publication: " + book.getYear_of_publication());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("--------------------------");
        }
    }

    public static void viewAllBooks() {

        /**
         Display all books in the database. Retrieve all books from the database and display them one by one.
         For each book, the title, author, publisher, publication year, and ISBN are shown.
         */

        System.out.println("\n===== View all books =====");
        List<Book> books = bookDAO.view_all_books();

        for (Book book:books) {
            System.out.println("--------------------------");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("Year of publication: " + book.getYear_of_publication());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("--------------------------");
        }
    }

    public static void deleteBook() {

        /**
         Remove a book from the database.
         The user is prompted to enter the title of the book to be removed.
         Based on the title, the book is searched for in the database and removed.
         If the book is found and successfully removed, a confirmation message is displayed.
         Otherwise, an error message is shown indicating that the book was not found.
         */

        System.out.println("===== Delete book =====");
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();

        if (title.isEmpty()) {
            System.out.println("No title entered. The search was canceled.");
            return; // Die Methode wird hier beendet, da kein Suchbegriff vorhanden ist.
        }


        List<Book> search_results = bookDAO.search_book(title);

        if(!search_results.isEmpty()) {
            Book book = search_results.get(0);
            bookDAO.delete_book(book.getTitle());
            System.out.println("Book deleted successfully: " + book.getTitle());
        }else{
            System.out.println("Book not found.");
        }
    }
}
