    public class Tree {
        int data;
        Tree left;
        Tree right;
        int height;
//         Default Constructor for the Tree
        public Tree(int data){
            this.data = data;
            this.height = 1;
        }

//        Deep copy of the tree in order to store versions.
        public Tree(Tree other) {
            this.data = other.data;
            this.height = other.height;
            this.left = (other.left != null) ? new Tree(other.left) : null;
            this.right = (other.right != null) ? new Tree(other.right) : null;
        }
    }
