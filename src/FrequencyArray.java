public class FrequencyArray {

    public void frequencyArray(int num) {
        int[] frequencyArray = new int[10];
        while (num > 0) {
            int mod = num % 10;
            frequencyArray[mod] += 1;
            num = num / 10;
        }
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {
                System.out.println("The frequency of " + i + " is: " + frequencyArray[i]);
            }
        }
    }

    public void stringFrequencyArray(String word) {
        int[] frequencyArray = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char currentElement = word.charAt(i);
            frequencyArray[currentElement - 'a'] += 1;
        }
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {
                int charNum = 97 + i;
                char ch = (char) charNum;
                System.out.println("The frequency of " + ch + " is: " + frequencyArray[i]);
            }
        }
    }

    public static int[] frequencyArr(int num) {
        int[] arr = new int[10];
        while (num > 0) {
            int mod = num % 10;
            arr[mod] += 1;
            num = num / 10;
        }
        return arr;
    }

    public static int[] charFrequencyArray(String word) {
        int[] frequencyArray = new int[3];
        for (int i = 0; i < word.length(); i++) {
            char currentElement = word.charAt(i);
            frequencyArray[currentElement - 'a'] += 1;
        }
        return frequencyArray;
    }
    public static int[] charFreqArrGreaterThanZero(String word) {
        int[] x = charFrequencyArray(word);
        int[] elementsWithoutZero = new int[6];
        for (int i = 0; i < word.length(); i++) {
            if (x[i] > 0) {
                elementsWithoutZero[i] = x[i];
                }
            }
        return elementsWithoutZero;
    }

    public static boolean ifTwoStringsAreAnagrams() {
        int[] x1 = charFrequencyArray("awestaw");
        int[] x2 = charFrequencyArray("sewwaa");
        if (x1.length != x2.length) {
            return false;
        }
        for (int i = 0; i < x1.length; i++) {
            if (x1[i] != x2[i]) {
                return false;
            }
        }
        return true;
    }

    public static char firstNonRepeatingChar() {
        int[] x = charFrequencyArray("awedweda");
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 1) {
                int val = 97+i;
                char ch = (char)val;
                return ch;
            }
        }
        return '0';
    }

    public static boolean isStringPalindromePermutation(String str){
        int[] x = charFreqArrGreaterThanZero(str);
        if ((str.length()%2) == 0){
            for (int i=0; i<str.length(); i++){
                if (x[i] != 2){
                    return false;
                }
                return true;
            }
        }
        else{
            for (int i=0; i<str.length(); i++){
                if (str.charAt(str.length()/2) != 1){
                    return false;
                }
                if (str.charAt(i) != 2){
                    return false;
                }
            }
            return true;
        }
        return true;
    }

}
