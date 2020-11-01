package com.huawei.leetcode.tree;

import java.util.Arrays;

public class Leetcode_106 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                int[] left_inorder = Arrays.copyOfRange(inorder, 0, i);
                int[] right_inorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                int[] left_preorder = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] right_preorder = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                root.left = buildTree(left_preorder, left_inorder);
                root.right = buildTree(right_preorder, right_inorder);
            }
        }
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}