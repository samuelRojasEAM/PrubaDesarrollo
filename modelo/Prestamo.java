package modelo;

import java.time.LocalDate;

public class Prestamo {
    private int id;
    private Libro libro;
    private Cliente cliente;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(int id, Libro libro, Cliente cliente) {
        this.id = id;
        this.libro = libro;
        this.cliente = cliente;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public int getId() {
        return id;
    }

    public Libro getLibro() {
        return libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean estaActivo() {
        return fechaDevolucion == null;
    }

    public void registrarDevolucion() {
        fechaDevolucion = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Prestamo #" + id + " | Libro: " + libro.getTitulo()
                + " | Cliente: " + cliente.getNombre()
                + " | Fecha préstamo: " + fechaPrestamo
                + " | Fecha devolución: " + (fechaDevolucion == null ? "Pendiente" : fechaDevolucion);
    }
}