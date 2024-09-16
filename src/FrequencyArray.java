public class FrequencyArray {

    public void frequencyArray(int num) {
        int[] frequencyArray = new int[10];
        while(num > 0) {
            int mod = num % 10;
            frequencyArray[mod] += 1;
            num = num / 10;
        }
        for (int i = 0; i < frequencyArray.length; i++){
            if (frequencyArray[i]>0){
                System.out.println("The frequency of " + i + " is: " + frequencyArray[i]);
            }
        }
    }
    public void stringFrequencyArray(String word){
        int[] frequencyArray = new int[26];
        for(int i=0; i<word.length(); i++){
            char currentElement = word.charAt(i);
            frequencyArray[currentElement - 'a'] += 1;
        }
        for(int i = 0; i < frequencyArray.length; i++){
            if (frequencyArray[i] > 0){
                int charNum = 97+i;
                char ch = (char)charNum;
                System.out.println("The frequency of " + ch + " is: " + frequencyArray[i]);
            }
        }

    }

}
