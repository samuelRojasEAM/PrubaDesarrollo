import java.util.ArrayList;
import modelo.Libro;

public class ControladorLibros {
    private ArrayList<Libro> libros;

    public ControladorLibros() {
        this.libros = new ArrayList<>();
    }

    //Crud:
    public void agregarLibro(Libro libro) {
        if (buscarLibro(libro.getId()) != null) {
            System.out.println("El libro con ID " + libro.getId() + " ya existe. No se puede agregar.");
            return;
        }
        libros.add(libro);
    }

    public void actualizarLibro(int id, String titulo, String autor, String editorial, int anioPublicacion, String categoria, boolean disponible) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                libro.setTitulo(titulo);
                libro.setAutor(autor);
                libro.setEditorial(editorial);
                libro.setAnioPublicacion(anioPublicacion);
                libro.setCategoria(categoria);
                libro.setDisponible(disponible);
                break;
            }
        }
    }

    public void eliminarLibro(int id) {
        libros.removeIf(libro -> libro.getId() == id);
    }

    public Libro buscarLibro(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null; 
    }

    //Metodos pedidos:
    public void mostarInformacionLibro(int id) {
        Libro libro = buscarLibro(id);
        if (libro != null) {
            System.out.println("ID: " + libro.getId());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Editorial: " + libro.getEditorial());
            System.out.println("Año de Publicación: " + libro.getAnioPublicacion());
            System.out.println("Categoría: " + libro.getCategoria());
            System.out.println("Disponible: " + (libro.isDisponible() ? "Sí" : "No"));
        } else {
            System.out.println("El libro con ID " + id + " no existe.");
        }
    }

    public void cambiarEstadoLibro(int id, boolean nuevoEstado) {
        Libro libro = buscarLibro(id);
        if (libro != null) {
            libro.setDisponible(nuevoEstado);
            System.out.println("El estado del libro con ID " + id + " ha sido cambiado a " + (nuevoEstado ? "disponible" : "no disponible") + ".");
        } else {
            System.out.println("El libro con ID " + id + " no existe.");
        }
    }

    //Otros metodos:
    public ArrayList<Libro> obtenerTodosLosLibros() {
        return new ArrayList<>(libros); 
    }
    public ArrayList<Libro> obtenerLibrosDisponibles() {
        ArrayList<Libro> librosDisponibles = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                librosDisponibles.add(libro);
            }
        }
        return librosDisponibles;
    }
}