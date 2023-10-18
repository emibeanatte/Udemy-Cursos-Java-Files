

package section_10;

import section_10.classes.Mascota;


public class Section10_Exercise_3 {

    
    public static void main(String[] args) {
        
        // crear un arreglo de tipo Mascota y llenarlo
        
        Mascota pets [] = new Mascota [3];
        
        pets[0] = new Mascota("Max", 2,"Pitbull");
        pets[1] = new Mascota("Simona", 7,"Caniche");
        pets[2] = new Mascota("Toby", 12,"Pastor Aleman");
       
        
        for (int i = 0; i < pets.length; i++) {
            System.out.println(pets[i]);
            System.out.println();
        }
        
        
        
    }

}
