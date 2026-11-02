package es.edu.biblioteca;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
/** Gestiona un catalogo de libros y sus prestamos en memoria. */
public final class Biblioteca {
    private final Map<String, Libro> catalogo = new LinkedHashMap<>();
    private final Map<String, Boolean> disponibles = new LinkedHashMap<>();

    /** Crea un catalogo vacio en memoria. */
    public Biblioteca() {}

    /** Anade un libro como disponible.
     * @param libro libro que se registra
     * @throws IllegalArgumentException si ya existe su ISBN
     * @throws NullPointerException si libro es null
     */
    public void agregar(Libro libro) {
        if (libro == null) throw new NullPointerException("El libro no puede ser null");
        if (catalogo.containsKey(libro.isbn())) throw new IllegalArgumentException("Ya existe el ISBN " + libro.isbn());
        catalogo.put(libro.isbn(), libro);
        disponibles.put(libro.isbn(), true);
    }

    /** Busca un libro por ISBN.
     * @param isbn identificador que se busca
     * @return Optional con el libro o vacio si no se encuentra
     */
    public Optional<Libro> buscar(String isbn) { return Optional.ofNullable(catalogo.get(isbn)); }

    /** Devuelve una instantanea inmodificable del catalogo.
     * @return libros en orden de alta
     */
    public List<Libro> listar() { return List.copyOf(catalogo.values()); }

    /** Presta un libro cuando existe y esta disponible.
     * @param isbn identificador del libro
     * @return true si se completo el prestamo
     */
    public boolean prestar(String isbn) {
        if (!catalogo.containsKey(isbn) || !disponibles.get(isbn)) return false;
        disponibles.put(isbn, false);
        return true;
    }

    /** Registra la devolucion de un libro prestado.
     * @param isbn identificador del libro
     * @return true si se completo la devolucion
     */
    public boolean devolver(String isbn) {
        if (!catalogo.containsKey(isbn) || disponibles.get(isbn)) return false;
        disponibles.put(isbn, true);
        return true;
    }

    /** Comprueba si un libro esta disponible.
     * @param isbn identificador del libro
     * @return true si existe y se puede prestar
     */
    public boolean estaDisponible(String isbn) { return Boolean.TRUE.equals(disponibles.get(isbn)); }
}
