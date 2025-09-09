import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    static void testBT() {
        BtNode bstRoot = new BtNode(18);
        BST bst = new BST(bstRoot);
        BtNode node1 = new BtNode(9);
        BtNode node2 = new BtNode(36);
        BtNode node3 = new BtNode(6);
        BtNode node4 = new BtNode(12);
        BtNode node5 = new BtNode(1);
        BtNode node6 = new BtNode(8);
        BtNode node7 = new BtNode(10);
////        BtNode node8 = new BtNode(19);
//        BtNode node9 = new BtNode(25);

//        bstRoot.left = node1;
//        bstRoot.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;
//
        bst.insertingLeafNode(node1, bstRoot);
        bst.insertingLeafNode(node2, bstRoot);
        bst.insertingLeafNode(node3, bstRoot);
        bst.insertingLeafNode(node4, bstRoot);
        bst.insertingLeafNode(node5, bstRoot);
        bst.insertingLeafNode(node6, bstRoot);
        bst.insertingLeafNode(node7, bstRoot);
        //bst.insertingLeafNode(node8, bstRoot);

//        bst.insertingLeafNode(new BtNode(5), bstRoot);
//        bst.insertingLeafNode(new BtNode(10), bstRoot);
//        bst.insertingLeafNode(new BtNode(2), bstRoot);
//        bst.insertingLeafNode(new BtNode(6), bstRoot);
//        bst.insertingLeafNode(new BtNode(12), bstRoot);
        //bst.insertingLeafNode(new BtNode(14), bstRoot);

        System.out.println(bst.maxSumBetween2NodesOfBST(bstRoot, node5, node7));
    }

        public static void main (String[]args){
            testBT();
    }




}











