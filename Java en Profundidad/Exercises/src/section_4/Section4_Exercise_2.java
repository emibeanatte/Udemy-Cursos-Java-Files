

package section_4;


public class Section4_Exercise_2 {

    
    public static void main(String[] args) {
        
        /* Modifica el programa anterior para que solo se impriman las tablas de multiplicar
        de numeros pares.
        */
        
        for (int i = 1; i < 21; i++) {
            
            System.out.println("Multiplication table of " + i + " :");
            
            for (int j = 1; j < 21; j++) {
                
                if ((i * j) % 2 == 0) {
                    
                    System.out.println(i + " * " + j + " = " + i * j );
                    
                }
                
                
            }
            System.out.println("\n");
            
        }
        
    }

}
