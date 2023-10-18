

package section_16.servers;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import section_16.objects.HTTPRequest;


public class ServerSocket3 {

    
    public static void main(String[] args) throws IOException {
        
         try (ServerSocket socket = new ServerSocket(8080);
               Socket client = socket.accept();
               DataInputStream dis = new DataInputStream(client.getInputStream()); 
               ObjectInputStream ois = new ObjectInputStream(dis)){

            System.out.printf("Cliente %s conectado \n", client.getInetAddress().getHostName());
            
            Integer status = 0;
            String msg = null;
            System.out.println("<Server> Envie protocolos. Escriba salir para terminar.");

            do {
                
                msg = dis.readUTF();
                System.out.printf("%s dice : %s \n",client.getInetAddress().getHostName(), msg);
                
                try {
                    
                    HTTPRequest http = (HTTPRequest) ois.readObject();
                    
                    if (http != null) {
                        
                        status = 200;
                        System.out.println(http.getBody());
                        
                        for (Map.Entry<String,String> entry : http.getHeaders().entrySet()) {
                            
                            System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
                            
                        }
                        System.out.println("Status: " + status);
                        
                    } else {
                        status = 400;
                        System.out.println("Null");
                        System.out.println("Status: " + status);
                    }    
                    
                } catch (Exception e) {
                    status = 500;
                    break;
                }

            } while (!"salir".equals(msg));

            System.out.println("<Server> Apagando Servidor");
            client.close();
            dis.close();

        }
        
    }

}
