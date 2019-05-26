package controlador.jsf;


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
import modelo.TipoUs;


@Named("tipoUsController")
@SessionScoped
public class TipoUsController implements Serializable {

    @EJB
    private controlador.jsf.TipoUsFacade ejbFacade;
    private List<TipoUs> items = null;
    private TipoUs selected;

    public TipoUsController() {
    }


    public TipoUs getSelected() {
        return selected;
    }


    public void setSelected(TipoUs selected) {
        this.selected = selected;
    }


    protected void setEmbeddableKeys() {
    }


    protected void initializeEmbeddableKey() {
    }


    private TipoUsFacade getFacade() {
        return ejbFacade;
    }


    public TipoUs prepareCreate() {
        selected = new TipoUs();
        initializeEmbeddableKey();
        return selected;
    }


    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TipoUsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }


    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TipoUsUpdated"));
    }


    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TipoUsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }


    public List<TipoUs> getItems() {
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


    public TipoUs getTipoUs(java.math.BigDecimal id) {
        return getFacade().find(id);
    }


    public List<TipoUs> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }


    public List<TipoUs> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }


    @FacesConverter(forClass = TipoUs.class)
    public static class TipoUsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoUsController controller = (TipoUsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoUsController");
            return controller.getTipoUs(getKey(value));
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
            if (object instanceof TipoUs) {
                TipoUs o = (TipoUs) object;
                return getStringKey(o.getIdTipo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TipoUs.class.getName()});
                return null;
            }
        }


    }

}
