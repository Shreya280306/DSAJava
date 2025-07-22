import org.w3c.dom.Node;

import java.util.HashSet;

public class SLL {
    SLL_Node head;
    SLL_Node tail;

    SLL() {
        this.head = null;
        this.tail = null;
    }

    SLL(SLL_Node node) {
        this.head = node;
        this.tail = node;
    }

    public void printList() {
        SLL_Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void addNodeInStartForGIvenData(int data) {
        SLL_Node nodeToAdd = new SLL_Node(data);
        nodeToAdd.next = this.head;
        this.head = nodeToAdd;
    }

    public void addNodeInStart(SLL_Node node) {
        if (node != null) {
            node.next = this.head;
            this.head = node;
        }
    }

    public void addNodeInEndForGivenData(int data) {
        SLL_Node nodeToAdd = new SLL_Node(data);
        tail.next = nodeToAdd;
        this.tail = nodeToAdd;
    }

    public void addNodeInEnd(SLL_Node node) {
            if(this.head == null){
                this.head = node;
                this.tail = node;
            }
            else {
                tail.next = node;
                tail = node;
            }
    }

    public void removeNodeFromStart() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        SLL_Node temp = head;
        head = head.next;
        temp = null;
    }

    public void removeNodeFromLast() {
        SLL_Node current = head;
            while (current.next.next != null) {
                current = current.next;
        }
        current.next = null;
            this.tail = current;
    }

    public void addNodeInMiddle(SLL_Node node, int num) {
        SLL_Node current = head;
        while (current.data != num) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
    }

    public int lengthOfList() {
        SLL_Node current = head;
        int length = 0;
        while (current != null) {
            length += 1;
            current = current.next;
        }
        return length;
    }

    public void maxOfList() {
        SLL_Node current = head;
        int max = head.data;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        System.out.println(max);
    }

    public void printingInReverseRecursion(SLL_Node current) {
        if (current == null) {
            return;
        } else {
            printingInReverseRecursion(current.next);
            System.out.println(current.data);
        }
    }
    // If we print after calling the function then it prints in reverse while emptying the stack but if print statement in written before calling the function it would first print and then execute again

    // Here we use the slow pointer-fast pointer approach of link lists
    public int returnMiddleNode() {
        SLL_Node slowPointer = head;
        SLL_Node fastPointer = head;
        while (fastPointer != null) {
            if (fastPointer.next == null || fastPointer.next.next == null) {
                break;
            }
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer.data;
    }

    public void nthNodeFromLast(int n) {
        int length = lengthOfList();
        if (n < 1 || n > length) {
            System.out.println("Node doesn't exist");
            return;
        }
        int element = length - n;
        SLL_Node current = head;
        for (int i = 0; i < element; i++) {
            current = current.next;
        }

        System.out.println(current.data);
    }

    public static SLL numberToList(int num) {
        int mod = num % 10;
        SLL_Node node1 = new SLL_Node(mod);
        SLL list = new SLL(node1);
        num = num / 10;
        while (num != 0) {
            mod = num % 10;
            SLL_Node node = new SLL_Node(mod);
            list.addNodeInStart(node);
            num = num / 10;
        }
        return list;
    }

    public int listToNumber() {
        int sum = 0;
        SLL_Node current = head;
        int num = current.data;
        current = current.next;
        while (current != null) {
            num = num * 10 + current.data;
            current = current.next;
        }
        return num;
    }

    public void deleteNodePassed(SLL_Node node) {
        SLL_Node current = head;
        SLL_Node prev = head;
        if (current.next == null) { //Last node is passed
            removeNodeFromLast();
        } else {
            if (current == node) {
                removeNodeFromStart();
                return;
            }
            while (current != null) {
                current = current.next;
                if (current == node) {
                    break;
                }
                prev = prev.next;
            }
            if (current == node) {
                prev.next = current.next;
            } else {
                System.out.println("Node doesn't exist");
            }
        }
    }

    /**
     * Problem: We need to delete a given node but without using head pointer.
     * Approach: This also means we can't traverse through the list with the current pointer since there is no initial pointer itself. The only pointer we have is the node we want to delete.
     *           Thus we take the data of the next node of from A and copy it into A. Then point next of A to the next of the next node of it so it appears as if that node has been deleted.
     * @param node
     */

    public void deleteNodeWithoutHead(SLL_Node node) {
        if (node.next != null) {
            node.data = node.next.data;
            if (node.next.next != null) {
                node = node.next.next;
            }else{
                removeNodeFromLast();
            }
        }
        printList();
    }

    // Looped linked list questions

    /**
     * Problem: Checking if the list is looped or not which means that the last node points to another node in the list and thus continues forward traversing the list again and creating a loop
     * Approach: We use two pointers, one that travels one step at a time and the other travelling two steps at a time. If the list is looped there has to be a scenario where these two pointers meet but if its not then there is no possibility of these pointers ever meeting
     */
    public void isListLoopedPointers() {
        SLL_Node fast = this.head;
        SLL_Node slow = this.head;
        fast = fast.next.next;
        slow = slow.next;
        while (fast != null) {
            if (fast == slow) {
                System.out.println("The list is looped");
                return;
            }
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                break;
            }
        }
        System.out.println("The list is not looped");
    }

    public void isListLoopedHashMap() {
        // If we want to use a frequency array but don't know the number of elements of the array to be formed we use hash set which is like a dictionary but only stores the keys and the size is not fixed we can keep appending to the hashset
        HashSet<Integer> hash = new HashSet<Integer>();
        SLL_Node current = this.head;
        while (current != null) {
            if (hash.contains(current.data)) {
                System.out.println("The list is looped");
                return;
            }
            hash.add(current.data);
            current = current.next;
        }
        System.out.println("The list is not looped");
    }

    /**
     * Problem: Break the list at the node at which its looped
     */
    public void breakLoop() {
        HashSet<Integer> hash = new HashSet<Integer>();
        SLL_Node current = this.head;
        while (current != null) {
            if (hash.contains(current.data)) {
                current.next = null;
                printList();
                return;
            }
            hash.add(current.data);
            current = current.next;
        }
    }

    public void reverseListWith2Nodes() {
        SLL_Node current = this.head;
        current = head.next;
        head.next = null;
        current.next = head;
        head = current;
        //printList();
    }

    public void reverseList() {
        SLL_Node current = this.head;
        SLL_Node temp = this.head.next;

        if (head.next == null) {
            System.out.println(head.data);
            return;
        }

        if (head.next.next == null) {
            reverseListWith2Nodes();
            return;
        }

        head = head.next;
        current.next = null;
        temp = temp.next;
        head.next = current;
        current = head;

        while (temp.next != null) {
            head = temp;
            temp = temp.next;
            head.next = current;
            current = head;
        }

        temp.next = current;
        head = temp;
    }
/*
Approach: Make two new lists, one which contains elements till first half and the other which contains elements till second half. If the two lists upon iterating contain the same data then its a palindrome
          We can't just equate two lists since then it checks its address and not the data inside thus we need two seperate pointers to iterate each list
 */
    public void isListPalindrome() {
        int middle = returnMiddleNode();
        SLL sepList = new SLL();
        SLL_Node current = this.head;

        while (current.data != middle) {
            current = current.next;
        }

        current = current.next;
        while (current != null) {
            sepList.addNodeInStartForGIvenData(current.data);
            current = current.next;
        }
        SLL_Node sepCurrent = sepList.head;
        current = this.head;
        while (sepCurrent != null) {
            if (sepCurrent.data != current.data) {
                System.out.println("Not a palindrome");
                return;
            }
            sepCurrent = sepCurrent.next;
            current = current.next;
        }
        System.out.println("Is a palindrome");
    }


    /**
     * Problem: Add numbers which are given as link lists and store the result in a new list
     * Approach: Reverse the input lists and then do the addition.
     * Special consideration for carry
     *
     * @param list1
     * @param list2
     */
    public static SLL addTwoListsLikeNumbers(SLL list1, SLL list2) {
        list1.reverseList();
        list2.reverseList();
        SLL list3 = new SLL();
        int carry = 0;
        SLL_Node current1 = list1.head;
        SLL_Node current2 = list2.head;
        while (current1 != null && current2 != null) {
            int sum = carry + current1.data + current2.data;
            if (sum > 9) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            list3.addNodeInStartForGIvenData(sum);
            current1 = current1.next;
            current2 = current2.next;
        }
        if (current1 == null && current2 == null && carry == 1) {
            list3.addNodeInStartForGIvenData(1);
        }

        // If list2 is fully traversed already
        if (current2 == null) {
            while (current1 != null) {
                list3.addNodeInStartForGIvenData(current1.data);
                current1 = current1.next;
            }
        }
        // else  list1 is fully traversed already
        else if (current1 == null) {
            while (current2 != null) {
                list3.addNodeInStart(current2);
                current2 = current2.next;
            }
        }
        list3.printList();
        return list3;
    }

    public static void mergeSortedListsWithNewList(SLL list1, SLL list2) {
        SLL list3 = new SLL();
        SLL_Node current1 = list1.head;
        SLL_Node current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                list3.addNodeInEndForGivenData(current1.data);
                current1 = current1.next;
            } else if (current1.data > current2.data) {
                list3.addNodeInEndForGivenData(current2.data);
                current2 = current2.next;
            }
        }

        if (current1 == null) {
            while (current2 != null) {
                list3.addNodeInEndForGivenData(current2.data);
                current2 = current2.next;
            }
        } else if (current2 == null) {
            while (current1 != null) {
                list3.addNodeInEndForGivenData(current1.data);
                current1 = current1.next;
            }
        }
        list3.reverseList();
        list3.printList();
    }


    public static void mergeSortedListByTweaking(SLL list1, SLL list2) {
        SLL_Node current1 = list1.head;
        SLL_Node current2 = list2.head;
        SLL_Node temp1 = list1.head;
        SLL_Node temp2 = list2.head;
        while (temp1.next != null && temp2.next != null) {
            if (current1.data < current2.data) {
                temp1 = temp1.next;
                if (temp1.data < current2.data) {
                    current1 = current1.next;
                    continue;
                }
                current1.next = current2;
                current1 = temp1;
            } else if (current2.data < current1.data) {
                temp2 = temp2.next;
                if (temp2.data < current1.data) {
                    current2 = current2.next;
                    continue;
                }
                current2.next = current1;
                current2 = temp2;
            }
        }
        if (current2.next == null) {
            while (current1 != null) {
                list1.addNodeInEnd(current1);
                current1 = current1.next;
            }
        } else if (current1.next == null) {
            while (current2 != null) {
                list1.addNodeInEnd(current2);
                current2 = current2.next;
            }
        }
        list1.printList();
    }

    public static int findingIntersection(SLL list1, SLL list2) {
        int length1 = list1.lengthOfList();
        int length2 = list2.lengthOfList();
        SLL_Node current1 = list1.head;
        SLL_Node current2 = list2.head;
        int diff = Math.abs(length2 - length1);

        if (length1 > length2) {
            for (int counter = 0; counter < diff; counter++) {
                current1 = current1.next;
            }
        } else if (length2 > length1) {
            for (int counter = 0; counter < diff; counter++) {
                current2 = current2.next;
            }
        }
        while (current1 != null) {
            if (current1 == current2) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }

    private void reverseListWithRecursionHelper2(SLL_Node current, SLL_Node temp) {
        //The loop replaced with recursion with the appropriate arguments needed
        if (temp.next != null) {
            this.head = temp;
            temp = temp.next;
            head.next = current;
            reverseListWithRecursionHelper2(this.head, temp);
        }
        if (temp.next == null) {
            this.head = temp;
            head.next = current;
        }
    }

    private void reverseListWithRecursionHelper1(SLL_Node current, SLL_Node temp) {
        // Changing pointers of first 2 nodes
        head = head.next;
        current.next = null;
        temp = temp.next;
        head.next = current;
        current = head;

        reverseListWithRecursionHelper2(current, temp);
    }

    public void reverseListWithRecursion() {
        //If there is only one node, nothing to do
        if (head.next == null) {
            return;
        }

        //If there are just 2 nodes in the list
        if (head.next.next == null) {
            reverseListWith2Nodes();
            return;
        }

        //Actually calling the function without having to give any arguments
        reverseListWithRecursionHelper1(this.head, this.head.next);
    }

    public void removingEveryKthNode(int k) {
        SLL_Node current = this.head;
        int count = 1;
        while (count - 1 != k && current.next != null) {
            current = current.next;
            count++;
            if (count == k) {
                deleteNodePassed(current);
                count = 0;
            }
        }
        printList();
    }

    public int countOccurrences(int k) {
        SLL_Node current = this.head;
        int count = 0;
        while (current != null) {
            if (current.data == k) {
                count += 1;
            }
            current = current.next;
        }
        return count;
    }

    public int countingNodesInCircularLinkedList() {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return 1;
        }
        SLL_Node current = this.head.next;
        int count = 1;
        while (current != head) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void deletingInCircularLinkedList(int k) {
        //No node is given
        if (head == null) {
            return;
        }
        //One node is given to be deleted
        if (head.next == null) {
            head = null;
            return;
        }
        // If the node to be deleted is the last node
        SLL_Node last = this.head.next;
        while (last.next != head) {
            last = last.next;
        }
        if (last.data == k) {
            SLL_Node current = this.head.next;
            while (current.next != last) {
                current = current.next;
            }
            current.next = last.next;
            return;
        }
        //If the node to be deleted is the first node
        if (k == this.head.data) {
            SLL_Node current = this.head.next;
            while (current.next != head) {
                current = current.next;
            }
            current.next = head.next;
            head = head.next;
            return;
        }
        //If the node to be deleted is any random node in the middle
        SLL_Node current = this.head;
        while (current.next.data != k) {
            current = current.next;
        }
        current.next = current.next.next;
    }

    public void singlyToCircularLinkedList() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            printList();
            return;
        }
        SLL_Node last = this.head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = head;
        printList();
    }

    public void exchangingFirstAndLastNodesInCircularLinkedList() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            printList();
            return;
        }
        SLL_Node last = this.head;
        while (last.next != head) {
            last = last.next;
        }
        int temp = last.data;
        last.data = head.data;
        head.data = temp;
        printList();
    }

    public void swappingElementsInPairs() {
        int count = 0;
        int temp = 0;
        SLL_Node current = this.head;
        while (current.next.next != null) {
            temp = current.data;
            current.data = head.data;
            head.data = temp;
            current = current.next.next;
        }
    }

    public int countNodesInLoop(){
        SLL_Node current = this.head;
        HashSet<SLL_Node> visited = new HashSet<>();
        int count = 0;
        while(current != null){
            if(visited.contains(current)){
                SLL_Node startOfLoop = current;
                count++;
                current = current.next;
                while(current != startOfLoop){
                    current = current.next;
                    count++;
                    return count;
                }
            }
            visited.add(current);
            current = current.next;
        }
        return 0;
    }

    public boolean checkIfListIsPalindrome(){
        SLL secondHalf = new SLL();
        int length = lengthOfList();
        int middle = returnMiddleNode();
        SLL_Node current = this.head;
        while(current.data != middle){
            current = current.next;
        }
        //current = middle node
            current = current.next;
            while(current != null){
                secondHalf.addNodeInStartForGIvenData(current.data);
                current = current.next;
        }
        //second half of the list has been put into another list
        SLL_Node secHalf = secondHalf.head;
        current = this.head;
        while(secHalf != null){
            if(current.data != secHalf.data){
                return false;
            }
            current = current.next;
            secHalf = secHalf.next;
        }
        return true;
    }

    public void removeDuplicates(){
           HashSet<Integer> passed = new HashSet<>();
        SLL_Node current = this.head;
        while(current != null){
            if(passed.contains(current.data)){
                deleteNodePassed(current);
                current = current.next;
            }
            else{
                passed.add(current.data);
                current = current.next;
            }
        }
        printList();
    }

    public void swapNodesWithoutSwappingData(SLL_Node node1, SLL_Node node2){
        SLL_Node beforeStart = this.head;
        SLL_Node start = new SLL_Node();
        SLL_Node beforeEnd = this.head;
        SLL_Node end = new SLL_Node();
        SLL_Node afterEnd = new SLL_Node();
        while(beforeStart.next != node1){
            beforeStart = beforeStart.next;
        }
        start = beforeStart.next;
        while(beforeEnd.next != node2){
            beforeEnd = beforeEnd.next;
        }
        end = beforeEnd.next;
        afterEnd = end.next;

        end.next = start.next;
        beforeStart.next = end;
        start.next = afterEnd.next;
        beforeEnd.next = start;

        printList();
    }

    public void addNodeUsingRandom(SLL_Node node, SLL_Node current){
        if(current != null){
            current.random = node;
        }
    }

    public SLL_Node nodeExistsInList(SLL_Node nodeToFind){
        SLL_Node current = this.head;
        while(current != null){
            if(current.data == nodeToFind.data){
                return current;
            }
            current = current.next;
        }
        return null;
    }




}








