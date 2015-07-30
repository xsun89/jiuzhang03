import java.util.ArrayList;
import java.util.Arrays;
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

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        traverse(node.left, result);
        traverse(node.right, result);
    }

    public List<Integer> preOrderStack(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null) {
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

    public void quickSort(int arr[]) {
        quickSortImpl(arr, 0, arr.length - 1);

        return;
    }

    private void quickSortImpl(int arr[], int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = getPartion(arr, left, right);
        quickSortImpl(arr, left, pivot - 1);
        quickSortImpl(arr, pivot + 1, right);
        return;
    }

    private int getPartion(int arr[], int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = pivot;

        return left;

    }

    public void mergeSort(int arr[]) {
        int tmpArray[] = new int[arr.length]; //����һ����ʱ�������������ʱ���������
        mergeSortImpl(arr, tmpArray, 0, arr.length - 1);     //��ʼ������鲢����


    }

    //�õݹ�ķ�������������й鲢����
    protected void mergeSortImpl(int arr[], int tmpArray[], int first, int last) {
        if (first < last) { //   ȷ�����鲻�ǿյ�
            int mid = (first + last) / 2;   //������ֳ�����
            //�������õݹ�ķ��������Ϸָ����顣��1��2��2��4���Դ����ơ�ֱ��ÿ�����鶼ֻʣ��2��Ԫ�ء�
            mergeSortImpl(arr, tmpArray, first, mid);
            mergeSortImpl(arr, tmpArray, mid + 1, last);
            // ������������ʱ����tmpArray[] �Էָ�����������͹鲢
            merge(arr, tmpArray, first, mid, last);
            System.out.println(Arrays.toString(arr));
        }
    }

    private void merge(int a[], int tmpArray[], int first, int mid, int last) {
        int beginHalf1 = first; //   ��һ���������ʼԪ���±�
        int endHalf1 = mid; //   ��һ�������ĩβԪ���±�
        int beginHalf2 = mid + 1; //   �ڶ����������ʼԪ���±�
        int endHalf2 = last; //   �ڶ��������ĩβԪ���±�
        int index = beginHalf1;  //   ��ʱ���������
        int num = last - first + 1;     //   ����ʱ����tmpArray���Ѿ��ź�˳���Ԫ�ؿ���������arr[]��Ҫ�Ĵ����� (����û���ź�˳���Ԫ����Ȼ�Ͳ��ø��ƹ�ȥ������arr��Щû�������Ԫ�ػ���ԭ����

        while ((beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2)) { // ȷ�Ϸָ������������Ƿ�ȡ�������һ��Ԫ��
            if (a[beginHalf1] <= a[beginHalf2]) {         //   �ֱ����������г�ȡ����Ԫ�ص�ֵ���бȽ�
                //���Ǹ�Ԫ��ֵС���͸��Ƶ���ʱ����tmpArray��Ӧ��λ���У�Ȼ��index++��ͬʱ���Ƕ�������ȥ��һ��Ԫ��

                tmpArray[index++] = a[beginHalf1++];
            } else {
                tmpArray[index++] = a[beginHalf2++];

            }

        }
        //���������whileѭ�����ض��ж������Ԫ�ض�ȡ����,���϶�����һ��������û��ȡ��ģ�����ûȡ�⣬����ʣ�µ�Ԫ�ػ��Ѿ��������ˡ�������������whileֻ��һ����ִ�У����ǽ�ʣ�µ��Ƕ�������Ѿ��ź�˳���Ԫ�ض���������ʱ����tmpArray[]�ж�Ӧ��λ�á�

        while (beginHalf1 <= endHalf1) {
            tmpArray[index++] = a[beginHalf1++];
        }
        while (beginHalf2 <= endHalf2) {
            tmpArray[index++] = a[beginHalf2++];
        }
        //   ����ʱ����tmpArray[]�е��Ѿ��ź�˳���Ԫ��ȫ��������ԭ��������arr[]��
        for (int i = 0; i < num; i++, endHalf2--) {
            a[endHalf2] = tmpArray[endHalf2];
        }
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    private int maxBalancedDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxBalancedDepth(root.left);
        int right = maxBalancedDepth(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return maxBalancedDepth(root) != -1;
    }

    public TreeNode getAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }
        TreeNode left = getAncestor(root.left, node1, node2);
        TreeNode right = getAncestor(root.right, node1, node2);

        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }

        return null;
    }

    public int maxPathSumA(TreeNode root){
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSumImpl(root, max);
        return max[0];
    }

    private int maxPathSumImpl(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }

        int left = maxPathSumImpl(root.left, max);
        int right = maxPathSumImpl(root.right, max);

        int csum = Math.max(root.val, Math.max(root.val+ left, root.val+ right));
        max[0] = Math.max(max[0], Math.max(csum, left+root.val+right));

        return csum;
    }

    private class ResultType {
        // singlePath: ��root�����ߵ����������·��������·�����Բ������κε�
        // maxPath: ���������⵽���������·��������·�����ٰ���һ����
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
}
