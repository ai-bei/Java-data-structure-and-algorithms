package com.iotknowyou.Tree.AVLTree;

import org.junit.Test;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 **/
public class AVLTreeTest {

    /** TODO  对树进行 平衡操作时，存在问题。   */

    @Test
    public void test(){
        int arr[] = {3, 2, 1, 4, 5, 7, 44};
        int i;
        AVLTree<Integer> tree = new AVLTree<Integer>();

        System.out.printf("== 依次添加: ");
        for (i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            tree.insert(arr[i]);
        }
        System.out.printf("\n== 前序遍历: ");
        tree.preOrder();

        System.out.printf("\n== 中序遍历: ");
        tree.infixOrder();

        System.out.printf("\n== 后序遍历: ");
        tree.postOrder();
        System.out.printf("\n");

        System.out.printf("== 高度: %d\n", tree.height());
        System.out.printf("== 树的详细信息: \n");
        tree.print();

        i = 6;
        System.out.printf("\n== 删除根节点: %d", i);
        tree.remove(i);

        System.out.printf("\n== 高度: %d", tree.height());
        System.out.printf("\n== 中序遍历: ");
        tree.infixOrder();
        System.out.printf("\n== 树的详细信息: \n");
        tree.print();

    }
}
