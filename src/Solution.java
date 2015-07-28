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
        if(root == null)
            return null;
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null){
                stack.push(node.left);
            }
        }

        return result;
    }

    public List<Integer> preorderTraversalDivideConquer(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // null or leaf
        if (root == null) {
            return result;
        }

        // Divide
        List<Integer> left = preorderTraversalDivideConquer(root.left);
        List<Integer> right = preorderTraversalDivideConquer(root.right);

        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}
