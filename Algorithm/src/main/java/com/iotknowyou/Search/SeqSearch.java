package com.iotknowyou.Search;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  线性查询实现
 * @updateRemark
 * @createDate 2020/4/24 19:08
 * @updateDate 2020/4/24 19:08
 **/
public class SeqSearch {

    public static void main(String[] args) {
        int arr[] = { 1, 9, 11, -1, 34, 89 };// 没有顺序的数组
        int index = seqSearch(arr, -11);
        if(index == -1) {
            System.out.println("没有找到到");
        } else {
            System.out.println("找到，下标为=" + index);
        }
    }

    /**
     * 实现的线性查找是找到一个满足条件的值，就返回下标，没有则返回 -1
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr, int value) {
        // 线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
