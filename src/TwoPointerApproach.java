public class TwoPointerApproach {
    /**
     * Problem: Remove duplicates from a sorted array using the two pointer approach
     * Approach: Pointer b moves one step after every iteration and pointer a waits if the element is same.
     *           If the element a and b are not equal first move a and then copy the value of the b'th element into a and then b moves forward in next iteration
     *           In this way we get all the duplicate elements in the last of the array after the pointer a so to remove them we only traverse the array until the pointer a
     * @param arr
     */
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

    /**
     * Problem: Find out if the string is a palindrome using two pointer technique
     * Approach: Place one pointer at the start of the array and one at the end. If the two elements are same then move a forward and b backward. If at any point the value of a and b dont match instantly return False
     * @param str
     * @return
     */
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

    /**
     * Problem: Find two numbers in an sorted array whose sum is equal to the input
     * Approach: One pointer at the start of the array and one at the end. If the sum is greater than required then move b backwards and if the sum is less then move a forward until a crosses b or is equal
     * @param arr
     * @param sum
     */
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

    /**
     * Problem: Find the longest substring which contains at most k distinct characters
     * Approach: Handle 3 variables together which are maxLength, currentLength, and numberOfUniqueChar using freqArray. Move b forward after every iteration and a forward if unique exceeds k.
     *           The number of steps a moves forward is equal to the frequency of pointer a element. Keep comparing the max and current length at each step too
     * @param str
     * @param k
     */
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
                if (currentLength-1 > maxLength) {
                    maxLength = currentLength-1;
                }
                currentLength = currentLength - freqArray[x - 'a'];
                freqArray[x-'a'] = 0;
                uniqueCharacter --;
            }
        }
        if(currentLength > maxLength){
            maxLength = currentLength;
        }
        System.out.println(maxLength);
    }

    /**
     *Problem: Check if the function is a palindrome and if its not then make it a palindrome
     * @param str
     */
    public static void becomingPalindrome(String str) {
        int a = 0;
        int b = str.length() - 1;

        while (a < b){
            int x = str.charAt(a);
            int y = str.charAt(b);
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

    /**
     * Problem: Find the longest substring without the repeating of characters
     * Approach: Handle unique characters, max length and current length together. If unique character is greater than 1 then move the pointer a as many steps as its value in the freqArray
     *           Pointer b is moved one step ahead with every iteration. Compare maxlength and currentlength at every iteration too
     * @param str
     */
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

    /**
     * Problem: Move all the zeroes in the array to the end
     * Approach: Move pointer b with every iteration, if b=0 then keep moving it till we get a non-zero element then move a one step and switch both the elements
     * @param arr
     */
    public static void movingZeroesToTheEnd(int[] arr){
        int a = 0;
        int b = 0;
        int temp = 0;
        while(b != arr.length-1){
            b++;
            if(arr[b] == 0){
                while(arr[b] == 0){
                    b++;
                }
            }
            a++;
            temp = arr[b];
            arr[b] = arr[a];
            arr[a] = temp;
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    /**
     * Problem: Find the number of maximum consecutive ones in an array
     * Approach: Here we only need one pointer, if we get a 1 we increase the currentCount and compare it with the maxCount variable and keep moving forward until we keep getting ones, as soon as we dont get a 1 the loop breaks and the count is finalized
     * @param arr
     * @return
     */
    public static int maxConsecutiveOnes(int[] arr){
        int b = 0;
        int currentCounter = 0;
        int maxCounter = 0;
        if(arr.length == 1 && arr[0] == 1){
            return 1;
        }
            while(b != arr.length){
                if(arr[b] == 1){
                    currentCounter += 1;
                    if(currentCounter > maxCounter){
                        maxCounter = currentCounter;
                    }
                    if(arr[b+1] == 1){
                    while(arr[b] == 1) {
                        b++;
                        currentCounter += 1;
                        if (currentCounter - 1 > maxCounter) {
                            maxCounter = currentCounter - 1;
                        }
                        if(b==arr.length){
                            return maxCounter;
                        }
                    }
                    }
                }
                b++;
                currentCounter = 0;
            }
        return maxCounter;
        }

    /**
     * Problem: The array iven signifies the height of the lines starting from the x axis and every 2 lines represent a container which carries water. We have to find the container which carries the most water
     * Approach: We access every element of the array and find the area of the container between the two lines returning the maximum area, which will contain maximum water
     * @param arr
     * @return
     */
    public static int containerWithMostWater(int[] arr){
            float currentArea = 0;
            float maxArea = 0;
            int index = 0;
            for(int i= 1; i<arr.length; i++){
                currentArea = ((arr[i] + arr[i-1])*i)/2;
                if(currentArea > maxArea){
                    maxArea = currentArea;
                    index = i;
                }
            }
            return index;
        }
    }


