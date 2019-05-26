/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.login;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Usuario;



/**
 *
 * @author asathor
 */
@Stateless
public class UsuarioFac extends absFacade<Usuario> implements UsuarioFacLocal {

    @PersistenceContext(unitName = "VentaBookPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFac() {
        super(Usuario.class);
    }
    @Override
    public Usuario login(Usuario usuario) throws Exception {
        Usuario miUsuario = null;
        String consulta;
        try {
            consulta = "FROM Usuario u WHERE u.rutUsuario = ?1 and u.contrasenaUsuario = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, usuario.getRutUsuario());
            query.setParameter(2, usuario.getContrasenaUsuario());
            List<Usuario> lista = query.getResultList();
            if (!lista.isEmpty()) {
                miUsuario = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return miUsuario;
    }





    
}
