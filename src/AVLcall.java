import java.util.HashMap;
import java.util.Map;

public class AVLcall {
    public static void main(String args[]){
        AvlDS tree = new AvlDS();
        AVLSideQueries q = new AVLSideQueries();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(8);
        tree.insert(6);
        tree.delete(3);
        tree.delete(6);
        tree.delete(2);
        HashMap<Integer,Tree> map = tree.getVersions();
        for(Map.Entry<Integer,Tree> e: map.entrySet()){
            System.out.print("Version : ["+e.getKey()+"] ");
            q.printTree(e.getValue());
        }
        Tree founded = tree.getByVersions(4);
        q.printTree(founded);
        int medianQuery = q.MedianQuery(founded);
        System.out.println("Median for version 3 is: "+medianQuery);

    }
}
