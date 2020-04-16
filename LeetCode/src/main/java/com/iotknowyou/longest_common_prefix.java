package com.iotknowyou;

/*
    编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。

    示例 1:

    输入: ["flower","flow","flight"]
    输出: "fl"
    示例 2:

    输入: ["dog","racecar","car"]
    输出: ""
    解释: 输入不存在公共前缀。
    说明:

    所有输入只包含小写字母 a-z 。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/longest-common-prefix
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/


public class longest_common_prefix {

    public String longestCommonPrefix(String[] strs) {
        // 空数组直接返回 空串
        if (strs.length == 0){
            return "";
        }

        String prefix = strs[0];
        // 遍历所有的 strs
        for (int i = 1; i < strs.length; i++){
            //返回指定字符在字符串中第一次出现处的索引
            //为0 则不改变 prefix  不为0 则 prefix去掉一位再匹配
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                // 都没有匹配时，prefix 为 null ， 此时返回空字符串
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }


    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "car";
        strs[1] = "bus";
        strs[2] = "subway";

        String[] strs2 = new String[3];
        strs2[0] = "car";
        strs2[1] = "car";
        strs2[2] = "car";

        longest_common_prefix longestCommonPrefix  = new longest_common_prefix();
        String s = longestCommonPrefix.longestCommonPrefix(strs2);

        // 方便结果显示，简单处理 空串
        if(s == null || "".equals(s)){
            s = "空字符串" ;
        }

        System.out.println("最长前缀为 ："+s);
    }


}
