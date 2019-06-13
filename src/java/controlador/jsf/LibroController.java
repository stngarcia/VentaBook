package controlador.jsf;

import ejb.LibroFacade;
import controlador.jsf.util.JsfUtil;
import controlador.jsf.util.JsfUtil.PersistAction;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import modelo.Libro;


@Named("libroController")
@SessionScoped
public class LibroController implements Serializable {

    @EJB
    private ejb.LibroFacade ejbFacade;
    private List<Libro> items = null;
    private Libro selected;

    public LibroController() {
    }


    public Libro getSelected() {
        return selected;
    }


    public void setSelected(Libro selected) {
        this.selected = selected;
    }


    protected void setEmbeddableKeys() {
    }


    protected void initializeEmbeddableKey() {
    }


    private LibroFacade getFacade() {
        return ejbFacade;
    }


    public Libro prepareCreate() {
        selected = new Libro();
        initializeEmbeddableKey();
        return selected;
    }


    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("LibroCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }


    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("LibroUpdated"));
    }


    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("LibroDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }


    public List<Libro> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }


    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }


    public Libro getLibro(java.math.BigDecimal id) {
        return getFacade().find(id);
    }


    public List<Libro> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }


    public List<Libro> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }


    @FacesConverter(forClass = Libro.class)
    public static class LibroControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LibroController controller = (LibroController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "libroController");
            return controller.getLibro(getKey(value));
        }


        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }


        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }


        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Libro) {
                Libro o = (Libro) object;
                return getStringKey(o.getIdLibro());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Libro.class.getName()});
                return null;
            }
        }


    }

}
