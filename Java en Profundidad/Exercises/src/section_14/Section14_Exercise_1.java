

package section_14;


import java.util.Random;

class Contador extends Thread {

    private int value;

    public Contador(int value, String name) {
        super(name);
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = value; i >= 0; i--) {
            System.out.printf("%s Valor %d \n", getName(), i);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
    


public class Section14_Exercise_1 {

    
    public static void main(String[] args) {
        
        /*
        Crea un programa donde un hilo haga una cuenta regresiva
        dado un numero, el tiempo q debe esperar el hilo debe ser aleatorio
        Inicia 10 hilos y revisa que hilo termino primero, asegurate de colocarle
        un nombre a cada uno de ellos.
        */
        
        Contador[] hilos = new Contador[10];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Contador(new Random().nextInt(10), "Hilo " + i);
        }

        for (Contador hilo : hilos) {
            hilo.start();
        }

        boolean dead = false;
        
        while (!dead) {
            
            dead = true;
            
            for (Contador hilo : hilos) {
                
                if (hilo.isAlive()) {
                    
                    dead = false;
                    break;
                    
                }
            }
        }

        System.out.println("El hilo que terminó primero fue el: " + hilos[0].getName());
        
    }

}
