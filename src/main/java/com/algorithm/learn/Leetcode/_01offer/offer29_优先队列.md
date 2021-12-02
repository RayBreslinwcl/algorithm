【参考： https://www.cnblogs.com/wei-jing/p/10806236.html 】

# 一、优先队列概述

 　　优先队列PriorityQueue是Queue接口的实现，可以对其中元素进行排序，可以放基本数据类型的包装类（如：Integer，Long等）或自定义的类对于基本数据类型的包装器类，优先队列中元素默认排列顺序是升序排列但对于自己定义的类来说，需要自己定义比较器。

# 二、常用方法

```
peek()//返回队首元素
poll()//返回队首元素，队首元素出队列
add()//添加元素
size()//返回队列元素个数
isEmpty()//判断队列是否为空，为空返回true,不空返回false
```

# 三、优先队列的使用

## 1.队列保存的是基本数据类型的包装类

```
//自定义比较器，降序排列
static Comparator<Integer> cmp = new Comparator<Integer>() {
      public int compare(Integer e1, Integer e2) {
        return e2 - e1;
      }
    };
public static void main(String[] args) {
        //不用比较器，默认升序排列
        Queue<Integer> q = new PriorityQueue<>();
        q.add(3);
        q.add(2);
        q.add(4);
        while(!q.isEmpty())
        {
            System.out.print(q.poll()+" ");
        }
        /**
         * 输出结果
         * 2 3 4 
         */
        //使用自定义比较器，降序排列
        Queue<Integer> qq = new PriorityQueue<>(cmp);
        qq.add(3);
        qq.add(2);
        qq.add(4);
        while(!qq.isEmpty())
        {
            System.out.print(qq.poll()+" ");
        }
        /**
         * 输出结果
         * 4 3 2 
         */
}
```



 

## 2.队列保存的是自定义类



```
//矩形类
class Node{
    public Node(int chang,int kuan)
    {
        this.chang=chang;
        this.kuan=kuan;
    }
    int chang;
    int kuan;
}

public class Test {
　　　　//自定义比较类，先比较长，长升序排列，若长相等再比较宽，宽降序
    static Comparator<Node> cNode=new Comparator<Node>() {
        public int compare(Node o1, Node o2) {
            if(o1.chang!=o2.chang)
                return o1.chang-o2.chang;
            else
                return o2.kuan-o1.kuan;
        }
        
    };
    public static void main(String[] args) {
        Queue<Node> q=new PriorityQueue<>(cNode);
        Node n1=new Node(1, 2);
        Node n2=new Node(2, 5);
        Node n3=new Node(2, 3);
        Node n4=new Node(1, 2);
        q.add(n1);
        q.add(n2);
        q.add(n3);
        Node n;
        while(!q.isEmpty())
        {
            n=q.poll();
            System.out.println("长: "+n.chang+" 宽：" +n.kuan);
        }
　　　　　/**
　　　　　　* 输出结果
　　　　　　* 长: 1 宽：2
　　　　　　* 长: 2 宽：5
　　　　　　* 长: 2 宽：3
　　　　　　*/
    }
}
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

##  3.优先队列遍历

　　PriorityQueue的iterator（）不保证以任何特定顺序遍历队列元素。

　　若想按特定顺序遍历，先将队列转成数组，然后排序遍历



```
Queue<Integer> q = new PriorityQueue<>(cmp);
        int[] nums= {2,5,3,4,1,6};
        for(int i:nums)
        {
            q.add(i);
        }
        Object[] nn=q.toArray();
        Arrays.sort(nn);
        for(int i=nn.length-1;i>=0;i--)
            System.out.print((int)nn[i]+" ");
        /**
         * 输出结果
         * 6 5 4 3 2 1 
         */
```

 

## 4.比较器生降序说明



```
Comparator<Object> cmp = new Comparator<Object>() {
        public int compare(Object o1, Object o2) {
            //升序
            return o1-o2;
            //降序
            return o2-o1;
        }
    };
```

