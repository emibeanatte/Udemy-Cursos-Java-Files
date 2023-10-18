

package section_5;




public class Cat {
    
    private String name;
    private int age;
    private String color;

    public Cat() {
    }

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }
    
    
    public void feed(){
        // feeding code
    }
    
    public void sleep(){
        // sleeping code
    }
    
    public void climb(){
        // climbing code
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    

}
