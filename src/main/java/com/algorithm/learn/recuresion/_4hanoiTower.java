package com.algorithm.learn.recuresion;

import java.util.Scanner;

/**
 * 汉诺塔问题
 * 如下图所示，从左到右有A、B、C三根柱子，其中A柱子上面有从小叠到大的n个圆盘，
 * 现要求将A柱子上的圆盘移到C柱子上去，期间只有一个原则：一次只能移到一个盘子
 * 且大盘子不能在小盘子上面，求移动的步骤和移动的次数
 *
 * 参考：https://dmego.me/2016/10/16/hanoi
 *
 */
public class _4hanoiTower {
    /**
     * 移动次数
     */
    static int m=0;

    /**
     * 移动盘子操作
     * @param disks 第几号盘，从上往下
     * @param N 原始柱子
     * @param M 目的柱子
     */
    public static void move(int disks,char N,char M){
        System.out.println("第" + (++m) +" 次移动 : " +" 把 "+ disks+" 号圆盘从 " + N +" ->移到->  " + M);
    }

    /**
     * 递归实现汉诺塔的函数
     * @param n
     * @param A 源
     * @param B 辅助
     * @param C 目的
     */
    public static void hanoi(int n,char A,char B ,char C){
        if(n==1){
            //圆盘只有一个时，只需将其从A塔移到C塔
            _4hanoiTower.move(1,A,C);
        }else{
            //否则
            hanoi(n-1,A,C,B);//递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
            _4hanoiTower.move(n,A,C);//把A塔上编号为n的圆盘移到C上
            hanoi(n-1,B,A,C);//递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char A='A';
        char B='B';
        char C='C';
        System.out.println("******************************************************************************************");
        System.out.println("这是汉诺塔问题（把A塔上编号从小号到大号的圆盘从A塔通过B辅助塔移动到C塔上去");
        System.out.println("******************************************************************************************");
        System.out.print("请输入圆盘的个数：");
//        int disks=sc.nextInt();
        int disks=2;
        _4hanoiTower.hanoi(disks,A,B,C);
        sc.close();
    }
}
