package com.iotknowyou.Sort;

import java.util.Arrays;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  简单的选择算法
 * @updateRemark
 * @createDate 2020/4/21 11:33
 * @updateDate 2020/4/21 11:33
 **/
public class SelectSort {
    /**
     基本思路：
        1、使用双重for循环遍历
        2、一共需要(arr.length - 1)趟排序
        3、每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
        4、再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
        5、直到全部待排序的数据元素排完。

     注：
        1、每走一趟，都会确定一个元素的位置

        int [] arr = {101, 34, 119, 1, -1, 90, 123};

         第1轮后~~
         [-1, 34, 119, 1, 101, 90, 123]

        # 1、 假定 arr[0] 为最小值
          2、 用 arr[0] 和 arr[1] -- arr[length-1] 的元素比较
          3、 否则，arr[0] = arr[j]





         第2轮后~~
         [-1, 1, 119, 34, 101, 90, 123]
         第3轮后~~
         [-1, 1, 34, 119, 101, 90, 123]
         第4轮后~~
         [-1, 1, 34, 90, 101, 119, 123]
         第5轮后~~
         [-1, 1, 34, 90, 101, 119, 123]
         第6轮后~~
         [-1, 1, 34, 90, 101, 119, 123]
         顺序排序：
         [-1, 1, 34, 90, 101, 119, 123]



     */

    public static void main(String[] args) {
        int [] arr = {101, 34, 119, 1, -1, 90, 123};
        selectSort_asc(arr);
        System.out.println("顺序排序：");
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------------------");
        selectSort_desc(arr);
        System.out.println("倒序排序：");
        System.out.println(Arrays.toString(arr));
    }

    //选择排序 ， 按从小到大的排序规则
    //选择排序时间复杂度是 O(n^2)
    public static void selectSort_asc(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值，并不是最小
                    min = arr[j]; // 重置min
                    minIndex = j; // 重置minIndex
                }
            }

            // 将最小值，放在arr[0], 即交换
            if (minIndex != i) { // 当 minIndex发生改变时，才需要交换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            // 输出每一趟的结果，方便推导
            System.out.println("第"+(i+1)+"轮后~~");
            System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
        }
    }

    //选择排序 ， 按从大到小的排序规则
    //选择排序时间复杂度是 O(n^2)
    public static void selectSort_desc(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            int max = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (max < arr[j]) { // 说明假定的最小值，并不是最小
                    max = arr[j]; // 重置min
                    maxIndex = j; // 重置minIndex
                }
            }
            // 将最小值，放在arr[0], 即交换
            if (maxIndex != i) { // 当 minIndex发生改变时，才需要交换
                arr[maxIndex] = arr[i];
                arr[i] = max;
            }
            // 输出每一趟的结果，方便推导
            //System.out.println("第"+(i+1)+"轮后~~");
            //System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
        }
    }
}
