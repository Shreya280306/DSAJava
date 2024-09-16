import java.util.Scanner;

public class TwoDArrays {
    public void twoDArrays(){
        int [][] matrix = new int[3][3];
        int [][] newMatrix = new int[3][3];

        System.out.println("Enter the values of a 3X3 matrix: ");
        //taking matrix as input
        for (int i=0; i<3; i++){
            for(int j=0; j<3; j++) {
                Scanner sc = new Scanner(System.in);
                matrix[i][j] = sc.nextInt();
            }
        }
        //transposing
        for(int rows=0; rows<3; rows++){
            for(int columns=0; columns<3; columns++){
                newMatrix[columns][rows] = matrix[rows][columns];
            }
        }
        //printing
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.println(newMatrix[i][j]);
            }
        }
    }
}
