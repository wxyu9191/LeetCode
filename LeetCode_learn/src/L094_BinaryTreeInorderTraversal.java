import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: admin
 * @date: 2018/8/11
 * @description:
 */

//  Definition for a binary tree node.中序遍历
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class L094_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
               stack.push(cur);
               cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }

    public List<Integer> inorderTraversalRecurse(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root.left != null)
            inorderTraversalRecurse(root.left);
        res.add(root.val);
        if (root.right != null)
            inorderTraversalRecurse(root.right);

        return res;
    }



}
