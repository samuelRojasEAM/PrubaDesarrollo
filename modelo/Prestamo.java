package modelo;

import java.time.LocalDate;

public class Prestamo {
    private Libro libro;
    //private Cliente cliente;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro) {
        this.libro = libro;
        //this.cliente = cliente;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public Libro getLibro() {
        return libro;
    }

    //public Cliente getCliente() {
    //    return cliente;
    //}

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

    
}
