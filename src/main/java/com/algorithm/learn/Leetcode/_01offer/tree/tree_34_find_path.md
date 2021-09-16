# [【剑指Offer】 24、二叉树中和为某一值的路径](https://www.cnblogs.com/gzshan/p/10796134.html)

  **题目描述：**

  输入一颗二叉树的根结点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

  **解题思路：**

  本题实质上就是深度优先搜索。使用前序遍历的方式对整棵树进行遍历，当访问到某一个结点时，将该结点添加到路径上，并且累加该结点的值。当访问到的结点是叶结点时，如果路径中的结点值之和正好等于输入的整数，则说明是一条符合要求的路径。如果当前结点不是叶结点，则继续访问它的子结点。

  当找到一条符合要求的路径之后，需要回溯进一步查找别的路径，因此，这实际上仍然是一个递归的过程，特别注意在函数返回之前要删掉当前结点，从而才可以正确的回溯。

  **举例：**

![img](https://img2018.cnblogs.com/blog/1608161/201904/1608161-20190430151109127-936036131.png)

![img](https://img2018.cnblogs.com/blog/1608161/201904/1608161-20190430151117681-1738890995.png)



  **编程实现（Java）：**

```java
public class Solution {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private lengthCompare c=new lengthCompare();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null)
            return res;
        ArrayList<Integer> temp=new ArrayList<>();
        FindPath(root,target,temp);
        res.sort(c);
        return res;
    }
    public void FindPath(TreeNode root,int target,ArrayList<Integer> temp){
        temp.add(root.val);
        if(root.left==null && root.right==null){ //root是叶结点
            if(root.val==target) {//找到了一条路径
                ArrayList<Integer> list=new ArrayList();
                list.addAll(temp);
                res.add(list);
            }
        }
        else{
            if(root.left!=null)
                FindPath(root.left,target-root.val,temp);
            if(root.right!=null)
                FindPath(root.right,target-root.val,temp);
        }
        if(temp.size()!=0) //回溯
            temp.remove(temp.size()-1);
    }
    class  lengthCompare implements Comparator<ArrayList>{
        public int compare(ArrayList a,ArrayList b){
            if(a.size()>b.size())
               return -1;
            else if(a.size()==b.size())
                return 0;
            else
                return 1;
        }
    }
}
```



# 二、上述方法在牛客网行不通

## 剑指offer面试题34：二叉树中和为某一值的路径（Java 实现）


题目：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

思路：利用二叉树的前序遍历，把每一个遍历到是根节点保存在一个 list 中。然后判断当前节点是不是叶节点，若不是叶节点，则用递归的方式接着遍历它的左节点和右节点；

若是叶节点则判断从根节点到这个叶节点的路径和等不等于 target，如果相等就把这条路径对应的 list 添加进 listAll 中，如果不相等就回退到根节点接着遍历尝试新的路径。

测试用例：

1. 功能测试：二叉树中有一条或多条符合的路径；二叉树中没有符合的路径。
2. 特殊测试：输入的根节点为空。

### 方法一：

```java
public class test_thirty_four {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if (root == null)return listAll;
 
        list.add(root.val);
        target = target - root.val;
 
        if (target == 0 && root.left == null && root.right == null){
            //这里必须要重新生成一个对象实例，并使用list对其初始化赋值
            listAll.add(new ArrayList<Integer>(list));
        }
            FindPath(root.left,target);
            FindPath(root.right,target);
            //模拟了栈回退,当前节点为叶子节点或者已经访问过的情况下，回溯到父节点
            list.remove(list.size()-1);
            return listAll;
    }
}
```



### 方法二：（常规做法：利用栈）

```java
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return pathList;
        Stack<Integer> stack=new Stack<Integer>();
        FindPath(root,target,stack,pathList );
        return pathList;
    }
    private void FindPath(TreeNode root, int target,
            Stack<Integer> path,
            ArrayList<ArrayList<Integer>> pathList) {
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            if(root.val==target){
                ArrayList<Integer> list=
                        new ArrayList<Integer>();
                for(int i:path){
                    list.add(new Integer(i));
                }
                list.add(new Integer(root.val));
                pathList.add(list);
            }
        }
        else{
            path.push(new Integer(root.val));
            FindPath(root.left, target-root.val, path, pathList);
            FindPath(root.right, target-root.val, path,  pathList);
            path.pop();
        }
    }
}
```



————————————————
版权声明：本文为CSDN博主「不止于代码」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41163113/article/details/88365644