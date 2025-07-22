public class StackInIntArray {
    private StackInIntArray auxStack;
    final int stackSize = 20;
    int[] arr = new int[stackSize];
    int stackTop = -1;
//
//    public StackInIntArray(int size){
//        arr = new int[size];
//        stackTop = -1;
//    }
//
//    public void setAuxStack(StackInIntArray other){
//        this.auxStack = other;
//    }

    public void push(int element){
        stackTop++;
        arr[stackTop] = element;
    }

    public int pop(){
        int result = arr[stackTop];
        arr[stackTop] = 0;
        stackTop--;
        return result;
    }

    public int peek(){
        if(!this.isEmpty()) {
            return arr[stackTop];
        }
        else return -1;
    }

    public int size(){
        return stackTop+1;
    }
    public boolean isEmpty(){
        if(stackTop == -1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFull(){
        if(stackTop == stackSize){
            return true;
        }
        else{
            return false;
        }
    }

    public int findingMinimumUsingOrderOfOne(){
        return auxStack.peek();
    }



}
