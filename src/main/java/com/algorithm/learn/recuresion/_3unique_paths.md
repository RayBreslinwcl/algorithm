# [递归训练二：Leetcode 62.不同路径](https://www.iamshuaidi.com/1809.html)

[![img](https://www.iamshuaidi.com/wp-content/themes/ripro-v2/assets/img/avatar.png)](https://www.iamshuaidi.com/author/帅地)[五大算法思想](https://www.iamshuaidi.com/algorithm-5) 1年前 0 2.0K



### 问题描述

一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

![img](https://img-blog.csdnimg.cn/20191110133605470.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTA3Nzk3,size_16,color_FFFFFF,t_70)

> 这是 leetcode 的 62 号题：https://leetcode-cn.com/problems/unique-paths/

**（1）找出递归关系式**

首先这个问题的关键就是要找出递归之间的关系式，我们先定义函数 dfs(i，j) 的返回值是**机器人从 (0, 0) 走到 (i, j) 时的所有路径数**，

想象以下，机器人要怎么样才能到达 (i, j) 这个位置？由于机器人可以向下走或者向右走，所以有两种方式到达

一种是从 (i-1, j) 这个位置走一步到达

一种是从(i, j – 1) 这个位置走一步到达

因为是计算所有可能的步骤，所以是把所有可能走的路径都加起来，所以递归关系式是 dfs(i, j) = dfs(i – 1, j) + dfs(i, j – 1)。

如果你不是特别明白，那么我建议你可以画一个图演示一下。

**（2）找出初始值**

显然，在 dfs(i, j) 中，如果 i 或者 j 有一个为 0，那么还能使用关系式吗？答是不能的，因为这个时候把 i – 1 或者 j – 1，就变成负数了，也就是说，i = 0 或者 j = 0 =是函数的边界，而且当 i = 0 或者 j = 0，代表机器人在做上面一行或者做有左边一列，此时的 dfs(i, j) = 1。

所以代码如下：

```java
class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(m - 1, n -1);
    }

    public int dfs(int i, int j) {
        if(i == 0 || j == 0){
            return 1;
        }
        return arr[i][j] = dfs(i - 1, j) + dfs(i, j - 1);

    }
}
```

Java

Copy

**优化一下**

大部分问题都可以用递归暴力做出来，但是绝大部分都是可以优化的，例如该问题就有很多被重复计算的地方，如果自己不大懂，那么你平时可以画一个图看一下，例如当 i = 4, j = 4 时，递归调用的图如下：

![image-20210518202223721](https://tva1.sinaimg.cn/large/008i3skNgy1gqmulpfwq9j31mu0pqb29.jpg)

画红圈的地方，就是重复调用的地方，如果不进行剪枝，那么时间复杂度就是指数级别的了。

所以呢，我们可以用一个**数组**来存储计算的结果，例如我们可以用 arr[3] [3] 把 dfs (3, 3) 的计算结果保存起来，每次要计算 dfs(3, 3) 的时候，我们可以先判断 arr[3] [3] 是否有记录过了。

至于如何判断是否记录过，你可以刚开始的时候，给数组 arr 赋予一个特殊的值，代码如下

```java
class Solution {
    // 全局变量，用来保存计算过的只
    static int[][] arr = null;
    public int uniquePaths(int m, int n) {
        // 创建一个二维数组
        arr = new int[m][n];
        return dfs(m - 1, n -1);
    }

    public int dfs(int i, int j) {
        if(i == 0 || j == 0){
            return 1;
        }
        // java 里，数组的初始值是 0，所以可以用 arr[i][i] 是否为 0 来判断
        if(arr[i][j] != 0){
            return arr[i][j];
        }
                // 把计算过的指保存起来
        arr[i][j] = dfs(i - 1, j) + dfs(i, j - 1);

        return arr[i][j];
    }
}
```

Java

Copy

时间复杂度为 O(m * n)，空间复杂度为 (m * n)。

但其实这道题的最优解，应该是用动态规划来做，但是咱们这种的专题是递归，所以我就不讲动态规划相关的了。

### 相关训练题

[递归训练一：Leetcode 104.二叉树的最大深度](https://www.iamshuaidi.com/?p=1805)

[递归训练三：剑指 Offer 16. 数值的整数次方](https://www.iamshuaidi.com/?p=1811)

[递归训练四：Leetcode 4. 寻找两个正序数组的中位数](https://www.iamshuaidi.com/?p=1813)

[递归](https://www.iamshuaidi.com/tag/递归)