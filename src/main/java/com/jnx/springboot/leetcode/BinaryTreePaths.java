package com.jnx.springboot.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * [257]二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * Related Topics 树 深度优先搜索
 *
 * @author 蒋楠鑫
 * @date 2020/9/4
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode secondLeft = new TreeNode(2);
        TreeNode thirdLeft = new TreeNode(4);
        TreeNode thirdRight = new TreeNode(5);
        secondLeft.left = thirdLeft;
        secondLeft.right = thirdRight;
        TreeNode secondRight = new TreeNode(3);
        root.left = secondLeft;
        root.right = secondRight;
        List<String> list = binaryTreePaths(root);
        System.out.println(list);
        List<String> stringList = binaryTreePaths2(root);
        System.out.println(stringList);
    }

    /**
     * 解法一：深度优先搜索---前序遍历（递归思想）
     *
     * @param root 给定的二叉树
     * @return 所有根节点到叶子节点的路径
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        searshPath(root, "", list);
        return list;
    }

    /**
     * 递归搜索到叶子节点的路径
     *
     * @param root 根节点
     * @param path 到当前根节点的路径
     * @param list 所有路径集合
     */
    public static void searshPath(TreeNode root, String path, List<String> list) {
        // 如果当前的根节点是空的直接返回，由父节点继续遍历其他子节点
        if (root == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(path);
        stringBuilder.append(root.val);
        // 如果当前根节点不为空但是子节点均为空，说明该节点是叶子节点，该路径符合要求加入到路径的集合
        if (root.left == null && root.right == null) {
            list.add(stringBuilder.toString());
        } else {
            stringBuilder.append("->");
            // 继续递归左边子节点
            searshPath(root.left, stringBuilder.toString(), list);
            // 继续递归右边子节点
            searshPath(root.right, stringBuilder.toString(), list);
        }
    }

    /**
     * 解法二：非递归思想，利用栈来解决
     *
     * @param root 给定的二叉树
     * @return 所有根节点到叶子节点的路径
     */
    public static List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new LinkedList<>();
        // 用栈来保存当前节点和到当前节点的路径
        Stack<Object> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        // 先放入当前根节点，再放入到当前根节点的路径
        stack.push(root);
        stack.push(String.valueOf(root.val));
        // 遍历栈
        while (!stack.isEmpty()) {
            // 每次从栈取出两个元素，第一个为当前路径，第二个为根节点
            String path = (String) stack.pop();
            TreeNode treeNode = (TreeNode) stack.pop();
            // 如果没有子节点，说明当前节点为叶子节点，该路径符合要求加入到路径的集合
            if (treeNode.left == null && treeNode.right == null) {
                list.add(path);
            }
            // 如果右节点不为空，先将右节点入栈，然后再将到右节点的路径入栈
            if (treeNode.right != null) {
                stack.push(treeNode.right);
                stack.push(path + "->" + treeNode.right.val);
            }
            // 如果左节点不为空，先将左节点入栈，然后再将到左节点的路径入栈
            if (treeNode.left != null) {
                stack.push(treeNode.left);
                stack.push(path + "->" + treeNode.left.val);
            }
        }
        return list;
    }

    static class TreeNode {

        /**
         * 当前节点的值
         */
        int val;

        /**
         * 左边的子节点
         */
        TreeNode left;

        /**
         * 右边的子节点
         */
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
