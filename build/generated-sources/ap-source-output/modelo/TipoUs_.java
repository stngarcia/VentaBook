package modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-05-27T14:55:28")
@StaticMetamodel(TipoUs.class)
public class TipoUs_ { 

    public static volatile SingularAttribute<TipoUs, String> nombreTipo;
    public static volatile ListAttribute<TipoUs, Usuario> usuarioList;
    public static volatile SingularAttribute<TipoUs, BigDecimal> idTipo;

}