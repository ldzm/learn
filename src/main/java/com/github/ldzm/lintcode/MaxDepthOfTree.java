package com.github.ldzm.lintcode;


class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

/**
 * 给定一个二叉树，找出其最大深度。

   二叉树的深度为根节点到最远叶子节点的距离。
 */
public class MaxDepthOfTree {

    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);

        int right = maxDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        left = left == 0 ? Integer.MAX_VALUE - 1 : left + 1;
        right = right == 0 ? Integer.MAX_VALUE - 1 : right + 1;

        return left < right ? left : right;
    }
}
