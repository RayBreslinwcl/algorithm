# [【剑指Offer】61、序列化二叉树](https://www.cnblogs.com/gzshan/p/10898708.html)

  **题目描述：**

  请实现两个函数，分别用来序列化和反序列化二叉树。

  **解题思路：**

  序列化是指将结构化的对象转化为字节流以便在网络上传输或写到磁盘进行永久存储的过程。反序列化是指将字节流转回结构化的对象的过程，是序列化的逆过程。

  受第4题：[重建二叉树](https://www.cnblogs.com/gzshan/p/10730338.html)的启发，我们知道从前序遍历和中序遍历序列中可以构造出一棵二叉树，因此将一棵二叉树序列化为一个前序遍历序列和一个中序遍历序列，然后在反序列化时用第四题的思路重建二叉树。

  这种思路是可行的，但是存在两个缺点：一是该方法要求二叉树中不能有重复的结点（比如我们通过前序知道根是1，若有重复的结点无法在中序序列中定位根的位置）；二是只有当两个序列中所有的数据都读出后才能开始反序列化，如果两个遍历序列是从一个流中读出来的，那么可能需要等待较长的时间。

  因此，这里我们采用另外一种方法，即**只根据前序遍历的顺序来进行序列化**，前序遍历是从根结点开始，在遍历二叉树碰到null指针时，就将其序列化为一个特殊字符，比如`$`,另外，结点的数值之间用一个特殊字符（比如`,`）进行分隔。比如对于以下的树，序列化为字符串：`"1,2,4,$,$,$,3,5,$,$,6,$,$"`。

![img](https://img2018.cnblogs.com/blog/1608161/201905/1608161-20190521111824678-471667484.png)



  然后我们可以以`"1,2,4,$,$,$,3,5,$,$,6,$,$"`为例来分析反序列化的过程，第一个读出1，这是根结点的值，然后读出2，这是根结点的左孩子，同样接下来的4是值为2的结点的左孩子结点；接下来读出两个“”，说明值为4的结点左右孩子都是null，这是一个叶结点。然后回到值为2的结点，重建它的右子树，由于下一个字符是“”，说明值为4的结点左右孩子都是null，这是一个叶结点。然后回到值为2的结点，重建它的右子树，由于下一个字符是“”，说明值为2的结点的右孩子结点为null，这个结点的左右子树都重建完毕，接下来再次回溯就到了根结点，所以，左子树重构完毕。

  由于下一个数字是3，所以右子树的根结点值为3，左结点时一个值为5的叶结点（因为接下来的三个字符是`5,$,$`）,同理右结点时一个值为6的结点。至此，重构完毕，反序列化完成。

  序列化比较简单，就是一个前序遍历的过程，而反序列化也不难发现，实际就是一个递归解决每个子树的问题，详见以下代码实现。

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
    String Serialize(TreeNode root){
        if(root==null)
            return "#,";
        String res="";
        res+=root.val+",";   //前序遍历，根左右
        res+=Serialize(root.left);
        res+=Serialize(root.right);
        return res;
    }

    //反序列化
    int start=-1;
    TreeNode Deserialize(String str){
        if(str==null || str.length()==0)
            return null;
        String[] strArr=str.split(",");
        return Deserialize(strArr);
    }
    TreeNode Deserialize(String[] strArr){
        start++;
        if(start>=strArr.length || strArr[start].equals("#"))
            return null;
        TreeNode cur=new TreeNode(Integer.valueOf(strArr[start]));
        cur.left=Deserialize(strArr);
        cur.right=Deserialize(strArr);
        return cur;
    }
}
```

博学 审问 慎思 明辨 笃行

分类: [算法（剑指Offer）](https://www.cnblogs.com/gzshan/category/1446107.html)