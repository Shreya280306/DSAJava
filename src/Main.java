import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static void testBT() {
        BtNode bstRoot = new BtNode(6);
        BST bst = new BST(bstRoot);
        BtNode node1 = new BtNode(7);
        BtNode node2 = new BtNode(3);
        BtNode node3 = new BtNode(2);
        BtNode node4 = new BtNode(2);
        BtNode node5 = new BtNode(4);
//        BtNode node5 = new BtNode(6);
//        BtNode node6 = new BtNode(7);
////        BtNode node7 = new BtNode(19);
//        BtNode node8 = new BtNode(25);

        bstRoot.left = node1;
        bstRoot.right = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

//        bst.insertingLeafNode(node1, bstRoot);
//        bst.insertingLeafNode(node2, bstRoot);
//        bst.insertingLeafNode(node3, bstRoot);
//        bst.insertingLeafNode(node4, bstRoot);
//        bst.insertingLeafNode(node5, bstRoot);
//        bst.insertingLeafNode(node6, bstRoot);
//        bst.insertingLeafNode(node7, bstRoot);
//        bst.insertingLeafNode(node8, bstRoot);

//        bst.insertingLeafNode(new BtNode(8), bstRoot);
//        bst.insertingLeafNode(new BtNode(22), bstRoot);
//        bst.insertingLeafNode(new BtNode(4), bstRoot);
//        bst.insertingLeafNode(new BtNode(12), bstRoot);
//        bst.insertingLeafNode(new BtNode(10), bstRoot);
//        bst.insertingLeafNode(new BtNode(14), bstRoot);
//        bst.insertingLeafNode(new BtNode(10), bstRoot);
        int[] length = {0};
        int[] maxlength = {0};
        System.out.println(bst.findingBSTFromBinaryTree(bstRoot, length, maxlength));
    }

        public static void main (String[]args){
            testBT();
    }




}











