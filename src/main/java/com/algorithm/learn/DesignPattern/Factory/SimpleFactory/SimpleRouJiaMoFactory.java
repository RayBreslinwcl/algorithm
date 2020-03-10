package com.algorithm.learn.DesignPattern.Factory.SimpleFactory;

/**
 * Created by Administrator on 2020/3/11.
 * 【简单工厂模式】
 * 解决问题：
 * 可以使在使用创建肉夹馍对象实例的时候，可以直接使用工厂类创建
 */
public class SimpleRouJiaMoFactory {

    public RouJiaMo createRouJiaMo(String type){
        RouJiaMo rouJiaMo=null;
        if(type.equals("Suan")){
            rouJiaMo=new SuanRouJiaMo();
        }else if(type.equals("Tian")){
            rouJiaMo=new TianRouJiaMo();
        }else if(type.equals("La")){
            rouJiaMo=new LaRouJiaMo();
        }
        return rouJiaMo;
    }



}
