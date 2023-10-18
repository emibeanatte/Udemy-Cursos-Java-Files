

package section_13;

abstract class FiguraAnonima {
    abstract void foo();
}

abstract interface Jugable {
    abstract void jugar();
}


public class EjemploAnonimasAbstractas {

    
    public static void main(String[] args) {
        
        FiguraAnonima figura = new FiguraAnonima(){
            @Override
            void foo() {
                System.out.println("Foo");
            }   
        };
        
        figura.foo();   
        
        Jugable j = new Jugable() {
            
            @Override
            public void jugar() {
                System.out.println("Jugando");
            }     
        };
        
        j.jugar();
        
    }

}
