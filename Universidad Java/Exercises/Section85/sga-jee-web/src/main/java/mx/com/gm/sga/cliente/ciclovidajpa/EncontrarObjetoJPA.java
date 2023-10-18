package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EncontrarObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        // inciar transaccion
        // Paso 1. Recuperar objeto
        EntityTransaction et = em.getTransaction();
        et.begin();

        // Paso 2. Ejecuta SQL SELECT
        Persona persona1 = em.find(Persona.class, 1);
        
        // Paso 3. Termina la transaccion
        et.commit();
        
        //Objeto en estado de detached
        log.debug("Objeto recuperado: " + persona1);
        

        //Cerramos el entity manager
        em.close();

    }

}
