

package section_14;

import java.util.Arrays;
import java.util.Random;

class Contador2 extends Thread {

    private int value;

    public Contador2(int value, String name) {
        super(name);
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = value; i >= 0; i--) {
            System.out.printf("%s Valor %d \n", getName(), i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}


public class Section14_Exercise_2 {

    
    public static void main(String[] args) throws InterruptedException {
        
        /* Modifica el programa anterior para que todos los hilos
        esperen el mismo tiempo asignando diferentes prioridaes. Lanza
        30 hilos revisa si el cambio de prioridad genero algun cambio.
        */
        
        Contador2[] hilos = new Contador2[30];
        
        for (int i = 0; i < hilos.length; i++) {
            
            hilos[i] = new Contador2(new Random().nextInt(10), "Hilo " + i);
            hilos[i].setPriority(new Random().nextInt(10) + 1);
            
        }
        
        // Ordeno los hilos por prioridad
        Arrays.sort(hilos, (h1, h2) -> h2.getPriority() - h1.getPriority());

        // inciamos los hilos
        for (Contador2 hilo : hilos) {
            hilo.start();
        }

        // Esperamos a que todos los hilos terminen
        for (Contador2 hilo : hilos) {
            hilo.join();
        }
        
        System.out.println("El hilo que termino primero fue: " + hilos[0].getName());
        
        
    }

}
