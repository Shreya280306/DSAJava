import java.util.ArrayList;
import java.util.HashSet;

/*
Blueprint of Backtracking Questions

void backtrack(parameters) {
    if (base case met) {
        save solution
        return;
    }

    for (all choices at current step) {
        if (choice is valid) {
            make the choice
            backtrack(next state)
            undo the choice // backtrack
        }
    }
}

What all to think mainly:
1. What are the number of choices I have at each step, based on that you can have loop or just call recursive  function 2-3 times
2. What all parameters we need to have
    a. Initial value
    b. What will change when we make a choice
    c. What will be new parameter values when Recursive function is called
3. Do we need any condition while making a choice, if yes then what that condition will be?
4. Undoing required or not
 */
public class BackTracking {

    public static void printAllSubsets(int[] arr, ArrayList<Integer> answer, int i){
        if(i==arr.length){
            System.out.println(answer);
            return;
        }
        //include element
        answer.add(arr[i]);
        printAllSubsets(arr, answer, i+1);

        answer.remove(answer.size()-1); //Backtracking step
        //exclude element
        printAllSubsets(arr, answer, i+1);
    }

    public static void allSubsetsWithDuplicates(int[] arr, ArrayList<Integer> answer, int i){
        if(i == arr.length){
            System.out.println(answer);
            return;
        }
        //include
        answer.add(arr[i]);
        allSubsetsWithDuplicates(arr, answer, i+1);

        answer.remove(answer.size()-1);
        int index = i+1;
        while(index < arr.length && arr[index] == arr[index-1]){
            index++;
        }

        allSubsetsWithDuplicates(arr, answer, index);
    }

    public static void permutationsOfArrayWithoutExtraSpace(int[] numbers, int index){
        if(index == numbers.length){
            for (int i=0;i<numbers.length;i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=index; i<numbers.length; i++){
            swapArrayElements(numbers, index,i); //index place- ith element choice
            permutationsOfArrayWithoutExtraSpace(numbers, index+1);
            swapArrayElements(numbers, index,i);//backtracking step
        }
    }

    private static void swapArrayElements(int[] array, int position1, int position2){
        int temp = array[position1];
        array[position1] = array[position2];
        array[position2] = temp;
    }

    public static void permutationsOfArrayWithExtraSpace(int[] arr, ArrayList<Integer> answer, boolean[] visited) {
        if (answer.size() == arr.length) {
            System.out.println(answer);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer.add(arr[i]);
                permutationsOfArrayWithExtraSpace(arr, answer, visited);
                answer.remove(answer.size() - 1);
                visited[i] = false;
            }
        }
    }


    public static void permutationsOString(String str, String resultantStr) {
        if (str.isEmpty()) {
            System.out.println(resultantStr + " ");
            return;
        }
        for (int i =0; i< str.length(); i++) {
            //All the combinations are valid, no every choice has to be considered
            char ch = str.charAt(i);
            String per = str.substring(0,i) + str.substring(i+1);
            permutationsOString(per, resultantStr + ch);
            // Undo is not required in this question as we input parameter (str) is a string  which is immutable
            // and so in every call, its a different object.
        }
    }


    public static void printAllBinaryStringsUsingStrBuilder(int n, StringBuilder resultantStr){
        if(resultantStr.length() == n){
            System.out.println(resultantStr);
            return;
        }
        resultantStr.append("0");
        printAllBinaryStringsUsingStrBuilder(n, resultantStr);
        resultantStr.deleteCharAt(resultantStr.length()-1);

        resultantStr.append("1");
        printAllBinaryStringsUsingStrBuilder(n, resultantStr);
        resultantStr.deleteCharAt(resultantStr.length()-1);
    }

    public static void printAllBinaryStringsUsingStr(int n, String resultantStr){
        if(resultantStr.length() == n){
            System.out.println(resultantStr);
            return;
        }

        printAllBinaryStringsUsingStr(n, resultantStr +  "0");
        printAllBinaryStringsUsingStr(n, resultantStr + "1");
    }

    public static void binaryStringsWithoutConsecutiveOnes(int n, String str) {
        if (str.length() == n) {
            System.out.println(str);
            return;
        }

        binaryStringsWithoutConsecutiveOnes(n, str + "0");
        if (str.isEmpty() || str.charAt(str.length()-1) != '1') {
            binaryStringsWithoutConsecutiveOnes(n, str + "1");
        }
    }

    private static int numberOfChars(String str, char ch){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ch){
                count++;
            }
        }
        return count;
    }

    private static String closeOpeningBrackets(String str){
        int sub = numberOfChars(str, '(') - numberOfChars(str, ')');
        for(int i=0; i<sub; i++){
            str = str + sub;
        }
        return str;
    }

    public static void allBalancedParentheses(int n, String result) {
        if (result.length() == (2*n)) {
            System.out.println(result);
            return;
        }
        if (numberOfChars(result, '(') < 3) {
            allBalancedParentheses(n, result + '(');
        } else {
//            int sub = numberOfChars(result, '(') - numberOfChars(result, ')');
//            for (int i = 0; i < sub; i++) {
//                result = result + ')';
//            }
//            return;
            //allBalancedParentheses(n, result + ')', resultList);
            closeOpeningBrackets(result);
        }
        if (numberOfChars(result, '(') != numberOfChars(result, ')')) {
            allBalancedParentheses(n, result + ')');
        }
    }

    public static char capatalizingChar(char input){
        int temp = (int) input;
        return (char)(temp-32);
    }

    public static void letterCasePermutation(String inputStr, String resultStr, int index){
        if(inputStr.length() == resultStr.length()){
            System.out.println(resultStr);
            return;
        }
        if(!Character.isDigit(inputStr.charAt(index))){
//            resultStr = resultStr + inputStr.charAt(index);
//            return;
            letterCasePermutation(inputStr, resultStr + capatalizingChar(inputStr.charAt(index)), index+1);
        }
        letterCasePermutation(inputStr, resultStr+inputStr.charAt(index), index+1);
    }

    private static int sumOfArray(ArrayList<Integer> arr){
        int sum = 0;
        for(int i=0; i<arr.size(); i++){
            sum += arr.get(i);
        }
        return sum;
    }

    public static boolean areArraysSame(int[] arr1, int[]arr2){
        int[] freqArr1 = new int[10];
        int[] freqArr2 = new int[10];
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i=0; i<arr1.length; i++){
            freqArr1[arr1[i]] += 1;
        }
        for(int i=0; i<arr2.length; i++){
            freqArr2[arr2[i]] += 1;
        }
        for(int i=0; i<freqArr1.length; i++){
            if(freqArr1[i] != freqArr2[i]){
                return false;
            }
        }
        return true;
    }



    public static void combinationSumToTargetOneElementCanComeOnlyONce(int[] arr, int target, ArrayList<Integer> resultArr, boolean[] visited){
        if(sumOfArray(resultArr) == target){
            System.out.println(resultArr);
            return;
        }
        if(sumOfArray(resultArr) > target){
            return;
        }
        for(int i=0; i<arr.length; i++) {
            if (visited[i] == false) {
                resultArr.add(arr[i]);
                visited[i] = true;
                combinationSumToTargetOneElementCanComeOnlyONce(arr, target, resultArr, visited);
                resultArr.remove(resultArr.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void combinationSumToTarget(int[] arr, int target, ArrayList<Integer> resultArr, ArrayList<ArrayList<Integer>> storeResult){
        if(sumOfArray(resultArr) == target){
            storeResult.add(resultArr);
            System.out.println(resultArr);
            return;
        }
        if(sumOfArray(resultArr) > target){
            return;
        }
        for(int i=0; i<arr.length; i++){
            resultArr.add(arr[i]);
            combinationSumToTarget(arr, target, resultArr, storeResult);
            resultArr.remove(resultArr.size()-1);
        }
    }

    private static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static void palindromePartitioning(String str, String resultStr, int index){
        if(!resultStr.isEmpty() && resultStr.length() <= 3){
            System.out.println(resultStr);
            return;
        }
        if(reverseString(resultStr).equals(resultStr)) {
            palindromePartitioning(str, resultStr + str.charAt(index), index + 1);
        }
        palindromePartitioning(str, resultStr, index+1);
    }

    public static void permutationInStringWithoutDuplicates(String str, String resultStr, boolean[] visited){
        if (str.length() == resultStr.length()) {
            System.out.println(resultStr);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutationInStringWithoutDuplicates(str, resultStr+str.charAt(i), visited);
                resultStr = resultStr.substring(0,resultStr.length());
                visited[i] = false;
            }
        }
    }

    public static void permutationInStringDuplicatesAllowed(String str, String resultStr){
        if (str.length() == resultStr.length()) {
            System.out.println(resultStr);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            permutationInStringDuplicatesAllowed(str, resultStr+str.charAt(i));
            resultStr = resultStr.substring(0,resultStr.length());
        }
    }

    public static void permutationsOfStringOfDifferentLengths(String str, StringBuilder result, boolean[] visited){
        if (!result.isEmpty()) {
            System.out.println(result);
        }
        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.append(str.charAt(i));

                permutationsOfStringOfDifferentLengths(str, result, visited);

                result.deleteCharAt(result.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void permutationsOfStringOfDifferentLengthsPalindrome(String str, StringBuilder result, boolean[] visited, ArrayList<String> list){
        if (!result.isEmpty()  && result.toString().equals(reverseString(result.toString())) && !list.contains(result.toString())) {
            System.out.println(result);
            list.add(result.toString());
        }
        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.append(str.charAt(i));

                permutationsOfStringOfDifferentLengthsPalindrome(str, result, visited,list);

                result.deleteCharAt(result.length() - 1);
                visited[i] = false;
            }
        }
    }

    }











