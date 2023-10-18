

package test;

import beans.HolaMundoEjbRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;




public class TestHolaMundoEJB {

    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        
        try {
            Context jndi = new InitialContext();
            HolaMundoEjbRemote holaMundoEJB = (HolaMundoEjbRemote) jndi.lookup("java:global/HolaMundoEJB/HolaMundoEjbImpl!beans.HolaMundoEjbRemote");
            int resultado = holaMundoEJB.suma(5, 3);
            System.out.println("El resultado de la suma 5 + 3 es " + resultado);  
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
        
        
        
        
    }
    
    
    
}
