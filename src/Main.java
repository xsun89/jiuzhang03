import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        root.left = a;
        root.right = b;
        a.left = new TreeNode(3);
        a.right = new TreeNode(4);

        Solution solution = new Solution();
        List<Integer> ret = solution.preorderTraversal(root);
        Iterator<Integer> it = ret.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
