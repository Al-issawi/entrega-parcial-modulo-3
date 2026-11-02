package es.edu.biblioteca;
import java.util.Objects;
/** A book identified by its ISBN. */
public record Libro(String isbn, String titulo, String autor) {
    /** Creates a book after validating its required fields.
     * @param isbn unique identifier
     * @param titulo book title
     * @param autor author
     */
    public Libro {
        isbn = validar(isbn, "ISBN");
        titulo = validar(titulo, "title");
        autor = validar(autor, "author");
    }
    private static String validar(String value, String field) {
        Objects.requireNonNull(value, field + " cannot be null");
        if (value.isBlank()) throw new IllegalArgumentException(field + " cannot be empty");
        return value.trim();
    }
}
