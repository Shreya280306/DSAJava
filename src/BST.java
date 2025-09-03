import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
            return result; //This condition is when you've found your answer and need to return it through the recursion stack then we can
                            // simply put a check as to if the result value stores our answer or n
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
    public void creatingArrayOfBSTNodes(BtNode current, ArrayList<Integer> arr) {
        if (current == null) {
            return;
        }
        creatingArrayOfBSTNodes(current.left, arr);
        arr.add(current.data);
        creatingArrayOfBSTNodes(current.right, arr);
    }

    public static BtNode balancingBST(ArrayList<Integer> arr, int start, int end) {
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

    public void binaryTreeToBinarySearchTree(BtNode current, ArrayList<Integer> arr, int[] count){
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
//

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

        private static SLL newListFromGivenList(SLL list){
            SLL newList = new SLL();
            SLL_Node current = list.head;
            while(current != null){
                SLL_Node temp = new SLL_Node(current.data);
                newList.addNodeInEnd(temp);
                current = current.next;
            }
            return newList;
        }

    /**
     * Problem: Given a sorted linked list, create a BST from it
     * Approach: We found the middle for the list and cut the list into two parts sending only the left half for the root.left and only the
     *           right half for the root.right
     * Problem with this approach: The time complexity here increases since we can't directly access the middle element like in an array so
     *                             we have to traverse the list everytime to find the middle element. We will also have to traverse the list
     *                             twice to cut it into two parts since it can't just be cut like an array.
     * Alternate approach: We could also have put the elements of the linked list into an array and then solved like before- O(N)
     * @param list
     * @return
     */
    public static BtNode sortedLinkedListToBalancedBST(SLL list){
            SLL leftList = newListFromGivenList(list);
            SLL rightList = newListFromGivenList(list);

            int middle = list.returnMiddleNode();
            BtNode root = new BtNode(middle);

            SLL_Node leftcurrent = leftList.head;//working on making the leftList
            if(leftcurrent.next != null) {
                while (leftcurrent.next.data != middle) {
                    leftcurrent = leftcurrent.next;
                }
                leftcurrent.next = null;
            }
            else{
                return root;
            }

            SLL_Node rightcurrent = rightList.head;
            if(rightcurrent.next != null) {
                while (rightcurrent.data != middle) {
                    rightcurrent = rightcurrent.next;
                }
                SLL_Node temp = rightcurrent.next;
                rightcurrent.next = null;
                rightList.head = temp;
            }
            else{
                return root;
            }

            root.left = sortedLinkedListToBalancedBST(leftList);
            root.right = sortedLinkedListToBalancedBST(rightList);
            return root;
        }

        public static BtNode SLLToBSTWithoutMiddle(SLL list, int lengthOfList){
            if(lengthOfList <= 0){
                return null;
            }
            BtNode left = SLLToBSTWithoutMiddle(list, lengthOfList/2);
            BtNode root = new BtNode(list.head.data);
            root.left = left;
            list.head = list.head.next;
            root.right = SLLToBSTWithoutMiddle(list, lengthOfList-lengthOfList/2 - 1);
            return root;
        }

    public void BSTToGreaterSumTree(SLL list, BtNode current, int[] sum){
        if(current == null){
            return;
        }
        BSTToGreaterSumTree(list, current.right, sum);
        int temp = current.data;
        current.data = sum[0];
        sum[0] += temp;
        BSTToGreaterSumTree(list, current.left, sum);
    }

    public void BSTToSmallerSumTree(SLL list, BtNode current, int[] sum){
        if(current == null){
            return;
        }
        BSTToSmallerSumTree(list, current.left, sum);
        sum[0] += current.data;
        current.data = sum[0];
        BSTToSmallerSumTree(list, current.right, sum);
    }


    /**
     * Problem: Given a BST we need to find its level order traversal
     * Approach: We put the BtNodes in a queue here and then dequeue one at a time which solves our problem of the location or order the
     *           nodes are supposed to come in
     * @param result
     * @param root
     */
    public void BSTLevelOrderTraversal(ArrayList<Integer> result, BtNode root) {
        QueueInLinkedList queue = new QueueInLinkedList();
        queue.enqueueBtNode(root);

        while (!queue.isEmptyQueue()) {
            BtNode current = queue.dequeueBtNode();
            result.add(current.data);
            if (current.left != null) {
                queue.enqueueBtNode(current.left);
            }
            if (current.right != null) {
                queue.enqueueBtNode(current.right);
            }
        }
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    /**
     * Approach: Using DP in binary tree
     * @param root
     * @param dp
     * @return
     */
    public int maxSumOfNonAdjacentNodes(BtNode root, HashMap<BtNode, Integer> dp){
        if(root == null){
            return 0;
        }
        int pick = root.data;
        if(root.left != null) {
            pick = pick + maxSumOfNonAdjacentNodes(root.left.left, dp) + maxSumOfNonAdjacentNodes(root.left.right, dp);
        }

        if(root.right != null) {
            pick = pick + maxSumOfNonAdjacentNodes(root.right.left, dp) + maxSumOfNonAdjacentNodes(root.right.right, dp);
        }
        int notPick = maxSumOfNonAdjacentNodes(root.left, dp) + maxSumOfNonAdjacentNodes(root.right, dp);
        return Math.max(pick, notPick);
    }

    public static BtNode getNode(int data){
        BtNode newNode = new BtNode(data);
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    /**
     * Problem: We have been given an array which contains the level order of BST nodes we need to find the BST fro that
     * Approach: We make a new queue which takes in a binary tree node along with min and max values which get updated comparing with the
     *           current array element. This question is the combination of the min max approach along with the putting into a queue approach
      * @param arr
     * @return
     */
    public static BtNode getBSTFromLevelOrder(int[]arr){
        BtNode root = new BtNode(arr[0]);
        QueueForLevelOrderBST queue = new QueueForLevelOrderBST();
        queue.enqueue(new QueueForLevelOrderBSTNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        int i = 1;
        while(i < arr.length && !queue.isEmptyQueue()){
            QueueForLevelOrderBSTNode queueNode = queue.dequeue();

            if(arr[i] > queueNode.min && arr[i] < queueNode.btnode.data){
                queueNode.btnode.left = new BtNode(arr[i]);
                queue.enqueue(new QueueForLevelOrderBSTNode(queueNode.btnode.left, queueNode.min, queueNode.btnode.data));
                i++;
            }

            if(arr[i] > queueNode.btnode.data && arr[i] < queueNode.max){
                queueNode.btnode.right = new BtNode(arr[i]);
                queue.enqueue(new QueueForLevelOrderBSTNode(queueNode.btnode.right, queueNode.btnode.data, queueNode.max));
                i++;
            }
        }
        return root;
    }

    public static boolean isArrayLevelOrder(int[] arr){
        BtNode root = new BtNode(arr[0]);
        QueueForLevelOrderBST queue = new QueueForLevelOrderBST();
        queue.enqueue(new QueueForLevelOrderBSTNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        int i = 1;
        while(i < arr.length && !queue.isEmptyQueue()){
            QueueForLevelOrderBSTNode queueNode = queue.dequeue();

            if(arr[i] > queueNode.min && arr[i] < queueNode.btnode.data){
                queueNode.btnode.left = new BtNode(arr[i]);
                queue.enqueue(new QueueForLevelOrderBSTNode(queueNode.btnode.left, queueNode.min, queueNode.btnode.data));
                i++;
            }

            if(arr[i] > queueNode.btnode.data && arr[i] < queueNode.max){
                queueNode.btnode.right = new BtNode(arr[i]);
                queue.enqueue(new QueueForLevelOrderBSTNode(queueNode.btnode.right, queueNode.btnode.data, queueNode.max));
                i++;
            }
        }
            if(arr.length == i){
                return true;
            }
            else{
                return false;
            }
    }

    public boolean inorder(BtNode root, BtNode prevNode) {
        if(root == null){
            return true;
        }

        if(!inorder(root.left, prevNode)){
            return false;
        }
        if(prevNode != null && root.data <= prevNode.data){
            return false;
        }
        return inorder(root.right, root);
    }

    /**
     * Question: This is a binary tree. Given two nodes we need to find their lowest common ancestor- the node that is
     *           common to them in the tree or the node where the two given nodes connect.
     * Approach: Since this is a binary tree we can't just use the interval approach so, we store the paths in the tree in arrays until we
     *           find the node and then compare the two paths to give their common element as LCA. For finding the paths we have to use
     *           backtracking since if my node is at the right i don't want my path to include the left node too while traversing so
     *           we check if the node is at the right or left and if not we remove the node that we just added to the arraylist
     * @param node1
     * @param node2
     * @param root
     * @return
     */
    public int lowestCommonAncestorBinaryTree(BtNode node1, BtNode node2, BtNode root){
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        notingPaths(root, path1, node1);
        notingPaths(root, path2, node2);
        int length;
        if(path1.size() > path2.size()){
            length = path2.size();
        }
        else{
            length = path1.size();
        }
        int common = 0;
        for(int i=0; i<length-1; i++){
            if(path1.get(i).equals(path2.get(i))){
                common = path1.get(i);
            }
        }
        return common;
    }

    private boolean notingPaths(BtNode root, ArrayList<Integer> path, BtNode nodeGiven) {
        if (root == null) {
            return false;
        }
        path.add(root.data);

        if (root == nodeGiven) {
            return true;
        }
        if(notingPaths(root.left, path, nodeGiven) || notingPaths(root.right, path, nodeGiven)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    /**
     * Approach: Trying to find the pattern between the nodes and their LCA we see that the LCA always lies in the middle of both the nodes
     *           of the BST. Moreover, the LCA is the first node while traversing that lies between them so we break as soon as those conditions
     *           are met
     * @param node1
     * @param node2
     * @param root
     * @return
     */
    public BtNode LCAOfBST(BtNode node1, BtNode node2, BtNode root){
        if(root == null){
            return null;
        }
        if(root.data >= node1.data && root.data <= node2.data){
            return root;
        }
        if(node1.data <= root.data){
           return LCAOfBST(node1, node2, root.left);
        }
        else{
            return LCAOfBST(node1, node2, root.right);
        }
    }

    public int findingDistanceBetweenTwoNode(BtNode node1, BtNode node2, BtNode root){
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        notingPaths(root, path1, node1);
        notingPaths(root, path2, node2);
        int length1 = path1.size();
        int length2 = path2.size();
        return length1 + length2 - 2;
    }

    public boolean largestBSTinBT(BtNode root){
        if(root == null){
            return true;
        }
        boolean left = largestBSTinBT(root.left);
        boolean right = largestBSTinBT(root.right);

        if(root.left.data < root.data && root.right.data > root.data){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Problem: Given a binary tree we need to find the size of the largest subtree which is a binary search tree. Return the size which is
     *          the number of nodes present in the subtree.
     * Approach: Trying to find at each node if that node is the root for a BST. The check of whether it's a bst is a different function
     *          which is repeatedly called for every node. But the time complexity for this function is O(n2)
     * @param root
     * @param length
     * @param maxlength
     * @return
     */
    public int findingBSTFromBinaryTree(BtNode root, int[] length, int[] maxlength){
        if(root == null){
            return 0;
        }
        boolean result = isBinaryTreeBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, length);
        if(result){
            if(length[0] > maxlength[0]){
                maxlength[0] = length[0];
            }
            length[0] = 0;
            return maxlength[0];
        }
        else{
            length[0] = 0;
            findingBSTFromBinaryTree(root.left, length, maxlength);
            findingBSTFromBinaryTree(root.right, length, maxlength);
        }
        return maxlength[0];
    }

    public boolean isBinaryTreeBST(BtNode root, int min, int max, int[] length){
        if(root == null){
            return true;
        }
        length[0]++;
        if(root.data <= min || root.data >= max){
            return false;
        }
        return isBinaryTreeBST(root.left, min, root.data, length) && isBinaryTreeBST(root.right, root.data, max, length);
    }

    //taking an array arr[isBST, size, min, max]
    public int[] isBinaryTreeBST2(BtNode root, int[] maxSize){
        if(root == null){
            return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = isBinaryTreeBST2(root.left, maxSize);
        int[] right = isBinaryTreeBST2(root.right, maxSize);
        if(left[0] == 1 && right[0] == 1 && root.data > left[3] && root.data < right[2]){
            int size = left[1] + right[1] + 1;
            maxSize[0] = Math.max(size, maxSize[0]);
            int min = Math.min(root.data, left[2]);
            int max = Math.max(root.data, right[3]);
            return new int[]{1, size, min, max};
        }
        return new int[]{0, Math.max(left[1], right[1]), 0, 0};
    }



}