import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static void testBT() {
        BtNode bstRoot = new BtNode(1);
        BST bst = new BST(bstRoot);
        BtNode node1 = new BtNode(2);
        BtNode node2 = new BtNode(3);
        BtNode node3 = new BtNode(4);
        BtNode node4 = new BtNode(5);
        BtNode node5 = new BtNode(6);
        bstRoot.left = node1;
        bstRoot.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;

//        bst.insertingLeafNode(new BtNode(2), bstRoot);
//        bst.insertingLeafNode(new BtNode(8), bstRoot);
//        bst.insertingLeafNode(new BtNode(3), bstRoot);
//        bst.insertingLeafNode(new BtNode(5), bstRoot);
//        bst.insertingLeafNode(new BtNode(1), bstRoot);
//        bst.insertingLeafNode(new BtNode(5), bstRoot);
//        bst.insertingLeafNode(new BtNode(8), bstRoot);
//        bst.insertingLeafNode(new BtNode(10), bstRoot);

        int[] arr = {11, 6, 13, 5, 12, 10};
        System.out.println(BST.isArrayLevelOrder(arr));
    }

        public static void main (String[]args){
            testBT();
    }




}











