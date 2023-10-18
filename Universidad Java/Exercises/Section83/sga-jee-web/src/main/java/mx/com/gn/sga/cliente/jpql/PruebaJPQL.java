

package mx.com.gn.sga.cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;




public class PruebaJPQL {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        String jpql = null;        
        Query q = null;        
        List<Persona> personas = null;
        Persona persona = null;
        Iterator it = null;
        Object [] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        
        // 1. Consultar todos los objetos de tipo Persona
        log.debug("\n 1. Consulta de todas las Personas");        
        jpql = "select p from Persona p";
        
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        // 2. Consulta de la persona con id = 1
        log.debug("\n 2. Consulta de la persona con id = 1");
        jpql = "select p from Persona p where p.idPersona = 1";
        
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        
        // log.debug(persona);
        
        // 3. Consulta de persona por nombre
        log.debug("\n 3. Consulta de persona por nombre");
        jpql = "select p from Persona p where p.nombre = 'Karla'";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        
        // 4. Consulta de datos individuales, arreglo (tupla) de tipo object de 3 columnas
        log.debug("\n 4. Consulta de datos individuales, arreglo (tupla) de tipo object de 3 columnas ");
        jpql = "select p.nombre as Nombre, p.apellido as Apellido, p.email as Email from Persona p";
        it = em.createQuery(jpql).getResultList().iterator();
        
        while(it.hasNext()){
            tupla = (Object[]) it.next();
            String nombre = (String) tupla[0];
            String apellido  = (String) tupla[1];
            String email = (String) tupla[2];
            //log.debug("nombre: " + nombre + ", apellido: " + apellido + ", email: " + email);
        }
        
        // 5. Obtiene el objeto Persona y el id, se crea un arreglo de tipo Object con 2 columnas
        log.debug("\n 5. Obtiene el objeto Persona y el id, se crea un arreglo de tipo Object con 2 columnas.");
        jpql = "select p, p.idPersona from Persona p";
        it = em.createQuery(jpql).getResultList().iterator();
        
        while(it.hasNext()){  
            tupla = (Object[]) it.next();
            persona = (Persona) tupla [0];
            int idPersona = (int) tupla[1];
            //log.debug("Objeto persona: \n" + persona + "\n id de la persona: " + idPersona);   
        }
        
        
        // 6. Consulta todas las personas
        log.debug("\n  6. Consulta todas las personas");
        jpql = "select new mx.com.gm.sga.domain.Persona(p.idPersona) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        // 7. Consulta valor minimo y maximo del idPersona
        log.debug("\n 7. Consulta valor minimo y maximo del idPersona");
        jpql ="select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona) as Contador from Persona p";
        it = em.createQuery(jpql).getResultList().iterator();
        
        while(it.hasNext()){
            tupla = (Object[]) it.next();
            Integer minId = (Integer) tupla [0];
            Integer maxId = (Integer) tupla [1];
            Long count = (Long) tupla [2];
            
            //log.debug("idMin: " + minId + ", idMax: " + maxId, ", contador: " + count); 
        }
        
        
        // 8. Contar los nombres de las personas que son distintos
        log.debug("\n 8. Contar los nombres de las personas que son distintos");
        jpql = "select count(distinct p.nombre) from Persona p";
        
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        
        //log.debug("\nPersonas con nombre distinto: " + contador);
        
        // 9. Concatena y convierte a mayusculas el nombre y apellido
        log.debug("\n9. Concatena y convierte a mayusculas el nombre y apellido.");
        jpql = "select CONCAT(p.nombre, ' ', p.apellido) as Nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        
        for (String nombre : nombres) {
            //log.debug(nombre);
        }
        
        // 10. Obtiene el objeto persona con id igual al parametro proporcionado
        log.debug("\n10. Obtiene el objeto persona con id igual al parametro proporcionado");
        int idPersona = 1;
        jpql = "select p from Persona p where p.idPersona = :id";
        q = em.createQuery(jpql);
        q.setParameter("id", idPersona);
        persona = (Persona) q.getSingleResult();
        
        //log.debug(persona);
        
        
        // 11. Obtener personas que contenga la letra 'a' en su nombre, sin importar mayusculas o minusculas
        log.debug("\n11. Obtener personas que contenga la letra 'a' en su nombre, sin importar mayusculas o minusculas");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:param)";
        String param = "%a%";
        q = em.createQuery(jpql);
        q.setParameter("param",param);
        personas = q.getResultList();
        
        //mostrarPersonas(personas);
        
        
        // 12. Uso de Between
        log.debug("\n 12. Uso de between");
        jpql = "select p from Persona p where p.idPersona between 1 and 2";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        

        // 13. Uso de order by
        log.debug("\n 13. Uso de order by");
        jpql = "select p from Persona p where p.idPersona > 1 order by p.nombre desc, p.apellido desc";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        
        // 14. Uso de Subconsultas
        log.debug("\n 14. Uso de subconsultas.");
        jpql = "select p from Persona p where p.idPersona in (select min(p1.idPersona) from Persona p1)";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        // 15. Uso de join con lazy loading
        log.debug("\n 15. Uso de join con lazy loading");
        jpql = "select u from Usuario u join u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        //mostrarUsuarios(usuarios);
        
        // 16. Uso de left join con Eager loading
        log.debug("\n16. Uso de left join con Eager loading");
        jpql = "select u from Usuario u left join fetch u.persona";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);  
    }

    private static void mostrarPersonas(List<Persona> personas) {
        
        for (Persona persona : personas) {
            log.debug(persona);
        }
    }

    private static void mostrarUsuarios(List<Usuario> usuarios) {
        
        for (Usuario usuario : usuarios) {
            log.debug(usuario);
        }
    }

}
