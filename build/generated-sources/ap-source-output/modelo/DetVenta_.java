package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.DetVentaPK;
import modelo.Libro;
import modelo.Venta;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-05-27T14:55:28")
@StaticMetamodel(DetVenta.class)
public class DetVenta_ { 

    public static volatile SingularAttribute<DetVenta, Libro> libro;
    public static volatile SingularAttribute<DetVenta, Venta> venta;
    public static volatile SingularAttribute<DetVenta, DetVentaPK> detVentaPK;
    public static volatile SingularAttribute<DetVenta, Short> cantidad;

}