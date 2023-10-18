

package section_8;

import section_8.cars.Ferrari;
import section_8.cars.Fiat;
import section_8.cars.Tesla;


public class Main {

    
    public static void main(String[] args) {
        
        Fiat fiat = new Fiat("AGF 099", 5, 100d);
        Ferrari ferrari = new Ferrari("YTU 678", 3, 100d);
        Tesla tesla = new Tesla("OPW 430", 5, 100d);

        fiat.drive();
        fiat.park();
        fiat.repare();
        fiat.clean();
        
        ferrari.drive();
        ferrari.park();
        ferrari.repare();
        ferrari.clean();
        
        tesla.drive();
        tesla.park();
        tesla.repare();
        tesla.clean();
        
        
    }

}
