package com.algorithm.learn.Leetcode._1309decrypt_string_from_alphabet_to_integer_mapping;

/**
 * Created by Administrator on 2020/1/12.
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：

 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 返回映射之后形成的新字符串。

 题目数据保证映射始终唯一。

 示例 1：
 输入：s = "10#11#12"
 输出："jkab"
 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

 示例 2：
 输入：s = "1326#"
 输出："acz"

 示例 3：
 输入：s = "25#"
 输出："y"

 示例 4：
 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 输出："abcdefghijklmnopqrstuvwxyz"
  

 提示：
 1 <= s.length <= 1000
 s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 s 是映射始终存在的有效字符串。
 在真实的面试中遇到过这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1309decrypt_string_from_alphabet_to_integer_mapping {

    public String freqAlphabets(String s) {
        String res=new String();
        // StringBuilder sb=StringBuilder
        char[] schar=s.toCharArray();
        for(int i=0;i<schar.length;i++){
            if(i+2<s.length() && s.charAt(i+2)=='#'){
                // res+=Character.toString(((char)((schar[i]-'1')*10+(schar[i+1]-'0')+'j')));
                res+=((char)((schar[i]-'1')*10+(schar[i+1]-'0')+'j'));
                i+=2;//因为每一次循环默认会加1
            }else{
                res+=((char)(schar[i]-'1'+'a'));
            }
        }
        return res;
    }
}
