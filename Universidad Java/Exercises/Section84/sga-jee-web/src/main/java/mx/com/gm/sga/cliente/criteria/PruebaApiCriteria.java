

package mx.com.gm.sga.cliente.criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;




public class PruebaApiCriteria {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> cq = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        // Query usando el api de criteria
        // 1. Consultar todas las personas
        
        // Paso 1. El objeto EntityManager crea instancia de Criteria Builder
        cb = em.getCriteriaBuilder();
        
        // Paso 2. Se crea un objeto CriteriaQuery
        cq = cb.createQuery(Persona.class);
        
        // Paso 3. Creamos el objeto raiz de query
        fromPersona = cq.from(Persona.class);
        
        // Paso 4. Seleccionamos lo necesario del from
        cq.select(fromPersona);
        
        // Paso 5. Creamos el tipo de query TypeSafe
        query = em.createQuery(cq);
        
        // Paso 6. Ejecutamos la consulta
        personas = query.getResultList();
        
        //mostrarPersonas(personas);
        
        
        // 2. Consulta de la persona con id = 1
        log.debug("\n 2. Consulta de la persona con id = 1");
        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(Persona.class);
        fromPersona = cq.from(Persona.class);
        cq.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
        persona = em.createQuery(cq).getSingleResult();
        
        log.debug(persona);
        
        // Otra opcion:
        log.debug("\n Otra opcion para hacer lo anterior: ");
        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(Persona.class);
        fromPersona = cq.from(Persona.class);
        cq.select(fromPersona);
        
        // La clase predicate nos permite agregar varios criterios dinamicamente
        List<Predicate> criterios = new ArrayList<Predicate>();
        
        // Verificamos si tenemos criterios que agregar
        Integer idPersonaParam = 1;
        ParameterExpression<Integer> param = cb.parameter(Integer.class,"idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), param));
        
        // Agregamos los criterios
        if (criterios.isEmpty()){
            throw new RuntimeException("Sin criterios");
        } else if (criterios.size() >= 1) {
            cq.where(criterios.get(0));
        } else {
            cq.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        
        query = em.createQuery(cq);
        query.setParameter("idPersona", idPersonaParam);
        
        // Ejecutamos el query
        persona = query.getSingleResult();
        log.debug(persona);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    private static void mostrarPersonas(List<Persona> personas) {
        
        for (Persona persona : personas) {
            log.debug(persona);
        }
    }

}
