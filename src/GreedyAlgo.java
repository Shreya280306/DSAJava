import com.sun.source.tree.Tree;

import java.sql.Array;
import java.util.*;
import java.util.Arrays;
public class GreedyAlgo {
    public static int fractionalKnapsack(int[] units, int[] weight, int totalWeight) {
        int weightCount = 0;
        int unitCount = 0;
        int weightRemaining = 0;
        Integer[] average = new Integer[units.length];
        for (int i = 0; i < average.length; i++) {
            average[i] = units[i] / weight[i];
        }
        Arrays.sort(average, Collections.reverseOrder());
        for (int i = 0; i < average.length; i++) {
            weightRemaining = totalWeight - weightCount;
            if (weight[i] > weightRemaining) {
                unitCount = unitCount + ((weightRemaining * units[i]) / weight[i]);
                break;
            }
            if (weightCount < totalWeight) {
                weightCount += weight[i];
                unitCount += units[i];
            }
        }
        return unitCount;
    }

    public static int minCostToMakeArray1(int[] arr) {
        int smallest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest * arr.length;
    }

    public static int smallestSubsetSumGreaterThanOthers(Integer[] arr) {
        int subSum = 0;
        int i = 0;
        int restSum = 0;
        for (int count = 0; count < arr.length; count++) {
            restSum += arr[count];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        while (subSum < restSum) {
            subSum += arr[i];
            restSum -= arr[i];
            i++;
        }
        return i;
    }

    public static int assignCookies(int[] greed, int[] cookies) {
        Arrays.sort(greed);
        Arrays.sort(cookies);
        int greedSum = 0;
        int cookieSum = 0;
        for (int count = 0; count < greed.length; count++) {
            greedSum += greed[count];
        }
        for (int count = 0; count < cookies.length; count++) {
            cookieSum += cookies[count];
        }
        if (cookieSum > greedSum) {
            return greed.length;
        }
        if (greed[0] > cookieSum) {
            return 0;
        }
        int cookiePointer = 0;
        int greedPointer = 0;
        int children = 0;
        int i = 0;
        while (cookiePointer != (cookies.length)) {
            if (cookies[cookiePointer] < greed[greedPointer]) {
                cookiePointer++;
                continue;
            }
            if (cookies[cookiePointer] >= greed[greedPointer]) {
                children++;
                greedPointer++;
                cookiePointer++;
            }
        }
        return children;
    }

    public static int maxStocks(int[] prices, int moneyInHand, int numberOfDays) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            hashmap.put(prices[i], i + 1);
        }
        TreeMap<Integer, Integer> sorted = new TreeMap<>(hashmap);
        for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) { //Sorting both the keys and the values of the hashmap
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        int moneyLeft = moneyInHand;
        int count = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            int result = key * value;
            if (result > moneyLeft) {
                while (moneyLeft >= key) {
                    count += 1;
                    moneyLeft = moneyLeft - key;
                    sum += key;
                }
                break;
            }
            sum += result;
            count += value;
            moneyLeft = moneyLeft - result;
        }
        return count;
    }

    public static int minimumRotationsOfCircularLock(int input, int code) {
        int rotation = 0;
        while (input > 0) {
            int inputDigit = input % 10;
            int codeDigit = code % 10;
            int val1 = Math.abs(inputDigit - codeDigit);
            int val2 = 10 - val1;
            rotation += Math.min(val1, val2);
            input = input / 10;
            code = code / 10;
        }
        return rotation;
    }

    public static int maxSumOfConsecutiveDiffWithRearrangement(int[] arr) {
        Arrays.sort(arr);
        int a = 0;
        int b = arr.length - 1;
        ArrayList<Integer> arraylist = new ArrayList<>();
        while (a < b) {
            arraylist.add(arr[a]);
            arraylist.add(arr[b]);
            a++;
            b--;
        }
        int maxDiff = arraylist.get(arr.length - 1) - arraylist.get(0);
        for (int i = 0; i < arr.length - 1; i++) {
            maxDiff += Math.abs(arraylist.get(i + 1) - arraylist.get(i));
        }
        return maxDiff;
    }

    public static int minCostToBuyAll(int[] prices, int k) {
        Arrays.sort(prices);
        int a = 0;
        int b = prices.length - 1;
        int cost = 0;
        while (a <= b) {
            cost += prices[a];
            a++;
            b = b - k;
        }
        return cost;
    }

    public static int minNumberOfCurrencyNotesAndValues(int amount) {
        int[] noteValues = {2000, 500, 200, 100, 50, 20, 10, 5, 1};
        int count = 0;
        for (int i = 0; i < noteValues.length; i++) {
            if (amount < noteValues[i]) {
                continue;
            }
            if (amount > noteValues[i]) {
                while (amount > noteValues[i]) {
                    amount = amount - noteValues[i];
                    count += 1;
                }
            }
            if (amount == noteValues[i]) {
                count++;
                break;
            }
        }
        return count;
    }

    public static int maxConsecutiveSum(int num) {
        int quotient = num / 4;
        int remainder = num % 4;
        int count = quotient;
        if (remainder == 1) {
            return (count - 1);
        }
        if (remainder == 3) {
            return (count - 1);
        }
        return count;
    }

    public static List<int[]> sortingTwoArraysWithLinkIntact(int[] first, int[] second){
        List<int[]> list = new ArrayList<>();
        //Forms a list of arrays which has first index as the one according to which its being sorted and the second index as the mapped element
        for(int i=0; i<first.length; i++){
            list.add(new int[]{first[i], second[i]});
        }
        int temp = 0;
        int temp1 = 0;
        for(int i=0; i<list.size()-1; i++){
            for(int j=0; j < list.size()-i-1; j++) {
                if(list.get(j)[0] > list.get(j+1)[0]){
                    temp = list.get(j)[0];
                    list.get(j)[0] = list.get(j+1)[0];
                    list.get(j+1)[0] = temp;
                    temp1 = list.get(j)[1];
                    list.get(j)[1] = list.get(j+1)[1];
                    list.get(j+1)[1] = temp1;
                }
            }
        }
        return list;
    }

    public static int activitySelection(int[]start, int[]end){
        List<int[]> list = new ArrayList<>();
        list = sortingTwoArraysWithLinkIntact(end, start);
        int storeEnd = list.get(0)[0];
        int count = 1;
        for(int i=1; i<list.size(); i++){
            if(storeEnd < list.get(i)[1]){
                count++;
                storeEnd = list.get(i)[0];
            }
        }
        return count;
    }

    public static int findingMaxInArrayList(ArrayList<Integer> list){
        int max = list.get(0);
        int maxIndex = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) > max){
                max = list.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public static int minimumJumps(int[]arr){
        int current = 0;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(current < arr.length){
            for(int value=1; value <= arr[current]; value++){
                if(current+value >= arr.length){
                    count ++;
                    return count;
                }
                list.add(arr[current+value] + value);
            }
                int jumps = findingMaxInArrayList(list);
                current += jumps + 1;
            count++;
            list.clear();
        }
        return count;
    }

    public static ArrayList<Integer> mergeOverlappingIntervals(int[][] arr){
        int temp;
        int temp1;
        ArrayList<Integer> resultList = new ArrayList<>();
        //Sorting the array on the basis of their 0th index
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j < arr.length-i-1; j++) {
                if (arr[j][0] > arr[j + 1][0]) {
                    temp = arr[j][0];
                    arr[j][0] = arr[j + 1][0];
                    arr[j + 1][0] = temp;
                    temp1 = arr[j][1];
                    arr[j][1] = arr[j+1][1];
                    arr[j + 1][1] = temp1;
                }
            }
        }
        for(int i=1; i<arr.length; i++){
                if(arr[i][0] > (arr[0][0]) && arr[i][0] < (arr[0][1]) && arr[0][1] > arr[i][1]){
                    resultList.add(arr[0][0]);
                    resultList.add(arr[0][1]);
                }
                else if(arr[i][0] > (arr[0][0]) && arr[i][0] < (arr[0][1]) && arr[0][1] < arr[i][1]){
                    resultList.add(arr[0][0]);
                    resultList.add(arr[i][1]);
                }
                else{
                    resultList.add(arr[i][0]);
                    resultList.add(arr[i][1]);
                }

        }
        return resultList;
    }

    public static int accessingFibSeriesBiggestNumber(int num, ArrayList<Integer> fib){ //helper function for next question
        //getting the fibonacci series upto a particular element
        int max = 0;
        for(int i=0; fib.get(i) <= num; i++){
            int x = fib.get(i);
            if(x > max){
                max = x;
            }
        }
        return max;
    }

    public static int accessingMinFibonacciTermsForSumK(int k){
        int a = 0;
        int b = 1;
        int result;
        int count = 1;
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(a);
        fib.add(b);
        while(b < k){
            result = a+b;
            fib.add(result);
            a = b;
            b = result;
        }
        while(k!= 3) {
            int x = accessingFibSeriesBiggestNumber(k, fib);
            if (fib.contains(k)) {
                return count;
            }
            if(k == 1){
                return count+1;
            }
            else {
                k = k - x;
                count++;
            }
        }
        return -1;
    }

    public static int calculatingSmallestNumber(ArrayList<Integer> arr){ //helper function for next question
        int min = arr.get(0);
        for(int i=0; i<arr.size(); i++){
            if(min > arr.get(i) && arr.get(i) != 0){
                min = arr.get(i);
            }
        }
        return min;
    }

    public static int minimumCostForCuttingRopes(int[] arr){
        //Converting this array into an arraylist
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i=0; i<arr.length; i++){
//            list.add(arr[i]);
//        }
//        int cost = 0;
//        int smallest = 0;
//        int secondSmallest = 0;
//        while(list.size() != 1){
//            smallest = calculatingSmallestNumber(list);
//            list.remove(smallest);
//            secondSmallest = calculatingSmallestNumber(list);
//            list.remove(secondSmallest);
//            cost = cost + smallest + secondSmallest;
//        }
//        return cost;

        Arrays.sort(arr);
        int cost = 0;
        for(int i=0; i<arr.length-2; i++){
            cost += arr[i] + arr[i+1];
            i++;
        }
        return cost;
    }

    public static List<int[]> mergingOverlappingIntervals(List<int[]> inputList){
        List<int[]> outputList = new ArrayList<>();
        int start = inputList.get(0)[0];
        int end = inputList.get(0)[1];
        int i=1;
        while(i<inputList.size()){
            if(inputList.get(i)[0] > start && inputList.get(i)[0] < end && inputList.get(i)[1] < end) {
                outputList.add(new int[]{start, end});
                i++;
                if (i < inputList.size()) {
                    start = inputList.get(i)[0];
                    end = inputList.get(i)[1];
                }
            }
            else if(inputList.get(i)[0] > start && inputList.get(i)[0] < end && inputList.get(i)[1] > end){
                end = inputList.get(i)[1];
                outputList.add(new int[]{start, end});
                i++;
                if(i < inputList.size()) {
                    start = inputList.get(i)[0];
                    end = inputList.get(i)[1];
                }
            }
            else{
                i++;
            }
        }
        return outputList;
    }

    public static void jobSequencingProblem(int[] deadline, int[] profit){
        List<int[]> list = sortingTwoArraysWithLinkIntact(deadline, profit);
        int amountEarned = 0;
        int numberOfJobs = 0;
        for(int i=0; i<list.size()-1; i++){ //this condition will not always work if we have multiple same first terms
            if(list.get(i)[0] == list.get(i+1)[0]){
                numberOfJobs += 1;
                int max = list.get(0)[1];
                int j = 0;
                while(list.get(j)[0] == list.get(j+1)[0]){
                    if(list.get(j)[1] > max){
                        max = list.get(j)[1];
                    }
                    j++;
                }
                amountEarned += max;
                i = i+j-1;
            }
            else if(list.get(i)[0] < list.get(i+1)[0]){
                numberOfJobs += 1;
                amountEarned += list.get(i+1)[1];
            }
        }
        System.out.println("Number of Jobs: " + numberOfJobs);
        System.out.println("Amount Earned: " + amountEarned);
    }

    public static ArrayList<Integer> minCostForCuttingRopes(int[] arr){
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            list.add(arr[i]);
        }
        int length = arr.length;
        int sum = 0;
        while(length != 1){
            sum = list.get(0) + list.get(1);
            ArrayList<Integer> tempList = new ArrayList<>();
            tempList.add(sum);
            list.remove(0);
            list.remove(0);
            length = length-2;
            for(int i=0; i<length; i++){
                tempList.add(list.get(i));
            }
            length++;
            list = tempList;
        }
        return list;
    }

    public static void divide1ToNInto2GroupsWithMinDifference(int n){
        //First finding the sum
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        int sumOfGroup = sum/2;

        ArrayList<Integer> group1 = new ArrayList<>();
        ArrayList<Integer> group2 = new ArrayList<>();
        //Dividing into two groups such that their max difference is 1
        //We need to start the loop in reverse otherwise all the greater elements will go in the second loop and smaller in the first but this way it has to filter at each step
        for(int i = n; i > 0; i--){
            if(sumOfGroup - i >= 0){
                group1.add(i);
                sumOfGroup = sumOfGroup-i;
            }
            else{
                group2.add(i);
            }
        }
        //Printing out the groups
        System.out.println("Group1: ");
        for(int i=0; i<group1.size(); i++){
            System.out.println(group1.get(i));
        }
        System.out.println("Group2: ");
        for(int i=0; i<group2.size(); i++){
            System.out.println(group2.get(i));
        }
    }

//    public static void cuttingPaperIntoMinNumberOfSquares(int length, int breadth){
//        int sq = Math.min(length, breadth);
//        int subtract = Math.abs(length-breadth);
//        int count = 1;
//        while(subtract != 1){
//            subtract = Math.abs(length-breadth);
//            breadth = length;
//            length = subtract;
//            count++;
//        }
//    }

    public static int minDiffBetwGroupsOf2(int[] arr){
        Arrays.sort(arr);
        int a = 0;
        int b = arr.length-1;
        int sum1 = arr[a] + arr[b];
        while(a != b && a < b){
            a++;
            b--;
        }
        int sum2 = arr[a] + arr[b];
        return Math.abs(sum2-sum1);
    }

    public static int maxCustomersSatisfiedWithGivenQuantity(int a, int b, int n, int d, List<int[]> variety){
        ArrayList<Integer> demand = new ArrayList<>();
        for(int i=0; i<variety.size(); i++){
            int sum = (variety.get(i)[0]) * a + (variety.get(i)[1]) * b;
            demand.add(sum);
        }
        Collections.sort(demand);
        int quantLeft = d;
        int count = 0;
        for(int i=0; quantLeft > 0; i++){
            quantLeft = quantLeft - demand.get(i);
            if(quantLeft < 0){
                return count;
            }
            count++;
        }
        return count;
    }

    public static String largestPalindromicNumber(int num){
        int[] freqArray = new int[10];
        while (num > 0) {
            int mod = num % 10;
            freqArray[mod] += 1;
            num = num / 10;
        }
        int numberOfOnes = 0;
        for(int i=0; i<freqArray.length; i++){
            if(freqArray[i] == 1){
                numberOfOnes += 1;
            }
            else if(freqArray[i] == 2 || freqArray[i] == 0){
                continue;
            }
            else{
                return "Cannot form a palindrome";
            }
        }
        if(numberOfOnes > 1){
            return "Cannot form a palindrome";
        }

        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        int freqOne = 0;
        for(int i=0; i<freqArray.length; i++){
            if(freqArray[i] == 2){
                listOfNumbers.add(i);
            }
            if(freqArray[i] == 1){
                freqOne = i;
            }
        }
        Collections.reverse(listOfNumbers);
        String str = "";
        for(int i=0; i<listOfNumbers.size(); i++){
            str += listOfNumbers.get(i);
        }
        String revString = new StringBuilder(str).reverse().toString();
        String palindrome = str + freqOne + revString;
        return palindrome;
    }

    public static String lexicographicallyLargestSubsequenceWithMinKCharacters(String str, int k){
        int[] freqArray = new int[26];
        String resultStr = "";
        //Creating the frequency array
        for (int i = 0; i < str.length(); i++) {
            char currentElement = str.charAt(i);
            freqArray[currentElement - 'a'] += 1;
        }

        for(int i = 25; i >= 0; i--){
            char letter = (char) (i+97);
            if(freqArray[i] >= k){
                for(int j = 0; j <= k; j++){
                    resultStr = resultStr + letter;
                }
            }
        }
        return resultStr;
    }

    public static int minNumberOfPlatformsRequired(int[] arrival, int[] departure){
        Arrays.sort(arrival);
        Arrays.sort(departure);
        List<int[]> list = new ArrayList<>();
        int a = 0;
        int b = 0;
        while (a < arrival.length && b < departure.length) {
            //We mark 1 for arrival and 0 for departure
            if(arrival[a] < departure[b]){
                int[] arr = {1, arrival[a]};
                list.add(arr);
                    a++;
            }
            else {
                int[] dep = {0, departure[b]};
                list.add(dep);
                    b++;
            }
        }

        if(b == departure.length && a != arrival.length){
            while(a != arrival.length){
                int[] arr = {1, arrival[a]};
                list.add(arr);
                a++;
            }
        }
        else if(a == arrival.length && b!= departure.length){
            while(b != departure.length){
                int[] arr = {0, departure[b]};
                list.add(arr);
                b++;
            }
        }
        int count = 0;
        int maxCount = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i)[0] == 1){
                count++;
            }
            else{
                count--;
            }
            if(count > maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }

    /**
     * We first create a class called cell which has three variables- the value and the 2 coordinates
     * Then create a list with all these cells which need to be sort but we write our own sorting algorithm for this which means we have to define a seperate class telling it which values to be comparing
     * Then create a new boolean matrix and initialize all those values to false which we will make true as and when it is traversed
     * Now traverse each element in the list which is a cell using the depth first search function
     * dfs function- lengthwise first and then breadthwise checks for 3 conditions- if the cell in the adjacent location exists, if its been visited before and if it can be traversed to according to the question's conditions
     * Then apply a loop to traverse each cell and apply dfs to each cell
     * @param n
     * @param m
     * @param visit
     * @param adj
     * @param N
     * @param M
     */
    private static void dfs(int n, int m, Boolean[][]visit, int[][]adj, int N, int M){
        //helper function will be used below
        visit[n][m] = true;
        if(n+1 < N && !visit[n+1][m] && adj[n][m] >= adj[n+1][m]){
            dfs(n+1, m, visit, adj, N, M);
        }
        if(m+1 < M && !visit[n][m+1] && adj[n][m] >= adj[n][m+1]){
            dfs(n, m+1, visit, adj, N, M);
        }
        if(n-1 >= 0 && !visit[n-1][m] && adj[n][m] >= adj[n-1][m]){
            dfs(n-1, m, visit, adj, N, M);
        }
        if(m-1 >= 0 && !visit[n][m-1] && adj[n][m] >= adj[n][m-1]){
            dfs(n, m-1, visit, adj, N, M);
        }
    }
    public static void printMinSources(int[][]adj, int N, int M){
        LinkedList<Cell> x = new LinkedList<Cell>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                x.add(new Cell(adj[i][j], i, j));
            }
        }
        Collections.sort(x, new CellComparer());// defining my own sorting algorithm
        Boolean[][] visit = new Boolean[N][M];
        //initializing the matrix values to false
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visit[i][j] = false;
            }
        }
        //Applying the df function for each vertex in the matrix
        for(int i=0; i<x.size(); i++){
            if(!visit[x.get(i).i][x.get(i).j]){
                System.out.printf("%d %d\n", x.get(i).i, x.get(i).j);
                dfs(x.get(i).i, x.get(i).j, visit, adj, N, M);
            }
        }
    }
}
class CellComparer implements Comparator<Cell>{
    public int compare(Cell a, Cell b){
        return b.value-a.value;
    }
}

class Cell{
    public int value, i, j;
    public Cell(int value,int i,int j){
        this.value = value;
        this.i = i;
        this.j = j;
    }
}


