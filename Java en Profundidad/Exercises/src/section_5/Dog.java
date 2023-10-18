

package section_5;




public class Dog {
    
    private String name;
    private int age;
    private String race;

    public Dog() {
    }

    public Dog(String name, int age, String race) {
        this.name = name;
        this.age = age;
        this.race = race;
    }

    public Dog(String name, String race) {
        this.name = name;
        this.race = race;
    }
    
    
    public void feed(){
        // feeding code
    }
    
    public void breathe(){
        // breathing code
    }
    
    
    public boolean castrate(){
        // castrate code
        return false || true;
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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
    
    
}
