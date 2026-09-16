import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class ControladorCliente {
    private static ArrayList<Cliente> clientes = new ArrayList<>(); // se inicializa una sola vez

    public static void crearCliente(Cliente nuevoCliente) {
        for (Cliente c : clientes) {
            if (c.getId() == nuevoCliente.getId()) {
                System.out.println("El cliente con id " + nuevoCliente.getId() + " ya existe.");
                return;
            }
        }
        clientes.add(nuevoCliente);
        System.out.println("Cliente agregado correctamente.");
    }

    public static List<Cliente> listarClientes() {
        return clientes;
    }

    public static Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public static boolean actualizarCliente(int id, String nombre, int telefono, String correo) {
        Cliente c = buscarCliente(id);
        if (c == null) {
            return false;
        }
        c.setNombre(nombre);
        c.setTelefono(telefono);
        c.setCorreo(correo);
        return true;
    }

    public static boolean eliminarCliente(int id) {
        Cliente c = buscarCliente(id);
        if (c == null) {
            return false;
        }
        clientes.remove(c);
        return true;
    }

    // Método pedido: mostrar info de un cliente puntual
    public static void mostrarInformacionCliente(int id) {
        Cliente c = buscarCliente(id);
        if (c != null) {
            System.out.println(c);
        } else {
            System.out.println("El cliente con ID " + id + " no existe.");
        }
    }

    public static void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }
}