package com.iotknowyou.Tree.HuffmanTree;

import org.junit.Test;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/28 14:18
 * @updateDate 2020/4/28 14:18
 **/
public class CreateHuffmanTreeTest {

    @Test
    public void test(){
        Integer arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        HuffmanTree huffmanTree = new HuffmanTree();
        Node<Integer> huffmanTreeRoot = huffmanTree.createHuffmanTree(arr);

        //测试一把
        huffmanTree.preOrder(huffmanTreeRoot); //
    }
}
