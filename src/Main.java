import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        StackInIntArray stack = new StackInIntArray();
//        stack.push(3);
//        stack.push(1);
//        stack.push(4);
//        stack.push(2);
//        Recursion.sortingStack(stack);
////
////        //Recursion.removeBottomElementOfStack(stack);
//        StackQuestions.printStackData(stack);
////////
////        QueueInLinkedList queue = new QueueInLinkedList();
////        queue.enQueue(10);
////        queue.enQueue(7);
////        queue.enQueue(16);
////        queue.enQueue(9);
////        queue.enQueue(20);
////        queue.enQueue(5);
////        Recursion.sortingAQueue(queue);
////        queue.printData();

//        int[] arr = {1, 2, 3};
//        ArrayList<Integer> answer = new ArrayList<>();
//        boolean[] visited = new boolean[arr.length];
//        BackTracking.permutationsOfArrayWithExtraSpace(arr, answer, visited);

        //BackTracking.permutationsOfArray();
//        BackTracking.stringByPlacingSpaces("ABC", new StringBuilder());
//        int[] arr = {2,3,6,7};
//        boolean[] visited = new boolean[arr.length];
//        BackTracking.combinationSumToTargetOneElementCanComeOnlyONce(arr, 7, new ArrayList<Integer>(), visited);
//        String input = "aab";
//        ArrayList<String> result = new ArrayList<>();
//        boolean[] visited = new boolean[input.length()];
//        BackTracking.permutationsOfStringOfDifferentLengths(input, new StringBuilder(), new boolean[3]);

        SLL list = new SLL();
        SLL_Node node1 = new SLL_Node(1);
        SLL_Node node2 = new SLL_Node(2);
        SLL_Node node3 = new SLL_Node(3);
        SLL_Node node4 = new SLL_Node(4);
        SLL_Node node5 = new SLL_Node(5);
        SLL_Node node6 = new SLL_Node(6);
//        SLL_Node node6 = new SLL_Node(9);
//        SLL_Node node7 = new SLL_Node(4);
//        SLL_Node node8 = new SLL_Node(5);
        list.addNodeInEnd(node1);
        list.addNodeInEnd(node2);
        list.addNodeInEnd(node3);
        list.addNodeInEnd(node4);
        list.addNodeInEnd(node5);
        list.addNodeInEnd(node6);

//        node1.random = node3;
//        node2.random = node4;
//        node3.random = node6;
//        node4.random = null;
//        node5.random = node1;
//        node6.random = null;
//
//        list.addNodeUsingRandom(node3, node1);
//        list.addNodeUsingRandom(node4, node2);
//        list.addNodeUsingRandom(node6, node3);
//        list.addNodeUsingRandom(null, node5);
//        list.addNodeUsingRandom(null, node6);

        //list.printList();
//        list.addNodeInEnd(node7);
//        list.addNodeInEnd(node8);
//        //LinkListRecursion.pointerTravellingBackwards(list, list.lengthOfList());
//        SLL_Node current = list.head;
//        SLL resultList = new SLL();
//        LinkListRecursion.copyList(list, current);
//        LinkListRecursion.pointerTravellingBackwards(list, list.lengthOfList());
//
//        LinkListRecursion linkListRecursion = new LinkListRecursion();
//        linkListRecursion.head = node1;
//        linkListRecursion.stop = false;
//        linkListRecursion.reorderList(list.head);
//        list.printList();
//        LinkListRecursion.copyListWithRandomPointer(list);
//        LinkListRecursion.splittingListIntoParts(list, 2, list.head, 0, new SLL(), new ArrayList<SLL>());
//          System.out.println(Recursion.fibonacciSeries(0));
//        System.out.println(Recursion.fibonacciSeries(1));
//        System.out.println(Recursion.fibonacciSeries(2));
//        System.out.println(Recursion.fibonacciSeries(3));
//          System.out.println("Ans: " + Recursion.fibonacciSeries(1000));
//          int num = 10000;
//          int[] arr = new int[num +1];
//          Arrays.fill(arr, -1);
////        System.out.println("Ans: " + Recursion.fibonacciSeriesDPTopDown(num, arr));
//        System.out.println("Ans: " + Recursion.fibonacciSeriesDPBottomUp(num, arr));


//        System.out.println(Recursion.fibonacciSeries(5));
//        System.out.println(Recursion.fibonacciSeries(6));
//        System.out.println(Recursion.fibonacciSeries(7));
//        int n = 3;
//        int[] nums = {1,2,3,4};
//
//        int[] arr = new int[n+1];
//        int m = 2; int n = 3;
//        int[][] grid = {
//                {5,1,2},
//                {2,3,4},
//                {3,7,6},
//        };
//
//        int[][] dpArray = {
//                {-1,-1,-1,-1},
//                {-1,-1,-1,-1},
//                {-1,-1,-1,-1},
//                {-1,-1,-1,-1}
//        };
        int[] arr = {1, 2, 3};
        BackTracking.printAllSubsets(arr, new ArrayList<Integer>(), 0);
    }
}










