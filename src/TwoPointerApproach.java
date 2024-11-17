public class TwoPointerApproach {
    public static void removeDuplicates(int[] arr) {
        int a = 0;
        int b = 0;
        for (; b < arr.length; b++) {
            if (arr[a] != arr[b]) {
                a++;
                arr[a] = arr[b];
            }
        }
        for (int i = 0; i <= a; i++) {
            System.out.println(arr[i]);
        }
    }

    public static boolean isStringPalindrome(String str) {
        int a = 0;
        int b = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(a) != str.charAt(b)) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }

    public static void twoSum(int[] arr, int sum) {
        int a = 0;
        int b = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            int result = arr[a] + arr[b];
            if (result == sum) {
                System.out.println("a is " + arr[a] + " b is " + arr[b]);
                return;
            } else if (result < sum) {
                a++;
            } else if (result > sum) {
                b--;
            }
        }
        System.out.println("Not possible");
    }

    public static void zeroesToTheEnd(int[] arr) {
        int a = 0;
        int b = 0;
        int temp = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if(arr[i] == 0) {
                a = i;
                b = i;
                while (arr[i] == 0 && i <= arr.length - 1) {
                    b++;
                    i++;
                }
                temp = arr[a];
                arr[a] = arr[b];
                arr[b] = temp;
            }
//            } else if (arr[b] == 0) {
//                b++;
//                if (arr[b] != 0) {
//                    temp = arr[a];
//                    arr[a] = arr[b];
//                    arr[b] = temp;
//                    a++;
//                } else {
//                    b++;
//                }
//            } else {
//                temp = arr[b];
//                arr[b] = arr[a];
//                arr[a] = temp;
//            }
//            if (b > arr.length - 1) {
//                break;
//            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void longestSubstringOfk(String str, int k) {
        int maxLength = 0;
        int currentLength = 0;
        int uniqueCharacter = 0;
        int pointer1 = 0;
        int pointer2 = 0;

        int[] freqArray = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(pointer1);
            char y = str.charAt(pointer2);
            currentLength += 1;
            if (freqArray[y - 'a'] == 0) {
                uniqueCharacter += 1;
            }
            freqArray[y - 'a'] += 1;
            pointer2++;


            if (uniqueCharacter > k) {
                pointer1 = pointer1 + freqArray[x - 'a'];
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
        }
        System.out.println(maxLength);
    }

    public static void becomingPalindrome(String str) {
        int a = 0;
        int b = str.length() - 1;
        int x = str.charAt(a);
        int y = str.charAt(b);
        for (int i = 0; i < str.length(); i++) {
            if (x == y) {
                a++;
                b--;
            } else {
                b--;
                if (x == y) {
                    a++;
                    b--;
                }
            }
        }
    }

    public static void longestSubstring(String str) {
        int a = 0;
        int b = 0;
        int x = str.charAt(a);
        int y = str.charAt(b);
        int currentLength = 0;
        int maxLength = 0;
        int uniqueCharacter = 0;
        int[] freqArray = new int[26];
        for (int i = 0; i < str.length(); i++) {
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
            if (a != b) {
                a++;
                b++;
                uniqueCharacter += 1;
                currentLength += 1;
                freqArray[y] += 1;
            } else {
                b++;
                currentLength += 1;
                if (freqArray[y] == 0) {
                    uniqueCharacter += 1;
                }
                freqArray[y] += 1;
            }
            if (uniqueCharacter > 1) {
                a = a + freqArray[x];
            }
        }
    }
}

