package com.linkai.practise.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TreeNodeUtil {

    public static TreeNode buildTree(Integer[] array) {
        return buildTree(Arrays.asList(array));
    }

    public static TreeNode buildTree(List<Integer> array) {
        if (array.size() == 0) {
            return null;
        }
        return buildTree(array, 0);
    }

    private static TreeNode buildTree(List<Integer> array, int rootTreeNodeIndex) {
        if (rootTreeNodeIndex >= array.size() || array.get(rootTreeNodeIndex) == null) {
            return null;
        }
        TreeNode root = new TreeNode(array.get(rootTreeNodeIndex));
        TreeNode left = buildTree(array, rootTreeNodeIndex + 1);
        TreeNode right = buildTree(array, rootTreeNodeIndex + 2);
        root.left = left;
        root.right = right;
        return root;
    }
}
