

package section_16.servers;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerSocket1 {

    
    public static void main(String[] args) throws IOException {
        
        try (ServerSocket socket = new ServerSocket(8080);) {
            System.out.println("Escuchando peticiones ...");
            Socket client = socket.accept();

            System.out.printf("Cliente %s conectado \n", client.getInetAddress().getHostName());
            DataInputStream dis = new DataInputStream(client.getInputStream());

            String msg = null;

            do {
                
                msg = dis.readUTF();
                System.out.printf("%s dice : %s \n",client.getInetAddress().getHostName(), msg);
                
                if (msg.equalsIgnoreCase("iniciando")) {
                    
                    System.out.println("Iniciando Servidor");
                    
                } else if (msg.equalsIgnoreCase("reiniciando")){
                    
                    System.out.println("Reiniciando Servidor.");
                }

            } while (!"apagando".equals(msg));

            System.out.println("Apagando Servidor");
            client.close();
            dis.close();

        }
        
    }

}
