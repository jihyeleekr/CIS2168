class BST {
    // Create root
    Node root;
    public BST() {
        this.root = null;
    }

    // Insert the root into the tree
    void insert(Node parent, int val) {
        if (parent == null) {
            root = new Node(val); // If the tree is empty, create a new root node
        } else if (val < parent.val) {
            if (parent.left == null) {
                parent.left = new Node(val);
                parent.left.parent = parent;
            } else {
                insert(parent.left, val);
            }
        } else if (val >= parent.val) {
            if (parent.right == null) {
                parent.right = new Node(val);
                parent.right.parent = parent;
            } else {
                insert(parent.right, val);
            }
        }
    }

    public Node Successor(Node node) {
        if (node == null) {
            return null;
        }

        // If the node has a right child, find the leftmost node in the right subtree
        if (node.right != null) {
            return minVal(node.right);
        }

        // If the node doesn't have a right child, find the first ancestor that is a left child
        Node successor = null;
        Node current = root; // Start from the root

        while (current != null) {
            if (node.val < current.val) {
                successor = current; // Update the potential successor
                current = current.left; // Traverse the left subtree
            } else if (node.val > current.val) {
                current = current.right; // Traverse the right subtree
            } else {
                break; // Node found, stop searching
            }
        }

        return successor;
    }

    private Node minVal(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node delete(Node root, int val) {
        if (root == null) {
            return root; // Value not found
        }

        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            // Node with the value to be deleted found

            // Case 1: Node has no children (leaf node)
            if (root.left == null && root.right == null) {
                root = null;
            }
            // Case 2: Node has one child
            else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }
            // Case 3: Node has two children
            else {
                // Find the in-order successor
                Node successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }

                // Replace the node's value with the in-order successor's value
                root.val = successor.val;

                // Recursively delete the in-order successor
                root.right = delete(root.right, successor.val);
            }
        }
        return root; // Value deleted

    }

    // Traversal

    // Inorder: left -> root -> right
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + " ");
            inOrder(node.right);
        }
    }
    // Postorder: left -> right -> root
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + " ");
        }
    }

    // Preorder: root -> left -> right
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    // Search Operation

    public boolean search(Node node, int val) {
        // return false when the tree is empty
        if (node == null) {
            return false;
        }
        // If the root is the value that we are looking for then return true
        if (val == node.val) {
            return true;
            // If the value that we are looking for is smaller than the root then check the left subtree.
        } else if (val < node.val) {
            return search(node.left, val);
            // If the value that we are looking for is greater than the root then check the right subtree.
        } else {
            return search(node.right, val);
        }
    }


    // Subtree size calculation
    public int SubtreeSizes(Node node) {
        if (node == null) {
            return 0;
        }

        int leftSize = SubtreeSizes(node.left);
        int rightSize = SubtreeSizes(node.right);

        int totalSize = leftSize + rightSize + 1;
        System.out.println("Node " + node.val + ": Left Subtree Size = " + leftSize + ", Right Subtree Size = " + rightSize);

        return totalSize;
    }

    // Extra Credit: Height calculation
    public int getHeight(Node node) {
        // If the tree is empty then return 0(no height)
        if (node == null) {
            return 0;
        }
        //Get the height of the left subtree
        int leftHeight = getHeight(node.left);
        //Get the height of the right subtree
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

}

