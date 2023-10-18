

package section_4;


public class Section4_Exercise_1 {

    
    public static void main(String[] args) {
        
        /* Realizar un programa que imprima las tablas de multiplicar del 1 al 20,
        debe existir un espacio entre una y otra para identificarlas.
        */
        
        
        for (int i = 1; i < 21; i++) {
            
            System.out.println("Multiplication table of " + i + " :");
            
            for (int j = 1; j < 21; j++) {
                
                System.out.println(i + " * " + j + " = " + i * j );
                
            }
            System.out.println("\n");
            
        }
        
    }

}
