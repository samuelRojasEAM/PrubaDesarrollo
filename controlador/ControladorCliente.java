import java.util.ArrayList;
import java.util.List;
import modelo.cliente;

public class ControladorCliente {
 private static ArrayList<cliente> clientes;

    public ControladorCliente() {
        this.clientes = new ArrayList<>();
    }

    public static void crearCliente(cliente nuevoCliente) {
        for (cliente c : clientes) {
            if (c.getId() == nuevoCliente.getId()) {
                System.out.println("El cliente con id " + nuevoCliente.getId() + " ya existe.");
                return;
            }
        }
        clientes.add(nuevoCliente);
        System.out.println("Cliente agregado correctamente.");
    }

    public static List<cliente> listarClientes() {
        return clientes;
    }

    public static cliente buscarCliente(int id) {
        for (cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public static boolean actualizarCliente(int id, String nombre, int telefono, String correo) {
        cliente c = buscarCliente(id);
        if (c == null) {
            return false;
        }
        c.setNombre(nombre);
        c.setTelefono(telefono);
        c.setCorreo(correo);
        return true;
    }

    public static boolean eliminarCliente(int id) {
        cliente c = buscarCliente(id);
        if (c == null) {
            return false;
        }
        clientes.remove(c);
        return true;
    }

    public static void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (cliente c : clientes) {
                System.out.println("ID: " + c.getId() + " | Nombre: " + c.getNombre()
                        + " | Telefono: " + c.getTelefono() + " | Correo: " + c.getCorreo());
            }        }        }

}
