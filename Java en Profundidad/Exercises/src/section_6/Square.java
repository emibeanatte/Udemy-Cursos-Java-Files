

package section_6;




public final class Square extends Shape {

    private double side;

    public Square(String name, double side) {
        super(name);
        this.side = side;
    }
    
    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return side * 4;
    }  

}
