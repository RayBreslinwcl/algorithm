# [【剑指Offer】39、平衡二叉树](https://www.cnblogs.com/gzshan/p/10843320.html)

  **题目描述：**

  输入一棵二叉树，判断该二叉树是否是平衡二叉树。这里的定义是：如果某二叉树中任意结点的左、右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

  **解题思路：**

  首先对于本题我们要正确理解，一般情况下，平衡二叉树就是AVL树，它首先是二叉搜索树（左小右大），其次满足左右子树高度之差不超过1。但是在本题中，没有二叉搜索树的要求，只对平衡与否进行判断即可。

  根据求二叉树深度的思路我们很容易想到一种解法，即：在遍历树的每一个结点时，求其左右子树的深度，判断深度之差，如果每个结点的左右子树深度相差都不超过1，那么就是一棵平衡二叉树。本思路直观简洁，但是需有很多结点需要重复遍历多次，时间效率不高。

  为了避免重复遍历，我们可以得到一种**每个结点只遍历一次的解法**。思路如下：采用后序遍历的方式遍历二叉树的每个结点，这样在遍历到每个结点的时候就已经访问了它的左右子树。所以，只要在遍历每个结点的时候记录它的深度，我们就可以一边遍历一边判断每个结点是不是平衡的。

  **编程实现（Java）：**

```java
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null) //空树也是二叉平衡树
            return true;
        int res=getDepth(root);
        if(res==-1)
            return false;
        return true;
    }
    public int getDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        if(left==-1) //遍历过程中发现子树不满足平衡条件直接返回
            return -1;
        int right=getDepth(root.right);
        if(right==-1)  //遍历过程中发现子树不满足平衡条件直接返回
            return -1;
        if(Math.abs(left-right)>1)
            return -1;
        else
            return left>right?left+1:right+1;
    }
}
```

博学 审问 慎思 明辨 笃行