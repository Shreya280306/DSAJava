public class Recursion {
    void printNum(int n) {
        if (n ==0)
            return;

        printNum(n-1);
        System.out.println(n);
    }

    int findSumRecFn(int n , int sum) {
        if (n ==0){
            return sum;
        }

        sum = sum +n;
        int result = findSumRecFn(n-1, sum);
        return result;
    }

    int findFactorial(int n, int factorial) {
        if (n==0 || n==1){
            return factorial;
        }

        factorial = factorial * n;
        int result = findFactorial(n-1, factorial);
        return result;
    }

    private void printFibSeriesRecFn(int n, int prev, int next) {

        if (n==0)
            return;

        System.out.println(prev + next);
        printFibSeriesRecFn(n-1, next, prev + next);
    }

    void printFibSeries(int n) {
        System.out.println(0);
        System.out.println(1);
        printFibSeriesRecFn(n-2, 0, 1);
    }

    int largestNumber(int[] arr, int index, int maximum){
        if (index == 0){
            return maximum;
        }
        if (arr[index] > maximum){
            maximum = arr[index];
        }
        return largestNumber(arr, index - 1, maximum);
    }

    int sumWithRecursion(int n, int sum){
        if (n == 0){
            return sum;
        }
        sum = sum + n;
        int x = sumWithRecursion(n-1, sum);
        return x;
    }

}
