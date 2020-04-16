package com.iotknowyou;

import java.util.Stack;

/* 题目描述：

    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    示例 1:

    输入: "()"
    输出: true
    示例 2:

    输入: "()[]{}"
    输出: true
    示例 3:

    输入: "(]"
    输出: false
    示例 4:

    输入: "([)]"
    输出: false
    示例 5:

    输入: "{[]}"
    输出: true

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/valid-parentheses
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


*/

public class valid_parentheses {

    public boolean isValid(String s){
        // 判断的标志
        boolean flag = false;
        // 创建 Stack 对象
        Stack<String> fh = new Stack<String>();
        String str;
        for (int i = 0; i < s.length(); i++) {
            str=String.valueOf(s.charAt(i));

            if (fh.empty()) {  // 栈为空，则进栈
                // 把项压入堆栈顶部
                fh.push(str);
            } else {  // 栈不为空，查看堆栈顶部的对象，进行比较，满足条件时，顶栈对象出栈， 当前的对象不进栈
                String stackElem=fh.peek();
                if (stackElem.equals("(") && str.equals(")")||stackElem.equals("[")&&str.equals("]")||stackElem.equals("{")&&str.equals("}")) {
                    // 移除堆栈顶部的对象
                    fh.pop();
                } else {
                    // 把项压入堆栈顶部
                    fh.push(str);
                }
            }
        }
        // 栈为空时，表示 true
        if (fh.empty()) {
            flag = true;
        }
        return flag;
    }


    public static void main(String[] args) {
        valid_parentheses validParentheses = new valid_parentheses();
        boolean isvalid = validParentheses.isValid("{(())}");
        System.out.println("result is :" +  isvalid);
    }
}

/* 知识点补充：

    栈是Vector的一个子类，它实现了一个标准的后进先出的栈，栈本身最重要的就是 push 和 pop.
    堆栈只定义了默认构造函数，用来创建一个空栈。堆栈除了包括由Vector定义的所有方法，也定义了自己的一些方法
    Stack()
    除了由Vector定义的所有方法，自己也定义了一些方法：

    序号	方法描述
    1	boolean empty()
    测试堆栈是否为空。
    2	Object peek( )
    查看堆栈顶部的对象，但不从堆栈中移除它。
    3	Object pop( )
    移除堆栈顶部的对象，并作为此函数的值返回该对象。
    4	Object push(Object element)
    把项压入堆栈顶部。
    5	int search(Object element)
    返回对象在堆栈中的位置，以 1 为基数。



*/