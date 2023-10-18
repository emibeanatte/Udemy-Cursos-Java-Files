

package section_5;


public class Main {

    
    public static void main(String[] args) {
        
        Dog dog1 = new Dog();
        Dog dog2 = new Dog("Max", 6, "Pitbull");
        
        dog2.breathe();
        dog2.castrate();
        dog1.feed();
        
        
        Cat cat1 = new Cat();
        Cat cat2 = new Cat("Mia", 3, "Black");
        
        cat2.feed();
        cat2.sleep();
        cat1.climb();
        
        Fish fish1 = new Fish();
        Fish fish2 = new Fish("Nemo", "Orange, White", "Clown", false);
        
        fish1.feed();
        fish2.swim();
        fish2.clearWater();
        
        
    }

}
