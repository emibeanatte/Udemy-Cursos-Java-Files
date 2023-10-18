

package section_13;

class ExternaStatic {
    public void foo(){
        System.out.println("Foo");
    }
    
    static class InternalStatic {
        void bar(){
            System.out.println("Bar");
        }
    }
}


public class ClasesInternasStatic {

    
    public static void main(String[] args) {
        
        ExternaStatic.InternalStatic obj = new ExternaStatic.InternalStatic();
        
        obj.bar();
        
    }

}
