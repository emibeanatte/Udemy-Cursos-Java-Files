

package section_14.classes;

import java.util.Random;




public class CuentaBancaria implements Runnable {
    
    private int saldo;

    public CuentaBancaria(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public void run() {
        // Consultamos el saldo
        consultarSaldo();

        // Realizamos una extracción
        extraerSaldo(new Random().nextInt(1000));

        // Consultamos el saldo nuevamente
        consultarSaldo();
    }

    public void consultarSaldo() {
        System.out.println(Thread.currentThread().getName() + " -> El saldo es de: " + getSaldo());
    }

    public void extraerSaldo(int monto) {
        if (monto > getSaldo()) {
            System.out.println(Thread.currentThread().getName() + " -> El monto ingresado supera el saldo en su cuenta.");
        } else {
            setSaldo(getSaldo() - monto);
            System.out.println(Thread.currentThread().getName() + "-> Retiro realizado con exito.");
        }
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}

