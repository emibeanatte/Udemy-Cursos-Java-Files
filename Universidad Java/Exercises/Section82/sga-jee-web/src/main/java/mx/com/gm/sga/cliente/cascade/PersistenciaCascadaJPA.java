

package mx.com.gm.sga.cliente.cascade;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;




public class PersistenciaCascadaJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        
        // Paso 1. Crear un objeto nuevo en estado transitivo
        Persona persona1 = new Persona("Hugo", "Hernandez", "hhernandez@mail.com", "556879932");
        
        // Crear objeto usuario relacionado a esta persona
        Usuario usuario1 = new Usuario("hhernandez", "123", persona1);
        
        // Paso 2. Persistir el objeto usuario solamente
        em.persist(usuario1);
        
        // Paso 3. Commit transaccion
        et.commit();
        
        // Imprimimos objetos en estado detached
        log.debug("Objeto persistido (Persona) : " + persona1);
        log.debug("Objeto persistido (Usuario) : " + usuario1);
        
   
    }
}
