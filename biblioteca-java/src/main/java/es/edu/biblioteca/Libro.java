package es.edu.biblioteca;
import java.util.Objects;
/** Representa un libro identificado por su ISBN.
 * @param isbn identificador unico del libro
 * @param titulo titulo del libro
 * @param autor autor o autora
 */
public record Libro(String isbn, String titulo, String autor) {
    /** Crea un libro tras validar sus campos obligatorios.
     * @param isbn identificador unico
     * @param titulo titulo del libro
     * @param autor autor o autora
     */
    public Libro {
        isbn = validar(isbn, "ISBN");
        titulo = validar(titulo, "titulo");
        autor = validar(autor, "autor");
    }
    private static String validar(String valor, String campo) {
        Objects.requireNonNull(valor, "El " + campo + " no puede ser null");
        if (valor.isBlank()) throw new IllegalArgumentException("El " + campo + " no puede estar vacio");
        return valor.trim();
    }
}
