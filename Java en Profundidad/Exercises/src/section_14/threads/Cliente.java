

package section_14.threads;

import section_14.classes.CuentaBancaria;




public class Cliente extends Thread {
    
    private CuentaBancaria cuentaBancaria;

    public Cliente(CuentaBancaria cuentaBancaria,String name) {
        super(name);
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public void run() { 
        Thread cuentaB = new Thread(cuentaBancaria, getName());
        cuentaB.start();
    }
}


