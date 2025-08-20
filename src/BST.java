import java.util.ArrayList;
import java.util.Arrays;

public class BST {
    BtNode right;
    BtNode left;
    BtNode root;

    BST() {
        this.root = null;
        this.left = null;
        this.right = null;
    }

    BST(BtNode node) {
        this.root = node;
        this.left = node.left;
        this.right = node.right;
    }

    public void inorderTraversal(BtNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public void preorderTraversal(BtNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void postorderTraversal(BtNode node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public void insertingLeafNode(BtNode nodeToInsert, BtNode current) {
        if (nodeToInsert.data < current.data) {
            if (current.left == null) {
                current.left = nodeToInsert;
            } else {
                insertingLeafNode(nodeToInsert, current.left);
            }
        } else if (nodeToInsert.data > current.data) {
            if (current.right == null) {
                current.right = nodeToInsert;
            } else {
                insertingLeafNode(nodeToInsert, current.right);
            }
        } else {
            System.out.println("Node already exists");
        }
    }

    public void searchingNode(BtNode nodeToSearch, BtNode current) {
        if (nodeToSearch == null || current == null) {
            System.out.println(false);
            return;
        }
        if (nodeToSearch.data < current.data) {
            searchingNode(nodeToSearch, current.left);
        } else if (nodeToSearch.data > current.data) {
            searchingNode(nodeToSearch, current.right);
        } else {
            System.out.println(true);
        }
    }

    public void deletingLeafNode(BtNode nodeToDelete, BtNode current) {
        if (nodeToDelete == null) {
            return;
        }
        if (current.right.data == nodeToDelete.data) {
            current.right = null;
            return;
        }
        if (current.left.data == nodeToDelete.data) {
            current.left = null;
            return;
        }

        if (nodeToDelete.data < current.data) {
            deletingLeafNode(nodeToDelete, current.left);
        } else if (nodeToDelete.data > current.data) {
            deletingLeafNode(nodeToDelete, current.right);
        }
    }

    public void deletingNodeWithOnlyOneOrTwoChildren(BtNode nodeToDelete, BtNode current) {
        if (nodeToDelete == null) {
            return;
        }
        if (current.data == nodeToDelete.data) {
            current.data = current.right.data;
            current.right = null;
            return;
        }

        if (nodeToDelete.data < current.data) {
            deletingNodeWithOnlyOneOrTwoChildren(nodeToDelete, current.left);
        } else if (nodeToDelete.data > current.data) {
            deletingNodeWithOnlyOneOrTwoChildren(nodeToDelete, current.right);
        }
    }

    public void deletingMiddleNodeWithTreeBelow(BtNode nodeToDelete) {
        BtNode temp = deletingMiddleNodeWithTreeBelowHelper(this.root);
        nodeToDelete.data = temp.left.data;
        temp.left = null;
    }

    public BtNode deletingMiddleNodeWithTreeBelowHelper(BtNode current) {
        if (current.left.left == null) {
            return current;
        }
        if (current == this.root) {
            deletingMiddleNodeWithTreeBelowHelper(current.right);
        }
        return deletingMiddleNodeWithTreeBelowHelper(current.left);
    }

    public BtNode inorderPredecessor(BtNode current, int key) {
        BtNode predecessor = null;
        if (current == null) {
            return null;
        }
        if (key <= current.data) {
            return inorderPredecessor(current.left, key);
        } else {
            predecessor = inorderPredecessor(current.right, key);
            if (predecessor != null) {
                return predecessor;
            } else {
                return current;
            }
        }
    }

    public void inorderSuccessor(BtNode current) {
        if (current.left == null) {
            System.out.println(current.data);
            return;
        }
        if (current == this.root) {
            inorderSuccessor(current.left);
        }
        inorderSuccessor(current.right);
    }

    public void minimumElement(BtNode current) {
        if (current.left == null) {
            System.out.println(current.data);
            return;
        }
        minimumElement(current.left);
    }

    public void maximumElement(BtNode current) {
        if (current.right == null) {
            System.out.println(current.data);
            return;
        }
        maximumElement(current.right);
    }

    public void floorElement(double num, BtNode current, double gap, int answer) {
        if (num > current.data) {
            if ((num - current.data) < gap) {
                answer = current.data;
                gap = num - answer;
                if (current.right != null) {
                    floorElement(num, current.right, gap, answer);
                } else {
                    System.out.println(answer);
                }
            }
        }
        if (num < current.data) {
            if (current.left != null) {
                floorElement(num, current.left, gap, answer);
            } else {
                System.out.println(answer);
            }
        }
    }

    public int floorComparingRecursionStack(double num, BtNode current) {
        if (current == null) {
            return -1;
        }
        if (current.data == num) {
            return current.data;
        }

        if (current.data > num) {
            return floorComparingRecursionStack(num, current.left);
        } else {
            int floorFromRight = floorComparingRecursionStack(num, current.right);
            if (floorFromRight <= num && floorFromRight != -1) {
                return floorFromRight;
            } else {
                return current.data;
            }
        }

    }

    public void ceilingElement(double num, BtNode current, double gap, int answer) {
        if (num > current.data) {
            if (current.right != null) {
                ceilingElement(num, current.right, gap, answer);
            } else {
                System.out.println(answer);
            }
        }
        if (num < current.data) {
            if ((num - current.data) < gap) {
                answer = current.data;
                gap = answer - num;
                if (current.left != null) {
                    ceilingElement(num, current.left, gap, answer);
                } else {
                    System.out.println(answer);
                }
            }
        }
    }

    public void handlingDuplicates(BtNode nodeToInsert, BtNode current) {
        if (nodeToInsert.data < current.data) {
            if (current.left == null) {
                current.left = nodeToInsert;
            } else {
                handlingDuplicates(nodeToInsert, current.left);
            }
        } else {
            if (current.right == null) {
                current.right = nodeToInsert;
            } else {
                handlingDuplicates(nodeToInsert, current.right);
            }
        }
    }

    public int kthLargestElementUsingArrayForStoringResult(int k, BtNode current, int[] arr) {
        if (current == null) {
            return -1;
        }
        int result = kthLargestElementUsingArrayForStoringResult(k, current.right, arr);
        if (result != -1) {
            return result;
        }

        arr[0]++;
        if (arr[0] == k) {
            System.out.println(current.data);
            arr[1] = current.data;
            return current.data;
        }
        return kthLargestElementUsingArrayForStoringResult(k, current.left, arr);
    }

    public int kthLargestElement(int k, BtNode current, int[] arr) {
        if (current == null) {
            return -1;
        }
        int result = kthLargestElement(k, current.right, arr);
        if (result != -1) {
            return result;
        }

        arr[0]++;
        if (arr[0] == k) {
            return current.data;
        }
        return kthLargestElement(k, current.left, arr);
    }

    /**
     * In java the default parameter type is passing by value but through the recursion stack we want the variable count value to actually get
     * updated only when we want for every recursion after updating and not just for that particular recursion call. For that purpose
     * we use count as an array here since arrays are passed by reference but variables are passed by values. So everytime we need to access
     * the count variable we access the 0th element of the count array 
     * @param k
     * @param current
     * @param count
     * @param sum
     * @return
     */
    public int sumOfkLargestElements(int k, BtNode current, int[] count, int sum) {
        if (current == null) {
            return sum;
        }
        sum = sumOfkLargestElements(k, current.left, count, sum);
        count[0]++;
        if (count[0] <= k) {
            sum += current.data;
        }
        else{
            return sum;
        }
        sum = sumOfkLargestElements(k, current.right, count, sum);
        return sum;
    }

//Using inorder traversal
    public void creatingArrayOfBSTNodes(BtNode current, ArrayList<
Integer> arr) {
        if (current == null) {
            return;
        }
        creatingArrayOfBSTNodes(current.left, arr);
        arr.add(current.data);
        creatingArrayOfBSTNodes(current.right, arr);
    }

    public BtNode balancingBST(ArrayList<
Integer> arr, int start, int end) {
        int middle = (start + end) / 2;
        if (start > end) {
            return null;
        }
        BtNode root = new BtNode(arr.get(middle));
        root.left = balancingBST(arr, start, middle - 1);
        root.right = balancingBST(arr, middle + 1, end);
        return root;
    }
    //This exhibits level order traversal

    public boolean isBinaryTreeBST(BtNode current){
        boolean temp = true;
        if(current == null){
            return true;
        }
        if(current.left != null) {
            if (current.left.data > current.data) {
                return false;
            }
        }
        if(current.right != null) {
            if (current.right.data < current.data) {
                return false;
            }
        }
       temp = isBinaryTreeBST(current.left);
       temp = isBinaryTreeBST(current.right);
        if(!temp){
            return false;
        }
        else{
            return true;
        }
    }

    public void binaryTreeToBinarySearchTree(BtNode current, ArrayList<
Integer> arr, int[] count){
        if(current == null){
            return;
        }
        binaryTreeToBinarySearchTree(current.left, arr, count);
                if(current.data != arr.get(count[0])) {
                current.data = arr.get(count[0]);
                count[0]++;
            }

        binaryTreeToBinarySearchTree(current.right, arr, count);
    }

    private static int findNextIndex(int[]arr, int start, int min, int max){
        for(int i=start; i<arr.length; i++){
            if(arr[i] > min && arr[i] < max){
                return arr[i];
            }
        }
        return -1;
    }

    //Not done
    public static boolean areBSTIdentical(int[]arr1, int[]arr2, int i1, int i2, int min, int max){
        if(arr1.length != arr2.length){
            return false;
        }
        int j1 = findNextIndex(arr1, i1, min, max);
        int j2 = findNextIndex(arr2, i2, min, max);
        if(j1 == -1 && j2 == -1){
            return true;
        }
        if(j1 == -1 || j2 == -1){
            return false;
        }
//        if(arr1[i1] != arr2[i2]){
//            return false;
//        }
        int val = arr1[i1];
        boolean left = areBSTIdentical(arr1, arr2, i1+1, i2+1, min, val);
        boolean right = areBSTIdentical(arr1, arr2, i1+1, i2+1, val, max);
        return left && right;
    }

    //Not done
    public void sortedArrayToBSTUsingQueue(int[] arr, QueueInLinkedList queue, int arrStart, int arrEnd){
        if(arrStart > arrEnd){
            return;
        }
        int middle = (arrStart+arrEnd)/2;
        SLL_Node QueueNode = new SLL_Node(middle);
        QueueNode.start = 0;
        QueueNode.end = 6;
        queue.enQueue(QueueNode.data);
        int temp = queue.deQueue();
        BtNode treeNode = new BtNode(temp);
    }
    //Min heap is a type of bt wherein the smallest node is the root and all the elements on the left of the tree are smaller than the
    //elements on the right
    public void binaryTreeToMinHeap(ArrayList<
Integer> arr, BtNode current, int[] count){
        if(current == null){
            return;
        }
        if(current.data != arr.get(count[0])){
            current.data = arr.get(count[0]);
        }
        count[0]++;
        binaryTreeToMinHeap(arr, current.left, count);
        binaryTreeToMinHeap(arr, current.right, count);
    }

    public void addAllGreaterElementsToNode(BtNode current, int[] sum){
        if(current == null){
            return;
        }
        addAllGreaterElementsToNode(current.right, sum);
        sum[0] += current.data;
        current.data = sum[0];
        addAllGreaterElementsToNode(current.left, sum);
    }

    public static boolean BSTContainingSameElements(BST tree1, BST tree2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        tree1.creatingArrayOfBSTNodes(tree1.root, arr1);
        tree2.creatingArrayOfBSTNodes(tree2.root, arr2);
        if(arr1.size() != arr2.size()){
            return false;
        }
        for(int i=0; i<arr1.size(); i++){
            if(!arr1.get(i).equals(arr2.get(i))){
                return false;
            }
        }
        return true;
    }

//    public static void buildingPreorderFromArr(int[] arr, ArrayList<
//Integer> preorder, int min, int max){
//        int smallerCounter = 0;
//        if(min != Integer.MIN_VALUE){
//            smallerCounter = min;
//        }
//        if(!preorder.isEmpty()) {
//            max = preorder.getLast();
//        }
//        if(min == arr[0]){
//            smallerCounter = 0;
//        }
//        for(; smallerCounter<arr.length; smallerCounter++){
//            if(arr[smallerCounter] > min && arr[smallerCounter] < max){
//                break;
//            }
//        }
//        if(smallerCounter == arr.length){
//            return;
//        }
//        preorder.add(arr[smallerCounter]);
//        buildingPreorderFromArr(arr, preorder, min, max);
//
//        min = arr[smallerCounter];
//        int largerCounter = min;
//        if(min == arr[0] && max == Integer.MAX_VALUE){
//             largerCounter = 0;
//        }
//        for(; largerCounter<arr.length; largerCounter++){
//            if(arr[largerCounter] > min && arr[largerCounter] < max){
//                break;
//            }
//        }
//        //min = max;
//        if(largerCounter == arr.length){
//            return;
//        }
//        preorder.add(arr[largerCounter]);
//        buildingPreorderFromArr(arr, preorder, min, max);
//    }


        public static ArrayList<Integer> getPreorder(int[] arr) {
            ArrayList<Integer> out = new ArrayList<>();
            preorder(arr, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, out);
            return out;
        }

        // Find the first index >= start whose value is in (min, max)
        private static int nextIdxInRange(int[] arr, int start, int min, int max) {
            for (int i = start; i < arr.length; i++) {
                if (arr[i] > min && arr[i] < max){
                    return i;
                }
            }
            return -1;
        }

        private static void preorder(int[] arr, int start, int min, int max, ArrayList<Integer> out) {
            int idx = nextIdxInRange(arr, start, min, max);
            if (idx == -1) {
                return;                   // no node in this range
            }

            int root = arr[idx];
            out.add(root);                            // visit root (preorder)

            // Left subtree: values in (min, root)
            preorder(arr, idx + 1, min, root, out);

            // Right subtree: values in (root, max)
            preorder(arr, idx + 1, root, max, out);
        }
        public static BtNode constructingBSTFromPreorder(int[] arr, int[] index, int min, int max){
            if(index[0] >= arr.length){
                return null;
            }
            int key = arr[index[0]];
            if(key <= min || key >= max){
                return null;
            }
            BtNode root = new BtNode(key);
            index[0]++;

            root.left = constructingBSTFromPreorder(arr, index, min, key);
            root.right = constructingBSTFromPreorder(arr, index, key, max);
            return root;
        }

    /**
     * Problem: We have to check if the given two arrays create the same bst or not
     * Approach: We know that if their preorder is same then the bst's created will also be same thus we first try to find the preorder
     *           of both the bst's only using their arrays and just compare if the arrays we got are same or not
     * @param arr1
     * @param arr2
     * @return
     */
        public static boolean areSameBSTs(int[] arr1, int[] arr2){
            int[] preOrder1 = new int[10];
            int[] preOrder2 = new int[10];
            getPreorder(preOrder1);
            getPreorder(preOrder2);
            for(int i=0; i<preOrder1.length; i++){
                if(preOrder1[i] != preOrder2[i]){
                    return false;
                }
            }
            return true;
        }

        public static boolean areSameBSTsWithoutUsingArrays(int[] arr1, int[] arr2, int n, int l, int r, int min, int max){
            int leftIndex = l;
            int rightIndex = r;
            for(; leftIndex<n; leftIndex++){
                if(arr1[leftIndex] > min && arr1[leftIndex] < max){
                    break;
                }
            }

            for(; rightIndex<n; rightIndex++){
                if(arr2[rightIndex] > min && arr2[rightIndex] < max){
                    break;
                }
            }

            if(leftIndex == n && rightIndex == n){
                return true;
            }

            if((leftIndex == n || rightIndex == n) || arr1[leftIndex] != arr2[rightIndex]){
                return false;
            }
            return areSameBSTsWithoutUsingArrays(arr1, arr2, n, leftIndex+1, rightIndex+1, arr1[leftIndex], max) &&
                    areSameBSTsWithoutUsingArrays(arr1, arr2, n, leftIndex+1, rightIndex+1, min, arr1[leftIndex]);

        }

}