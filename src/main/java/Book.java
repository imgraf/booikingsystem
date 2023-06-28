public class Book {

    // Variable deklarieren
    private String title;
    private String author;
    private String publisher;
    private String year_of_publication;
    private String isbn;

    // Konstruktor erstellen
    public Book(String title, String author, String publisher, String year_of_publication, String isbn){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year_of_publication = year_of_publication;
        this.isbn = isbn;
    }

    // Getter- und Setter-Methoden generieren

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(String year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
