package controlador.jsf;

import java.util.ArrayList;
import java.util.List;
import modelo.Libro;


/**
 * @author asathor
 */
public class LibroService {

    private List<Libro> listaLibros;
    private final LibroController libroController;

    private LibroService() {
        listaLibros = new ArrayList<>();
        libroController = new LibroController();
        listaLibros = libroController.getItemsAvailableSelectOne();
    }


    public static LibroService create() {
        return new LibroService();
    }


    public List<Libro> getListaLibros() {
        return listaLibros;
    }


}
