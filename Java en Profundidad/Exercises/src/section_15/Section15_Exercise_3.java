

package section_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


public class Section15_Exercise_3 {
    
    public static void moveFile(File file, File dir) throws IOException{
        
        try {
        
            Files.move(file.toPath(), dir.toPath().resolve(file.toPath().getFileName()), REPLACE_EXISTING);
            System.out.println("El archivo se movio correctamente a " + dir);
            
        } catch (IOException e) {
            
            System.out.println("Error." + e.getMessage());
            
        } 
        
    }

    
    public static void main(String[] args) throws IOException {
        
        // programa el comando mp para mover un archivo de un directorio a otro
        
        File f = new File("C:\\Users\\Usuario\\OneDrive\\Documentos\\Emi\\Programacion\\test.txt");
        
        File dir = new File("C:\\Users\\Usuario\\OneDrive\\Documentos\\Emi\\Programacion\\test");
        
        moveFile(f,dir);
    }

}
