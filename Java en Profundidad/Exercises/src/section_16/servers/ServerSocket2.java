

package section_16.servers;


import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;


public class ServerSocket2 {
    
    public static final String DIR_SERVER_PATH = "C:\\Users\\Usuario\\OneDrive\\Documentos\\Emi\\Programacion\\test";
    public static final String FILE_CLIENT_PATH = "C:\\Users\\Usuario\\OneDrive\\Documentos\\Emi\\Programacion\\";
    
    public static void receiveFile(File file) throws IOException{
        
        try {
            
            Path copiedFile = Files.copy(file.toPath(), new File(DIR_SERVER_PATH, file.getName()).toPath());
            System.out.println("El archivo se envio correctamente a " + copiedFile);
            
        } catch (IOException e) {
            
            System.out.println("Error." + e.getMessage());
            
        }
        
    
    }

    
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
                
                if (msg.equalsIgnoreCase("enviar archivo")) {
                    
                    String file = null;
                    System.out.println("<Server> Indique el nombre del archivo y luego escriba listo para confirmar. ");
                    do {

                        msg = dis.readUTF();
                        
                        if (!"listo".equalsIgnoreCase(msg)) {
                            
                            file = msg;
                            
                        }
                        
                    } while (!"listo".equalsIgnoreCase(msg));
                    
                    File f = new File(FILE_CLIENT_PATH.concat(File.separator).concat(file));
                    
                    receiveFile(f);
                } 

            } while (!"salir".equals(msg));

            System.out.println("Apagando Servidor");
            client.close();
            dis.close();

        }
        
    }

}
