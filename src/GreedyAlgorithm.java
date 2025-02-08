import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;
public class GreedyAlgorithm {
    public int fractionalKnapsack(int[] units, int[] weight, int totalWeight){
        int weightCount = 0;
        int unitCount = 0;
        int weightRemaining = 0;
        Integer[] average = new Integer[units.length];
        for(int i=0; i < average.length; i++){
            average[i] = units[i]/weight[i];
        }
        Arrays.sort(average, Collections.reverseOrder());
        for(int i=0; i<average.length; i++){
            weightRemaining = totalWeight-weightCount;
            if(weight[i] > weightRemaining){
                unitCount = unitCount + ((weightRemaining * units[i])/weight[i]);
                break;
            }
            if(weightCount < totalWeight){
                weightCount += weight[i];
                unitCount += units[i];
            }
        }
        return unitCount;
    }

    public static int minCostToMakeArray1(int[] arr){
        int smallest = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i] < smallest){
                smallest = arr[i];
            }
        }
        return smallest* arr.length;
    }

    public static int smallestSubsetSumGreaterThanOthers(Integer[] arr){
        int subSum = 0;
        int i=0;
        int restSum = 0;
        for(int count=0; count<arr.length; count++){
            restSum += arr[count];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        while(subSum < restSum) {
            subSum += arr[i];
            restSum -= arr[i];
            i++;
        }
        return i;
    }

    public static int assignCookies(int[] greed, int[] cookies){
        Arrays.sort(greed);
        Arrays.sort(cookies);
        int greedSum = 0;
        int cookieSum = 0;
        for(int count = 0; count<greed.length; count++){
            greedSum += greed[count];
        }
        for(int count = 0; count<cookies.length; count++){
            cookieSum += cookies[count];
        }
        if(cookieSum > greedSum){
            return greed.length;
        }
        if(greed[0] > cookieSum){
            return 0;
        }
        int cookiePointer = 0;
        int greedPointer = 0;
        int children = 0;
        int i=0;
        while(cookiePointer != (cookies.length)){
            if(cookies[cookiePointer] < greed[greedPointer]){
                cookiePointer++;
                continue;
            }
            if(cookies[cookiePointer] >= greed[greedPointer]){
                children++;
                greedPointer++;
                cookiePointer++;
            }
        }
        return children;
    }

    public static int maxStocks(int[] prices, int moneyInHand, int numberOfDays){
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0; i<prices.length; i++){
            hashmap.put(prices[i], i+1);
        }
        TreeMap<Integer, Integer> sorted = new TreeMap<>(hashmap);
        for(Map.Entry<Integer, Integer> entry: sorted.entrySet()){ //Sorting both the keys and the values of the hashmap
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        int moneyLeft = moneyInHand;
        int count = 0;
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : sorted.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            int result = key*value;
            if(result > moneyLeft) {
                while (moneyLeft >= key) {
                    count += 1;
                    moneyLeft = moneyLeft - key;
                    sum += key;
                }
                break;
            }
            sum += result;
            count += value;
            moneyLeft = moneyLeft-result;
        }
        return count;
    }

    public static int minimumRotationsOfCircularLock(int input, int code){
        int rotation = 0;
        while(input > 0){
            int inputDigit = input % 10;
            int codeDigit = code % 10;
            int val1 = Math.abs(inputDigit-codeDigit);
            int val2 = 10 - val1;
            rotation += Math.min(val1, val2);
            input = input/10;
            code = code/10;
        }
        return rotation;
    }

    public static int maxSumOfConsecutiveDiffWithRearrangement(int[] arr){
        Arrays.sort(arr);
        HashSet<Integer> newArr = new HashSet<>();
        int a = 0;
        int b = arr.length-1;
        while(a < b){
            newArr.add(arr[a]);
            newArr.add(arr[b]);
            a++;
            b--;
        }
        int maxDiff = 0;
        for(int i=0; i<arr.length; i++){
            maxDiff += Math.abs(arr[i+1] - arr[i]);
        }
        return maxDiff;
    }

    public static int minCostToBuyAll(int[] prices, int k){
        Arrays.sort(prices);
        int a = 0;
        int b = prices.length-1;
        int cost = 0;
        while(a < b){
            cost += prices[a];
            a++;
            b = b-k;
        }
        return cost;
    }

    public static int minNumberOfCurrencyNotesAndValues(int amount){
        int[] noteValues = {2000, 500, 200, 100, 50, 20, 10, 5, 1};
        int count = 0;
        for(int i=0; i<noteValues.length; i++){
            if(amount < noteValues[i]){
                continue;
            }
            if(amount > noteValues[i]){
                while(amount > noteValues[i]){
                    amount = amount - noteValues[i];
                    count += 1;
                }
            }
        }
        return count;
    }
}
