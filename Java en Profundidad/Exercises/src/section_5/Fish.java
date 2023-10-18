

package section_5;




public class Fish {
    
    private String name;
    private String colors;
    private String type;
    private boolean cleanWater;

    public Fish() {
    }

    public Fish(String name, String colors, String type, boolean cleanWater) {
        this.name = name;
        this.colors = colors;
        this.type = type;
        this.cleanWater = cleanWater;
    }

    public Fish(String name, String colors) {
        this.name = name;
        this.colors = colors;
    }
    
    public void feed(){
        // feeding code
    }
    
    public void clearWater(){
        // cleaning water code
    }
    
    public void swim(){
        // swimming code
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCleanWater() {
        return cleanWater;
    }

    public void setCleanWater(boolean cleanWater) {
        this.cleanWater = cleanWater;
    }
    
    
    

}
