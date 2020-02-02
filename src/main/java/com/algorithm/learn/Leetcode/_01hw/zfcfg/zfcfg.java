package com.algorithm.learn.Leetcode._01hw.zfcfg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Administrator on 2020/2/2.
 * 题目：
 * 字符串分隔
 *
 * 题目描述
 •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 输入描述:
 连续输入字符串(输入2次,每个字符串长度小于100)

 输出描述:
 输出到长度为8的新字符串数组

 示例1
 输入
 abc
 123456789

 输出
 abc00000
 12345678
 90000000
 */
public class zfcfg {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            //读取数字个数
            String str1=sc.nextLine();
            //复杂错误解答，没有验证：
//            String str2=sc.nextLine();
//            List<String> list=new ArrayLcuoist<>();
//
//            String stemp="00000000";
//            for (int i=0;i<str1.length();i=i+8){
//                if(i+8> str1.length()){
//                    list.add(str1.substring(i)+stemp.substring(0,i+8-str1.length())) ;
//                }else {
//                    list.add(str1.substring(i,i+8));
//                }
//            }

            //错误原因：被题目带偏了
            //参考大神方法，有了新的思路，可以先有多余，再直接修剪。方法步骤一调换，瞬间简单很多
            if(str1.length()%8 !=0){
                str1=str1+"00000000";
            }
            while (str1.length()>=8){
                System.out.println(str1.substring(0,8));
                str1=str1.substring(8);
            }

        }
    }
}
