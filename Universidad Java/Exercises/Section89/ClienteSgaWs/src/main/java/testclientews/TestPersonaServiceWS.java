package testclientews;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWs;
import java.util.List;
import javax.xml.ws.BindingProvider;

public class TestPersonaServiceWS {

    public static void main(String[] args) {
        PersonaServiceWs pservice = new PersonaServiceImplService().getPersonaServiceImplPort();

        ((BindingProvider) pservice).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        ((BindingProvider) pservice).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");

        System.out.println("Ejecutando servicio de listar personas ws");
        List<Persona> personas = pservice.listarPersonas();

        for (Persona persona : personas) {

            System.out.println("Persona, idPersona: " + persona.getIdPersona()
                    + ", Nombre: " + persona.getNombre()
                    + ", Apellido: " + persona.getApellido()
                    + ", Email: " + persona.getEmail());
        }
        System.out.println("Fin de servicio listar personas ws");
    }
}
