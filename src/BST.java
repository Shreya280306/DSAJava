public class BST {
    BtNode right;
    BtNode left;
    BtNode root;

    BST(){
       this.root = null;
       this.left = null;
       this.right = null;
    }
    BST(BtNode node){
        this.root = node;
        this.left = node.left;
        this.right = node.right;
    }

    public void inorderTraversal(BtNode root, int pred) {
        if(root == null){
            return;
        }
            inorderTraversal(root.left, pred);
            System.out.println(root.data);
            inorderTraversal(root.right, pred);
    }

    public void preorderTraversal(BtNode root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public void postorderTraversal(BtNode root){
        if(root == null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.data);
    }

    public BtNode addingLeafNode(BtNode root, BtNode node) {
        if(node.data == root.data){
            return node;
        }
        if(node.data < root.data){
            if(root.left == null){
                root.left = node;
            }
            addingLeafNode(root.left, node);
        }
        if(node.data > root.data){
            if(root.right == null){
                root.right = node;
            }
            addingLeafNode(root.right, node);
        }
        return root;
    }

    public BtNode locatingElement(BtNode root, BtNode node){
        if(root == null || root.data == node.data){
            return root;
        }
        if(node.data < root.data){
           return locatingElement(root.left, node);
        }
        else{
            return locatingElement(root.right, node);
        }
    }

    public BtNode deletingNode(BtNode root, int x){
        if(root == null){
            return root;
        }
        if(x < root.data){
           root.left = deletingNode(root.left, x);
        }
        if(x > root.data){
            root.right = deletingNode(root.right, x);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
        }
        BtNode succ = getSuccessor(root);
        root.data = succ.data;
        root.right = deletingNode(root.right, succ.data);
        return root;
    }

    private static BtNode getSuccessor(BtNode node){
        node = node.right;
        while(node != null && node.left != null){
            node = node.left;
        }
        return node;
    }

    public BtNode insertingLeafNode(BtNode root, BtNode node){
        if(root == null){
            return root;
        }
        if(node.data < root.data){
            if(root.left == null){
                root.left = node;
            }
            insertingLeafNode(root.left, node);
        }
        if(node.data > root.data){
            if(root.right == null){
                root.right = node;
            }
            insertingLeafNode(root.right, node);
        }
        return root;
    }

    public BtNode minimumInBST(BtNode root){
        while(root.left != null) {
            return minimumInBST(root.left);
        }
        return root;
    }

    public BtNode maximumInBST(BtNode root){
        while(root.right != null) {
            return maximumInBST(root.right);
        }
        return root;
    }

    public int floorInBST(BtNode root, int x) {
        if(root == null){
            return -1;
        }
        if(root.data == x){
            return root.data;
        }
        if(root.data > x){
            floorInBST(root.left, x);
        }

            int val = floorInBST(root.right, x);
            if(val <= x && val != -1){
                return val;
            }
            else{
                return root.data;
            }
    }

    public int ceilingInBst(BtNode root, int x){
        if(root == null){
            return -1;
        }
        if(root.data == x){
            return root.data;
        }
        if(root.data < x){
            ceilingInBst(root.right, x);
        }
        int ceil = ceilingInBst(root.left, x);
        if(ceil >= x && ceil != -1){
            return ceil;
        }
        else{
            return root.data;
        }
    }

    public BtNode inorderPredecessor(BtNode root, int x){
        if(root == null){
            return null;
        }
        if(root.data > x){
            return inorderPredecessor(root.left, x);
        }
        if(root.data == x && root.left != null){
            return maximumInBST(root.left);
        }
        else{
            BtNode pred = root;
            if(root.right.data == x){
                return pred;
            }
            return inorderPredecessor(root.right, x);
        }
    }

    private void reverseInBST(BtNode root, int[] count, int[] result) {
        if(root == null){
            return;
        }
        reverseInBST(root.right, count, result);
        count[0]++;
        if(count[0] == 2){
            result[0] = root.data;
            return;
        }
        reverseInBST(root.left, count, result);
    }

    public int secondLargestElement(BtNode root){
        int[] count = {0};
        int[] result = {-1};
        reverseInBST(root, count, result);
        return result[0];
    }
}
