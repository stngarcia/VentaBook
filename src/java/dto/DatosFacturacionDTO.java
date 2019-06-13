package dto;

import java.io.Serializable;


/**
 * @author asathor
 */
public class DatosFacturacionDTO implements Serializable {

    private String razonSocial;
    private String rut;
    private String direccion;
    private String giro;
    private String contacto;
    private String ciudad;
    private int cantidadDetalle;

    public DatosFacturacionDTO() {
    }


    public String getRazonSocial() {
        return razonSocial;
    }


    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }


    public String getRut() {
        return rut;
    }


    public void setRut(String rut) {
        this.rut = rut;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getGiro() {
        return giro;
    }


    public void setGiro(String giro) {
        this.giro = giro;
    }


    public String getContacto() {
        return contacto;
    }


    public void setContacto(String contacto) {
        this.contacto = contacto;
    }


    public String getCiudad() {
        return ciudad;
    }


    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    public int getCantidadDetalle() {
        return cantidadDetalle;
    }


    public void setCantidadDetalle(int cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }


}
