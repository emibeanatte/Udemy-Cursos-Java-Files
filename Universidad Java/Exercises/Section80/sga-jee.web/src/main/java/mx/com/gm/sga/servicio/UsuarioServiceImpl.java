

package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.gm.sga.datos.UsuarioDAO;
import mx.com.gm.sga.domain.Usuario;



@Stateless
public class UsuarioServiceImpl implements UsuarioServiceRemote, UsuarioService {
    
    @Inject
    private UsuarioDAO usuarioDao;
    

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        return usuarioDao.findByUserId(usuario);
    }

    @Override
    public Usuario encontrarUsuarioPorNombreUsuario(Usuario usuario) {
        return usuarioDao.findByUsername(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertUser(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioDao.modifyUser(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.deleteUser(usuario);
    }

}
