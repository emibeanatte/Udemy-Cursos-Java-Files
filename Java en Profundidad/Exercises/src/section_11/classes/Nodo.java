

package section_11.classes;




public class Nodo {

    private int value;
    private Nodo next;
    private Nodo previous;

    public Nodo(int value) {
        this.value = value;
        next = null;
        previous = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getPrevious() {
        return previous;
    }

    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }
 
}
