public class BinarySearchTree {
    private Node root; //We need to make this variable private cause when we create a BST we need to protect the root

    public Node getRoot() {
        return root;
    }

    public BinarySearchTree(){
        root = null;
    }

    //Insert
    public void insert(int value) {
        root = insertRecursive(root, value);
    }
    private Node insertRecursive(Node root, int value){ // This root it's a new root that represent a new father/root
        if (root == null){ //Verify if the tree is empty
            root = new Node(value); // Assign a value to root with a new node
            return root; // Return the root
        }

        if(value < root.value){
            root.left = insertRecursive(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecursive(root.right, value);
        }
        return root;
    }

    //Remove
    public Node searchMinor(Node root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
    public void remove(int value){
        root = removeRecursive(root, value);
    }
    private Node removeRecursive(Node root, int value){
        if (root == null) return root; //Base: Node nor found

        if (value < root.value){
            root.left = removeRecursive(root.left, value);
        } else if (value > root.value){
            root.right = removeRecursive(root.right, value);
        } else {
            //Case 1: Node leaf - no children
            if (root.right == null && root.left == null){
                return null;
            }
            //Case 2: Node with only one child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            //Case 3: Node with two children
            else {
                Node successor = searchMinor(root.right); //Search a successor
                root.value = successor.value; //Replaced by successor
                root.right = removeRecursive(root.right, successor.value);
            }
        }
        return root;
    }

    //Additional properties
    public int height() {
        return heightRec(root);
    }
    private int heightRec(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = heightRec(node.left);
        int rightHeight = heightRec(node.right);

        if (leftHeight > rightHeight) {
            return 1 +leftHeight;
        } else if (rightHeight > leftHeight) {
            return 1 +rightHeight;
        } else {
            return 1+ rightHeight;
        }
    }

    public int countNode() {
        return countNodeRec(root);
    }
    private int countNodeRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodeRec(node.left) + countNodeRec(node.right);
    }

    public int countLeaves() {
        return countLeavesRec(root);
    }
    private int countLeavesRec(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) { //If a node doesn't have child the code plus 1
            return 1;
        }
        return countLeavesRec(node.left) + countLeavesRec(node.right);
    }

    public int depthNode(int value) {
            return depthNodeRec(root, value, 0);
    }
    private int depthNodeRec(Node node, int value, int currentDepth) {
        if (node == null) {
            return -1;
        }
        if (node.value == value) {
            return currentDepth;
        }
        // search in the trees
        int depth = depthNodeRec(node.left, value, currentDepth + 1); //left
        if (depth != -1) {
            return depth; // if left returns depth
        }
        return depthNodeRec(node.right, value, currentDepth + 1); // right
    }

    //Search
    public boolean search(int value){
        return searchRecursive(root, value);
    }
    private boolean searchRecursive(Node node, int value){
        if (node == null) return false;

        if (node.value == value) return true;

        if(value < node.value){
            return searchRecursive(node.left, value);
        } else {
            return searchRecursive(node.right, value);
        }
    }

    //Print
    public void printInOrder(){
        System.out.print("In order: ");
        printInOrderRec(root);
        System.out.println();
    }
    private void printInOrderRec(Node root){
        if (root != null){
            printInOrderRec(root.left);
            System.out.print(root.value + " ");
            printInOrderRec(root.right);
        }
    }

    public void printPreOrder() {
        System.out.print("Pre order: ");
        printPreOrderRec(root);
        System.out.println();
    }
    private void printPreOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            printPreOrderRec(root.left);
            printPreOrderRec(root.right);
        }
    }

    public void printPosOrder() {
        System.out.print("Pos order: ");
        printPosOrderRec(root);
        System.out.println();
    }
    private void printPosOrderRec(Node root) {
        if (root != null) {
            printPosOrderRec(root.left);
            printPosOrderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

}
