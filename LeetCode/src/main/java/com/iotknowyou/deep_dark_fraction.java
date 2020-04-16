package com.iotknowyou;

/**
  连分式 化简成 简分式

  实例一:
  输入：cont = [3, 2, 0, 2]
  输出：[13, 4]
  解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。

  实例二:
  输入：cont = [0, 0, 3]
  输出：[3, 1]
  解释：如果答案是整数，令分母为1即可。


  来源：力扣（LeetCode）
  链接：https://leetcode-cn.com/problems/deep-dark-fraction
  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class deep_dark_fraction {

    public static void main(String[] args) {
        //测试
        int[] cont = new int[]{3, 2, 0, 2};

        int[] fraction_result = fraction(cont);

        for (int i : fraction_result) {
            System.out.println("数组的结果是："+i);
        }

    }



    /**
     *  公式推导-通分
     *  递归函数的循环体，通过递归计算出极简分式 a + 1/b 同 (ab + 1)/b 的结果,将结果存储为 [ab+1 , b]
     * @param count
     * @param index
     * @return int[0]-分子，int[1]-分母
     */
    private static int[] recursive(int[] count, int index) {

        /**
         * 递归到根节点时，直接返回 [ count[index] , 1 ]
         *
         * 注：
         *   若  count == count[1,2,3,...,n]
         *
         *   当  index == count.length - 1 (当index等于 数组的长度减1的时候) 则  return  =  [n,1]
         *
         *   否则  return = [ count[index] * nextRes[0] + nextRes[1], nextRes[0] ] , nextRes 表示为前一个极简式的结果数组
         *   返回极简式(ab + 1)/b 的结果,将结果为 [ab+1 , b]
         *
         */
        if (index == count.length - 1) {
            return new int[]{count[index], 1};
        }

        int[] nextRes = recursive(count, index+1);
        return new int[]{count[index] * nextRes[0] + nextRes[1], nextRes[0]};
    }

    /**
     * 递归计算结果
     * @param cont
     * @return
     */
    public static int[] fraction(int[] cont) {
        return recursive(cont, 0);
    }
}
