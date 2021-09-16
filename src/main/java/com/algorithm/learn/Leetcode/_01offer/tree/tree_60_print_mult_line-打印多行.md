# [【剑指Offer】60、把二叉树打印成多行](https://www.cnblogs.com/gzshan/p/10893563.html)

  **题目描述：**

  从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

  **解题思路：**

  本题可类比第22题：[从上往下打印二叉树](https://www.cnblogs.com/gzshan/p/10789737.html)，这两道题实际上是一回事，只不过这里我们多了一个分行打印的要求，实际上大同小异，稍加修改即可。

  在二叉树层次遍历上，我们使用的是队列，借助队列先进先出的性质实现，具体规律：每次打印一个结点时，如果该结点有子结点，则将子结点放到队列的末尾，接下来取出队列的头重复前面的打印动作，直到队列中所有的结点都打印完毕。在此基础上我们考虑这里的分行要求，不难想到我们只要增加两个变量即可：一个用于保存当前层中还没有打印的结点个数，另一个用于记录下一层结点的数目。而使用队列的话，实际上这两个变量可以统一用队列的长度来实现。

  **举例：**

![img](https://img2018.cnblogs.com/blog/1608161/201905/1608161-20190520124806385-473179174.png)



  **编程实现（Java）：**

```java
import java.util.*;
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        //思路：使用队列实现
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(pRoot==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>(); //借助队列实现
        TreeNode root=pRoot;
        queue.add(root);
        while(!queue.isEmpty()){ //队列不空
            //当前队列长度代表当前这一层节点个数
            int len=queue.size();
            ArrayList<Integer> row=new ArrayList<>();
            for(int i=0;i<len;i++){  //循环次数，也就是当前这一层节点个数
                 TreeNode temp=queue.poll();
                 if(temp.left!=null)
                     queue.add(temp.left);
                 if(temp.right!=null)
                     queue.add(temp.right);
                row.add(temp.val);
            }
           res.add(row);
        }
        return res;
    }
}
```

博学 审问 慎思 明辨 笃行