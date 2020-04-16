package com.iotknowyou;

/*
    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

    示例 1:

    输入: 121
    输出: true
    示例 2:

    输入: -121
    输出: false
    解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    示例 3:

    输入: 10
    输出: false
    解释: 从右向左读, 为 01 。因此它不是一个回文数。
    进阶:

    你能不将整数转为字符串来解决这个问题吗？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/palindrome-number
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class palindrome_number {

    public boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        int flag = 1;
        if(input.charAt(0) == '-'){
            //为负数直接返回false
            return false;
            /*input = input.substring(1);
            flag= -1;*/
        }
        char[] inputChars = input.toCharArray();
        char[] tempChars = new char[inputChars.length];
        for (int i = inputChars.length - 1; i > -1; i--) {
            tempChars[inputChars.length - 1 - i] = inputChars[i];
        }
        Long along = Long.valueOf(new String(tempChars)) * flag;

        if((long) x ==  along){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {

        palindrome_number palindromeNumber = new palindrome_number();

        boolean palindrome = palindromeNumber.isPalindrome(-121);
        System.out.println("输出的结果："+palindrome);
    }
}
