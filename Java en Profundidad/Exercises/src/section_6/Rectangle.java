

package section_6;




public final class Rectangle extends Shape {

    private double base;
    private double height;

    public Rectangle(String name, double base, double height) {
        super(name);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return base * height;
    }

    @Override
    public double calculatePerimeter() {
        return (base + height) * 2;
    }
}
