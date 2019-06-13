package dto;

import java.io.Serializable;


/**
 * @author asathor
 */
public class DetalleVentaDTO implements Serializable {

    private String idEjemplar;
    private String nombreEjemplar;
    private int precioUnitario;
    private int cantidad;
    private long precioTotal;

    public DetalleVentaDTO() {
    }


    public String getIdEjemplar() {
        return idEjemplar;
    }


    public void setIdEjemplar(String idEjemplar) {
        this.idEjemplar = idEjemplar;
    }


    public String getNombreEjemplar() {
        return nombreEjemplar;
    }


    public void setNombreEjemplar(String nombreEjemplar) {
        this.nombreEjemplar = nombreEjemplar;
    }


    public int getPrecioUnitario() {
        return precioUnitario;
    }


    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public long getPrecioTotal() {
        return precioTotal;
    }


    public void setPrecioTotal(long precioTotal) {
        this.precioTotal = precioTotal;
    }


}
