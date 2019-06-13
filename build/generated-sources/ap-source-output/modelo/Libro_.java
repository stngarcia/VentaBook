package modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Autor;
import modelo.DetVenta;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-05-27T14:55:28")
@StaticMetamodel(Libro.class)
public class Libro_ { 

    public static volatile ListAttribute<Libro, DetVenta> detVentaList;
    public static volatile SingularAttribute<Libro, Short> cantidadejemplaresLibro;
    public static volatile SingularAttribute<Libro, Integer> precioLibro;
    public static volatile SingularAttribute<Libro, BigDecimal> idLibro;
    public static volatile SingularAttribute<Libro, Autor> idAutor;
    public static volatile SingularAttribute<Libro, String> sinopsisLibro;
    public static volatile SingularAttribute<Libro, String> isbnLibro;
    public static volatile SingularAttribute<Libro, String> tituloLibro;

}