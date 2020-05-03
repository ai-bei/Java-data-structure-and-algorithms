package com.iotknowyou.Sort;

import java.util.Arrays;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  冒泡算法的实现
 * @updateRemark
 * @createDate 2020/4/21 10:45
 * @updateDate 2020/4/21 10:45
 **/
public class bubbleSort {
    public static void main(String[] args) {
        //需要排序的数组
        int  arr[] = {3,9,-1,10,-2};
        bubblesortOne(arr);
        System.out.println("-------------------------------------");
        //需要排序的数组
//        int  arrTwo[] = {3,9,-1,10,-2};
        int  arrTwo[] = {2,1,1,3,4};
        bubblesortTwo(arrTwo);


        System.out.println("");
    }


    /**
     * 冒泡算法 1   时间复杂度 O(n^2)
     *      冒泡排序的思路
     *      1、如果需要排序的数值中有n个元素，需要进行 n-1 趟排序
     *      2、每完成一次排序，就会将最大的数值，排在最后面
     *      3、每走一趟排序，就会少一个元素参与冒泡
     */
    public static void bubblesortOne(int[] arr){
        int temp = 0 ;
        for (int i = 0; i < arr.length - 1; i++) {
            // 每走一趟排序，就会少一个元素参与冒泡 ====>  arr.length - 1 - i
            for (int j = 0; j < arr.length - 1 - i ; j++) {
                // 如果前面的数比后面的数大，则交换
                // 每完成一次排序，就会将最大的数值，排在最后面
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));

        }
    }


    /**
     * 冒泡算法 2  对冒泡算法进行简单的优化
     *      冒泡排序的思路
     *      1、如果需要排序的数值中有n个元素，需要进行 n-1 趟排序
     *      2、每完成一次排序，就会将最大的数值，排在最后面
     *      3、每走一趟排序，就会少一个元素参与冒泡
     *      优化思路：
     *          1、添加一个flag标志，判断冒泡在一趟循环后，有没有进行交换数据
     *          2、否则，表示冒泡排序完成，后续的操作可以不需要，跳出冒泡循环即可。
     *
     *
     * @param arr
     */
    public static void bubblesortTwo(int[] arr){
        int temp = 0 ;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            // 每走一趟排序，就会少一个元素参与冒泡 ====>  arr.length - 1 - i
            for (int j = 0; j < arr.length - 1 - i ; j++) {
                // 如果前面的数比后面的数大，则交换
                // 每完成一次排序，就会将最大的数值，排在最后面
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(!flag){ // 在一趟排序中，一次交换都没有发生过
                break;
            }else {
                flag = false; // 重置flag!!!, 进行下次判断
            }

            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));

        }
    }
}
