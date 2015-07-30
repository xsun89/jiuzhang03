import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(7);
        root.left = a;
        root.right = b;
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(6);
        b.left = c;
        b.right = d;

        Solution solution = new Solution();
        List<Integer> ret = solution.preOrderStack(root);
        Iterator<Integer> it = ret.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("---------------------------------------");
        List<Integer> ret2 = solution.preOrderStack(root);
        Iterator<Integer> it2 = ret.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }

        System.out.println("---------------------------------------");
        List<Integer> ret3 = solution.preorderTraversalDivideConquer(root);
        Iterator<Integer> it3 = ret.iterator();
        while(it3.hasNext()){
            System.out.println(it3.next());
        }
        System.out.println("---------------------------------------");
        int Arr[] = new int[]{3,5,0,4,6,1,2,4};
        solution.quickSort(Arr);

        for (int i=0 ; i < Arr.length ; i++) System.out.print(Arr[i] + " ");
        System.out.println();

        System.out.println("---------------------------------------");
        TreeNode retNode = solution.getAncestor(root, a, c);
        System.out.println(retNode.val);
    }
}
