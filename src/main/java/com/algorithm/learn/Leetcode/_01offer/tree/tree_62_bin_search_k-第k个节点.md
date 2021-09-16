# [【剑指Offer】62、二叉搜索树的第k个结点](https://www.cnblogs.com/gzshan/p/10898735.html)

  **题目描述：**

  给定一棵二叉搜索树，请找出其中的第k小的结点。例如（5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。

  **解题思路：**

  本题实际上比较简单，主要还是考察对树的遍历的理解，只要熟练掌握了树的三种遍历方式及其特点，解决本题并不复杂，很明显本题是对中序遍历的应用。

  对于本题，我们首先可以知道二叉搜索树的特点：左结点的值<根结点的值<右结点的值。因此，我们不难得到如下结论：如果按照中序遍历的顺序对一棵二叉搜索树进行遍历，那么得到的遍历序列就是递增排序的。因此，只要用中序遍历的顺序遍历一棵二叉搜索树，就很容易找出它的第k大结点。

  **举例：**

![img](https://img2018.cnblogs.com/blog/1608161/201905/1608161-20190521112055125-1702218086.png)



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
    private int num;
    TreeNode KthNode(TreeNode pRoot, int k){
        //思路：二叉搜索树中序遍历正好就是递增序列
        if(pRoot==null||k<1)
            return null;
        num=k;
       return findKthNode(pRoot);
    }
    TreeNode findKthNode(TreeNode pRoot){
        TreeNode res=null;
        if(pRoot.left!=null)
            res=findKthNode(pRoot.left);
        if(res==null){
            if(num==1)
                res=pRoot;
            --num;
        }
        if(res==null && pRoot.right!=null) //左边和根都没找到
            res=findKthNode(pRoot.right);
        return res;
    }


}
```

博学 审问 慎思 明辨 笃行

分类: [算法（剑指Offer）](https://www.cnblogs.com/gzshan/category/1446107.html)

标签: [算法](https://www.cnblogs.com/gzshan/tag/算法/), [剑指Offer](https://www.cnblogs.com/gzshan/tag/剑指Offer/), [二叉树](https://www.cnblogs.com/gzshan/tag/二叉树/)



# 二、无法理解代码，参考第二个可以



## 题目描述

给定一棵二叉搜索树，请找出其中的第k小的结点。

 

## 样例

（5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。

 

## 思路分析

方法一：递归法 二叉搜索树按照中序遍历的顺序 打印出来 即为升序排序 设置一计数器 进行中序排序 找到第k个 即可

方法二：非递归法 构造一个栈，思路同 中序遍历的非递归法

 

## 代码及结果

### 方法一：

````java
int count = 0;
TreeNode ans;
TreeNode KthNode(TreeNode pRoot, int k){
		helper(pRoot, k);
		return ans;
    }
	
public void helper(TreeNode node, int k){
		if (node==null || count>k) {
			return;
		}
		helper(node.left, k);
		count++;
		if (count == k) {
			ans = node;
		}
		helper(node.right, k);
	}
````

![img](https://img-blog.csdn.net/20180924155207215?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3N1bjEwMDgx/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



### 方法二：

```java
TreeNode KthNode(TreeNode pRoot, int k){
		if (pRoot == null) {
			return null;
		}
		int count = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = null;
		while (!stack.isEmpty() || pRoot!=null) {
			while (pRoot != null) {
				stack.push(pRoot);
				pRoot = pRoot.left;
			}
			TreeNode node = stack.pop();
			count++;
			if (count == k) {
				temp = node;
			}
			pRoot = node.right;
		}
		return temp;
	}
```

![img](https://img-blog.csdn.net/20180924160355103?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3N1bjEwMDgx/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



————————————————
版权声明：本文为CSDN博主「sun10081」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/sun10081/article/details/82805991