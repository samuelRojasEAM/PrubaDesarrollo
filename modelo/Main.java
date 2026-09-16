package modelo;
import java.util.ArrayList;
import java.util.Scanner;
import


public class Main {

    private static final ControladorLibros controladorLibros = new ControladorLibros();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarLibro();
                    break;
                case 2:
                    listarLibrosDisponibles();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            System.out.println();
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("=== Sistema Biblioteca LibrosYMas ===");
        System.out.println("1. Registrar libro");
        System.out.println("2. Listar libros disponibles");
        System.out.println("0. Salir");
    }

    private static void registrarLibro() {
        System.out.println("--- Registro de nuevo libro ---");

        int id = leerEntero("ID único del libro: ");

        if (controladorLibros.buscarLibro(id) != null) {
            System.out.println("Ya existe un libro con el ID " + id + ". Registro cancelado.");
            return;
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        System.out.print("Editorial: ");
        String editorial = sc.nextLine();

        int anio = leerEntero("Año de publicación: ");

        String categoria = leerCategoria();

        Libro nuevoLibro = new Libro(id, titulo, autor, editorial, anio, categoria, true);
        controladorLibros.agregarLibro(nuevoLibro);
        System.out.println("Libro registrado correctamente: " + titulo);
    }

    private static void listarLibrosDisponibles() {
        ArrayList<Libro> disponibles = controladorLibros.obtenerLibrosDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("No hay libros disponibles en este momento.");
            return;
        }
        System.out.println("=== Libros disponibles ===");
        for (Libro l : disponibles) {
            System.out.println("[" + l.getId() + "] " + l.getTitulo() + " - " + l.getAutor()
                    + " (" + l.getAnioPublicacion() + ") | " + l.getCategoria());
        }
    }

    private static String leerCategoria() {
        String[] categorias = {"Literatura", "Ciencia", "Historia", "Tecnologia"};
        System.out.println("Categoría:");
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i]);
        }
        int op = leerEntero("Seleccione una opción: ");
        if (op >= 1 && op <= categorias.length) {
            return categorias[op - 1];
        }
        System.out.println("Opción inválida, se asigna Literatura por defecto.");
        return "Literatura";
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine(); 
        return valor;
    }
}
