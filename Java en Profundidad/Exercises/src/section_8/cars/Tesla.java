

package section_8.cars;

import section_8.Car;
import section_8.interfaces.Reparable;




public class Tesla extends Car implements Reparable {
    
    private double charge;

    public Tesla(String patent, int doors, double charge) {
        super(patent, doors);
        this.charge = charge;
    }

    @Override
    public void drive() {
        System.out.println("Driving Tesla.");
        setCharge(getCharge() - 1d);
    }

    @Override
    public void park() {
        System.out.println("Parked Tesla. Resting charge: " + getCharge());
    }

    @Override
    public void repare() {
        System.out.println("Repared Tesla.");
        setCharge(100d);
    }

    @Override
    public boolean clean() {
        System.out.println("Cleaned Tesla.");
        return true;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

}
