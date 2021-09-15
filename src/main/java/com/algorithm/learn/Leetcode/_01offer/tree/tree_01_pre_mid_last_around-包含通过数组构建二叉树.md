# 二叉树的先序,中序,后序遍历序列(java实现非递归与递归)

## 一、概述

先序遍历：根左右
中序遍历：左根右
后序遍历：左右根

## 二、建树

```java
public class BinaryTree {
    TreeNode root;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public BinaryTree(Integer[] array) {//建树
        root = new TreeNode(array[1]);
        TreeNode[] treeNodes = new TreeNode[array.length];//树的所有结点
//        二叉链表建树
        treeNodes[1] = root;
        for (int i = 2; i < array.length; i++) {
            if (array[i] == null) continue;
            treeNodes[i] = new TreeNode(array[i]);
            int parent = i / 2;
            if (i % 2 == 0) {//左儿子
                treeNodes[parent].left = treeNodes[i];
            } else {
                treeNodes[parent].right = treeNodes[i];
            }
        }
    }

}

```



## 三、代码实现

### 1.非递归版本

#### 先序

```java
public List<Integer> preOrder(TreeNode root) {//根左右
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty()||node!=null){//栈不为空且当前结点不为空继续遍历
            while (node!=null){//遍历左儿子 边遍历边添加结果
                stack.push(node);
                list.add(node.val);
                node = node.left;
            }
            node = stack.pop();//返回当前节点的父节点
            node = node.right;
        }
        return list;
    }

```



#### 中序

```java
   public List<Integer> midOrder(TreeNode root) {//左根右
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty()||node!=null) {//栈不为空且当前结点不为空继续遍历
            while (node!=null){//遍历左儿子 找到最左儿子
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();//返回当前节点的父节点
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

```



#### 后序

后序用双栈实现 根据栈的特性先进后出 后序需要的是左右根 当我们向栈中按照根右左压入时 最后弹出的顺序就是左右根 所以此时后序遍历就转换为先序遍历的形式了。

```java
    public List<Integer> afterOrder(TreeNode root) {//左右根
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> out = new Stack<>();
        TreeNode node = root;
        while (!stack.empty()||node!=null) {//找根右左
            while (node!=null){//遍历右儿子 边遍历边存结果
                stack.push(node);
                out.push(node);
                node = node.right;
            }
            node = stack.pop();//返回当前节点的父节点
            node = node.left;
        }
        while (!out.empty())//利用栈的先入后出变成左右根存入
            list.add(out.pop().val);
        return list;
    }

```



### 2.递归版本

#### 先序

```java
public void preOrder(TreeNode node,List<Integer> list){
        if(node==null)return;
        list.add(node.val);//根
        preOrder(node.left,list);//左
        preOrder(node.right,list);//右
    }
```



#### 中序

```java
public void midOrder(TreeNode node,List<Integer> list){
        if(node==null)return;
        preOrder(node.left,list);//左
        list.add(node.val);//根
        preOrder(node.right,list);//右
    }

```

#### 后序

```java
public void afterOrder(TreeNode node,List<Integer> list){
        if(node==null)return;
        afterOrder(node.left,list);//左
        afterOrder(node.right,list);//右
        list.add(node.val);//根
    }

```




————————————————
版权声明：本文为CSDN博主「我会jvav啊」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43434328/article/details/113356807