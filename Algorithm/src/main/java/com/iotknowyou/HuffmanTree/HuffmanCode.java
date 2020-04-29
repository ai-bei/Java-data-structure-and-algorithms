package com.iotknowyou.HuffmanTree;

import org.junit.Test;

import java.util.Arrays;
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
        Node<Object> root = huffmanTree.ArrToHuffman(bytes);
        huffmanTree.preOrder(root);

        System.out.println("----------------------------------");

        // char[] chars = {'l','i','k','e'};
        String st = "I Like Java !";
        char[] chars = st.toCharArray();

        Node<Object> huffmanroot = huffmanTree.ArrToHuffman(chars);
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
        Node<Object> huffmanroot = huffmanTree.ArrToHuffman(chars);
        huffmanTree.preOrder(huffmanroot);
        // 生成 霍夫曼树的编码
        Map<Object, String> codes = huffmanTree.getCodes(huffmanroot);
        // 遍历 map
        for (Map.Entry<Object, String> objectStringEntry : codes.entrySet()) {
            System.out.println(objectStringEntry);
        }

    }


    /**
     * 测试：
     *    1、生成霍夫曼编码表
     *    2、使用霍夫曼编码表进行 信息编码
     */
    @Test
    public void test3(){
        String st = "I Like Java !";
        char[] chars = st.toCharArray();
        HuffmanTree<Object> huffmanTree = new HuffmanTree<>();
        // 构建 霍夫曼树
        Node<Object> huffmanroot = huffmanTree.ArrToHuffman(chars);
        huffmanTree.preOrder(huffmanroot);
        // 生成 霍夫曼树的编码
        Map<Object, String> codes = huffmanTree.getCodes(huffmanroot);
        // 遍历 map
        for (Map.Entry<Object, String> objectStringEntry : codes.entrySet()) {
            System.out.println(objectStringEntry);
        }
        System.out.println("-----");
        // 使用 霍夫曼编码表 对 信息进行编码 ，
        // 编码完成后，返回 编码后的 char[] 数组
        char[] chars1 = huffmanTree.HuffmanZip(chars);
        System.out.println();
    }

    /**
     * 测试：
     *    1、生成霍夫曼编码表
     *    2、使用霍夫曼编码表进行 信息编码
     */
    @Test
    public void test4(){
        String st = "I Like Java !";
        byte[] bytes = st.getBytes();
        HuffmanTree<Object> huffmanTree = new HuffmanTree<>();
        // 构建 霍夫曼树
        Node<Object> huffmanroot = huffmanTree.ArrToHuffman(bytes);
        huffmanTree.preOrder(huffmanroot);
        // 生成 霍夫曼树的编码
        Map<Object, String> codes = huffmanTree.getCodes(huffmanroot);
        // 遍历 map
        for (Map.Entry<Object, String> objectStringEntry : codes.entrySet()) {
            System.out.println(objectStringEntry);
        }
        System.out.println("-----");
        // 使用 霍夫曼编码表 对 信息进行编码 ，
        // 编码完成后，返回 编码后的 char[] 数组
        byte[] bytes1 = huffmanTree.HuffmanZip(bytes);
        System.out.println();

    }

    @Test
    public void test5(){
        String content = "i like like like java do you like a java";
        // 使用 霍夫曼编码表 对 信息进行编码 ，
        // 编码完成后，返回 编码后的 char[] 数组
        HuffmanTree<Object> huffmanTree = new HuffmanTree<>();
        byte[] bytes1 = huffmanTree.HuffmanZip(content.getBytes());
        System.out.println();
    }

    @Test
    public void test6(){
        String content = "li";
        HuffmanTree<Byte> huffmanTree = new HuffmanTree<>();
        // 构建 霍夫曼树
        Node<Byte> huffmanroot = huffmanTree.ArrToHuffman(content.getBytes());
        huffmanTree.preOrder(huffmanroot);
        // 生成 霍夫曼树的编码表
        Map<Byte, String> codes = huffmanTree.getCodes(huffmanroot);
        // 使用 霍夫曼编码表，对信息进行编码,得到编码后的 数组
        byte[] bytes = huffmanTree.HuffmanZip(content.getBytes(), codes);
        System.out.println("编码后的信息：" + Arrays.toString(bytes));

        // 使用 霍夫曼编码表 ，对信息进行解编码，得到原始的信息
        byte[] sourceData = huffmanTree.getSourceData(codes, bytes);
        System.out.println("解编码后的信息：" + new String(sourceData));

    }

    /**
     *  文件的解码和编码的测试
     *   1、如果文件本身已经进行压缩处理，那么使用赫夫曼编码再进行压缩，效率不会有很明显的变化
     *   2、赫夫曼编码是按字节来处理的，因此可以处理所有的文件
     *   3、如果一个文件中的内容，重复的数据不多，压缩效果也不会很明显
     */
    @Test
    public void test7(){
        ZipFile zipFile = new ZipFile();
        zipFile.zipFile(
                "E:\\IDEA_Code\\Exercise_Code\\Java-data-structure-and-algorithms\\files\\huffmanTest\\girl.png",
                "E:\\IDEA_Code\\Exercise_Code\\Java-data-structure-and-algorithms\\files\\huffmanTest\\girl.zip");
        System.out.println("压缩成功 ！");
        zipFile.unZipFile(
                "E:\\IDEA_Code\\Exercise_Code\\Java-data-structure-and-algorithms\\files\\huffmanTest\\girl.zip",
                "E:\\IDEA_Code\\Exercise_Code\\Java-data-structure-and-algorithms\\files\\huffmanTest\\girl.png");
        System.out.println("解压缩成功 ！");
    }

    
}
