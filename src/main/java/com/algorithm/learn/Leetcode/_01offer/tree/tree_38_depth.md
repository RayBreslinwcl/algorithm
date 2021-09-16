# [【剑指Offer】38、二叉树的深度](https://www.cnblogs.com/gzshan/p/10837595.html)

  **题目描述：**

  输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

  **解题思路：**

  本题相对比较简单。根据二叉树深度的定义，我们有以下理解：如果一棵树只有一个结点，那么它的深度为1。如果根结点只有左子树而没有右子树，那么树的深度为其左子树深度加1；相反，如果根结点只有右子树而没有左子树，那么深度为右子树深度加1；如果既有左子树又有右子树，那么该树的深度为左、右子树深度的较大值加1。

  因此，很明显本题应该使用递归的思路来解决。

  **举例：**

![img](https://img2018.cnblogs.com/blog/1608161/201905/1608161-20190509114250103-1395213059.png)



  **编程实现（Java）：**

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int leftDepth=TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        int depth=leftDepth>rightDepth?leftDepth:rightDepth;
        return 1+depth;
    }
}
```