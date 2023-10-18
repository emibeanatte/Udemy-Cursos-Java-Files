package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EliminarObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        // inciar transaccion
        // Paso 1. Recuperar objeto
        EntityTransaction et = em.getTransaction();
        et.begin();
        
        // Paso 2. Ejecutamos SQL de tipo SELECT
        Persona persona1 = em.find(Persona.class, 8);
        
        // Paso 3. termina la transaccion 1
        et.commit();
        
        // Objeto en estado detached
        log.debug("Objeto encontrado: " + persona1);
        
        // Paso 4. Iniciar transaccion 2
        EntityTransaction et2 = em.getTransaction();
        et2.begin();
        
        // Paso 5. Ejecutar SQL DELETE
        em.remove(em.merge(persona1));
        
        // Paso 6. Terminar la transaccion 2
        et2.commit();
        
        // Objeto en estado detached ya eliminado
        log.debug("Objeto eliminado: " + persona1);
        
        //Cerramos el entity manager
        em.close();

    }

}
