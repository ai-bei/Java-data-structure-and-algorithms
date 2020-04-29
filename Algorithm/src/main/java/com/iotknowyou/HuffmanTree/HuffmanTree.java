package com.iotknowyou.HuffmanTree;

import java.util.*;

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
    private Node<E> ToHuffman(char[] chars){
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
    private Node<E> ToHuffman(byte[] bytes){
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

    public Node<E> ArrToHuffman(char[] chars){
        return ToHuffman(chars);
    }

    public Node<E> ArrToHuffman(byte[] chars){
        return ToHuffman(chars);
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

    //对外暴露方法 , 为了测试使用
    public Map<E, String> getCodes(Node<E> root){
          return Codes(root);
    }


// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * 将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]
     * @param bytes  原始的字符串对应的 byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的 byte[]
     */


    private  char[] zip(char[] bytes, Map<E, String> huffmanCodes) {

        //1.利用 huffmanCodes 将  bytes 转成  赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes 数组 ， 对原始的信息，进行 赫夫曼编码
        for(char b: bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        //统计返回  byte[] huffmanCodeBytes 长度
        //一句话 int len = (stringBuilder.length() + 7) / 8;
        int len;
        if(stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建 存储压缩后的 byte数组
        char[] huffmanCodeBytes = new char[len];
        int index = 0;//记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) { //因为是每8位对应一个byte,所以步长 +8
            String strByte;
            if(i+8 > stringBuilder.length()) {//不够8位
                strByte = stringBuilder.substring(i);
            }else{
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte 转成一个byte,放入到 huffmanCodeBytes
            huffmanCodeBytes[index] = (char) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }
    /* TODO  */
    private static   int zeroCount = 0 ;

    private  byte[] zip(byte[] bytes, Map<E, String> huffmanCodes) {

        //1.利用 huffmanCodes 将  bytes 转成  赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes 数组
        for(byte b: bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        //统计返回  byte[] huffmanCodeBytes 长度
        //一句话 int len = (stringBuilder.length() + 7) / 8;
        int len;


        if(stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建 存储压缩后的 byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录是第几个byte

        for (int i = 0; i < stringBuilder.length(); i += 8) { //因为是每8位对应一个byte,所以步长 +8
            String strByte;
            if(i+8 > stringBuilder.length()) {//不够8位
                strByte = stringBuilder.substring(i);
                /*TODO  */
                // 如果最后一次是00110010、0110等情况，需要记录前面有多少个0
                for (int j = 0; j < strByte.length(); j++) {
                    if (strByte.length() == 1) {
                        break;
                    }
                    if (strByte.charAt(j) == '0') {
                        zeroCount++;
                    } else {
                        break;
                    }
                }
            }else{
                strByte = stringBuilder.substring(i, i + 8);

            }
            //将strByte 转成一个byte,放入到 huffmanCodeBytes
            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    /**
     * 对外暴露接口
     * 将字符串对应的char[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]
     * @param bytes
     * @return
     */
    public char[] HuffmanZip(char[] bytes){
        //创建的赫夫曼树
        Node<E> huffmanroot = ArrToHuffman(bytes);
        //对应的赫夫曼编码表  (根据 赫夫曼树)
        Map<E, String> huffmanCodes = getCodes(huffmanroot);
        //根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        return zip(bytes ,huffmanCodes );
    }
    public char[] HuffmanZip(char[] bytes ,Map<E, String> huffmanCodes ){
        //根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        return zip(bytes ,huffmanCodes);
    }


    /**
     * 对外暴露接口
     * 将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]
     * @param bytes
     * @return
     */
    public byte[] HuffmanZip(byte[] bytes ){
        //创建的赫夫曼树
        Node<E> huffmanroot = ArrToHuffman(bytes);
        //对应的赫夫曼编码(根据 赫夫曼树)
        Map<E, String> huffmanCodes = getCodes(huffmanroot);
        //根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        return zip(bytes ,huffmanCodes );
    }
    public byte[] HuffmanZip(byte[] bytes ,Map<E, String> huffmanCodes ){
        //根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        return zip(bytes ,huffmanCodes);
    }


// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // 编写 霍夫曼编码数据进行解码


    /**
     * 将一个byte 转成一个二进制的字符串
     * @param b 传入的 byte
     * @param flag 标志是否需要补高位如果是true ，表示需要补高位，如果是false表示不补, 如果是最后一个字节，无需补高位
     * @return 是该b 对应的二进制的字符串，（注意是按补码返回）
     */
    private static String byteToBitString(boolean flag, byte b) {
        //使用变量保存 b
        int temp = b; //将 b 转成 int
        //如果是正数我们还存在补高位
        if(flag) {
            temp |= 256; //按位与 256  1 0000 0000  | 0000 0001 => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp); //返回的是temp对应的二进制的补码
        if(flag) {
            return str.substring(str.length() - 8);
        } else {

            if (str.length() > 8) {
                return str.substring(str.length() - 8);
            }
            for (int i = 0; i < zeroCount; i++) {
                str = "0" + str;
            }
            return str ;


        }
    }

    //编写一个方法，完成对压缩数据的解码
    /**
     *
     * @param huffmanCodes 赫夫曼编码表 map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    private  byte[] decode(Map<Byte,String> huffmanCodes, byte[] huffmanBytes) {

        //1. 先得到 huffmanBytes 对应的 二进制的字符串 ， 形式 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for(int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        //把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        Map<String, Byte>  map = new HashMap<String,Byte>();
        for(Map.Entry<Byte, String> entry: huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        //创建要给集合，存放byte
        List<Byte> list = new ArrayList<>();
        //i 可以理解成就是索引,扫描 stringBuilder
        for(int  i = 0; i < stringBuilder.length(); ) {

            /* TODO 存在一定的问题 */

            int count = 1; // 小的计数器
            boolean flag = true;
            Byte b = null;

            while(flag) {
                //1010100010111...
                //递增的取出 key 1
                String key = stringBuilder.substring(i, i+count);//i 不动，让count移动，指定匹配到一个字符
                b = map.get(key);
                if(b == null) {//说明没有匹配到
                    count++;
                }else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;//i 直接移动到 count
        }
        //当for循环结束后，我们list中就存放了所有的字符  "i like like like java do you like a java"
        //把list 中的数据放入到byte[] 并返回
        byte b[] = new byte[list.size()];
        for(int i = 0;i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;

    }


    /**
     * 对压缩编码的数据进行解码
     * @param huffmanCodes
     * @param huffmanBytes
     * @return
     */
    public byte[] getSourceData(Map<Byte,String> huffmanCodes, byte[] huffmanBytes){
        return decode(huffmanCodes,huffmanBytes);
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


    /**
     * 获取霍夫曼编码表
     * @return
     */
    public Map<E, String> getHuffmanCodes() {
        return huffmanCodes;
    }
}
