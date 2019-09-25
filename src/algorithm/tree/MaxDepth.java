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
测试case：
[3,9,20,null,null,15,7]
[0]

 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode left=new TreeNode(2);
        TreeNode left1=new TreeNode(3);
        //root.left=left;
        //left.left=left1;
        System.out.println(solution(root,0));

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
    public static void scan(TreeNode node) {
        System.out.print(node.val);
        if (!(isleaf(node.left))) {
            scan(node.left);
        } else System.out.print(node.left.val);
        if (!(isleaf(node.right))) {
            scan(node.right);
        } else System.out.print(node.right.val);
    }

    /*
    叶子节点判定
     */
    public static boolean isleaf(TreeNode node) {
        return null == node.left && null == node.right;
    }

    /*
    题解：数树。完全自己思考出来。
    类似遍历树的方式，写一个方法返回左右子树中层级较大者。

    执行用时 :1 ms, 在所有 Java 提交中击败了98.14%的用户
    内存消耗 :37.7 MB, 在所有 Java 提交中击败了40.90%的用户
     */
    public static int solution(TreeNode root, int num) {
        if(null==root) return 0;
        int leftNum=0;
        int rightNum=0;
        //如果是叶子了，直接返回调用方的值+1
        if (null == root.left && null == root.right){
            return num+1;
        }
        else {
            if (null!=root.left) {
                leftNum=solution(root.left, num+1);
            }
            if(null!=root.right){
                rightNum=solution(root.right,num+1);
            }
        }
        return rightNum>leftNum?rightNum:leftNum;
    }
    /*
    官方。他爷爷的，真简洁。。。
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
