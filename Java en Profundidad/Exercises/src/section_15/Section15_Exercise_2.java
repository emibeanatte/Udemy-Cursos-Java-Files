

package section_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Section15_Exercise_2 {
    
    
    public static void copyFile(File file, File dir) throws IOException{
        
        try {
            
            Path copiedFile = Files.copy(file.toPath(), new File(dir, file.getName()).toPath());
            System.out.println("El archivo se copio correctamente a " + copiedFile);
            
        } catch (IOException e) {
            
            System.out.println("Error." + e.getMessage());
            
        }
        
    
    }

    
    public static void main(String[] args) throws IOException {
        
        // programa el comando cp para copiar un archivo de un directorio a otro
        
        File f = new File("C:\\Users\\Usuario\\OneDrive\\Documentos\\Emi\\Programacion\\test.txt");
        
        File dir = new File("C:\\Users\\Usuario\\OneDrive\\Documentos\\Emi\\Programacion\\test");
        
        copyFile(f,dir);
        
    }

}
