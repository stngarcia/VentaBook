/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.jsf;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.DetVenta;



/**
 *
 * @author asathor
 */
@Stateless
public class DetVentaFacade extends AbstractFacade<DetVenta> {

    @PersistenceContext(unitName = "VentaBookPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetVentaFacade() {
        super(DetVenta.class);
    }
    
}
