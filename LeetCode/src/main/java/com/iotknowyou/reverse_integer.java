package com.iotknowyou;


/* 题目

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

    输入: 123
    输出: 321
 
示例 2:

    输入: -123
    输出: -321

示例 3:

    输入: 120
    输出: 21

注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


*/
public class reverse_integer {

    public int reverse(int x) {
        String input = Integer.toString(x);
        // 正负数标志
        int flag = 1;
        // 如果是负数，截取从第 1 个字符开始的字符串
        // 将flag值为设为 -1
        if(input.charAt(0) == '-'){
            input = input.substring(1);
            flag = -1;
        }
        //转成char数组
        char[] inputChars = input.toCharArray();
        //创建临时char 数组
        char[] temp = new char[inputChars.length];
        // 元素翻转
        for (int i = inputChars.length - 1; i >= 0; i--) {
            temp[inputChars.length - 1 - i] = inputChars[i];
        }
        //将结果转成 Long
        Long aLong = Long.valueOf(new String(temp));

        //判断是否溢出
        if(aLong > Integer.MAX_VALUE ) {
            return 0;
        }
        return (int) (aLong * flag);

    }

    public int reverse(int x , String ways){
        String a = Integer.toString(x);
        int b = 1;
        if(a.charAt(0) == '-') {
            a = a.substring(1);
            b = -1;
        }
        char[] chars = a.toCharArray();
        char[] chars1 = new char[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            chars1[chars.length - 1 - i] = chars[i];
        }
        Long aLong = Long.valueOf(new String(chars1));
        if(aLong > Integer.MAX_VALUE || aLong < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (aLong * b);

    }


    public static void main(String[] args) {

        reverse_integer reverseInteger = new reverse_integer();

        int reverse = reverseInteger.reverse(8795);

        //int reverse_2 = reverseInteger.reverse(5689,"2");


        // 输出结果
        System.out.println(reverse);

    }
}
