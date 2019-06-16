package modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-06-15T11:13:38")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, BigDecimal> idSucursal;
    public static volatile SingularAttribute<Sucursal, String> direccionSucursal;
    public static volatile ListAttribute<Sucursal, Usuario> usuarioList;
    public static volatile SingularAttribute<Sucursal, String> nombreSucursal;

}