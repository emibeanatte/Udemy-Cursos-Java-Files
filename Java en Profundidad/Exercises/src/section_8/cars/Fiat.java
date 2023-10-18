

package section_8.cars;

import section_8.Car;
import section_8.interfaces.Reparable;




public class Fiat extends Car implements Reparable {

    private double gasoline;
    
    
    public Fiat(String patent, int doors, double gasoline) {
        super(patent, doors);
        this.gasoline = gasoline;
    }
    
    @Override
    public void drive() {
        System.out.println("Driving Fiat.");
        setGasoline(getGasoline()- 1d);
    }

    @Override
    public void park() {
        System.out.println("Parked Fiat. Resting gasoline: " + getGasoline());
    }

    @Override
    public void repare() {
        System.out.println("Repared Fiat.");
        setGasoline(100d);
    }

    @Override
    public boolean clean() {
        System.out.println("Cleaned Fiat.");
        return true;
    }

    public double getGasoline() {
        return gasoline;
    }

    public void setGasoline(double gasoline) {
        this.gasoline = gasoline;
    }

}
