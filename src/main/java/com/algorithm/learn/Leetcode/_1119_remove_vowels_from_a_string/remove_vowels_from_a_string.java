package com.algorithm.learn.Leetcode._1119_remove_vowels_from_a_string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/1/8.
 * 题目：删去字符串中的元音
 * 给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。

 示例 1：
 输入："leetcodeisacommunityforcoders"
 输出："ltcdscmmntyfrcdrs"

 示例 2：
 输入："aeiou"
 输出：""
  
 提示：
 S 仅由小写英文字母组成。
 1 <= S.length <= 1000
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-vowels-from-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class remove_vowels_from_a_string {

    public static void main(String[] args) {
        String input="leetcodeisacommunityforcoders";
        String res= removeVowels(input);
        System.out.println(res);
    }

    public static String removeVowels(String S) {
        List<Character> clist=new ArrayList<>();
        clist.add('a');
        clist.add('e');
        clist.add('i');
        clist.add('o');
        clist.add('u');

//        S.replace()
        char[] c=S.toCharArray();
        StringBuffer sbf=new StringBuffer();
        for(int i=0;i<S.length();i++){
            if(!clist.contains(c[i])){
                sbf.append(c[i]);
            }
        }
        return sbf.toString();
    }
}
