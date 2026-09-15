package modelo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private int id;
    private String nombre;
    private int telefono;
    private String correo;
    private boolean prestado;

    private static List<Cliente> listaClientes = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(int id, String nombre, int telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public static void crearCliente(Cliente nuevoCliente) {
        for (Cliente c : listaClientes) {
            if (c.getId() == nuevoCliente.getId()) {
                System.out.println("El cliente con id " + nuevoCliente.getId() + " ya existe.");
                return;
            }
        }
        listaClientes.add(nuevoCliente);
        System.out.println("Cliente agregado correctamente.");
    }

    public static List<Cliente> listarClientes() {
        return listaClientes;
    }

    public static Cliente buscarCliente(int id) {
        for (Cliente c : listaClientes) {
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
        listaClientes.remove(c);
        return true;
    }

    public static void mostrarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : listaClientes) {
                System.out.println("ID: " + c.getId() + " | Nombre: " + c.getNombre()
                        + " | Telefono: " + c.getTelefono() + " | Correo: " + c.getCorreo());
            }        }        } }