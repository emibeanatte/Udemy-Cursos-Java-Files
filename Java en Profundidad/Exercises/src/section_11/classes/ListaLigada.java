

package section_11.classes;

import section_11.classes.Nodo;




public class ListaLigada {
    
    private Nodo first;
    private Nodo last;

    public ListaLigada(Nodo first, Nodo last) {
        this.first = null;
        this.last = null;
    }

    public ListaLigada() {
    }
    
    public void agregar(int dato) {
       
        Nodo nuevo = new Nodo(dato);

        // Si la lista está vacía, el nuevo nodo es el primero y el último
        if (first == null) {
            first = nuevo;
            last = nuevo;
        } else {
            // Actualizamos el siguiente del último nodo
            last.setNext(nuevo);

            // Actualizamos el anterior del nuevo nodo
            nuevo.setPrevious(last);

            // Actualizamos el último
            last = nuevo;
        }
    }
    
    public void borrar(int dato) {
        // Buscamos el nodo a borrar
        Nodo nodo = first;
        while (nodo != null && nodo.getValue() != dato) {
            nodo = nodo.getNext();
        }

        // Si el nodo no existe, no hacemos nada
        if (nodo == null) {
            System.out.println("El nodo no existe.");
            return;
        }

        // Si el nodo a borrar es el primero
        if (nodo == first) {
            // Actualizamos el primero
            first = nodo.getNext();

            // Si el nodo a borrar también es el último
            if (nodo == last) {
                last = null;
            } else {
                // Actualizamos el anterior del siguiente nodo
                nodo.getNext().setPrevious(null);
            }
        } else {
            // Si el nodo a borrar no es el primero

            // Actualizamos el anterior del nodo anterior
            nodo.getPrevious().setNext(nodo.getNext());

            // Si el nodo a borrar es el último
            if (nodo == last) {
                last = nodo.getPrevious();
            } else {
                // Actualizamos el siguiente del nodo siguiente
                nodo.getNext().setPrevious(nodo.getPrevious());
            }
        }
    }
    
    
    public Nodo buscar(int dato) {
        // Inicializamos el nodo actual
        Nodo nodo = first;

        // Recorremos la lista
        while (nodo != null && nodo.getValue() != dato) {
            nodo = nodo.getNext();
        }

        // Devolvemos el nodo encontrado o null si no se encuentra
        return nodo;
    }

    public Nodo getFirst() {
        return first;
    }

    public void setFirst(Nodo first) {
        this.first = first;
    }

    public Nodo getLast() {
        return last;
    }

    public void setLast(Nodo last) {
        this.last = last;
    }
    
    
}
    


