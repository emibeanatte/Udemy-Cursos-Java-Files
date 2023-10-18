

package section_3;

import java.util.Scanner;


public class Section3_Exercise_1 {

    
    public static void main(String[] args) {
        
        final Scanner sc = new Scanner(System.in).useDelimiter("\n");
        
      /* 1) Realiza un programa capaz de calcular el area de un cuadrado,
            circulo, rectangulo y triangulo */
      
      while(true){
          
          System.out.println("Calculation Menu");
          System.out.println("Please select a shape to calculate the area: ");
          System.out.println("1 - Square.");
          System.out.println("2 - Circle.");
          System.out.println("3 - Rectangle.");
          System.out.println("4 - Triangle.");
          System.out.println("5 - Exit.");
          System.out.print("Enter option: ");
          int opt = sc.nextInt();
          
          if (opt == 5) {
              break;
          }
          
          switch (opt) {
              
              case 1:
                  
                  System.out.println("Area de un cuadrado: ");
                  System.out.print("Enter side 1: ");
                  double l1 = sc.nextDouble();
                  System.out.print("Enter side 2: ");
                  double l2 = sc.nextDouble();
                  
                  System.out.println("The area is " + (l1*l2) + " cm²");
                  break; 
                  
              case 2:
                  
                  System.out.println("Area de un Circulo: ");
                  System.out.print("Enter radius: ");
                  double r = sc.nextDouble();
                  
                  double result = Math.PI * Math.pow(r, 2);
                  
                  System.out.println("The area is " + result + " cm²");
                  break;
                                    
              case 3:
                  
                  System.out.println("Area de un Rectangle: ");
                  System.out.print("Enter base: ");
                  double b = sc.nextDouble();
                  
                  System.out.print("Enter height: ");
                  double a = sc.nextDouble();
                  
                  System.out.println("The area is: " + (b * a) + " cm²");
                  break;
                                   
              case 4:
                  
                  System.out.println("Area de un triangulo: ");
                  
                  System.out.print("Enter base: ");
                  double bt = sc.nextDouble();
                  
                  System.out.print("Enter height: ");
                  double at = sc.nextDouble();
                  
                  double res = Math.round(bt * at * 0.5);
                  
                  System.out.println("The area is " + res + " cm²");
                  break;
                  
              case 5:
                  break;                 
              default:
                  System.out.println("Invalid option.");
                  System.out.println();
                  break;              
          }    
                   
          
      }
      
        System.out.println("Thanks for using my program!");
        sc.close();
            
        
    }

}
