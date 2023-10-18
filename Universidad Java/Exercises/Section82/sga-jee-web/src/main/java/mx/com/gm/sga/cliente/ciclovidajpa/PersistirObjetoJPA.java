

package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;






public class PersistirObjetoJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction et = em.getTransaction();
        
        // inciar transaccion
        
        // Paso 1 cear un objeto en estado transitivo
        Persona persona1 = new Persona("Pedro","Luna","pluna@mail.com","12125566");
        
        // Paso 2 iniciar la transaccion
        et.begin();
        
        // Paso 3. Ejecutar el SQL
        em.persist(persona1);
        
        log.debug("Objeto persistido - sin commit: " + persona1);
        
        // Paso 4. commit/rollback
        et.commit();
        
        
        // Objeto en estado detached
        log.debug("Objeto persistido - estado detached: " + persona1);
        
        
        //Cerramos el entity manager
        em.close();
        
    }

}
