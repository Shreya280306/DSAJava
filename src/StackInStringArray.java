public class StackInStringArray {
    final int stackSize = 200;
    String[] arr = new String[stackSize];
    int stackTop = -1;

    public void push(String element){
        stackTop++;
        arr[stackTop] = element;
    }

    public String pop(){
        String result = arr[stackTop];
        stackTop--;
        return result;
    }

    public String peek(){
        return arr[stackTop];
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

}
