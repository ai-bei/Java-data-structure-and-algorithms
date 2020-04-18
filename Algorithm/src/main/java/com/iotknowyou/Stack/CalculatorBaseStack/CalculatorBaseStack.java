package com.iotknowyou.Stack.CalculatorBaseStack;

import java.util.Scanner;

/**
 * @author LiuRongHua
 * @updateUser
 * @description 使用 stack 的思想，设计实现简单的计算器
 * @updateRemark
 * @createDate 2020/4/18 16:55
 * @updateDate 2020/4/18 16:55
 **/
public class CalculatorBaseStack {


    public static void main(String[] args) {
        String key= "";
        String expression = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("exp: 输入表达式，计算结果");
            System.out.println("exit: 退出程序");
            System.out.println("请输入您的选择：");
            key = scanner.next();
            switch (key){
                case "exp":
                    System.out.print("请输入表达式：");
                    expression = scanner.next();
                    CalculatorCenterTwo(expression);
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序结束");
    }
    /**
     * 总结：
     *      1、由于 栈的 FIFO的特性，在遍历表达式的时候，建议倒序遍历，使用倒序遍历入栈后，进行出栈计算的时候，就可以满足 从左到右的计算顺序了
     *      2、下面的 CalculatorCenter计算方法，只适用于 个位数的 + - * / 表达式运算
     * @param expression
     */
    public static void CalculatorCenter(String expression) {

        // 创建数值栈，存放表达式中的数值
        ArrayStack numStack = new ArrayStack(10);
        // 创建符号栈，存放表达式的 符号
        ArrayStack operStack = new ArrayStack(10);

        // 定义需要用到的变量
        int index = 0;
        int index_2 = 0;
        int num_1 = 0;
        int num_2 = 0;
        char oper = 0;
        int res = 0;
        char ch =' '; //将每次扫描得到的char保存在这里

        // 定义一个 flag ， 当数值前面的符号为 '-' 时，我让它乘以 -1 再入栈
        // 这样的好处是为了，遍历完表达式后，保证了 表达式从右往左计算结果和从左往右计算结果相同。
        int flag = 1;

        // 使用循环扫描 expression
        while (true){
            /**
             * ********************************************************************************
             * 方法二 : 倒序遍历
             *  倒序遍历输入的表达式，以保证最后表达式计算的顺序是  从左到右
             */

            // 依次得到 expression 中的 字符
            // ch = expression.substring(index,index+1).charAt(0);

              index_2 = expression.toCharArray().length - 1;

              ch = expression.substring(index_2 - index ,index_2 - index + 1).charAt(0);

            // 判断ch是不是运算符，然后做相应的处理
            if(operStack.isOper(ch)){
                /**
                 *******************************************************************************
                // 方法一
                // 判断当前的符号是不是 '-' ,将 flag = -1 ,操作符转变成 '+' 传入栈中, 下一个存入的数字 将会是负数
                // 这种处理方式，相当于 '-'符号的运算被 '+'符号运算 代替了
                if(ch == '-'){
                    flag = -1;
                    ch = '+';
                }else {
                    flag = 1 ;
                }
                 ********************************************************************************
                 */
                // 判断当前的符号栈是否为空
                if(!operStack.isEmpty()){
                    //如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符，
                    // 就需要从数栈中pop出两个数，在符号栈中pop出一个符号，进行运算，将运算结果存入数栈，
                    // 最后需要将当前的操作符入 符号栈
                    if(operStack.priority(ch) <= operStack.priority((char)operStack.peek())){
                        num_1 = numStack.pop();
                        num_2 = numStack.pop();
                        oper = (char) operStack.pop();
                        res = numStack.cal(num_1,num_2,oper);

                        // 将运算结果入数栈
                        numStack.push(res);

                        // 将当前的操作符入符号栈
                        operStack.push(ch);
                    } else {
                        // 如果当前的操作符的优先级大于栈中的操作符，直接入符号栈
                        operStack.push(ch);
                    }
                }else {
                    // 如果为空，就直接入栈
                    operStack.push(ch);
                }
            } else {
                // 如果是数字，直接入数栈
                numStack.push(flag *(ch - 48));
            }

            // index ++ ,指向下一个字符
            index++;
            // 当满足下面条件，表示已经扫描到了栈尾，直接退出。
            if(index >= expression.length()){
                break;
            }
        }

        // 当表达式扫描完毕后，就顺序的从 数栈 和 符号栈中pop出相应的数和符号，并运行
        while (true) {
            // 如果符号栈为空，则计算到最后的结果，且数栈中只有一个数字，即最后的结果
            if(operStack.isEmpty()){
                break;
            }
            num_1 = numStack.pop();
            num_2 = numStack.pop();
            oper = (char) operStack.pop();
            res = numStack.cal(num_1,num_2,oper);
            numStack.push(res); // 运算结果入栈
        }
        // 输出计算结果
        System.out.printf("表达式 %s = %d \n" , expression ,numStack.pop());
    }


    /**
     *   1、改进 数值 入栈的程序代码，实现对 多位数的 + - * / 表示式的计算
     *   基本思路：
     *      1、给定一个 boolean 变量 KeepNnm， 一个数值入栈后 ， KeepNnm = true , 一个符号入栈时， KeepNnm = false
     *      2、在数值 入栈的程序代码中，添加对 KeepNum的判断， 为true时，numStock.pop 和当前的 ch 拼接后，再入栈
     *    总结：
     *      1、通过实践发现，当使用 Integer.valueOf("00") 入栈中的数值是 0 ，会使得  10000... 的数值 最后入栈中的数值是 10
     *      2、解决上述的问题，引入的 zeroCount 的变量统计拼接数值的次数， 每拼接一次，都增加一阶
     *         入栈时使用 Integer.valueOf(tempNUm)*Math.pow(10,zeroCount)) + pop  以保证数值的大小
     *      3、operStack.priority(ch) <= operStack.priority((char)operStack.peek()) 中的等号应该去掉 ，
     *      以保证相同的优先级的计算都先入栈 ， 高优先级的先计算完再入栈
     *
     * @param expression
     */
    public static void CalculatorCenterTwo(String expression) {

        // 创建数值栈，存放表达式中的数值
        ArrayStack numStack = new ArrayStack(10);
        // 创建符号栈，存放表达式的 符号
        ArrayStack operStack = new ArrayStack(10);

        // 定义需要用到的变量
        int index = 0;
        int index_2 = 0;
        int num_1 = 0;
        int num_2 = 0;
        char oper = 0;
        int res = 0;
        char ch =' '; //将每次扫描得到的char保存在这里

        // 定义一个 flag ， 当数值前面的符号为 '-' 时，我让它乘以 -1 再入栈
        // 这样的好处是为了，遍历完表达式后，保证了 表达式从右往左计算结果和从左往右计算结果相同。
        int flag = 1;


        // 定义一个 KeepNum
        boolean KeepNum =false ;
        String tempNUm = "" ;
        int zeroCount = 0;

        // 使用循环扫描 expression
        while (true){
            /**
             * ********************************************************************************
             * 方法二 : 倒序遍历
             *  倒序遍历输入的表达式，以保证最后表达式计算的顺序是  从左到右
             */

            // 依次得到 expression 中的 字符
            // ch = expression.substring(index,index+1).charAt(0);

            index_2 = expression.toCharArray().length - 1;

            ch = expression.substring(index_2 - index ,index_2 - index + 1).charAt(0);

            // 判断ch是不是运算符，然后做相应的处理
            if(operStack.isOper(ch)){
                /**
                 *******************************************************************************
                 // 方法一
                 // 判断当前的符号是不是 '-' ,将 flag = -1 ,操作符转变成 '+' 传入栈中, 下一个存入的数字 将会是负数
                 // 这种处理方式，相当于 '-'符号的运算被 '+'符号运算 代替了
                 if(ch == '-'){
                 flag = -1;
                 ch = '+';
                 }else {
                 flag = 1 ;
                 }
                 ********************************************************************************
                 */
                // 判断当前的符号栈是否为空
                if(!operStack.isEmpty()){
                    //如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符，
                    // 就需要从数栈中pop出两个数，在符号栈中pop出一个符号，进行运算，将运算结果存入数栈，
                    // 最后需要将当前的操作符入 符号栈
                    if(operStack.priority(ch) < operStack.priority((char)operStack.peek())){
                        num_1 = numStack.pop();
                        num_2 = numStack.pop();
                        oper = (char) operStack.pop();
                        res = numStack.cal(num_1,num_2,oper);

                        // 将运算结果入数栈
                        numStack.push(res);

                        // 将当前的操作符入符号栈
                        operStack.push(ch);
                        KeepNum = false;
                    } else {
                        // 如果当前的操作符的优先级大于栈中的操作符，直接入符号栈
                        operStack.push(ch);
                        KeepNum = false;
                    }
                }else {
                    // 如果为空，就直接入栈
                    operStack.push(ch);
                    KeepNum = false;
                }
            } else {
                // 如果是数字,判断 KeepNum 值，如果为真时，需要拼接字符串
                if(KeepNum){
                    zeroCount ++ ; // 每拼接一数值，则数值都增加一阶 10 100 1000  10000
                    int pop = numStack.pop() ;
                    tempNUm = "" + ch ;
                    numStack.push((int) (Integer.valueOf(tempNUm)*Math.pow(10,zeroCount)) + pop);
                }else {
                    //清空之前的数据
                    zeroCount=0;
                    tempNUm = "";

                    numStack.push(flag *(ch - 48));
                    KeepNum = true;
                }

            }

            // index ++ ,指向下一个字符
            index++;
            // 当满足下面条件，表示已经扫描到了栈尾，直接退出。
            if(index >= expression.length()){
                break;
            }
        }

        // 当表达式扫描完毕后，就顺序的从 数栈 和 符号栈中pop出相应的数和符号，并运行
        while (true) {
            // 如果符号栈为空，则计算到最后的结果，且数栈中只有一个数字，即最后的结果
            if(operStack.isEmpty()){
                break;
            }
            num_1 = numStack.pop();
            num_2 = numStack.pop();
            oper = (char) operStack.pop();
            res = numStack.cal(num_1,num_2,oper);
            numStack.push(res); // 运算结果入栈
        }
        // 输出计算结果
        System.out.printf("表达式 %s = %d \n" , expression ,numStack.pop());
    }
}
