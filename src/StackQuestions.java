
public class StackQuestions {

    public static void printStackData(StackInIntArray stack){
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    public static boolean balancingOfSymbols(String str) {
        StackInCharArray stack = new StackInCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ']' || str.charAt(i) == '}' || str.charAt(i) == ')') {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public static int postfixEvaluation(String str) {
        StackInIntArray stack = new StackInIntArray();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                int op1 = stack.pop();
                int op2 = stack.pop();
                if (str.charAt(i) == '+') {
                    stack.push(op1 + op2);
                } else if (str.charAt(i) == '-') {
                    stack.push(op2 - op1);
                } else if (str.charAt(i) == '*') {
                    stack.push(op1 * op2);
                } else if (str.charAt(i) == '/') {
                    stack.push(op2 / op1);
                }
            } else {
                stack.push(Character.getNumericValue(str.charAt(i)));
            }
        }
        return stack.pop();
    }

    private static int precedence(char ch) {
        if (ch == '^') return 3;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '+' || ch == '-') return 1;
        else return -1;
    }

    public static String infixToPostfix(String str) {
        StackInCharArray stack = new StackInCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                result.append(str.charAt(i));
            } else if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else { //operator
                if (!stack.isEmpty() && precedence(str.charAt(i)) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(str.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static String prefixToInfix(String str){
        StackInStringArray stack = new StackInStringArray();
        for(int i=(str.length())-1; i>=0; i--){
            String eachChar = str.charAt(i) + "";
            if(Character.isLetterOrDigit(str.charAt(i))){
                stack.push(eachChar);
            }
            else{//operator
                String ch1 = stack.pop();
                String ch2 = stack.pop();
                String temp = '(' + ch1 + eachChar + ch2 + ')';
                stack.push(temp);
            }
        }
       return stack.pop();
    }

    public static String postfixToInfix(String str){
        StackInStringArray stack = new StackInStringArray();
        for(int i=0; i<str.length(); i++){
            String eachChar = str.charAt(i) + "";
            if(Character.isLetterOrDigit(str.charAt(i))){
                stack.push(eachChar);
            }
            else{//operator
                String ch1 = stack.pop();
                String ch2 = stack.pop();
                String temp = '(' + ch1 + eachChar + ch2 + ')';
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    public static String infixToPrefix(String str){
        StackInCharArray stack = new StackInCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = (str.length())-1; i >= 0; i--) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                result.insert(0,str.charAt(i));
            } else if (str.charAt(i) == ')') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    result.insert(0,stack.pop());
                }
                stack.pop();
            }
            else { //operator
                if (!stack.isEmpty() && precedence(str.charAt(i)) <= precedence(stack.peek())) {
                    result.insert(0,stack.pop());
                }
                stack.push(str.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            result.insert(0,stack.pop());
        }
        return result.toString();
    }

    public static int[] nearestSmallerNumberOnLeft(int[] arr){
        StackInIntArray stack = new StackInIntArray();
        StackInIntArray minSTack = new StackInIntArray();
        int[] resultArray = new int[arr.length];

        stack.push(arr[0]);
        minSTack.push(arr[0]);
        resultArray[0] = -1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] >= stack.peek()){
                resultArray[i] = stack.peek();
            }
            else{
                if(arr[i] < minSTack.peek()){
                    minSTack.push(arr[i]);
                    resultArray[i] = -1;
                }
                else{
                  resultArray[i] = minSTack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return resultArray;
    }

    public static int[] largestNumberOnRight(int[]arr){
        StackInIntArray stack = new StackInIntArray();
        int[] resArr = new int[arr.length];
        stack.push(arr[arr.length-1]);
        resArr[arr.length-1] = -1;
        for(int i=arr.length-2; i >= 0; i--){
            if(arr[i] <= stack.peek()){
                resArr[i] = stack.peek();
                stack.push(arr[i]);
            }
            else{
                while(!stack.isEmpty() && arr[i] > stack.peek()){
                    stack.pop();
                }
                resArr[i] = stack.peek();
                stack.push(arr[i]);

            }
        }
        return resArr;
    }

    public static int numberOfBuildingsFacingSun(int[] arr){
        StackInIntArray stack = new StackInIntArray();
        int counter = 1;

        stack.push(arr[0]);
        for(int i = 1; i<arr.length; i++){
            if(arr[i] > stack.peek()){
                stack.push(arr[i]);
                counter++;
            }
        }
        return counter;
    }

    public static int[] nextSmallerOfNextGreater(int[] arr){
        int[] nextGreater = largestNumberOnRight(arr);
        StackInIntArray stack = new StackInIntArray();
        int[] resArr = new int[nextGreater.length];
        int temp = 0;

        for(int i=0; i<nextGreater.length; i++){
            if(nextGreater[i] == -1){
                resArr[i] = -1;
            }
            else{
                temp = i;
                while(arr[arr.length-1-temp] != nextGreater[i]){
                    if(arr[arr.length-1-temp] < nextGreater[temp]){
                        stack.push(arr[arr.length-1-temp]);
                    }
                    temp++;
                }
                resArr[i] = stack.pop();
            }
            while(!stack.isEmpty()){
                stack.pop();
            }
        }
        return resArr;
    }

    public static StackInIntArray reverseStack(StackInIntArray stack){
        StackInIntArray auxStack = new StackInIntArray();
        while(!stack.isEmpty()){
            auxStack.push(stack.pop());
        }
        return auxStack;
    }

    public static void deletingElementFromMiddle(StackInIntArray stack, int elementToDelete){
        if(stack.isEmpty()){
            return;
        }
        int data = stack.pop();
        deletingElementFromMiddle(stack, elementToDelete);
        if(data != elementToDelete) {
            stack.push(data);
        }
    }

    public static void deletingElementFromMiddleFirstElement(StackInIntArray stack, int elementToDelete, int count){
        if(stack.isEmpty()){
            return;
        }
        int data = stack.pop();
        if(data == elementToDelete){
            count++;
        }
        deletingElementFromMiddleFirstElement(stack, elementToDelete,count);
        if(data == elementToDelete){
            if(count != 1){
                stack.push(data);
            }
        }
        else{
            stack.push(data);
        }
    }

    public static void deletingElementFromMiddleWithoutEntireStack(StackInIntArray stack, int elementToDelete){
        if(stack.isEmpty()){
            return;
        }
        int data = stack.pop();
        if(data == elementToDelete){
            return;
        }
        deletingElementFromMiddleWithoutEntireStack(stack, elementToDelete);
            stack.push(data);
    }

}
