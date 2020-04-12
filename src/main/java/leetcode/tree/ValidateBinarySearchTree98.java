package leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ValidateBinarySearchTree98 {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(2);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(3);
        System.out.println(isValidBST(node1));
    }

    public static boolean isValidBST(TreeNode root) {
        List<Integer> array = new LinkedList<>();
        array = zhongXue(root);
        Long last = Long.MIN_VALUE;
        if(array.size()<=1){
            return true;
        }
        for(Integer i: array){
            long newL = i;
            if(last < i){
                last = newL;
            } else {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> zhongXue(TreeNode root) {
        if(root == null){
            return  new LinkedList<>();
        }
        int value = root.val;
        List<Integer> current = new LinkedList<>();
        current.add(value);
        List<Integer> arrayLeft = zhongXue(root.left);
        List<Integer> arrayRight = zhongXue(root.right);
        arrayLeft.addAll(current);
        arrayLeft.addAll(arrayRight);
        return arrayLeft;
    }
}

