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
//
//        int n=3;
//        int[] weights = {3,2,5};
//        int[] values = {30,40,60};
//        int[][]dpArray = {
//                {-1,-1,-1,-1,-1,-1,-1,-1,-1},
//                {-1,-1,-1,-1,-1,-1,-1,-1,-1},
//                {-1,-1,-1,-1,-1,-1,-1,-1,-1},
//        };
//        System.out.println(DynamicProgramming.knapsackProblem(n-1, 8,weights, values, dpArray));
        int[] arr = {2,3,5,7,8};
        int n = arr.length;
        int[][] queries = {
                {1,4},
                {0,1},
                {3,3}
        };
        int[] ans = new int[queries.length];
        int[] prefixArray = new int[n+1];
        prefixArray[0] = 0;
        for(int i=1; i<=n; i++){
            prefixArray[i] = prefixArray[i-1] + arr[i-1];
        }
        for(int i=0; i<queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = prefixArray[n] - (prefixArray[right+1] - prefixArray[left]);
        }
        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}










