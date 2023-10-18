

package section_6;


public class Main {

    
    public static void main(String[] args) {
        
        Shape square1 = new Square("Square", 10);
        
        System.out.println("The area is " + square1.calculateArea());
        System.out.println("The perimeter is " + square1.calculatePerimeter());
        
        Rectangle rect = new Rectangle("Rectangle", 10, 2);
        
        System.out.println("The area is " + rect.calculateArea());
        System.out.println("The perimeter is " + rect.calculatePerimeter());
        
        Circle circle = new Circle("Circle", 20);
        
        System.out.println("The area is " + circle.calculateArea());
        System.out.println("The perimter is " + circle.calculatePerimeter());

        Triangle triangle = new Triangle("Triangle", 20, 8);
        
        System.out.println("The area is " + triangle.calculateArea());
        System.out.println("The perimeter is " + triangle.calculatePerimeter());
        
    }

}
