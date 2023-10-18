

package section_16.clients;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Section16_Exercise_1 {

    public static String readMessage() throws IOException {
        
        System.out.print("\n -> ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
        
    }
    
    public static void main(String[] args) throws IOException {
        
        /* crea un programa que a atraves de un socket envie
        un mensaje, dependiendo del mismo, el servidor imprimira inciando
        reiniciando o apagando.
        */
        
        try(Socket cliente = new Socket("localhost",8080);
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream())){
            
            String mensaje = null;
            
            do {
                
                mensaje = readMessage();
                dos.writeUTF(mensaje);
                
            } while (!"apagando".equals(mensaje));
            
            
        }
        
        
    }

}
