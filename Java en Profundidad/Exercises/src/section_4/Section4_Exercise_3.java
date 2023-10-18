

package section_4;

import java.util.Scanner;


public class Section4_Exercise_3 {

    
    public static void main(String[] args) {
        
        final Scanner sc = new Scanner(System.in).useDelimiter("\n");
        
        /* Crea un programa utilizando ciclos que imprima el factorial
        de un numero.
        */
        
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int fact = 1;
        
        if (n == 0) {
            
            System.out.println(n + "!" + " = " + "1.");
            
        } else {
            
            for (int i = 1; i <= n; i++) {
            
                fact *= i;
            
            }
            
            System.out.println(n + "!" + " = " + fact);
        }
        
        
        
    }

}
