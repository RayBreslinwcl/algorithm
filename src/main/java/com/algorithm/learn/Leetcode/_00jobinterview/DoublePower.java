package com.algorithm.learn.Leetcode._00jobinterview;

/**
 * Created by Administrator on 2020/2/1.
 */
public class DoublePower {
//    boolean

    /**
     * 该题的解题思路如下：
     * 1.当底数为0且指数<0时，会出现对0求倒数的情况，需进行错误处理；
     * 2.判断底数是否等于0，由于base为double型，所以不能直接用==判断
     * 3.优化求幂函数（二分幂）。
     * (1)当n为偶数，a^n =（a^n/2）*（a^n/2）；
     * (2)当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a。
     * 时间复杂度O(logn)
     * @param base
     * @param exponent
     * @return
     */
    public double power1(double base,int exponent){
        //如果底数等于0，并且指数小于0则不成立
        if(base==0&&exponent<0){
            throw new RuntimeException("输入有问题！");
        }

        if(exponent>=0){
            return  getpower(base,exponent);
        }else {
            //如果指数小于0，将指数转正
            double result=getpower(base,-exponent);
            //结果为上面求的结果的倒数
            return 1/result;
        }



    }
    //判断两个double是否相等
    boolean equal(double num1,double num2){
        if(num1-num2>-0.000001&&num1-num2<0.000001){
            return true;
        }else {
            return false;
        }
    }
    double getpower(double b,int e){
        //如果指数为0，返回1
        if(e==0){
            return 1;
        }
        //如果指数为1，返回b
        if(e==1){
            return b;
        }
        //e>>1相等于e/2，这里就是求a^n =（a^n/2）*（a^n/2）
        double result=getpower(b,e>>1);
        result=result*result;
        //如果指数e为奇数，则要再乘一次
        if((e%2)==1){
            result*=b;
        }
        return result;

    }

    /**
     * 直接暴力解法
     * @return
     */
    public double power2(double base,int exponent){
        double result=1;

        //错误场景
        if(base==0&&exponent<0){
            throw  new RuntimeException("输入错误！");
        }

        for (int i=0;i<=Math.abs(exponent) ;i++){
            result=result*base;
        }

        if(exponent>=0){
            return result;
        }else {
            return 1/result;
        }

    }
}
