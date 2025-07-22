public class IntStackUsingArr {
     final int STACK_SIZE = 20;
    int[] arr = new int[20]; // Assuming our stack will never go beyond 20 elements
    int stackTop = -1;

    public void pushElementsOntoStack(int element){
        arr[++stackTop] = element;
    }

    public int popElementsFromStack(){
        return arr[stackTop--];
    }

    public int topElementInStack(){
        return arr[stackTop];
    }

    public int sizeOfStack(){
        return stackTop+1;
    }

    public boolean isStackEmpty(){
        if(stackTop == -1)
            return true;
        else
            return false;
    }
}
