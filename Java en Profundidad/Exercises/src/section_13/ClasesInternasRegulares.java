

package section_13;

class Externa{
    
    void foo(){
        System.out.println("Foo");
    }
    
    class Interna {
        
        void bar(){
            System.out.println("Bar");
        }
    }

    
}

public class ClasesInternasRegulares {

    
    public static void main(String[] args) {
        
        Externa ex = new Externa();
        
        ex.foo();
        
        Externa.Interna interna = ex.new Interna();
        
        interna.bar();
        
        
    }

}
