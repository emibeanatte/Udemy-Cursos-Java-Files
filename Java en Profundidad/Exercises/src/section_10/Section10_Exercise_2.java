

package section_10;


public class Section10_Exercise_2 {

    
    public static void main(String[] args) {
        
        // Crear un arreglo irregular en forma de triangulo
        
        int array [][] = new int [3][];
        
        array[0] = new int [1];
        array[0][0] = 10;
        
        array[1] = new int [2];
        array[1][0] = 20;
        array[1][1] = 30;
        
        array[2] = new int [3];
        array[2][0] = 40;
        array[2][1] = 50;
        array[2][2] = 60;
        
        showArray(array);
        
        
    }
    
    public static void showArray(int [][] array){
        
        for (int i = 0; i < array.length; i++) {
            
            for (int j = 0; j < array[i].length; j++) {
                
                System.out.print(array[i][j] + "\t");
                
            }
            System.out.println();
        }
        
        
    }

}
