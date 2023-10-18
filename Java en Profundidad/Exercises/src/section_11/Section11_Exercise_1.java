

package section_11;

import java.util.ArrayList;
import java.util.List;
import section_10.classes.Mascota;


public class Section11_Exercise_1 {

    
    public static void main(String[] args) {
        
        /* Crea una lista de mascotas modificando el ejemplo realizado
            en la sesion anterior
        */
        
        List<Mascota> pets = new ArrayList<>();
        
        pets.add(new Mascota("Max", 2,"Pitbull"));
        pets.add(new Mascota("Simona", 7,"Caniche"));
        pets.add(new Mascota("Toby", 12,"Pastor Aleman"));
        
        printList(pets);
        
    }
    
    
    public static void printList(List<Mascota> pets){
        
        for (Mascota pet : pets) {
            System.out.println(pet);
        }
        System.out.println();
  
    }  

}
