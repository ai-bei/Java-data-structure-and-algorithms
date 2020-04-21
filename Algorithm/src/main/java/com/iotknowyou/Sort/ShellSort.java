package com.iotknowyou.Sort;

import java.util.Arrays;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  希尔排序的实现 ，希尔排序的实现一般也有两种方式：交换法、移动法
 * @updateRemark
 * @createDate 2020/4/21 13:48
 * @updateDate 2020/4/21 13:48
 **/
public class ShellSort {

    public static void main(String[] args) {
        // 测试希尔排序
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        //shellSort(arr);
        shellSort2(arr);
    }



    // 使用交换法实现
    /*
        1、根据数组的长度计算出分组步长 ， gap = arr.length / 2
        2、遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
        3、如果当前元素大于加上步长后的那个元素，说明交换
        4、直到 步长 gap = 1 时，结束并且完成希尔排序

        特点： 1、效率比较低
    */


    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        // 根据前面的逐步分析，使用循环处理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
    }



    //对交换式的希尔排序进行优化->移位法
    // 与交换式排序最大的不同是，移动法排序会对 每个组里面进行 直接插入排序
    public static void shellSort2(int[] arr) {
        int count = 0;
        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));

        }
    }
}
