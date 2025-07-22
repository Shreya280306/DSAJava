import java.util.*;

public class Recursion {
    //In all these questions a loop is being replaced with recursion and any value that needs to be updated after every iteration is passed as a parameter
    //If there's any code that needs to be written in the function before the loop such that it should be executed only once then it can be written in a seperate helper function
    //which calls our main function. Even the parameters that the user doesn't pass but are needed and updated within the code can be passed in this function

    //If we write the function as a return statement then that means that the value which is determined is the same value that will exit the function and be returned to us at the end.
    //Whereas if the function is simply called then the value that is returned by one stack is bound to be changed by the other stacks' return function and the value in the end will not be the same

    //If we write the print statement after the function then it prints in reverse whem the stack is getting unloaded but before the function call the print statement prints in the correct order

    void printNum(int n) {
        if (n == 0)
            return;

        printNum(n - 1);
        System.out.println(n);
    }

    int findSumRecFn(int n, int sum) {
        if (n == 0) {
            return sum;
        }

        sum = sum + n;
        int result = findSumRecFn(n - 1, sum);
        return result;
    }

    int findFactorial(int n, int factorial) {
        if (n == 0 || n == 1) {
            return factorial;
        }

        factorial = factorial * n;
        int result = findFactorial(n - 1, factorial);
        return result;
    }

    private void printFibSeriesRecFn(int n, int prev, int next) {

        if (n == 0)
            return;

        System.out.println(prev + next);
        printFibSeriesRecFn(n - 1, next, prev + next);
    }

    void printFibSeries(int n) {
        System.out.println(0);
        System.out.println(1);
        printFibSeriesRecFn(n - 2, 0, 1);
    }

    int largestNumberWithRecursion(int[] arr, int index, int maximum) {
        if (index == 0) {
            return maximum;
        }
        if (arr[index] > maximum) {
            maximum = arr[index];
        }
        return largestNumberWithRecursion(arr, index - 1, maximum);
    }

    int sumWithRecursion(int n, int sum) {
        if (n == 0) {
            return sum;
        }
        sum = sum + n;
        return sumWithRecursion(n - 1, sum);
    }

    public static String reverseStringwithRecursion(String str, int index, String newStr) {
        if (index == str.length()) {
            return newStr;
        }
        newStr = str.charAt(index) + newStr;
        return reverseStringwithRecursion(str, index + 1, newStr);
    }

    public static boolean isArraySortedRec(int[] arr, int index) {
        if (index == arr.length) {
            return true;
        }
        if (index == arr.length - 1) {
            if (arr[index - 1] > arr[index - 2]) {
                return true;
            } else {
                return false;
            }
        }
        if (arr[index] < arr[index + 1]) {
            return isArraySortedRec(arr, index + 1);
        } else {
            return false;
        }
    }

    public static int printingNumbers(int start, int end) {
        if (start < end) {
            System.out.println(start);
            return printingNumbers(start + 1, end);
        } else {
            return start;
        }
    }

    public static int largestNumInArrays(int[] arr, int index, int currentMax) {
        if (index < arr.length) {
            if (arr[index] > currentMax) {
                currentMax = arr[index];
                return largestNumInArrays(arr, index + 1, currentMax);
            } else {
                return largestNumInArrays(arr, index + 1, currentMax);
            }
        } else {
            return currentMax;
        }
    }

    public static int sumOfArrayElements(int[] arr, int index, int sum) {
        if (index < arr.length) {
            sum = sum + arr[index];
            return sumOfArrayElements(arr, index + 1, sum);
        } else {
            return sum;
        }
    }

    public static String helperFuncRevString(String str) {
        String result = reverseString(str, str.length() - 1, "");
        return result;
    }

    public static String reverseString(String str, int index, String revString) {
        if (index >= 0) {
            revString += str.charAt(index);
            return reverseString(str, index - 1, revString);
        } else {
            return revString;
        }
    }

    public static String isStringPalindrome(String str, int index) {
        if (index < (str.length() / 2)) {
            if (str.charAt(index) == str.charAt(str.length() - index - 1)) {
                return isStringPalindrome(str, index + 1);
            } else {
                return "No";
            }
        } else {
            return "Yes";
        }
    }

    public static int[] countOccurencesInString(String word, int index, int[] freqArray) {
        if (index < word.length()) {
            char currentElement = word.charAt(index);
            freqArray[currentElement - 'a'] += 1;
            return countOccurencesInString(word, index + 1, freqArray);
        } else {
            return freqArray;
        }
    }

    public static int lengthOfStringUsingRecursion(String str, int counter) {
        if (counter != str.length()) {
            return lengthOfStringUsingRecursion(str, counter + 1);
        } else {
            return counter;
        }
    }

    public static boolean isArraySorted(int[] arr, int counter) {
        if (counter < arr.length - 1) {
            if (arr[counter + 1] > arr[counter]) {
                return isArraySorted(arr, counter + 1);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public static int productOfArrayElements(int[] arr, int counter, int multiply) {
        if (counter < arr.length) {
            multiply = multiply * arr[counter];
            return productOfArrayElements(arr, counter + 1, multiply);
        } else {
            return multiply;
        }
    }

    public static int firstOccurrence(int[] arr, int element, int counter) {
        if (counter < arr.length) {
            if (arr[counter] == element) {
                return counter;
            } else {
                return firstOccurrence(arr, element, counter + 1);
            }
        } else {
            return -1;
        }
    }

    public static int numberOfDigitsInStringRecursion(String str, int counter, int i) {
        if (i < str.length()) {
            if ((int) str.charAt(i) >= 48 && (int) str.charAt(i) <= 57) {
                return numberOfDigitsInStringRecursion(str, counter + 1, i + 1);
            } else {
                return numberOfDigitsInStringRecursion(str, counter, i + 1);
            }
        } else {
            return counter;
        }
    }

    public static int factorialUsingRecursion(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * factorialUsingRecursion(num - 1);
    }

    public static String reversingAString(String str, String reversed) {
        if (str == "") {
            return reversed;
        }
        return reversingAString(str.substring(0, str.length() - 1), reversed + str.charAt(str.length() - 1));

    }

    public static int lengthOfAString(String str, int length) {
        if (str == "") {
            return length;
        }
        return lengthOfAString(str.substring(0, str.length() - 1), length + 1);
    }

    public static int sumOfDigitsOfNumber(int num, int sum) {
        if (num == 0) {
            return sum;
        }
        return sumOfDigitsOfNumber(num / 10, sum + num % 10);
    }

    public static boolean isPalindrome(String str, String revString, String originalStr, int index) {
        if (index == originalStr.length()) {
            return originalStr.equals(revString);
        }
        return isPalindrome(str.substring(0, str.length() - 1), revString + str.charAt(str.length() - 1), originalStr, index + 1);
    }

    public static int minOfArray(int[] arr, int min, int index) {
        if (index == arr.length - 1) {
            return min;
        }
        if (min > arr[index]) {
            return minOfArray(arr, arr[index], index + 1);
        } else {
            return minOfArray(arr, min, index + 1);
        }
    }

    public static void reverseFibonacciSeries(int num, int a, int b) {
        if (num > 0) {
            reverseFibonacciSeries(num - 1, b, a + b);
            System.out.println(a);
        }
    }

    //Medium Problems
    public static void removeAdjacentDuplicates(StringBuilder str, int n) {
        int a = 0;
        for (int b = 0; b < n; b++) {
            if (b < n - 1 && str.charAt(b) == str.charAt(b + 1)) {
                while (str.charAt(b) == str.charAt(b + 1)) {
                    b++;
                }
            } else {
                str.setCharAt(a, str.charAt(b));
                a++;
            }
        }
        str.setLength(a);
        if (a != n) {
            removeAdjacentDuplicates(str, a);
            System.out.println(str.toString());
        }
    }

    public static int coinChange(int[] coins, int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0 || n == 0) {
            return 0;
        }

        return coinChange(coins, n, sum - coins[n - 1]) + coinChange(coins, n - 1, sum);
    }

    public static void deletingALinkedList(SLL list, SLL_Node current) {
        if (current == null) {
            return;
        }

        if (current.next == null) {
            list.removeNodeFromStart();
        } else {
            list.deleteNodePassed(current);
            deletingALinkedList(list, current.next);
        }
    }

    public static int productOfTwoNumbers(int x, int y, int result) {
        if (y == 0) {
            return result;
        } else {
            return productOfTwoNumbers(x, y - 1, result + x);
        }
    }

    public static void printingOneSidedTriangle(int n, int count) {
        if (count == n + 1) {
            return;
        }
        String str = "*";
        System.out.println(str.repeat(count));
        printingOneSidedTriangle(n, count + 1);
    }

    public static void printing180RotatedTriangle(int n, int count) {
        if (count == n + 1) {
            return;
        }
        String space = " ";
        String str = "*";
        System.out.print(space.repeat(n - count));
        System.out.print(str.repeat(count));
        System.out.println();
        printing180RotatedTriangle(n, count + 1);
    }

    public static void printingTriangle(int n, int count) {
        if (count == n + 1) {
            return;
        }
        String space = " ";
        String str = "* ";
        System.out.print(space.repeat(n - count));
        System.out.print(str.repeat(count));
        System.out.print(space.repeat(n - count));
        System.out.println();
        printingTriangle(n, count + 1);
    }

    public static void numberedRightAngledTriangle(int n, int count) {
        if (count == n + 1) {
            return;
        }
        String str = String.valueOf(count);
        System.out.println(str.repeat(count));
        numberedRightAngledTriangle(n, count + 1);
    }

    public static void patternWithoutRecursion(int n, int count) { //helper function for next question
        int numCount = 0;
        int lineCount = 0;
        for (int num = 1; numCount <= count; num++) {
            System.out.print(num + " ");
            numCount++;
            if (numCount == count) {
                System.out.println();
                numCount = 0;
                count++;
                lineCount++;
            }
            if (lineCount == n) {
                return;
            }
        }
    }

    public static int printRow(int count, int num) { //helper function for next question
        if (num == 0) {
            return count;
        }
        System.out.print(count + " ");
        return printRow(count + 1, num - 1);
    }

    public static void printingPattern(int n, int count, int num) {
        if (n == 0) {
            return;
        }
        count = printRow(count, num);
        System.out.println();
        printingPattern(n - 1, count, num + 1);
    }

    public static int longestPalindromic(String str, int i, int j, int count) {
        if (i > j)
            return count;
        if (i == j)
            return (count + 1);

        if (str.charAt(i) == str.charAt(j)) {
            count = longestPalindromic(str, i + 1, j - 1, count + 2);
            return Math.max(count, Math.max(longestPalindromic(str, i + 1, j, 0), longestPalindromic(str, i, j - 1, 0)));
        }
        return Math.max(longestPalindromic(str, i + 1, j, 0), longestPalindromic(str, i, j - 1, 0));
    }

    public static int calculateNCRUsingRecursion(int n, int r) {
        if (n < r) {
            return 0;
        }
        if (r == 0 || n == r) {
            return 1;
        }
        if (r == 1 || r == n - 1) {
            return n;
        }
        return calculateNCRUsingRecursion(n - 1, r - 1) + calculateNCRUsingRecursion(n - 1, r);
    }

    static int comb(int n, int r) {
        if (n < r) {
            return 0;
        }
        if (r == 0) {
            return 1;
        }
        if (r == 1) {
            return n;
        }
        if (n == 1) {
            return 1;
        }
        return comb(n - 1, r - 1) + comb(n - 1, r);
    }

    public static double geometricSum(int n, double sum, int terms) {
        if (terms == n) {
            return sum;
        }
        return geometricSum(n, sum + Math.pow(1.0 / 3, terms), terms + 1);
    }

    public static int convertingStringToInteger(String str, int index, int num) {
        if (index == str.length()) {
            return num;
        }
        char ch = str.charAt(index);
        num = (num * 10) + Character.getNumericValue(ch);
        return convertingStringToInteger(str, index + 1, num);
    }

    static void genParenthesisUtil(int n, int open, int close,
                                   String s, ArrayList<String> ans) {
        if (open == n && close == n) {
            ans.add(s);
            return;
        }
        if (open < n) {
            genParenthesisUtil(n, open + 1, close, s + "{", ans);
        }

        if (close < open) {
            genParenthesisUtil(n, open, close + 1, s + "}", ans);
        }
    }
    static ArrayList<String> AllParenthesis(int n) {

        // List for storing the answer
        ArrayList<String> ans = new ArrayList<>();
        if (n > 0) {
            genParenthesisUtil(n, 0, 0, "", ans);
        }
        return ans;
    }

    public static void reverseString(StringBuilder str){
         reverseStringHelper(str, new StringBuilder(""));
//         if(str == null){
//             return;
//         }
//         char ch = str.charAt(0);
//         reverseString(str);
//         resString += ch;
    }

    public static void reverseStringHelper(StringBuilder str, StringBuilder resString){
        if(str.toString().equals("".toString())){
            return;
        }

        char ch = str.charAt(0);
        str.deleteCharAt(0);
        reverseStringHelper(str, resString);
        resString.append(ch);
    }

    public static void removeAdjacentDuplicates(String str){
        HashSet<Character> hash = new HashSet<>();
        StringBuilder resultString = new StringBuilder("");
        removeAdjacentDuplicatesHelper(str, 0, resultString, hash);
        System.out.println(resultString);
    }

    public static void removeAdjacentDuplicatesHelper(String str, int index, StringBuilder resString, HashSet<Character> hash){
        if(index== str.length()){
            return;
        }
        char ch = str.charAt(index);
        if (!hash.contains(ch)) {
            hash.clear();
            resString.append(ch);
            hash.add(ch);
        }
        removeAdjacentDuplicatesHelper(str, index+1, resString, hash);
    }

    public static String reverseStringInSameString(String s) {
        if (s.isEmpty()) {
            return "";
        }
        String tempStr = s.substring(1);

        return reverseStringInSameString((tempStr)) + s.charAt(0);
    }

    public static boolean StringPalindrome(String str){
        StringBuilder firstHalf = StringPalindromeHelper(str, 0, new StringBuilder(""));
        String secondHalf = "";
        if(str.length() % 2 == 0){
            secondHalf = str.substring((str.length() / 2), str.length());
        }
        else{
            secondHalf = str.substring((str.length() / 2)+1, str.length());
        }

        if(secondHalf.equals(firstHalf.toString())){
            return true;
        }
        else{
            return false;
        }
    }

    public static StringBuilder StringPalindromeHelper(String str, int index, StringBuilder firstHalf){
        if(index == str.length()/2){
            return null;
        }
        char ch = str.charAt(index);
        StringPalindromeHelper(str, index+1, firstHalf);
        return firstHalf.append(ch);
    }

    public static void replaceOccurrencesOfCharacter(String str, char replace, char replaceWith){
        System.out.println(replaceOccurrencesOfCharacterHelper(str, replace, replaceWith, 0, new StringBuilder("")));
    }

    public static StringBuilder replaceOccurrencesOfCharacterHelper(String str, char replace, char replaceWith, int index, StringBuilder resString){
        if(index == str.length()){
            return null;
        }
        char ch = str.charAt(index);
        replaceOccurrencesOfCharacterHelper(str, replace, replaceWith, index+1, resString);
        if(ch == replace){
            return resString.insert(0, replaceWith);
        }
        else{
            return resString.insert(0, ch);
        }
    }

    public static boolean arraySorted(int[] arr, int index){
        if(index == arr.length){
            return true;
        }

        if(arr[index+1] < arr[index]){
            return false;
        }
        else{
            return arraySorted(arr, index+1);
        }
    }

    public static int firstOccurrencesOfElement(int[] arr, int element, int index){
        if(index == arr.length){
            return -1;
        }
        int data = arr[index];
        if(data == element){
            return index;
        }
        else {
            return firstOccurrencesOfElement(arr, element, index+1);
        }
    }

    public static int sumOfArrayNumbers(int[] arr, int index, int sum){
        if(index == arr.length){
            return sum;
        }
        return sumOfArrayNumbers(arr, index+1, sum += arr[index]);

    }

    public static int countZeroes(int[] arr, int index, int count){
        if(index == arr.length){
            return count;
        }
        if(arr[index] == 0){
            count++;
        }
        return countZeroes(arr, index+1, count);
    }

    public static void insertAtBottom(StackInIntArray stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
        } else {
            int data = stack.pop();
            insertAtBottom(stack, element);
            stack.push(data);
        }
    }

    public static void reverseStack(StackInIntArray stack){
         if(stack.isEmpty()){
            return;
        }
        int data = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, data);
    }

    public static void sortingStack(StackInIntArray stack){
        if(stack.isEmpty()){
            return;
        }
        int data = stack.pop();
        sortingStack(stack);
        sortingStackHelper(stack, data);
    }

    private static void sortingStackHelper(StackInIntArray stack, int element){
        if(stack.isEmpty()){
            stack.push(element);
        }
        else{
            if(stack.peek() > element){
                int temp = stack.pop();
                sortingStackHelper(stack, element);
                stack.push(temp);
            }
            else{
                stack.push(element);
            }
        }
    }

    public static void reverseQueue(QueueInLinkedList queue){
        if(queue.isEmptyQueue()){
            return;
        }
        int element = queue.deQueue();
        reverseQueue(queue);
        queue.enQueue(element);
    }

    public static void removeMiddleElementInStack(StackInIntArray stack){
        removeMiddleElementInStackHelper(stack, stack.size(), 0);
    }

    private static void removeMiddleElementInStackHelper(StackInIntArray stack, int length, int count){
        if(count == length/2){
            stack.pop();
            return;
        }
        int data = stack.pop();
        removeMiddleElementInStackHelper(stack, length, count+1);
        stack.push(data);
    }

    public static void isStackPalindrome(StackInIntArray stack){
        System.out.println(isStackPalindromeHelper(stack, 0, stack.size()));
    }

    private static boolean isStackPalindromeHelper(StackInIntArray stack, int count, int length){
        if(count == length/2){
            if(length % 2 == 0){
                return false;
            }
            else{
                stack.pop();
                return false;
            }
        }
        int data = stack.pop();
        isStackPalindromeHelper(stack, count+1, length);
        if(data != stack.peek()){
            return false;
        }
        stack.pop();
        return true;
    }

    public static void insertElementInFrontOfQueue(QueueInLinkedList queue, int element){
        QueueInLinkedList auxQueue = new QueueInLinkedList();
        insertElementInFrontOfQueueHelper(queue, element, auxQueue);
    }

    private static void insertElementInFrontOfQueueHelper(QueueInLinkedList queue, int element, QueueInLinkedList auxQueue) {
        if (queue.isEmptyQueue()) {
            queue.enQueue(element);
            return;
        }
        auxQueue.enQueue(queue.deQueue());
        insertElementInFrontOfQueueHelper(queue, element, auxQueue);
        if(auxQueue.isEmptyQueue()){
            return;
        }
        queue.enQueue(auxQueue.deQueue());
    }

    private static void moveFirstNodeToLast(QueueInLinkedList queue,int qSize){
        if(qSize <= 0){
            return;
        }
        queue.enQueue(queue.deQueue());
        moveFirstNodeToLast(queue, qSize-1);
    }

    public static void sortingAQueue(QueueInLinkedList queue){
        if(queue.isEmptyQueue()){
            return;
        }
        int data = queue.deQueue();
        sortingAQueue(queue);
        sortEachElement(queue, data, queue.queueSize());
    }

    private static void sortEachElement(QueueInLinkedList queue, int data, int qSize){
        if(queue.isEmptyQueue() || qSize == 0){
            queue.enQueue(data);
            return;
        }
        if(data < queue.front()){
            queue.enQueue(data);
            moveFirstNodeToLast(queue, qSize);
        }
        else{
            queue.enQueue(queue.deQueue());
            sortEachElement(queue, data, qSize-1);
        }
    }

    public static void removeBottomElementOfStack(StackInIntArray stack){
        if(stack.size() == 1){
            stack.pop();
            return;
        }
        int data = stack.pop();
        removeBottomElementOfStack(stack);
        stack.push(data);
    }

    public  static int fibonacciSeries(int n) {
        System.out.println(n);
        if (n==0 || n==1) {
            return n;
        }

        return fibonacciSeries(n-1) + fibonacciSeries(n-2);
    }

    public  static int fibonacciSeriesDPTopDown(int n, int[] arr) {
        if (arr[n] != -1) {
            System.out.println("Used the existing answer. " + n);
            return  arr[n];
        }
        System.out.println("Couldn't the existing answer. " + n);
        if (n==0 || n==1) {
            arr[n] = n;
            return n;
        }

        return arr[n] = fibonacciSeriesDPTopDown(n-1, arr) + fibonacciSeriesDPTopDown(n-2, arr);
    }

    public  static int fibonacciSeriesDPBottomUp(int n, int[] arr) {
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i<=n;i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }



}
