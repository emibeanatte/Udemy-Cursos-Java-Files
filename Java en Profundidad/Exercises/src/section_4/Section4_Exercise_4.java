

package section_4;


public class Section4_Exercise_4 {

    
    public static void main(String[] args) {
        
        // Crear figuras con ciclos 
        
        // 10 x 4 Square
        
        for (int i = 0; i < 4; i++) {
            
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();  
            
        }
        
        // Triangle
        
        for (int i = 0; i <= 5; i++) {
            
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.println();
        
        // Reverse triangle
        
        for (int i = 1; i <= 5; i++) {
            
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
        
        
        
    }

}
