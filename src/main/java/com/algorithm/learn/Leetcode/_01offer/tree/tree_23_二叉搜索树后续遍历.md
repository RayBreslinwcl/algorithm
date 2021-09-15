# [【剑指Offer】23、二叉搜索树的后序遍历序列](https://www.cnblogs.com/gzshan/p/10796115.html)

  **题目描述：**

  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

  **解题思路：**

  对于后续遍历序列，序列的最后一个值一定是树的根结点，而由二叉搜索树的性质：左小右大，我们可以从头开始遍历，当遍历到某个值比根结点大时停止，记为flag，此时flag之前的所有数值都是二叉搜索树的左子树的结点，flag以及flag之后的所有数都是二叉搜索树的右子树的结点。这是由二叉搜索树以及后序遍历共同决定的。

  接下来，我们就可以把任务交给递归，同样的方法去判断左子树和右子树是否是二叉搜索树，这显然是典型的递归解法。

  **举例：**

  以{5,7,6,9,11,10,8}为例，后序遍历结果的最后一个数字8就是根结点的值。在这个数组中，前3个数字5、7和6都比8小，是值为8的结点的左子树结点；后3个数字9、11和10都比8大，是值为8的结点的右子树结点。

  我们接下来用同样的方法确定与数组每一部分对应的子树的结构。这其实就是一个递归的过程。对于序列5、7、6，最后一个数字6是左子树的根结点的值。数字5比6小，是值为6的结点的左子结点，而7则是它的右子结点。同样，在序列9、11、10中，最后一个数字10是右子树的根结点，数字9比10小，是值为10的结点的左子结点，而11则是它的右子结点，所以它对应的二叉搜索树如下：

![img](https://img2018.cnblogs.com/blog/1608161/201904/1608161-20190430150817750-1287866411.png)



  **编程实现（Java）：**

```java
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0)
            return false;
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }
    public boolean VerifySquenceOfBST(int [] sequence,int begin,int end){
        if(end<=begin) //结束条件
            return true;
        //end为根节点，找左右子树的分界
        int i=begin;
        for(;i<end;i++) //找边界，并同时判断了左子树都小于根
            if(sequence[i]>sequence[end])
                break;
        for(int j=i+1;j<end;j++) //右子树如果存在小于根的，则不是二叉搜索树
            if(sequence[j]<sequence[end])
                return false;
        return VerifySquenceOfBST(sequence,begin,i-1) && VerifySquenceOfBST(sequence,i,end-1);
    }
}
```

博学 审问 慎思 明辨 笃行