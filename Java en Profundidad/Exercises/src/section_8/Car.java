

package section_8;

import section_8.interfaces.Reparable;




public abstract class Car implements Reparable {
    
    protected String patent;
    protected int doors;

    public Car(String patent, int doors) {
        this.patent = patent;
        this.doors = doors;
    }
    
    public abstract void drive();
    
    public abstract void park();
    

    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    
}
