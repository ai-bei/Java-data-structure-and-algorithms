package com.iotknowyou.Tree.ThreadedBinaryTree;

/**
 * @author LiuRongHua
 * @updateUser
 * @description   索引化功能的二叉树
 * @updateRemark
 * @createDate 2020/4/27 9:49
 * @updateDate 2020/4/27 9:49
 **/
public class ThreadedBinaryTree<E> {

/**
    1.   前序线索化二叉树遍历相对最容易理解，实现起来也比较简单。
         由于前序遍历的顺序是：根左右，所以从根节点开始，沿着左子树进行处理，当子节点的left指针类型是线索时，
         说明到了最左子节点，然后处理子节点的right指针指向的节点，可能是右子树，也可能是后继节点，
         无论是哪种类型继续按照上面的方式（先沿着左子树处理，找到子树的最左子节点，然后处理right指针指向），
         以此类推，直到节点的right指针为空，说明是最后一个，遍历完成。
    2.   中序线索化二叉树的网上相关介绍最多。中序遍历的顺序是：左根右，
         因此第一个节点一定是最左子节点，先找到最左子节点，依次沿着right指针指向进行
         处理（无论是指向子节点还是指向后继节点），直到节点的right指针为空，说明是最后一个，遍历完成。
    3.  后序遍历线索化二叉树最为复杂，通用的二叉树数节点存储结构不能够满足后序线索化，
         因此我们扩展了节点的数据结构，【增加了父节点的指针】。
         后序的遍历顺序是：左右根，先找到最左子节点，沿着right后继指针处理，
         当right不是后继指针时，并且上一个处理节点是当前节点的右节点，
         则处理当前节点的右子树，遍历终止条件是：当前节点是root节点，
         并且上一个处理的节点是root的right节点。
 */




    // 创建根节点
    private Node<E> root;


    // 初始化
    public ThreadedBinaryTree() {
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }



    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre 总是保留前一个结点
    private Node<E> pre = null;

    //重载一把threadedNodes方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }

//    ---------------------------------中序线索化的方法----------------------------------------
    //遍历线索化二叉树的方法   中序线索化的方法
    public void threadedList() {
        //定义一个变量，存储当前遍历的结点，从root开始
        Node<E> node = root;
        while(node != null) {
            //循环的找到leftType == 1的结点，第一个找到就是8结点
            //后面随着遍历而变化,因为当leftType==1时，说明该结点是按照线索化
            //处理后的有效结点
            while(node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //打印当前这个结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点,就一直输出
            while(node.getRightType() == 1) {
                //获取到当前结点的后继结点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = node.getRight();

        }
    }

    //编写对二叉树进行中序线索化的方法
    /**
     *
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNodes(Node<E> node) {

        //如果node==null, 不能线索化
        if(node == null) {
            return;
        }

        //(一)先线索化左子树
        threadedNodes(node.getLeft());
        //(二)线索化当前结点[有难度]

        //处理当前结点的前驱结点
        //以8结点来理解
        //8结点的.left = null , 8结点的.leftType = 1
        if(node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }

        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        //(三)在线索化右子树
        threadedNodes(node.getRight());


    }


//    ----------------------------------前序线索化的方法--------------------------------------

    public void threadedNodesByPreOrder(){
        this.threadedNodesByPreOrder(root);
    }

    //编写对二叉树进行前序线索化的方法
    /**
     *
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNodesByPreOrder(Node<E> node) {
        //如果node==null, 不能线索化
        if(node == null) {
            return;
        }

        // 第一步

        //线索化左子树
        if(node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }

        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        //线索化左子树
        // 判断当前节点的 LeftType == 1 ，如果已经线索化，就不需要线索化了
        if(node.getLeftType()!= 1){
            threadedNodesByPreOrder(node.getLeft());
        }

        //线索化右子树
        // 判断当前节点的 RightType == 1 ，如果已经线索化，就不需要线索化了
        if(node.getRightType() != 1){
            threadedNodesByPreOrder(node.getRight());
        }

    }


    /**
     * 前序线索化二叉树的遍历
     */
    public void threadedNodesByPreOrderList(){
        Node<E> temp = root;
        while(temp != null) {
            System.out.println(temp.getData());
            //如果存在左子节点就往左走，否则往右走，此时右指针一定是前序遍历的下一个节点
            if(temp.getLeftType() != 1) {
                temp = temp.getLeft();
            }else {
                temp = temp.getRight();
            }
        }
    }

//    -----------------------------------后序线索化的方法--------------------------------------

    public void threadedNodesByPostOrder(){
        this.threadedNodesByPostOrder(root);
    }

    //编写 二叉树 后序线索化的方法
    /**
     *
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNodesByPostOrder(Node<E> node) {
        //如果node==null, 不能线索化
        if(node == null) {
            return;
        }

        //递归线索化左子树
        threadedNodesByPostOrder(node.getLeft());


        //递归线索化右子树
        threadedNodesByPostOrder(node.getRight());


        //线索化左子树
        if(node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }

        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;


    }


    /**
     *  后序线索化  二叉树的遍历
     */
    public void threadedNodesByPostOrderList(){
        //1、找后序遍历方式开始的节点
        Node<E> node = root;
        while(node != null && node.getLeftType()!= 1) {
            node = node.getLeft();
        }

        Node preNode = null;
        while(node != null) {
            //右节点是线索
            if(node.getRightType() == 1) {
                System.out.println(node.getData());
                preNode = node;
                node = node.getRight();

            } else {
                //如果上个处理的节点是当前节点的右节点
                if(node.getRight() == preNode) {
                    System.out.println(node.getData());
                    if(node == root) {
                        return;
                    }

                    preNode = node;
                    node = node.getParent();

                } else {    //如果从左节点的进入则找到有子树的最左节点
                    node = node.getRight();
                    while(node != null && node.getLeftType()!= 1) {
                        node = node.getLeft();
                    }
                }
            }
        }
    }

}
