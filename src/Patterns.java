public class Patterns {
    public void solidRectangle(){
        for(int i = 0; i < 4; i ++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public void hollowRectangle(){
        for (int i = 1; i <= 4; i ++){
            for(int j = 1; j <= 5; j ++){
                if(i == 1 || i == 4 || j == 1 || j == 5){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public void halfPyramid(){
        for (int i = 1; i <= 4; i ++ ){
            for(int j = 1; j <= 4; j ++){
                if (i >= j){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public void invertedHalfPyramid(){
        for(int i = 4; i >= 1; i --){
            for(int j = 1; j <= i; j ++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void invertedRotatedHalfPyramid(){
        for (int i = 1; i <=4 ; i ++){
            for (int j = 1; j <= (4-i); j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j ++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void numericalHalfPyramid() {
        int num = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num ++;
            }
            System.out.println();
        }
    }
    public void numericalInvertedHalfPyramid(){
        for (int i=5; i>=1; i--){
            for (int j=1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public void binaryHalfPyramid(){
        for (int i=0; i<5; i++){
            for(int j=0; j<=i; j++){
                if ((i+j) % 2 == 0){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

}
