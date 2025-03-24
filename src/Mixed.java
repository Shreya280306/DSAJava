import java.util.Arrays;
import java.util.Collections;

public class Mixed {
    public static int[] freqArrayOfNum(int num) {
        int[] freqArray = new int[10];
        int mod = 0;
        while (num > 0) {
            mod = num % 10;
            freqArray[mod] += 1;
            num = num / 10;
        }
        return freqArray;
    }

    public static int[] freqArrayOfWord(String word) {
        int[] freqArray = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int x = (char) ch - 97;
            freqArray[x] += 1;
        }
        return freqArray;
    }

    public static int numberOfSubstringsWithKDifferentCharacters(String str, int k) {
        int count = 0;
        int distinct = 0;
        int a = 0;
        int b = 0;
        int[] freqArray = new int[26];
        while (b != str.length() - 1) {
            if (distinct <= k) {
                if (freqArray[b] == 0) {
                    distinct++;
                }

                char ch = str.charAt(b);
                int x = (char) ch - 97;
                freqArray[x] += 1;
                b++;
            }
            if (distinct > k) {
                count++;
                Arrays.fill(freqArray, 0);
                a++;
                b = a;
            }
        }
        return count;
    }

    //Two pointer approach
    public static void removeDuplicatesFromSortedArray(int[] arr) {
        int a = 0;
        int b = 0;
        while (b != arr.length - 1) {
            if (arr[a] == arr[b]) {
                b++;
            } else {
                a++;
                arr[a] = arr[b];
            }
        }
        for (int i = 0; i <= a; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void moveZeroesToTheEnd(int[] arr) {
        int a = 0;
        int b = 0;
        int temp = 0;
        while (b != arr.length - 1) {
            if (arr[b] == 0) {
                int index = 0;
                while (arr[b] == 0) {
                    b++;
                    index++;
                }
                if (index != 1) {
                    if (arr[b] != 0) {
                        if (arr[0] != 0) {
                            a++;
                            temp = arr[a];
                            arr[a] = arr[b];
                            arr[b] = temp;
                        } else {
                            temp = arr[a];
                            arr[a] = arr[b];
                            arr[b] = temp;
                        }
                    }
                } else {
                    temp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = temp;
                }
            } else {
                a++;
                b++;
            }
        }
        for (int i = 0; i <= a; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int fruitsInBasket(int[] arr) {
        int a = 0;
        int b = 0;
        int[] freqArray = new int[10];
        int unique = 0;
        int count = 0;
        int maxCount = 0;
        while (b != arr.length) {
            if (b == arr.length - 1) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
                break;
            }
            freqArray[arr[b]] += 1;
            if (freqArray[arr[b]] == 1) {
                unique++;
            }
            if (unique == 3) {
                a++;
                unique = 0;
                Arrays.fill(freqArray, 0);
                b = a;
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 0;
                continue;
            }
            count++;
            b++;
        }

        return maxCount;
    }

//Binary Search in Arrays
    public static boolean findingElementUsingBinarySearch(int[]arr, int element){
        int start = 0;
        int end = arr.length-1;
        int mid = (start+end)/2;
        boolean found = false;
        while(start <= end){
            if(element == arr[start] || element == arr[mid] || element == arr[end]){
                found = true;
                return found;
            }
            if(element > arr[start] && element < arr[mid]){
                end = mid-1;
                mid = (start+end)/2;
            }
            if(element > arr[mid] && element < arr[end]){
                start = mid+1;
                mid = (start+end)/2;
            }
        }
        return found;
    }

    public static int findingSquareRoot(int num){
        int start = 0;
        int end = num/2;
        int mid = (start+end)/2;
    while(start<end) {
        if (num == mid * mid) {
            return mid;
        } else if (num < mid * mid) {
            end = mid - 1;
            mid = (start + end) / 2;
        } else {
            start = mid + 1;
            mid = (start + end) / 2;
        }
    }
        return mid;
    }

    public static int findingMissingNumber(int[]arr){
        int start = 0;
        int end = arr.length-1;
        int mid = (start+end)/2;

        while(start < end){
            if(arr[mid] - arr[mid-1] > 1){
                return arr[mid]-1;
            }
            if(arr[mid+1] - arr[mid] > 1){
                return arr[mid]+1;
            }
            if(arr[mid] - arr[start] == mid+1){
                start = mid+1;
                mid = (start + end)/2;
            }
            else{
                end = mid-1;
                mid = (start+end)/2;
            }
        }
        return mid+1;
    }

}