package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author asathor
 */
public class VentaAggregate implements Serializable {

    private dto.VentaDTO ventaInfo;
    private dto.DatosFacturacionDTO datosFacturacionInfo;
    private List<dto.DetalleVentaDTO> detalleVentaInfo;

    public VentaAggregate() {
        this.ventaInfo = new VentaDTO();
        this.datosFacturacionInfo = new DatosFacturacionDTO();
        this.detalleVentaInfo = new ArrayList<>();
    }


    public VentaDTO getVentaInfo() {
        return ventaInfo;
    }


    public void setVentaInfo(VentaDTO venta) {
        this.ventaInfo = venta;
    }


    public DatosFacturacionDTO getDatosFacturacionInfo() {
        return datosFacturacionInfo;
    }


    public void setDatosFacturacionInfo(DatosFacturacionDTO datosFactura) {
        this.datosFacturacionInfo = datosFactura;
    }


    public List<DetalleVentaDTO> getDetalleVentaInfo() {
        return detalleVentaInfo;
    }


    public void setDetalleVentaInfo(List<DetalleVentaDTO> detalleVenta) {
        this.detalleVentaInfo = detalleVenta;
    }


    public void agregarDetalle(dto.DetalleVentaDTO detalleVentaDTO) {
        this.detalleVentaInfo.add(detalleVentaDTO);
    }


}
