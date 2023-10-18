

package section_8.cars;

import section_8.Car;
import section_8.interfaces.Reparable;




public class Ferrari extends Car implements Reparable {
    
    private double premiumFuel;

    public Ferrari(String patent, int doors, double premiumFuel) {
        super(patent, doors);
        this.premiumFuel = premiumFuel;
    }

    @Override
    public void drive() {
        System.out.println("Driving Ferrari");
        setPremiumFuel(getPremiumFuel() - 1d);
    }

    @Override
    public void park() {
        System.out.println("Parked Ferrari. Resting Fuel: " + getPremiumFuel()); 
    }

    @Override
    public void repare() {
        System.out.println("Repared Ferrari.");
        setPremiumFuel(100d);
    }

    @Override
    public boolean clean() {
        System.out.println("Cleaned Ferrari.");
        return true;
    }

    public double getPremiumFuel() {
        return premiumFuel;
    }

    public void setPremiumFuel(double premiumFuel) {
        this.premiumFuel = premiumFuel;
    }
    
    

}
