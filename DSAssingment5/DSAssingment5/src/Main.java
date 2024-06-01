
public class Main {
    public static void main(String[] args) {
        // Create new Tree
        BST tree = new BST();

        // Insert Nodes
        tree.insert(tree.root, 17);
        tree.insert(tree.root,12);
        tree.insert(tree.root,99);
        tree.insert(tree.root,8);
        tree.insert(tree.root,85);
        tree.insert(tree.root,4);
        tree.insert(tree.root,98);

        //Traversal
        System.out.println("Inorder traversal:");
        tree.inOrder(tree.root);
        System.out.println("");

        System.out.println("Preorder traversal:");
        tree.preOrder(tree.root);
        System.out.println("");

        System.out.println("Post-order traversal:");
        tree.postOrder(tree.root);
        System.out.println("");

        // Search for the node
        int valueToSearch = 85;
        System.out.println("Search for " + valueToSearch + ": " + tree.search(tree.root,valueToSearch));
        System.out.println("");

        int valueToDelete = 20;
        tree.delete(tree.root,valueToDelete);
        System.out.println("Deletion " + valueToDelete + ":");
        tree.inOrder(tree.root);

        System.out.println("Subtree sizes:");
        tree.SubtreeSizes(tree.root);
        System.out.println("");

        System.out.println("Height: " + tree.getHeight(tree.root));
    }

}