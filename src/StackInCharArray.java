public class StackInCharArray {
    final int stackSize = 200;
    char[] arr = new char[stackSize];
    int stackTop = -1;

    public void push(char element){
        stackTop++;
        arr[stackTop] = element;
    }

    public char pop(){
        char result = arr[stackTop];
        stackTop--;
        return result;
    }

    public char peek(){
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


