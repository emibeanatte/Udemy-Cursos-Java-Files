package test;

import domain.Persona;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class PruebaRestWS {
    
    public static void main(String[] args) {
        
        HttpAuthenticationFeature haf = (HttpAuthenticationFeature) HttpAuthenticationFeature.basicBuilder()
               .nonPreemptive()
               .credentials("admin", "admin")
               .build();
        
        ClientConfig cconfig = new ClientConfig();
        cconfig.register(haf);
        
        Client client = ClientBuilder.newClient(cconfig);
        
        WebTarget wt = client.target("http://localhost:8080/sga-jee-web/webservice").path("/personas");
        
        // Proporcionamos un idPersona valido
        Persona p1 = (Persona) wt.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        
        System.out.println("Persona recuperada: " + p1);
        
    }

}
