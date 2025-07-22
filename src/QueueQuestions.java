import java.util.HashMap;
import java.util.HashSet;

public class QueueQuestions {
    public static void pushingStackUsingQueue(int element, QueueInLinkedList queue1){
        QueueInLinkedList queue2 = new QueueInLinkedList();
        queue2.enQueue(element);
        while(!queue1.isEmptyQueue()) {
            int num = queue1.deQueue();
            queue2.enQueue(num);
        }
        queue2.printData();
    }

    public static void printData(QueueInLinkedList queue){
        if(queue.isEmptyQueue()){
            return;
        }
        int data = queue.deQueue();
        System.out.println(data);
        printData(queue);
    }

    public static void reversingQueue(QueueInLinkedList queue){
        if(queue.isEmptyQueue()){
            return;
        }
        int data = queue.deQueue();
        reversingQueue(queue);
        queue.enQueue(data);
    }

    /**
     * Problem: We divide the queue into two parts such that in our new queue we have one element from the first have followed by one element from the second half and so on till the queue comes to an end
     * Only a queue of even elements is allowed
     */
    public static void interleavingAQueue(QueueInLinkedList queue){
        int length = queue.queueSize();
        QueueInLinkedList firstHalf = new QueueInLinkedList();
        QueueInLinkedList resQueue = new QueueInLinkedList();
        while(firstHalf.queueSize() != length/2){
            firstHalf.enQueue(queue.deQueue());
        }
        while(!firstHalf.isEmptyQueue() || !queue.isEmptyQueue()) {
            resQueue.enQueue(firstHalf.deQueue());
            resQueue.enQueue(queue.deQueue());
        }
        resQueue.printData();
    }

    public static void deletingElementFromMiddle(QueueInLinkedList queue, int element){
        if(queue.isEmptyQueue()){
            return;
        }
        int data = queue.deQueue();
        deletingElementFromMiddle(queue, element);
        if(data != element){
            queue.enQueue(data);
        }
    }

    public static void reverseFirstKElements(QueueInLinkedList queue, int k, int count){
        QueueInLinkedList auxQueue = new QueueInLinkedList();
//        if(queue.isEmptyQueue() || count > k){
//            return;
//        }
//        int data = queue.deQueue();
//        count ++;
//        reverseFirstKElements(queue, k, count);;
//        auxQueue.enQueue(data);
        reverseFirstKElementsHelper(queue, k, count, auxQueue);
    }

    public static void reverseFirstKElementsHelper(QueueInLinkedList queue, int k, int count, QueueInLinkedList auxQueue){
        if(queue.isEmptyQueue() || count >= k){
            return;
        }
        int data = queue.deQueue();
        count ++;
        reverseFirstKElementsHelper(queue, k, count, auxQueue);
        auxQueue.enQueue(data);
    }

}
