

package section_15;

import java.io.File;


public class Section15_Exercise_1 {

    
    public static void main(String[] args) {
        
        // Programa el comando dir para listar los archivos en un directorio especificado.
        
        File f = new File("C:\\Users\\Usuario\\OneDrive\\Documentos\\Emi\\Programacion\\Bootcamp - Consiti");
        
        File [] content = f.listFiles();
        
        int dir = 0;
        int fi = 0;
        
        for (File file : content) {
            
            if (file.isDirectory()) {
                
                System.out.println("<DIR> " + file.getName());
                dir++;
                
            } else {
                
                System.out.println(file.getName());
                fi++;
                
            }  
        }
        
        System.out.println(fi + " archivos");
        System.out.println(dir + " directorios");
        
    }

}
