import java.util.ArrayList;

public class LinkListRecursion {
    public static void pointerTravellingBackwards(SLL list,int length){
        if(length <= 0){
            return;
        }
        SLL_Node current = list.head;
        System.out.println(pointerTravellingBackwardsHelper(list,current,1, length));
        pointerTravellingBackwards(list,length-1);
    }
    private static int pointerTravellingBackwardsHelper(SLL list, SLL_Node pointer, int index, int count){
        if(index == count){
            return pointer.data;
        }
        return pointerTravellingBackwardsHelper(list,pointer.next,index+1, count);
    }

    private static void swappingDataOfTwoNodes(SLL_Node node1, SLL_Node node2){
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    private static int distanceBetween2Nodes(SLL_Node left, SLL_Node right){
        int count = 1;
        while(left != right){
            left = left.next;
            count++;
        }
        return count;
    }

    public static void reversePartOfList(SLL list, int left, int right){
        SLL_Node leftPointer = list.head;
        while(leftPointer.data != left){
            leftPointer = leftPointer.next;
        }
        SLL_Node rightPointer = list.head;
        while(rightPointer.data != right){
            rightPointer = rightPointer.next;
        }
        reversePartOfListHelper(list, leftPointer, rightPointer);
    }

    private static void reversePartOfListHelper(SLL list,SLL_Node leftPointer, SLL_Node rightPointer){
        swappingDataOfTwoNodes(leftPointer, rightPointer);
        int length = distanceBetween2Nodes(leftPointer, rightPointer);
        leftPointer = leftPointer.next;
        rightPointer.data = pointerTravellingBackwardsHelper(list,list.head,1, length);
        reversePartOfListHelper(list, leftPointer, rightPointer);
    }

    private static boolean doesListContainNode(SLL list, SLL_Node node){
        SLL_Node current = list.head;
        while(current != null){
            if(current == node){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public SLL_Node head = null;
    boolean stop = false;
     void printLinkList(SLL_Node current) {
        if (current == null) {
            return;
        }
        printLinkList(current.next);
        if (stop) {
            return;
        }
        System.out.println("start: " + this.head.data +  " last: " +  current.data + "next head: " + this.head.next.data);
        this.head = this.head.next;
        if((head == current) || (head.next == current)) {
            stop = true;
        }
    }

    public static void removeDuplicatesInSortedList(SLL list, SLL_Node slow, SLL_Node fast){
         if(fast == null){
             return;
         }
         if(slow.data == fast.data){
             removeDuplicatesInSortedList(list, slow, fast.next);
         }
         else{
             slow.next = fast;
             removeDuplicatesInSortedList(list, fast, fast.next);
         }
    }

    public boolean isListPalindromeRecursion(SLL_Node current){
         if(current == null){
             return true;
         }
        boolean result = isListPalindromeRecursion(current.next);
         if(!result){
             return false;
         }
         boolean compare = (this.head.data == current.data);
        head = head.next;
        return compare;
    }

    public static void swapPairsOfNodes(SLL list){
         SLL_Node pointer1 = list.head;
        SLL_Node pointer2 = list.head.next;
        pointer1.next = pointer2.next;
        pointer2.next = pointer1;
        list.head = pointer2;
        SLL_Node temp = pointer1;
        if(list.lengthOfList() == 2){
            return;
        }
        swapPairsOfNodesHelper(list, pointer1.next, pointer1.next.next, temp);
    }

    private static void swapPairsOfNodesHelper(SLL list, SLL_Node pointer1, SLL_Node pointer2, SLL_Node temp){
        pointer1.next = pointer2.next;
        pointer2.next = pointer1;
        temp.next = pointer2;
        if(pointer1.next== null || pointer1.next.next == null){
            return;
        }

        swapPairsOfNodesHelper(list, pointer1.next, pointer1.next.next, pointer1);
    }

    public static void removeNodeOfValue(SLL list, int val, SLL_Node current){
         if(list.head.data == val){
             list.removeNodeFromStart();
             current = current.next;
         }
         if(list.tail.data == val){
             list.removeNodeFromLast();
         }
         if(current == null || current.next == null || current.next.next == null){
             return;
         }
         if(current.next.data == val) {
             SLL_Node temp = current;
             current = current.next;
             while(current.data == val){
                 current = current.next;
             }
             temp.next = current;
         }
         removeNodeOfValue(list, val, current.next);
    }

    public static int countNodesOfList(SLL list, int count, SLL_Node current){
         if(current == null){
             return count;
         }
         return countNodesOfList(list, count+1, current.next);
    }

    public static int middleElementOfList(SLL list, SLL_Node slow, SLL_Node fast){
         if(fast == null || fast.next == null || fast.next.next == null){
             return slow.data;
        }
         return middleElementOfList(list, slow.next, fast.next.next);
    }

    public static double binaryToInteger(SLL list, int index, SLL_Node current, double sum){
         if(current == null){
             return sum;
         }
         double pow = Math.pow(2, index);
         double multiply = current.data * pow;
         return binaryToInteger(list, index-1, current.next, sum + multiply);
    }

    public static SLL_Node reverseList(SLL list, SLL_Node head){
        if (head == null || head.next == null) {
            return head;
        }
        SLL_Node newHead = reverseList(list, head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private static SLL_Node whichNodeWithGivenData(SLL list ,int data){
         SLL_Node current = list.head;
         while(current != null){
             current = current.next;
             if(current.data == data){
                 return current;
             }
         }
         return null;
    }

    public static void reversePartOfList(SLL list, SLL_Node head, int left, int right) {
        SLL_Node temp1 = whichNodeWithGivenData(list, right);
        SLL_Node temp2 = temp1;
        if (temp1.next != null) {
             temp2 = temp1.next;
        }
        reversePartOfListHelper(list, head, left, right, temp1, temp2);
    }



    public static void reversePartOfListHelper(SLL list, SLL_Node head, int left, int right, SLL_Node temp1, SLL_Node temp2){
         if(head.data == right){
             return;
         }
        reversePartOfListHelper(list, head.next, left, right, temp1, temp2);
         if(head.data == left){
             head.next.next = head;
             head.next = temp2;
             return;
         }
         if(head.next == whichNodeWithGivenData(list, left)){
             head.next = temp1;
             return;
         }
         head.next.next = head;
         head.next = null;
    }
//
//    public SLL_Node head = null;
//    boolean stop = false;
    void reorderList(SLL_Node current) {
        if(current == null){
            return;
        }

        reorderList(current.next);
        if (stop) {
            return;
        }
        SLL_Node temp = this.head.next;
        if(current == temp){
            this.head.next = current;
            stop = true;
            return;
        }

        this.head.next = current;
        current.next = temp;
        head = temp;
        if((this.head == current) || (this.head.next == current)) {
            stop = true;
        }
    }

    public static void removeNthNodeFromEnd(SLL list, SLL_Node current, int n, int count, int length){
         if(count == length-n){
             return;
         }
         removeNthNodeFromEnd(list, current.next, n, count+1, length);
         if(count == length-n-1)
         current.next = current.next.next;
    }

    public static void copyList(SLL list){
         SLL newList = new SLL();
         SLL_Node firstNode = new SLL_Node();
         firstNode.data = list.head.data;
         newList.addNodeInEnd(firstNode);
        copyListHelper(list, newList, list.head.next);
    }

    public static void copyListHelper(SLL list, SLL newList, SLL_Node current){
         if(current == null){
             return;
         }
         SLL_Node newNode = new SLL_Node();
         newNode.data = current.data;
         newList.addNodeInEnd(newNode);
        copyListHelper(list, newList,current.next);
    }

    public static void copyListWithRandomPointer(SLL list){
        SLL newList = new SLL();
        SLL_Node firstNode = new SLL_Node();
        firstNode.data = list.head.data;
        newList.addNodeInEnd(firstNode);

        SLL_Node randomfirstNode = new SLL_Node();
        if(list.head.random != null) {
            randomfirstNode.data = list.head.random.data;
            newList.addNodeUsingRandom(randomfirstNode, firstNode);
        }
        copyListWithRandomPointerHelper(list, newList, list.head.next);
    }

    public static void copyListWithRandomPointerHelper(SLL list, SLL newList, SLL_Node current){
        if(current == null){
            return;
        }
        SLL_Node temp = newList.nodeExistsInList(current);
        if(temp != null){ //if the new node already exists because of the random pointer
            current.next = temp;
        }
        else{
            SLL_Node newNode = new SLL_Node();
            newNode.data = current.data;
            newList.addNodeInEnd(newNode);
        }
        if(current.random != null) {
            SLL_Node tempRandomNode = newList.nodeExistsInList(current);
            if (tempRandomNode != null) {
                current.random = tempRandomNode;
            } else {
                SLL_Node newRandomNode = new SLL_Node();
                newRandomNode.data = current.random.data;
                newList.addNodeUsingRandom(newRandomNode, current);
            }
        }
        copyListWithRandomPointerHelper(list, newList, current.next);
    }

    public static void splittingListIntoParts(SLL list, int numberOfParts, SLL_Node current, int count, SLL newList, ArrayList<SLL> result){
         if(count >= numberOfParts || current == null){
             if(!result.contains(newList)) {
                 result.add(newList);
             }
             return;
         }
         SLL_Node newNode = new SLL_Node(current.data);
         newList.addNodeInEnd(newNode);
         splittingListIntoParts(list, numberOfParts, current.next, count+1, newList, result);
        count = 0;
        newList = new SLL();
        splittingListIntoParts(list, numberOfParts, current.next, count, newList, result);
    }








}
