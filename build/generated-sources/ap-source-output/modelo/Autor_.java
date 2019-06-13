package modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Libro;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-05-27T14:55:28")
@StaticMetamodel(Autor.class)
public class Autor_ { 

    public static volatile SingularAttribute<Autor, String> nombreAutor;
    public static volatile SingularAttribute<Autor, BigDecimal> idAutor;
    public static volatile ListAttribute<Autor, Libro> libroList;

}