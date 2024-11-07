//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        //insert
        bst.insert(33);
        bst.insert(4);
        bst.insert(8);
        bst.insert(7);
        bst.insert(37);
        bst.insert(55);
        bst.insert(3);
        //print in order
        bst.printInOrder();
        //search
        System.out.println(bst.search(4));
        //remove
        bst.remove(8);
        bst.printInOrder();
        //print pre order
        bst.printPreOrder();
        //print pos order
        bst.printPosOrder();
        //get height
        System.out.println("Number of edges: " + bst.height());
        //count node
        System.out.println("Number of nodes: " + bst.countNode());
        //count leaves
        System.out.println("Number of leaves: " + bst.countLeaves());
        //depth
        System.out.println("Depth of the node: " + bst.depthNode(7));
    }
}