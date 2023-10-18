

package section_10;


public class Section10_Exercise_4 {

    
    public static void main(String[] args) {
        
        // Crear y sumar 2 matrices
        
        int matriz1 [][] = new int [3][3];
        int matriz2 [][] = new int [3][3];
        
        matriz1 = fillArray(matriz1);
        matriz2 = fillArray(matriz2);
        
        int matrizR [][] = sumArrays(matriz1, matriz2);
        
        System.out.println("Matriz 1: " + "\n");
        showArray(matriz1);
        
        System.out.println("\nMatriz 2: " + "\n");
        showArray(matriz2);
        
        System.out.println("\nResultado de su suma: " + "\n");
        showArray(matrizR);
        
        
        
        
    }
    
    public static int [][] fillArray(int [][] arr){
        
        for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < arr.length; j++) {
            
                arr[i][j] = (int) (Math.random() * 10 + 1);
                
            }
            
        }
        
        return arr;
    }
    
    public static int [][] sumArrays(int [][] arr1, int[][] arr2){
        
        int arr [][] = new int [3][3];
        
        
        for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < arr.length; j++) {
            
                arr[i][j] = arr1[i][j] + arr2[i][j];
                
            }
            
        }
        
        
        return arr;
    }
    
    public static void showArray(int [][] array){
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        
    }

}
