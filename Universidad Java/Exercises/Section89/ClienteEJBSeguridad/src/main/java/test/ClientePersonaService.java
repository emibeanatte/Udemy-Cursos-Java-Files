package test;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import java.util.List;
import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente");
        
        String authFile = "login.conf";
        
        System.setProperty("java.security.auth.login.config", authFile);
        ProgrammaticLogin pl = new ProgrammaticLogin();
        pl.login("admin", "admin".toCharArray());
        
        try {
            
            Context jndi = new InitialContext();
            PersonaServiceRemote psr = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            
            List<Persona> personas = psr.listarPersonas();
            
            for (Persona p : personas) {
                System.out.println("Persona:" + p);
            }
            System.out.println("\nFin de la llamda EJB desde el cliente.");
            
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
           
    }
}
