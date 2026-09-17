
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Libro;
import modelo.Prestamo;


public class ControladorPrestamos {
    private static ArrayList<Prestamo> prestamos = new ArrayList<>();
    private static int contadorId = 1;

    // Marca cuando un cliente recibe el préstamo de un libro
    public static boolean realizarPrestamo(Cliente cliente, Libro libro) {
        if (cliente == null || libro == null) {
            System.out.println("Cliente o libro inválido.");
            return false;
        }
        if (!libro.isDisponible()) {
            System.out.println("El libro '" + libro.getTitulo() + "' no está disponible.");
            return false;
        }
        if (cliente.isPrestado()) {
            System.out.println("El cliente " + cliente.getNombre() + " ya tiene un préstamo activo.");
            return false;
        }

        Prestamo nuevoPrestamo = new Prestamo(contadorId++, libro, cliente);
        prestamos.add(nuevoPrestamo);

        libro.setDisponible(false);
        cliente.setPrestado(true);

        System.out.println("Préstamo registrado: " + cliente.getNombre() + " recibió '" + libro.getTitulo() + "'.");
        return true;
    }

    // Registra la devolución del libro
    public static boolean registrarDevolucion(int idPrestamo) {
        Prestamo prestamo = buscarPrestamo(idPrestamo);
        if (prestamo == null) {
            System.out.println("No existe un préstamo con ID " + idPrestamo);
            return false;
        }
        if (!prestamo.estaActivo()) {
            System.out.println("Ese préstamo ya fue devuelto.");
            return false;
        }

        prestamo.registrarDevolucion();
        prestamo.getLibro().setDisponible(true);
        prestamo.getCliente().setPrestado(false);

        System.out.println("Devolución registrada: '" + prestamo.getLibro().getTitulo()
                + "' devuelto por " + prestamo.getCliente().getNombre());
        return true;
    }

    // Alternativa: devolver buscando por libro (útil si no manejas el id de préstamo en la UI)
    public static boolean registrarDevolucionPorLibro(int idLibro) {
        for (Prestamo p : prestamos) {
            if (p.getLibro().getId() == idLibro && p.estaActivo()) {
                return registrarDevolucion(p.getId());
            }
        }
        System.out.println("No hay un préstamo activo para el libro con ID " + idLibro);
        return false;
    }

    public static Prestamo buscarPrestamo(int id) {
        for (Prestamo p : prestamos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Muestra la info del cliente junto con su préstamo activo (si tiene)
    public static void mostrarInfoClienteConPrestamos(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.println(cliente);
        boolean tienePrestamos = false;
        for (Prestamo p : prestamos) {
            if (p.getCliente().getId() == cliente.getId()) {
                System.out.println("  -> " + p);
                tienePrestamos = true;
            }
        }
        if (!tienePrestamos) {
            System.out.println("  -> Sin historial de préstamos.");
        }
    }

    public static List<Prestamo> listarPrestamosActivos() {
        List<Prestamo> activos = new ArrayList<>();
        for (Prestamo p : prestamos) {
            if (p.estaActivo()) {
                activos.add(p);
            }
        }
        return activos;
    }

    public static List<Prestamo> listarTodosLosPrestamos() {
        return new ArrayList<>(prestamos);
    }
}