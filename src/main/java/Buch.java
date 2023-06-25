public class Buch {

    // Variable deklarieren
    private String titel;
    private String autor;
    private String verlag;
    private String erscheinungsjahr;
    private String isbn;

    // Konstruktor erstellen
    public Buch(String titel, String autor, String verlag, String erscheinungsjahr, String isbn){
        this.titel = titel;
        this.autor = autor;
        this.verlag = verlag;
        this.erscheinungsjahr = erscheinungsjahr;
        this.isbn = isbn;
    }

    // Getter- und Setter-Methoden generieren

    public String getTitel() {
        return titel;
    }

    public void setTitle(String title) {
        this.titel = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    public String getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(String erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
