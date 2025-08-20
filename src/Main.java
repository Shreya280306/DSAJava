import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static void testBT() {
        BtNode bstRoot = new BtNode(50);
        BST bst = new BST(bstRoot);
//        BtNode node1 = new BtNode(2);
//        BtNode node2 = new BtNode(8);
//        BtNode node3 = new BtNode(4);
//        BtNode node4 = new BtNode(7);
//        bstRoot.left = node1;
//        node1.left = node2;
//        node1.right = node3;
//        bstRoot.right = node4;
//        ArrayList<Integer> arr = new ArrayList<>();
//        int[] count = {0};
//        bst.creatingArrayOfBSTNodes(bstRoot, arr);
//        bst.binaryTreeToBinarySearchTree(bstRoot, arr, count);


        bst.insertingLeafNode(new BtNode(30), bstRoot);
        bst.insertingLeafNode(new BtNode(20), bstRoot);
        bst.insertingLeafNode(new BtNode(40), bstRoot);
        bst.insertingLeafNode(new BtNode(70), bstRoot);
        bst.insertingLeafNode(new BtNode(60), bstRoot);
        bst.insertingLeafNode(new BtNode(80), bstRoot);

//        int[] arr = {8, 10, 14, 3, 6, 4, 1, 7, 13};
//        ArrayList<Integer> preorder = new ArrayList<>();
//        //preorder.add(arr[0]);
//        //BST.buildingPreorderFromArr(arr, preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        preorder = BST.getPreorder(arr);
        int[] arr1 = {8, 3, 6, 1, 4, 7, 10, 14, 13};
        int[] arr2 = {8, 10, 14, 3, 6, 4, 1, 7, 13};
        System.out.println(BST.areSameBSTsWithoutUsingArrays(arr1, arr2, arr1.length, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

        public static void main (String[]args){
            testBT();
    }




}











