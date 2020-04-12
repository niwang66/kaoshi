package leetcode.tree;

public class LowestCommonAncestor235 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(6);
        TreeNode root2 = new TreeNode(2);
        TreeNode root8 = new TreeNode(8);
        TreeNode root0 = new TreeNode(0);
        TreeNode root4 = new TreeNode(4);
        TreeNode root7 = new TreeNode(7);
        TreeNode root9 = new TreeNode(9);
        TreeNode root3 = new TreeNode(3);
        TreeNode root5 = new TreeNode(5);
        root.left=root2;
        root.right=root8;
        root2.left=root0;
        root2.right=root4;
        root8.left=root7;
        root8.right=root9;
        root4.left=root3;
        root4.right=root5;
        TreeNode ancestor = lowestCommonAncestor(root,root2,root8);
        System.out.println(ancestor.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root==p ||  root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right !=null){
            return root;
        } else if (left !=null){
            return left;
        } else {
            return right;
        }
    }
}
