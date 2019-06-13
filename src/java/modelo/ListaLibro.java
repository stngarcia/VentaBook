package modelo;

/**
 * @author asathor
 */
public class ListaLibro {

    private Libro libro;
    private short cantidad;
    private long total;

    public ListaLibro() {
        this.libro = new Libro();
        this.cantidad = 0;
        this.total = 0;
    }


    public Libro getLibro() {
        return libro;
    }


    public void setLibro(Libro libro) {
        this.libro = libro;
    }


    public short getCantidad() {
        return cantidad;
    }


    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }


    public long getTotal() {
        if (this.libro == null) {
            this.total = 0;
        } else {
            this.total = (this.libro.getPrecioLibro() * this.cantidad);
        }
        return total;
    }


    public void setTotal(long total) {
        this.total = total;
    }


}
