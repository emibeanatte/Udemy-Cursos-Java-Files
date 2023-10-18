

package section_11;

import section_11.classes.Nodo;
import section_11.classes.ListaLigada;


public class Section11_Exercise_2 {

    
    public static void main(String[] args) {
        
        // Crea una implementacion propia de una lista ligada, debe soportar metodos de agregar, borrar y buscar
        ListaLigada lista = new ListaLigada();
        
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        
        // Buscar un nodo
        Nodo nodo = lista.buscar(2);
        
        if (nodo != null) {
            System.out.println("El elemento encontrado es: " + nodo.getValue());
        }
        
        // Borrar un elemento de la lista
        lista.borrar(2);
        
        // Imprimimos la lista
        for (Nodo nodoActual = lista.getFirst(); nodoActual != null; nodoActual = nodoActual.getNext()) {
            System.out.println(nodoActual.getValue());
        }
        
        
    }

}
