

package test;


import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;




public class ClienteEntidadPersona {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction et = em.getTransaction();
        
        // inicia la transaccion
        et.begin();
        
        //creamos un nuevo objeto persona
        Persona persona1 = new Persona("Maria", "Gutierrez", "mgutierrez@mail.com", "5529893102");
        
        log.debug("Objeto a persistir: " + persona1);
        
        // persistimos el objeto
        em.persist(persona1);
        
        // confirmamos la transaccion
        et.commit();
        
        log.debug("Objeto persistido " + persona1);
        em.close();      
    }
}
