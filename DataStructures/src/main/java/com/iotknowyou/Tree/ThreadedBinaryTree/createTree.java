package com.iotknowyou.Tree.ThreadedBinaryTree;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/27 13:38
 * @updateDate 2020/4/27 13:38
 **/
public class createTree<T> {

    /**
     * 通过数组构造一个二叉树（完全二叉树）
     * @param array
     * @param index
     * @return
     */
    public  Node<T> createBinaryTree(T[] array, int index) {
        Node<T> node = null;

        if(index < array.length) {
            node = new Node(array[index]);
            node.setLeft(createBinaryTree(array, index * 2 + 1));
            node.setRight(createBinaryTree(array, index * 2 + 2));

            //记录节点的父节点（后序线索化遍历时使用）
            if(node.getLeft() != null) {
                node.getLeft().setParent(node);
            }

            if(node.getRight() != null) {
                node.getRight().setParent(node);
            }
        }

        return node;
    }

}
