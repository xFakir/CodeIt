package Algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : InorderTraversal
 * @Description :
 * @Author : xcx
 * @Date : 2019-05-05 10:04
 * @Version : 1.0
 */
public class InorderTraversal {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> solution(TreeNode root) {

        traversal(root);
        return result;
    }

    private void traversal(TreeNode node) {
        if (node != null) {
            traversal(node.left);
            result.add(node.val);
            traversal(node.right);
        }
    }

    /**
     * preorder iteratively
     * @param root
     * @return
     */
    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            list.add(node.val);
            if (node.right != null) {
                s.push(node.right);
            }

            if (node.left != null) {
                s.push(node.left);
            }

        }
        return list;
    }

    /**
     * inorder iteratively
     * @param root
     * @return
     */
    public List<Integer> inorder(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> s = new Stack<>();

        do {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            if (!s.isEmpty()) {
                TreeNode node = s.pop();
                list.add(node.val);
                root = node.right;
            }
        } while (!s.isEmpty() || root != null);

        return list;
    }

    /**
     * postorder iteratively
     * @param root
     * @return
     */
    public List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while( !s.isEmpty() ) {
            TreeNode node = s.pop();
            if(node.left != null) {
                s.push(node.left);
            }

            if(node.right != null) {
                s.push(node.right);
            }

            list.add(0, node.val);
        }
        return list;
    }
}
