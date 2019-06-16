package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.DetVenta;
import modelo.TipoDoc;
import modelo.Usuario;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-06-15T11:13:38")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, String> rutFactura;
    public static volatile ListAttribute<Venta, DetVenta> detVentaList;
    public static volatile SingularAttribute<Venta, String> ciudadFactura;
    public static volatile SingularAttribute<Venta, String> rutcliente;
    public static volatile SingularAttribute<Venta, Usuario> idUsuario;
    public static volatile SingularAttribute<Venta, String> razonsocialFactura;
    public static volatile SingularAttribute<Venta, String> direccionFactura;
    public static volatile SingularAttribute<Venta, String> contactoFactura;
    public static volatile SingularAttribute<Venta, String> idVenta;
    public static volatile SingularAttribute<Venta, TipoDoc> idTipoDoc;
    public static volatile SingularAttribute<Venta, String> giroFactura;
    public static volatile SingularAttribute<Venta, String> nombrecliente;
    public static volatile SingularAttribute<Venta, Date> fechaVenta;

}