package algorithm.tree;

import java.util.Stack;

/*
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

 */
public class IsSymmetric {
    public static void main(String[] args) {

    }

    /*
    中左右
     */
    public static boolean solution(TreeNode root) {
        //空也对称
        if (null == root) return true;
        return checkRL(root,root);
    }

    public static boolean checkRL(TreeNode L, TreeNode R) {
        //空的可以
        if (null == L && null == R) return true;
        //只剩下要么真要么假，返回假
        if (null == L || null == R) return false;
        //处理都不为空的情况
        //给的节点都不相等就直接返回
        if (L.val != R.val) return false;
        //子节点的情况
        return checkRL(L.left,R.right) && checkRL(L.right,R.left);
    }
}
