

package mx.com.gm.sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.Usuario;



@Stateless
public class UsuarioDaoImpl implements UsuarioDAO {
    
    @PersistenceContext(unitName="SgaPU")
    EntityManager em;
    

    @Override
    public List<Usuario> findAllUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findByUserId(Usuario usuario) {
        return em.find(Usuario.class,usuario.getIdUsuario());
    }

    @Override
    public Usuario findByUsername(Usuario usuario) {
        return em.find(Usuario.class,usuario.getUsername());
    }

    @Override
    public void insertUser(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void modifyUser(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUser(Usuario usuario) {
        em.remove(em.merge(usuario));
    }

}
