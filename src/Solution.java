import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sun38 on 7/27/2015.
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        traverse(root, ret);
        return ret;
    }

    private void traverse(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }
        result.add(node.val);
        traverse(node.left, result);
        traverse(node.right, result);
    }

    public List<Integer> preOrderStack(TreeNode root){
        Stack<Integer> stack = new Stack<Integer>();
        return null;
    }
}
