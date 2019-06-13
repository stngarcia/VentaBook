package modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Sucursal;
import modelo.TipoUs;
import modelo.Venta;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-05-27T14:55:28")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Sucursal> idSucursal;
    public static volatile SingularAttribute<Usuario, String> contrasenaUsuario;
    public static volatile ListAttribute<Usuario, Venta> ventaList;
    public static volatile SingularAttribute<Usuario, BigDecimal> idUsuario;
    public static volatile SingularAttribute<Usuario, TipoUs> idTipo;
    public static volatile SingularAttribute<Usuario, String> nombreUsuario;
    public static volatile SingularAttribute<Usuario, String> rutUsuario;

}