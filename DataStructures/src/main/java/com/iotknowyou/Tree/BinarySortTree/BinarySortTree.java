package com.iotknowyou.Tree.BinarySortTree;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 **/
public class BinarySortTree {
    // 创建头节点
    private Node root = null;

    /**
     * 添加一个节点
     * @param node
     */
    public void addNode(Node node){
        if(root == null) {
            root = node;//如果root为空则直接让root指向node
        } else {
            root.addNode(node);
        }
    }

    //查找要删除的结点
    public Node search(Node node) {
        if(root == null) {
            return null;
        } else {
            return root.search(node);
        }
    }

    //查找父结点
    public Node searchParent(Node node) {
        if(root == null) {
            return null;
        } else {
            return root.searchParent(node);
        }
    }

    //编写方法:
    //1. 返回的 以node 为根结点的二叉排序树的最小结点的值
    //2. 删除node 为根结点的二叉排序树的最小结点
    /**
     *
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public Node delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点，就会找到最小值
        while(target.getLeft() != null) {
            target = target.getLeft();
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delNode(target);
        return target;
    }

    //删除结点
    public void delNode(Node node) {
        if(root == null) {
            return;
        }else {
            //1.需求先去找到要删除的结点  targetNode
            Node targetNode = search(node);
            //如果没有找到要删除的结点
            if(targetNode == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if(root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }

            //去找到targetNode的父结点
            Node parent = searchParent(node);
            //如果要删除的结点是叶子结点
            if(targetNode.getLeft() == null && targetNode.getRight() == null) {
                //判断targetNode 是父结点的左子结点，还是右子结点
                if(parent.getLeft() != null && parent.getLeft().getData().equals(node.getData()) ) { //是左子结点
                    parent.setLeft( null );
                } else if (parent.getRight() != null && parent.getRight().getData().equals(node.getData())) {//是由子结点
                    parent.setRight( null );
                }
            } else if (targetNode.getLeft() != null && targetNode.getRight() != null) { //删除有两颗子树的节点
                /* TODO  删除有两颗子树的节点*/
                Node minValNode = delRightTreeMin(targetNode.getRight());
                targetNode.setData(minValNode.getData());


            } else { // 删除只有一颗子树的结点
                //如果要删除的结点有左子结点
                if(targetNode.getLeft() != null) {
                    if(parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if(parent.getLeft().getData().equals(node.getData()) ) {
                            parent.setLeft(targetNode.getLeft()) ;
                        } else { //  targetNode 是 parent 的右子结点
                            parent.setRight(targetNode.getLeft());
                        }
                    } else {
                        root = targetNode.getLeft();
                    }
                } else { //如果要删除的结点有右子结点
                    if(parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if(parent.getLeft().getData().equals(node.getData()) ) {
                            parent.setLeft(targetNode.getRight());
                        } else { //如果 targetNode 是 parent 的右子结点
                            parent.setRight(targetNode.getRight());
                        }
                    } else {
                        root = targetNode.getRight();
                    }
                }

            }

        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if(root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }





}
