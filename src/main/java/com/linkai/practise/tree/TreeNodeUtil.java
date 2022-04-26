package com.linkai.practise.tree;

import java.util.List;
import java.util.Objects;

public final class TreeNodeUtil {

    public static boolean isEqual(TreeNode expected, TreeNode actual) {
        if (expected == null && actual == null) {
            return true;
        }
        if (expected != null && actual != null) {
            return Objects.equals(expected.val, actual.val) &&
                    isEqual(expected.left, actual.left) && isEqual(expected.right, actual.right);
        }
        return false;
    }

    public static TreeNode buildTree(List<Integer> array) {
        if (array.size() == 0) {
            return null;
        }
        return buildTree(array, 0, TreeBuildMode.DEFAULT);
    }

    public static TreeNode buildTree(List<Integer> array, TreeBuildMode mode) {
        if (array.size() == 0) {
            return null;
        }
        return buildTree(array, 0, TreeBuildMode.LEVEL);
    }

    private static TreeNode buildTree(List<Integer> array, int rootTreeNodeIndex, TreeBuildMode mode) {
        if (rootTreeNodeIndex >= array.size() || array.get(rootTreeNodeIndex) == null) {
            return null;
        }
        TreeNode root = new TreeNode(array.get(rootTreeNodeIndex));
        TreeNode left = buildTree(array, rootTreeNodeIndex + 1, mode);
        TreeNode right = buildTree(array, rootTreeNodeIndex + 2, mode);
        if (mode == TreeBuildMode.LEVEL) {
            left = buildTree(array, rootTreeNodeIndex * 2 + 1, mode);
            right = buildTree(array, rootTreeNodeIndex * 2 + 2, mode);
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
