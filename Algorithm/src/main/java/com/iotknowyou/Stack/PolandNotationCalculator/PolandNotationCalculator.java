package com.iotknowyou.Stack.PolandNotationCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  输入中缀表达式 ， 将中缀表达式转成逆波兰表达式（后缀表达式），最后通过计算逆波兰表达式得到结果
 * @updateRemark
 * @createDate 2020/4/19 13:46
 * @updateDate 2020/4/19 13:46
 **/
public class PolandNotationCalculator {

    /**
     * 将中缀表达式 字符数组 转成 后缀表达式 字符数组
     * @param PrefixExpressionList    中缀表达式 字符数组
     * @return suffixExpression   后缀表达式 的 List<String>数组
     * @return
     */
    public static List<String> PrefixExpression2suffixExpressionList(List<String> PrefixExpressionList){
        //定义两个栈
        Stack<String> s1 = new Stack<String>(); // 符号栈
        //说明：因为s2 这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
        //因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2
        //Stack<String> s2 = new Stack<String>(); // 储存中间结果的栈s2
        List<String> s2 = new ArrayList<String>(); // 储存中间结果的Lists2

        //遍历PrefixExpressionList
        for(String item: PrefixExpressionList) {
            //如果是一个数，加入s2
            if(item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while(!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//!!! 将 ( 弹出 s1栈， 消除小括号
            } else {
                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item) ) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次弹出并加入s2
        while(s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2; //注意因为是存放到List, 因此按顺序输出就是对应的后缀表达式对应的List
    }

    /**
     * 将字符串，转成字符数组
     * @param str
     * @return
     */
    public static List<String> String2List(String str){
        // 将 str ，分割成字符数组
        String[] split = str.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    /**
     * 接收一个逆波兰表达式的字符数组，返回表达式的结果
     *
     * 思路：
     *      1、从左往右扫描，如果是数字，直接入栈
     *      2、如果是 运算符，则 从栈中pop出2个数值进行计算。
     * @param suffixExpressionList
     * @return
     */
    public static int calculatorSuffixE(List<String> suffixExpressionList){
        // 创建 辅助栈
        Stack<String> stack = new Stack<>();
        
        // 遍历 suffixExpressionList
        for (String s : suffixExpressionList) {
            // 判断是不是 数字
            if(s.matches("\\d+")){  //使用正则表达式，比配多位数
                //入栈
                stack.push(s);
            }else {
                // 从栈中pop出两个数，进行运算，将结果存入栈中
                int num_1 = Integer.valueOf(stack.pop());
                int num_2 = Integer.valueOf(stack.pop());
                int res = 0;
                // 判断 操作符号
                if("+".equals(s)){
                    res = num_1 + num_2 ;
                }else if ("-".equals(s)){
                    res = num_2 - num_1 ;
                }else if ("*".equals(s)){
                    res = num_1 * num_2 ;
                }else if ("/".equals(s)){
                    res = num_2 / num_1 ;
                }else {
                    throw new RuntimeException("运算符不存在！");
                }
                stack.push(String.valueOf(res));
            }
        }

        // 最后将栈的结果 返回
        return Integer.parseInt(stack.pop());
    }


    // 测试类
    public static void main(String[] args) {

        // 直接输入 逆波兰表达式 , 对 逆波兰表达式进行计算
        String suffixExpression = "3 4 + 5 * 6 -";   // ==>  原表达式（中缀表达式）： （3+4）*5 -6
        List<String> suffixList = String2List(suffixExpression);

        // 直接输入 中缀表达式  ， 顶层会将  中缀表达式转换成 后缀表达式进行计算
//        String PrefixExpression = "( 3 + 4 ) * 5 - 6";
        String PrefixExpression = "( ( 2 + 3 ) * 4 )";
        List<String> PrefixList = String2List(PrefixExpression);
        List<String> prefixExpression2suffixExpressionList = PrefixExpression2suffixExpressionList(PrefixList);

        int res = calculatorSuffixE(suffixList);

        int res2 = calculatorSuffixE(prefixExpression2suffixExpressionList);

        System.out.println("计算结果 res  = " + res);
        System.out.println("计算结果 res2 = " + res2);
    }


}
