package com.algorithm.learn.Leetcode._205isomorphic_strings;

import java.util.HashMap;

/**
 * Created by Administrator on 2020/1/12.
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

 示例 1:
 输入: s = "egg", t = "add"
 输出: true

 示例 2:
 输入: s = "foo", t = "bar"
 输出: false

 示例 3:
 输入: s = "paper", t = "title"
 输出: true

 说明:
 你可以假设 s 和 t 具有相同的长度。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/isomorphic-strings
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _205isomorphic_strings {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s,t)&&isIsomorphicHelper(t,s);
    }

    private boolean isIsomorphicHelper(String s,String t){
        int n=s.length();
        HashMap<Character,Character> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1)!=c2){
                    return false;
                }

            }else{
                map.put(c1,c2);
            }
        }
        return true;
    }
}
