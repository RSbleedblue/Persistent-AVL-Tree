import java.util.HashMap;

public class AvlDS {
    private int versions; //To track version of the Tree
    private HashMap<Integer, Tree> AVLVersions;//Hashmap to store tree and version
    private Tree root;//Main Root of the tree.

// Constructor to initialize the AVL tree
    public AvlDS() {
        this.versions = 0;
        this.AVLVersions = new HashMap<>();
    }
// Method to insert new node into the tree
    public void insert(int data) {
        root = insertRec(root, data);
        versions++;
        AVLVersions.put(versions, new Tree(root));
    }
// Helper function for adding new node using Recursion
    private Tree insertRec(Tree node, int data) {
        if (node == null) {
            node = new Tree(data);
        }

        else if (data < node.data) {
            node.left = insertRec(node.left, data);
        } else if (data > node.data) {
            node.right = insertRec(node.right, data);
        }

        updateHeight(node);

        int balanceFactor = getBalance(node);

        if (balanceFactor > 1) {
            if (data < node.left.data) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balanceFactor < -1) {
            if (data > node.right.data) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }
//    Method to delete a node from the tree.
    public void delete(int data) {
        root = deleteRec(root, data);
        versions++;
        AVLVersions.put(versions, new Tree(root));
    }
//  Helper method to delete a node from tree using Recursion
    private Tree deleteRec(Tree node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = deleteRec(node.left, data);
        } else if (data > node.data) {
            node.right = deleteRec(node.right, data);
        } else {
            // Node to be deleted found

            // Case 1: Node with only one child or no child
            if (node.left == null || node.right == null) {
                Tree temp = (node.left != null) ? node.left : node.right;

                // No child
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    // One child
                    node = temp;
                }
            } else {
                // Case 2: Node with two children
                Tree successor = findSuccessor(node.right);
                node.data = successor.data;
                node.right = deleteRec(node.right, successor.data);
            }
        }

        // Update height and balance factor
        updateHeight(node);

        // Re-balance the tree
        int balanceFactor = getBalance(node);
        if (balanceFactor > 1) {
            if (getBalance(node.left) >= 0) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balanceFactor < -1) {
            if (getBalance(node.right) <= 0) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }
    //Method to find successor in Order to Balance The Tree
    private Tree findSuccessor(Tree node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

//     Rotation methods to balance the AVL tree
    private Tree leftRotate(Tree node) {
        Tree x = node.right;
        Tree y = x.left;

        x.left = node;
        node.right = y;

        updateHeight(node);
        updateHeight(x);

        return x;
    }
// Rotation methods to balance the AVL tree
    private Tree rightRotate(Tree node) {
        Tree x = node.left;
        Tree y = x.right;

        x.right = node;
        node.left = y;

        updateHeight(node);
        updateHeight(x);

        return x;
    }
// Helper method to update the height of a node
    private void updateHeight(Tree node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }
// Helper method to get the height of a node
    private int height(Tree node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }
//  Helper method to get Balance factor of the node
    private int getBalance(Tree node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }
// Method to retrieve all the versions stored in the HashMap.
    public HashMap<Integer,Tree> getVersions() {
        return AVLVersions;
    }
//    Selective Method in order to have a specific verison of the Tree.
    public Tree getByVersions(int v){
        if(AVLVersions.containsKey(v)){
            Tree FoundedNode = AVLVersions.get(v);
            return FoundedNode;
        }
        return null;
    }
}
