package SwordOffer;

import java.util.Arrays;

/**
 * @author: admin
 * @date: 2018/9/3
 * @description:
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class reConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int []pre, int []in) {
        if (pre==null || in==null || pre.length == 0 || in.length ==0 || pre.length != in.length){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++){
            if (pre[0] == in[i]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
            }
        }
        return root;
    }
}
