package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

public class TestPersonaServiceRS {
    
    private static final String URL_BASE = "http://localhost:8080/sga-jee-web/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder ib;
    private static Response resp;
    
    public static void main(String[] args) {
        
        cliente = ClientBuilder.newClient();
        
        // Leer una persona (metodo get)
        webTarget = cliente.target(URL_BASE).path("/personas");
        
        // Proporcionamos un idPersona valido
        persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada: " + persona);
        
        // Leer todas las personas (metodo get con readEntity de tipo List<T>)
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});
        System.out.println("\nPersonas recuperadas: ");
        imprimirPersonas(personas);
        
        // Agregar una persona (metodo post)
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Carlos");
        nuevaPersona.setApellido("Miranda");
        nuevaPersona.setEmail("cmiranda3@mail.com");
        nuevaPersona.setTelefono("999887700");
        
        ib = webTarget.request(MediaType.APPLICATION_XML);
        resp = ib.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println("\n" + resp.getStatus());
        
        // Recuperamos la persona recien agregada para modificarla y eliminarla al final
        Persona personaRecuperada = resp.readEntity(Persona.class);
        System.out.println("\n Persona agregada: " + personaRecuperada);
        
        // Modificar la persona recuperada (metodo put)
        Persona personaModificar = personaRecuperada;
        personaModificar.setApellido("Ramirez");
        String pathId = "/" + personaModificar.getIdPersona();
        
        ib = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        resp = ib.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        System.out.println("\n Response: " + resp.getStatus());
        System.out.println("Persona Modificada: " + resp.readEntity(Persona.class));
        
        // eliminar la persona recuperada metodo delete
        Persona deletePersona = personaRecuperada;
        String delPath = "/" + deletePersona.getIdPersona();
        
        ib = webTarget.path(delPath).request(MediaType.APPLICATION_XML);
        resp = ib.delete();
        
        System.out.println("\n Response: " + resp.getStatus());
        System.out.println("Persona Eliminada: " + deletePersona);
        
        
    }

    private static void imprimirPersonas(List<Persona> personas) {
        
        for (Persona persona1 : personas) {
            System.out.println(persona1);
        }
    }
}
