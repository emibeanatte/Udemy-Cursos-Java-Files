

package section_16.clients;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;
import section_16.objects.HTTPRequest;



public class Section16_Exercise_3 {

    public static String readMessage() throws IOException {
        
        System.out.print("\n -> ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
        
    }
    
    public static void main(String[] args) throws IOException {
        
        try(Socket cliente = new Socket("localhost",8080);
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(dos)){
            
            Map<String,String> headers = new TreeMap<>();
            String mensaje = null;
            
            do {
                
                mensaje = readMessage();
                dos.writeUTF(mensaje);
                headers.put(mensaje,cliente.getInetAddress().getHostName());
                HTTPRequest http = new HTTPRequest(mensaje,headers);
                
                oos.writeObject(http);
            } while (!"salir".equals(mensaje));
            
            
        }
        
    }

}
