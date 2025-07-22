public class QueueInLinkedList {
    SLL list = new SLL();

    //Adds an element to the end of the queue
    public void enQueue(int element){
        SLL_Node node = new SLL_Node(element);
        list.addNodeInEnd(node);
    }

    public int deQueue(){
        int element = list.head.data;
        list.removeNodeFromStart();
        return element;
    }

    public int front(){
        return list.head.data;
    }

    public int queueSize(){
        SLL_Node current = list.head;
        int number = 0;

        while(current!= null){
            number++;
            current = current.next;
        }
        return number;
    }

    public boolean isEmptyQueue(){
        if(list.head == null){
            return true;
        }
        else{
            return false;
        }
    }

    public void printData(){
        SLL_Node current = list.head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void reverseQueue(){
        list.reverseListWithRecursion();
    }
}
