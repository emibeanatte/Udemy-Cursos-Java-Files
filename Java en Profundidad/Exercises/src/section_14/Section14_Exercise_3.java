

package section_14;

import section_14.classes.CuentaBancaria;
import section_14.threads.Cliente;




public class Section14_Exercise_3 {

    
    public static void main(String[] args) {
        
        
        CuentaBancaria cuentaBancaria = new CuentaBancaria(100);

        
        Cliente[] clientes = new Cliente[10];
        
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(cuentaBancaria,"Hilo " + i);
        }

        
        for (Cliente cliente : clientes) {
            cliente.start();
        }
    }

}
