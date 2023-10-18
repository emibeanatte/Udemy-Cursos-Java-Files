

package section_3;

import java.util.Scanner;


public class Section3_Exercise_2 {

    
    public static void main(String[] args) {
        
        /* Toma el ejercicio anterior y combiertelo en un programa ofuscado.*/
 
        final Scanner $c = new Scanner(System.in).useDelimiter("\n");
        
      
      while(true){
          
          System.out.println("Calculation Menu");
          System.out.println("Please select a shape to calculate the area: ");
          System.out.println("1 - Square.");
          System.out.println("2 - Circle.");
          System.out.println("3 - Rectangle.");
          System.out.println("4 - Triangle.");
          System.out.println("5 - Exit.");
          System.out.print("Enter $_ : ");
          int $_ = $c.nextInt();
          
          if ($_ == 5) {
              break;
          }
          
          switch ($_) {
              
              case 1:
                  
                  System.out.print("Enter l$_1: ");
                  double l$_1 = $c.nextDouble();
                  System.out.print("Enter l$__2 ");
                  double l$__2 = $c.nextDouble();
                  
                  System.out.println("The area is " + (l$_1 * l$__2) + " cm²");
                  break; 
                  
              case 2:
                  
                  System.out.print("Enter r$A_d_ : ");
                  double r$A_d_ = $c.nextDouble();
                  
                  double r$A_d_f = Math.PI * Math.pow(r$A_d_, 2);
                  
                  System.out.println("The area is: " + r$A_d_f + " cm²");
                  break;
                                    
              case 3:
                  
                  System.out.print("Enter bA$$_ : ");
                  double bA$$_ = $c.nextDouble();
                  
                  System.out.print("Enter aT$$_L : ");
                  double aT$$_L = $c.nextDouble();
                  
                  System.out.println("The area is: " + (bA$$_  * aT$$_L) + " cm²");
                  break;
                                   
              case 4:
                  
                  System.out.print("Enter bA$_Et:  ");
                  double bA$_Et = $c.nextDouble();
                  
                  System.out.print("Enter $a_T : ");
                  double $a_T = $c.nextDouble();
                  
                  double r$aD_$o = Math.round(bA$_Et * $a_T * 0.5);
                  
                  System.out.println("The area is " + r$aD_$o + " cm²");
                  break;
                  
              case 5:
                  break;                 
              default:
                  System.out.println("Invalid $_ .");
                  System.out.println();
                  break;              
          }    
                   
          
      }
      
        System.out.println("Thank you for using my program!");
        $c.close();
            
        
    }
    

}
