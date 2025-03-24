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

    public static int coinChange(int[] coins, int n, int sum){
        if(sum == 0){
            return 1;
        }
        if(sum < 0 || n == 0){
            return 0;
        }

        return coinChange(coins, n, sum-coins[n-1]) + coinChange(coins, n-1, sum);
    }

    public static void deletingALinkedList(SLL list, SLL_Node current){
        if(current == null){
            return;
        }

        if(current.next == null){
            list.removeNodeFromStart();
        }
        else {
            list.deleteNodePassed(current);
            deletingALinkedList(list, current.next);
        }
    }
}







