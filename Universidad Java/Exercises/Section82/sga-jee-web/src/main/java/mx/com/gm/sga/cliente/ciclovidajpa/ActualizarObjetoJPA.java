package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        // inciar transaccion
        // Paso 1. Recuperar objeto
        EntityTransaction et = em.getTransaction();
        et.begin();

        // Paso 2. Ejecuta SQL de tipo SELECT
        // El id debe existir en la db
        Persona persona1 = em.find(Persona.class, 1);
        
        // Paso 3. Termina la transaccion 1
        et.commit();
        
        // Objeto en estado de detached
        log.debug("Objeto recuperado: " + persona1);
        
        // Paso 4. setValue(nuevoValor)
        persona1.setApellido("Juarez");
        
        // Paso 5 creamos e iniciamos una transaccion 2
        EntityTransaction et2 = em.getTransaction();
        et2.begin();
        
        // Paso 6. Modificamos el objeto
        em.merge(persona1);
        
        // Paso 7. Termina la transaccion 2
        et2.commit();
        
        // Objeto en estado de detached ya modificado
        log.debug("Objeto modificado: " + persona1);
        

        //Cerramos el entity manager
        em.close();

    }
}
