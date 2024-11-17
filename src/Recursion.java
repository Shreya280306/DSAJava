public class Recursion {
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
        int x = sumWithRecursion(n - 1, sum);
        return x;
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
        }
        else{
            return counter;
        }
    }
}
