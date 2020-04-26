package com.iotknowyou.Tree.ArrBinaryTreeDemo;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/26 22:08
 * @updateDate 2020/4/26 22:08
 **/
public class ArrBinaryTreeTest {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7};
        //创建一个 ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        //arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
        //arrBinaryTree.infixOrder(); // 4,2,5,1,6,3,7
        arrBinaryTree.postOrder(); // 4,5,2,6,7,3,1
    }

}

//编写一个ArrayBinaryTree, 实现顺序存储二叉树遍历



