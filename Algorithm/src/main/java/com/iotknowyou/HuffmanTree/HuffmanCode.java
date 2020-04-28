package com.iotknowyou.HuffmanTree;

import org.junit.Test;

import java.util.Map;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  霍夫曼编码的实现
 * @updateRemark
 * @createDate 2020/4/28 19:15
 * @updateDate 2020/4/28 19:15
 **/
public class HuffmanCode<T> {



    /**
     * 测试 ：
     *  1、数组转换成 霍夫曼树
     */
    @Test
    public void test(){
        // 测试创建霍夫曼树
        String s = "like" ;
        // 将 bytes 数组转成 霍夫曼树
        byte[] bytes = s.getBytes();
        HuffmanTree<Object> huffmanTree = new HuffmanTree<>();
        Node<Object> root = huffmanTree.ByteArrToHuffman(bytes);
        huffmanTree.preOrder(root);

        System.out.println("----------------------------------");

        // char[] chars = {'l','i','k','e'};
        String st = "I Like Java !";
        char[] chars = st.toCharArray();

        Node<Object> huffmanroot = huffmanTree.CharArrToHuffman(chars);
        huffmanTree.preOrder(huffmanroot);
    }

    /**
     * 测试：
     *    1、生成霍夫曼编码
     *
     */
    @Test
    public void test2(){
        String st = "I Like Java !";
        char[] chars = st.toCharArray();
        HuffmanTree<Object> huffmanTree = new HuffmanTree<>();
        // 构建 霍夫曼树
        Node<Object> huffmanroot = huffmanTree.CharArrToHuffman(chars);
        huffmanTree.preOrder(huffmanroot);
        // 生成 霍夫曼树的编码
        Map<Object, String> codes = huffmanTree.getCodes(huffmanroot);
        // 遍历 map
        for (Map.Entry<Object, String> objectStringEntry : codes.entrySet()) {
            System.out.println(objectStringEntry);
        }

    }

}
