package com.iotknowyou.Sort;

import java.util.Arrays;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/21 13:06
 * @updateDate 2020/4/21 13:06
 **/
public class InsertSort {

    /**
     插入排序的关键点：
     1、采用双层循环：时间复杂度也是O（n的平方）
     （1）外层循环表示的是排序的趟数，n个数字需要n-1趟，因此，外层循环的次数是n-1次；同时也代表数的位置。
     （2）内层循环表示的是每一趟排序的数字。根据插入排序的思想，第i趟排序时，有序数组中的数字就有i个，就需要进行i次比较，因此循环i次。注意采用的是从后往前进行比较。
     2、从后往前扫描的时候，如果必须插入的数大于有序数组中当前位置的数，则有序数组中的数和它之后的数均往后移一个位置，否则，把插入的数插入到有序数组中。（稳定排序）

     */
    public static void main(String[] args) {
        int[] arr = {102 , 34 , 113, 2};

        /**
         * 第一趟遍历   102 , 34 , 113, 2
            temp = 34 ,         类比（102 , 34） 冒泡
             102  102  113  2
             遍历完的结果  -->   34   102  113  2
         * 第二趟遍历   34   102  113  2
            temp = 113
             遍历完的结果  -->   34   102  113  2   类比（34   102  113） 冒泡
         * 第二趟遍历   34   102  113  2
            temp = 2
             遍历完的结果  -->    2 34   102  113     类比（34   102  113  2） 冒泡

         */

        insertSort(arr);
    }





    //插入排序
    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //使用for循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arr));
        }
    }

    //插入排序
    public static void insertSort_desc(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //使用for循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal > arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arr));
        }
    }
}
