package modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Venta;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-06-15T11:13:38")
@StaticMetamodel(TipoDoc.class)
public class TipoDoc_ { 

    public static volatile SingularAttribute<TipoDoc, BigDecimal> idTipoDoc;
    public static volatile ListAttribute<TipoDoc, Venta> ventaList;
    public static volatile SingularAttribute<TipoDoc, String> nombreTipoDocumento;

}