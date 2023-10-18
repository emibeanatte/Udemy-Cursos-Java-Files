

package section_12;

import section_12.classes.CustomException;


public class ManejoDeExcepciones {

    
    public static void main(String[] args) {
        
        try {
            
            int x = 2;
            
            int result = 2 / 2;
            
            System.out.println(result);
            
        } catch (ArithmeticException e) {
            System.out.println("Error " + e.getMessage());
        }   
        
        int z = 0;
        
        if (z == 0) {
            
            throw new CustomException("Error message.");
            
        }
        
        
    }

}
