# 史上最全！详解java递归解决汉诺塔问题



# 引子

相传在古印度圣庙中，有一种被称为汉诺塔(Hanoi)的游戏。该游戏是在一块铜板装置上，有三根杆(编号A、B、C)，在A杆自下而上、由大到小按顺序放置64个金盘。目标：把A杆上的金盘全部移到C杆上，并仍保持原有顺序叠好。操作规则：每次只能移动一个盘子，并且在移动过程中三根杆上都始终保持大盘在下，小盘在上，操作过程中盘子可以置于A、B、C任一杆上。

提示：以下是本篇文章正文内容，下面案例可供参考

# 一、解题思路

说简单点：就是把A上的n个圆盘全部移到C上，要求是，操作过程中ABC三个柱子从下往上，盘子依然是从大到小

![在这里插入图片描述](https://img-blog.csdnimg.cn/79f213c2c5124a528de98d4d7b961610.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

我们先来看几种简单的情况：

## n=1时：

A上只有1个圆盘，你直接移到C即可，我们用A->C表示

## n=2时：

A上2个圆盘，我们把最上面的移动到B，然后A剩余1个圆盘，，再把A剩余圆盘移动到C，最后B移动到C，我们用A->B,A->C,B->C表示，如下图：

![在这里插入图片描述](https://img-blog.csdnimg.cn/27e6518f7ff341a9af6622a05b6ceb85.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

A->B

![在这里插入图片描述](https://img-blog.csdnimg.cn/e2c8f52799e6400cab352a1cf1f2b6a0.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

A->C

![在这里插入图片描述](https://img-blog.csdnimg.cn/cde50716c53b411cb12694ed5dcc8db8.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

B->C

![在这里插入图片描述](https://img-blog.csdnimg.cn/e970359fc5f2409ea0fbd6fe5a484cf7.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

到这里完成n=2的目标。

## n=3时：

示意图如下：

![在这里插入图片描述](https://img-blog.csdnimg.cn/d2070928c78e490b8e151343f34eace2.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

A->C

![在这里插入图片描述](https://img-blog.csdnimg.cn/e7348464ede04982b7cb0b6d0f82c623.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

A->B

![在这里插入图片描述](https://img-blog.csdnimg.cn/a809868163ee48faa672dcb670499d56.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

C->B

![在这里插入图片描述](https://img-blog.csdnimg.cn/c666a748509a4866a79d554acd80f939.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

A->C

![在这里插入图片描述](https://img-blog.csdnimg.cn/004f2a5eda2c45efbd3d2e852fa05fd6.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

B->A

![在这里插入图片描述](https://img-blog.csdnimg.cn/e74748d7e1dc4178a3b8743102f67437.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

B->C

![在这里插入图片描述](https://img-blog.csdnimg.cn/f8c993d210c44276ad0ee53cb33a906c.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

A->C

![在这里插入图片描述](https://img-blog.csdnimg.cn/0ecbfa99e3f94357a97b7121ea05aba0.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

到这里n=3移植完毕。
注意：
在n=3时，我们可以发现，要从A移动3个盘子到C上，我们会经历2个盘子在B上的时候，如下图：

![在这里插入图片描述](https://img-blog.csdnimg.cn/004f2a5eda2c45efbd3d2e852fa05fd6.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

因为C上已经有最大的盘了，那这个时候问题就变成了，如何把B上2个盘子移动到C上，那不就是n=2时的操作吗？只不过这时B成了出发站，A成了中转站，C仍是目标站

我们用这个思路来看一看n=4的情况

![在这里插入图片描述](https://img-blog.csdnimg.cn/07a015e7bb4b43bb97943fb9841a9cd7.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA6auY6YKu5ZC05bCR,size_20,color_FFFFFF,t_70,g_se,x_16)

我们想办法把最大盘移动到C，然后剩余3个盘依次移动到B，如上图。这时问题就转换成了，如何把三个盘子从下往上是从大到小的顺序移动到C，这时思路就和n=3一样了

至此，递归的思路就很清晰了：n个盘子的时候，将n-1个盘子移动到中转上，然后从起始位置把1个最大盘移动到目标位置上。

然后问题转换为：中转位置成为起始位置，原起始位置成为中转位置，目标位置仍是pos3,如何把起始位置上n-2个盘子移动到目标位置上？
。。。

# 二、实战代码



————————————————
版权声明：本文为CSDN博主「劲夫学编程」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/m0_57180439/article/details/120972175