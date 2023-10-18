

package section_6;




public final class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle(String name, double base, double height) {
        super(name);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return (base * height) / 2;
    }

    @Override
    public double calculatePerimeter() {
        return base + height + Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
    }
    
}
