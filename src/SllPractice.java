import java.util.HashMap;
import java.util.HashSet;

public class SllPractice {
    SLL_Node head;
    SLL_Node tail;
    SllPractice(){
        this.head = null;
        this.tail = null;
    }

    SllPractice(SLL_Node node){
        this.head = node;
        this.tail = node;
    }

    public void printList(){
        SLL_Node current = this.head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void addNodeInTheStart(SLL_Node node){
        node.next = head;
        head = node;
    }

    public void addNodeInTheEnd(SLL_Node node){
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
    }

    public void removeNodeFromStart(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        SLL_Node temp = new SLL_Node();
        head = head.next;
        temp = null;
    }

    public void removeNodeFromEnd(){
        SLL_Node current = this.head;
        while(current.next != this.tail){
            current = current.next;
        }
        tail = current;
        current.next = null;
    }

    public void addNodeInMiddle(SLL_Node node){
        SLL_Node current = head;
        while (current != node) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
    }

    public void printingListInReverseUsingRecursion(SLL_Node current){
        if(current == null){
            return;
        }
        printingListInReverseUsingRecursion(current.next);
        System.out.println(current.data);
    }

    public void returnMiddleNode(){
        SLL_Node slowPointer = this.head;
        SLL_Node fastPointer = this.head;
        while(fastPointer.next != null) {
            slowPointer = slowPointer.next;
            if (fastPointer.next.next != null) {
                fastPointer = fastPointer.next.next;
                break;
            }
        }
        System.out.println(slowPointer.data);
    }

    public static SllPractice numberToList(int num){
        SllPractice listToStore = new SllPractice();
        //SLL_Node current = listToStore.head;
        int mod = 0;
        while(num > 0){
            mod = num % 10;
            SLL_Node temp = new SLL_Node(mod);
            listToStore.addNodeInTheStart(temp);
            //current = current.next;
            num = num/10;
        }
        return listToStore;
    }

    public int listToNumber(){
        SLL_Node current = this.head;
        int sum = 0;
        while(current != null){
            sum = (sum + current.data)*10;
            current = current.next;
        }
        return (sum/10);
    }

    public void deleteNodeWithoutHead(SLL_Node node){
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public void isListLooped(){
        //Two pointers are used
        //At some point the slow pointer and fast pointer has to meet for the list to be looped

        SLL_Node slowPointer = this.head;
        SLL_Node fastPointer = this.head;
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;

        while(fastPointer != null){
            if(slowPointer == fastPointer){
                System.out.println("The list is looped");
                return;
            }
            if(fastPointer.next != null && fastPointer.next.next != null){
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
            else{
                break;
            }
        }
        System.out.println("The list is not looped");
    }

    public void isListLoopedHashSet(){
        HashSet<SLL_Node> hash = new HashSet<>();
        SLL_Node current = this.head;
        while(current != null){
            if(hash.contains(current)){
                System.out.println("List is looped");
                return;
            }
            else{
                hash.add(current);
                current = current.next;
            }
        }
        System.out.println("List is not looped");
    }

    public void breakLoop(){
        SLL_Node current = this.head;
        HashSet<SLL_Node> hash = new HashSet<>();
        while(current != null){
            if(hash.contains(current)){
                current.next = null;
                return;
            }
            hash.add(current);
            current = current.next;
        }
    }

    public void reverseTwoNodes(){
        SLL_Node current = this.head.next;
        current.next = this.head;
        head.next = null;
        head = current;
    }

    public void reverseList(){
        SLL_Node p1 = this.head;
        SLL_Node p2 = this.head.next;
        SLL_Node p3 = this.head.next.next;

        p1.next = null;
        while(p3 != null){
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        if(p3 == null){
            p2.next = p1;
            head = p2;
            printList();
        }
    }

    public int lengthOfList(){
        SLL_Node current = this.head;
        int count = 0;
        if(current.next == null){
            return 1;
        }
        if(current == null){
            return 0;
        }
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void isListPalindrome(){
        SLL_Node current = this.head;
        SLL firstHalf = new SLL();
        SLL secondHalf = new SLL();
        int length = lengthOfList();

            for(int i=0; i<length/2; i++){
                firstHalf.addNodeInEnd(current);
                current = current.next;
            }
            for(int j=length/2; j<length; j++){
                secondHalf.addNodeInEnd(current);
                current = current.next;
            }

            secondHalf.reverseList();
            SLL_Node compare1 = firstHalf.head;
            SLL_Node compare2 = secondHalf.head;

            while(compare1 != null){
                if(compare1.data != compare2.data){
                    System.out.println("Not a palindrome");
                    return;
                }
                else{
                    compare1 = compare1.next;
                    compare2 = compare2.next;
                    if(compare1.next == null){
                        System.out.println("List is a palindrome");
                        break;
                    }
                }
            }
    }

    public static SllPractice addTwoListsLikeNumbers(SllPractice list1, SllPractice list2){
        int num1 = list1.listToNumber();
        int num2 = list2.listToNumber();
        int result = num1 + num2;
        SllPractice list3 = numberToList(result);
        return list3;
    }

    public void mergeSortedListsWithoutNewList(SllPractice list1, SllPractice list2){
        SLL_Node current1 = list1.head;
        SLL_Node current2 = list2.head;


    }


}
