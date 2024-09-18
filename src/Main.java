//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        String x = Recursion.reverseStringwithRecursion("abcdef", 0, "");
//        System.out.println(x);

        int[] arr = {1,2,3,4,2};
        boolean sort = Recursion.isArraySortedRec(arr, 0);
        System.out.println(sort);
    }
}