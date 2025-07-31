import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static void testBT() {
        BtNode bstRoot = new BtNode(10);
        BST bst = new BST(bstRoot);
        BtNode node1 = new BtNode(2);
        BtNode node2 = new BtNode(8);
        BtNode node3 = new BtNode(4);
        BtNode node4 = new BtNode(7);
        bstRoot.left = node1;
        node1.left = node2;
        node1.right = node3;
        bstRoot.right = node4;

//        bst.insertingLeafNode(new BtNode(2), bstRoot);
//        bst.insertingLeafNode(new BtNode(8), bstRoot);
//        bst.insertingLeafNode(new BtNode(4), bstRoot);
//        bst.insertingLeafNode(new BtNode(7), bstRoot);
//        bst.insertingLeafNode(new BtNode(7), bstRoot);
//        bst.insertingLeafNode(new BtNode(55), bstRoot);
//        bst.insertingLeafNode(new BtNode(65), bstRoot);
//

    }

    public static void main(String[] args) {
//        testBT();
        int[] arr = {1,2,3};
        int[][] dpArray = {
                {-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1}
        };
        System.out.println(DynamicProgramming.minimumCoinsForTarget(arr, arr.length-1, 7, dpArray));
        }
    }











