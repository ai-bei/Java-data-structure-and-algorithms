package com.iotknowyou.Tree.BinarySortTree;

import org.junit.Test;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 **/
public class BinarySortTreeTest {

    @Test
    public void test(){
        // 创建排序二叉树
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.addNode(new Node(arr[i]));
        }

        // 遍历
        binarySortTree.infixOrder(); System.out.println("=================");

        binarySortTree.delNode(new Node(10));
        // 遍历 排序二叉树
        binarySortTree.infixOrder(); System.out.println("=================");

        binarySortTree.delNode(new Node(7));
        // 遍历 排序二叉树
        binarySortTree.infixOrder(); System.out.println("=================");
    }
}
