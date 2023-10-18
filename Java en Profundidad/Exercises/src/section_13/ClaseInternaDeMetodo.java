

package section_13;



public class ClaseInternaDeMetodo {
    
    static void foo(){
        
        class ClaseInternaEnMetodo {
            
            void bar(){
                System.out.println("Bar");
            }
            
        }
        
        ClaseInternaEnMetodo obj = new ClaseInternaEnMetodo();
        
        obj.bar();
    }

    
    public static void main(String[] args) {
        
        foo();
        
    }

}
