package algorithm.tree;
/*
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7

返回它的最大深度 3 。

 */
public class MaxDepth {
    public static void main(String[] args) {

    }
    /*
    第一次接触到树的代码形式
    叶子节点，左右树都为空。
    数的遍历：前序、中序、后序
    前序：中->左->右
    中序：左->中->右
    后序：右->左->中
    顺序中，在单树中迭代方式执行。

     */
    /*
    先写个遍历方法
    中->左->右
     */
    public static void scan(TreeNode node){
        System.out.print(node.val);
        if(!(isleaf(node.left))){
            scan(node.left);
        }else System.out.print(node.left.val);
        if(!(isleaf(node.right))){
            scan(node.right);
        }else System.out.print(node.right.val);
    }
    /*
    叶子节点判定
     */
    public static boolean isleaf(TreeNode node){
        return null==node.left && null== node.right;
    }
    /*
    题解：数树
     */
}
