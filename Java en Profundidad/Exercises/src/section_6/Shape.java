

package section_6;




public class Shape {
    
    protected String name;
    protected double area;
    protected double perimeter;

    public Shape(String name) {
        this.name = name;
    }

    public double calculateArea(){
        return 0;
    }
    
    public double calculatePerimeter(){
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
