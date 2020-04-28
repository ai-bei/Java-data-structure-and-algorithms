package com.iotknowyou.HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  霍夫曼树的实现
 * @updateRemark
 * @createDate 2020/4/28 14:07
 * @updateDate 2020/4/28 14:07
 **/
public class HuffmanTree<E> {
    /**
     * 构建霍夫曼的基本思路：
     *  1、根据节点的权值，从小到大进行排序 。每个节点可以看成是一一颗最简单的二叉树
     *  2、取出根节点权值最小的两个节点，构成二叉树，该新的二叉树的根节点的权值是前面两颗二叉树根节点权值之和
     *  3、再将这颗新的二叉树，以根节点的权值大小 再次排序，不断重复
     *  4、重复 1-2-3 的操作，直到所有的数据都被处理得到一颗霍夫曼树
     */


    /**
     *  通过ArrayList创建对应的赫夫曼树
     * @param nodes
     * @return
     */
    public  Node<E> createHuffmanTree(ArrayList<Node<E>> nodes) {

        while(nodes.size() > 1) {
            //排序, 从小到大
            Collections.sort(nodes);
            //取出第一颗最小的二叉树
            Node<E> leftNode = nodes.get(0);
            //取出第二颗最小的二叉树
            Node<E> rightNode = nodes.get(1);
            //创建一颗新的二叉树,它的根节点 没有data, 只有权值
            Node<E> parent = new Node( leftNode.getValue() + rightNode.getValue() , null);
            parent.setLeft(leftNode);
            parent.setRight(rightNode);

            //将已经处理的两颗二叉树从nodes删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树，加入到nodes
            nodes.add(parent);

        }
        //nodes 最后的结点，就是赫夫曼树的根结点
        return nodes.get(0);

    }



    /**
     *  将 char 数组转成 Huffman 树
     * @param chars
     * @return
     */
    public Node<E> CharArrToHuffman(char[] chars){
        /*TODO 待改进 */
        //1创建一个ArrayList
        ArrayList<Node<E>> nodes = new ArrayList<>();

        //遍历 bytes , 统计 每一个byte出现的次数->map[key,value]
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : chars) {
            Integer count = counts.get(c);
            if (count == null) { // Map还没有这个字符数据,第一次
                counts.put(c, 1);
            } else {
                counts.put(c, count + 1);
            }
        }

        //把每一个键值对转成一个Node 对象，并加入到nodes集合
        //遍历map
        for(Map.Entry<Character, Integer> entry: counts.entrySet()) {
            nodes.add(new Node(entry.getValue() , entry.getKey() ));
        }

        // 创建霍夫曼树
        return  createHuffmanTree(nodes);
    }


    /**
     *  将 byte 数组转成 Huffman 树
     * @param bytes
     * @return
     */
    public Node<E> ByteArrToHuffman(byte[] bytes){
        /*TODO 待改进 */
        //1创建一个ArrayList
        ArrayList<Node<E>> nodes = new ArrayList<>();

        //遍历 bytes , 统计 每一个byte出现的次数->map[key,value]
        Map<Byte, Integer> counts = new HashMap<>();
        for (Byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) { // Map还没有这个字符数据,第一次
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //把每一个键值对转成一个Node 对象，并加入到nodes集合
        //遍历map
        for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {
            nodes.add(new Node(entry.getValue() , entry.getKey() ));
        }

        // 创建霍夫曼树
        return  createHuffmanTree(nodes);
    }

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //生成赫夫曼树对应的赫夫曼编码
    //思路:
    //1. 将赫夫曼编码表存放在 Map<Byte,String> 形式
    //   生成的赫夫曼编码表{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
     private Map<E, String> huffmanCodes = new HashMap<>();
    //2. 在生成赫夫曼编码表示，需要去拼接路径, 定义一个StringBuilder 存储某个叶子结点的路径
     private StringBuilder stringBuilder = new StringBuilder();

    /**
     * 功能：将传入的node结点的所有叶子结点的赫夫曼编码得到，并放入到huffmanCodes集合
     * @param node  传入结点
     * @param code  路径： 左子结点是 0, 右子结点 1
     * @param stringBuilder 用于拼接路径
     */
     private  void getCodes(Node<E> node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code 加入到 stringBuilder2
        stringBuilder2.append(code);
        if(node != null) { //如果node == null不处理
            //判断当前node 是叶子结点还是非叶子结点
            if(node.getData() == null) { //非叶子结点
                //递归处理
                //向左递归
                getCodes(node.getLeft(), "0", stringBuilder2);
                //向右递归
                getCodes(node.getRight(), "1", stringBuilder2);
            } else { //说明是一个叶子结点
                //就表示找到某个叶子结点的最后
                huffmanCodes.put(node.getData(), stringBuilder2.toString());
            }
        }
    }

    //为了调用方便，我们重载 getCodes
     private  Map<E, String> Codes(Node<E> root) {
        if(root == null) {
            return null;
        }
        //处理root的左子树
        getCodes(root.getLeft(), "0", stringBuilder);
        //处理root的右子树
        getCodes(root.getRight(), "1", stringBuilder);

        return huffmanCodes;
    }

    //对外暴露方法
    public Map<E, String> getCodes(Node<E> root){
          return Codes(root);
    }


// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    //前序遍历的方法
    public  void preOrder(Node root) {
        if(root != null) {
            root.preOrder();
        }else {
            System.out.println("赫夫曼树为空");
        }
    }


}
