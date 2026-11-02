package es.edu.biblioteca;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
/** Manages an in-memory book catalog and its loans. */
public final class Biblioteca {
    private final Map<String, Libro> catalogo = new LinkedHashMap<>();
    private final Map<String, Boolean> disponibles = new LinkedHashMap<>();
    /** Adds a book as available.
     * @param libro book to add
     * @throws IllegalArgumentException if its ISBN already exists
     */
    public void agregar(Libro libro) {
        if (libro == null) throw new NullPointerException("libro cannot be null");
        if (catalogo.containsKey(libro.isbn())) throw new IllegalArgumentException("ISBN already exists: " + libro.isbn());
        catalogo.put(libro.isbn(), libro); disponibles.put(libro.isbn(), true);
    }
    /** Looks up a book.
     * @param isbn identifier
     * @return optional book result
     */
    public Optional<Libro> buscar(String isbn) { return Optional.ofNullable(catalogo.get(isbn)); }
    /** Returns an immutable snapshot of the catalog.
     * @return books in insertion order
     */
    public List<Libro> listar() { return List.copyOf(catalogo.values()); }
    /** Loans an available book.
     * @param isbn identifier
     * @return true if the loan succeeded
     */
    public boolean prestar(String isbn) {
        if (!catalogo.containsKey(isbn) || !disponibles.get(isbn)) return false;
        disponibles.put(isbn, false); return true;
    }
    /** Returns a loaned book.
     * @param isbn identifier
     * @return true if the return succeeded
     */
    public boolean devolver(String isbn) {
        if (!catalogo.containsKey(isbn) || disponibles.get(isbn)) return false;
        disponibles.put(isbn, true); return true;
    }
    /** Checks availability.
     * @param isbn identifier
     * @return true if the book exists and is available
     */
    public boolean estaDisponible(String isbn) { return Boolean.TRUE.equals(disponibles.get(isbn)); }
}
