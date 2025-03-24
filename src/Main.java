import java.io.*;
import java.util.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SLL_Node node1 = new SLL_Node(1);
        SLL_Node node2 = new SLL_Node(2);
        SLL_Node node3 = new SLL_Node(2);
        SLL_Node node4 = new SLL_Node(1);
        SLL_Node node5 = new SLL_Node(5);
        SLL_Node node6 = new SLL_Node(6);
        SLL_Node node7 = new SLL_Node(7);

        SllPractice list = new SllPractice();
        list.addNodeInTheEnd(node1);
        list.addNodeInTheEnd(node2);
        list.addNodeInTheEnd(node3);
        list.addNodeInTheEnd(node4);

        SllPractice list1 = new SllPractice();
        list1.addNodeInTheEnd(node5);
        list1.addNodeInTheEnd(node6);
        list1.addNodeInTheEnd(node7);

        SllPractice result = new SllPractice();
        result = SllPractice.addTwoListsLikeNumbers(list, list1);
        result.printList();
    }


}

