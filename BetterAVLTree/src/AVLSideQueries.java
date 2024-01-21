import java.util.ArrayList;

public class AVLSideQueries {

    static ArrayList<Integer> list = new ArrayList<>();
    public AVLSideQueries(){
        this.list = new ArrayList<>();
    }
//    Method to Print Tree method
    public static void printTree(Tree node){
        printTreeRec(node);
        System.out.println();
    }
//    Helper method using recursive to print data Inorder.
    private static void printTreeRec(Tree node){
        if(node == null){
            return;
        }
        printTreeRec(node.left);
        System.out.print(node.data+" ");
        printTreeRec(node.right);
    }
    public static int MedianQuery(Tree node){
        int size = list.size();
        return list.get(size/2);
    }
}
