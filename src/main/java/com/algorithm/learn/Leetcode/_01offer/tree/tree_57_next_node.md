# [【剑指Offer】57、二叉树的下一个结点](https://www.cnblogs.com/gzshan/p/10889249.html)

  **题目描述：**

  给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

  **解题思路：**

  本题解决起来并不是很困难，主要是分析清楚所有可能的不同情况。对于中序遍历序列来说，遵循“左->根->右”的顺序，在深刻理解中序遍历的基础上，结合一些具体的实例我们不难得出以下结论。

  找一个结点在中序遍历序列中的下一个结点共有**三种不同的情况**：

- 如果一个结点有右子树，那么它的下一个结点就是它的右子树中最左边的那个结点，也就是说，从它的右子结点出发一直访问左指针，最后就可以找到这个最左结点。
- 如果一个结点没有右子树，那么需要再进一步考虑，不难知道：如果这个结点是其父结点的左结点，那么根据中序遍历规则，它的下一个结点就是它的父结点。
- 第三种情况略复杂一些，当一个结点既没有右子树，也不是其父结点的左结点时，我们可以沿着指向父结点的指针一直向上遍历，直到找到一个是它自身的父结点的左孩子的结点，如果这样的结点存在，那么这个结点的父结点就是我们要找的下一个结点。

  **举例：**

![img](https://img2018.cnblogs.com/blog/1608161/201905/1608161-20190519144844609-1942638423.png)



  以上图中的树为例，其中序遍历序列是：d,b,h,e,i,a,f,c,g。

  对应第一种情况（有右子树的情形），例如，图中结点b的下一个结点是h，结点a的下一个结点是f。

  对应第二种情况（没有右子树，但是其父结点的左结点的情形），例如，图中结点d的下一个结点是b，f的下一个结点是c。

  对应第三种情况（没有右子树，也不是其父结点的左结点的情形），例如，为了找到结点g的下一个结点，我们沿着指向父结点的指针向上遍历，先到达结点c。由于结点c是父结点a的右结点，我们继续向上遍历到达结点a。由于结点a是树的根结点。它没有父结点。因此结点g没有下一个结点。

  **编程实现（Java）：**

```java
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        /*
        思路：三种情况：（1）若给定结点有右子树，则下一个结点是它右子树中最左边的结点
            （2）若该结点没有右子树，并且是父节点的左结点，则下一个结点就是他的父节点
            （3）若该结点没有右子树，并且是父节点的右结点，则应该沿着父节点向上，直到找到的结点是一个左结点。则下一个结点是该左结点的父节点
        */
        if(pNode==null)
            return null;
        TreeLinkNode res=null;
        if(pNode.right!=null){ //有右子树
            res=pNode.right;
            while(res.left!=null)
                res=res.left;
        }else{  //没有右子树
            TreeLinkNode parent=pNode.next; //父节点
            if(parent!=null && pNode==parent.left) //是父节点的左结点
                res=parent;
            else{ //是父节点的右结点
                while(parent!=null && parent.next!=null && parent!=parent.next.left)
                    parent=parent.next;
                res=parent==null? null : parent.next;
            } 
        }
        return res;
    }
} 
```

博学 审问 慎思 明辨 笃行