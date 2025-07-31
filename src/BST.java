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


    public void creatingArrayOfBSTNodes(BtNode current, ArrayList<Integer> arr) {
        if (current == null) {
            return;
        }
        creatingArrayOfBSTNodes(current.left, arr);
        arr.add(current.data);
        creatingArrayOfBSTNodes(current.right, arr);
    }

    public BtNode balancingBST(ArrayList<Integer> arr, int start, int end) {
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
}