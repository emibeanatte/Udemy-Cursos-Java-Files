

package section_11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Section11_Exercise_3 {

    
    public static void main(String[] args) {
        
        /* crear un programa que administre los elementos de 
            una lista y te permita agregar, borrar y buscar
            un elemento. No puede haber datos duplicados.
        */
        
        List<String> names = new ArrayList<>();
        
        add(names,"Emiliano");
        add(names,"Luis");
        add(names,"Renzo");
        
        add(names,"Renzo"); // Error
        
        delete(names,"Emiliano");
        delete(names,"Emiliano"); // Error
        
        search(names,"Renzo");
        search(names,"Emiliano"); // Error
        
        System.out.println("Lista: ");
        for (String name : names) {
            
            System.out.println(name);
            
        }
        
        
    }
    
    public static void add(List<String> lista, String dato){
        
        Iterator<String> it = lista.iterator();
        boolean found = false;
        
        while(it.hasNext()){
            
            if (it.next().equals(dato)) {
                
                System.out.println("El elemento ya existe.");
                found = true;
                break;
                
            }
            
        }
        
        if (!found) {
            lista.add(dato);
        }
        
        
    }
    
    public static void delete(List<String> lista, String dato){
        
        Iterator<String> it = lista.iterator();
        boolean found = false;
        
        while(it.hasNext()){
            
            if (it.next().equals(dato)) {
                
                it.remove();
                System.out.println("Elemento eliminado con exito. ");
                found = true;
                break;
                
            }
            
        }
        
        if (!found) {
            System.out.println("No se ha encontrado el elemento indicado.");
        }
        
    }
    
    public static void search(List<String> lista, String dato){
        
        Iterator<String> it = lista.iterator();
        boolean found = false;
        
        while(it.hasNext()){
            
            if (it.next().equals(dato)) {
                
                System.out.println("Elemento encontrado.");
                found = true;
                break;
                
            }
            
        }
        
        if (!found) {
            System.out.println("No se ha encontrado el elemento indicado.\n");
        }
        
    }

}
