

package section_13;

class EjemploAnonima {
    
    void foo(){
        System.out.println("Foo");
    }
    
}

public class EjemploClasesAnonimas {

    
    public static void main(String[] args) {
        
        EjemploAnonima obj = new EjemploAnonima(){
            
            @Override
            void foo(){
                System.out.println("Bar");
            }
            
            
        };
        
        obj.foo();
        
        
    }

}
