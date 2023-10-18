

package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Usuario;


public interface UsuarioDAO {
    
    public List<Usuario> findAllUsuarios();
    
    public Usuario findByUserId(Usuario usuario);
    
    public Usuario findByUsername(Usuario usuario);
    
    public void insertUser(Usuario usuario);
    
    public void modifyUser(Usuario usuario);
    
    public void deleteUser(Usuario usuario);
}
