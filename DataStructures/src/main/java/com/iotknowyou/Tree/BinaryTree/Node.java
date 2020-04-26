package com.iotknowyou.Tree.BinaryTree;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  构建二叉树节点
 * @updateRemark
 * @createDate 2020/4/26 8:52
 * @updateDate 2020/4/26 8:52
 **/
public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    // 构造器
    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }


    // 前序遍历的方法
    public void preOrder() {
        System.out.println(this); //先输出父结点
        //递归向左子树前序遍历
        if(this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {

        //递归向左子树中序遍历
        if(this.left != null) {
            this.left.infixOrder();
        }
        //输出父结点
        System.out.println(this);
        //递归向右子树中序遍历
        if(this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if(this.left != null) {
            this.left.postOrder();
        }
        if(this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }



    /**
     *  前序遍历查找
     * @param node
     * @return  找到节点返回这个节点，没有找到返回NULL
     */
    public Node<T> preOrderSearch(Node<T> node) {
        System.out.println("进入前序遍历");
        //比较当前结点是不是
        if(this.data == node.getData()) {
            return this;
        }
        //1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到结点，则返回
        Node<T> resNode = null;
        if(this.left != null) {
            // this.left 体现出 向左递归调用
            resNode = this.left.preOrderSearch(node);
        }
        if(resNode != null) {//说明我们左子树找到
            return resNode;
        }
        //1.左递归前序查找，找到结点，则返回，否继续判断，
        //2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if(this.right != null) {
            // this.right 体现出向右递归调用
            resNode = this.right.preOrderSearch(node);
        }
        return resNode;
    }


    /**
     * 中序遍历查找
     * @param node
     * @return 找到节点返回这个节点，没有找到返回NULL
     */
    public Node<T> infixOrderSearch(Node<T> node) {
        //判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
        Node<T> resNode = null;
        if(this.left != null) {
            // this.left 体现出 向左递归调用
            resNode = this.left.infixOrderSearch(node);
        }
        if(resNode != null) {
            return resNode;
        }
        System.out.println("进入中序查找");
        //如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
        if( this.data == node.getData() ) {
            return this;
        }
        //否则继续进行右递归的中序查找
        if(this.right != null) {
            // this.right 体现出向右递归调用
            resNode = this.right.infixOrderSearch(node);
        }
        return resNode;

    }


    /**
     *  后序遍历查找
     * @param node
     * @return 找到节点返回这个节点，没有找到返回NULL
     */
    public Node<T> postOrderSearch(Node<T> node) {

        //判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
        Node<T> resNode = null;
        if(this.left != null) {
            // this.left 体现出 向左递归调用
            resNode = this.left.postOrderSearch(node);
        }
        if(resNode != null) {//说明在左子树找到
            return resNode;
        }

        //如果左子树没有找到，则向右子树递归进行后序遍历查找
        if(this.right != null) {
            // this.right 体现出向右递归调用
            resNode = this.right.postOrderSearch(node);
        }
        if(resNode != null) {
            return resNode;
        }
        System.out.println("进入后序查找");
        //如果左右子树都没有找到，就比较当前结点是不是
        if( this.data == node.getData() ) {
            return this;
        }
        return resNode;
    }



    //递归删除结点
    //1.如果删除的节点是叶子节点，则删除该节点
    //2.如果删除的节点是非叶子节点，则删除该子树
    public void delNode(Node<T> node) {

        //思路
		/*
		 * 	1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
			2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
			3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
			4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
			5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.

		 */
        //2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        if(this.left != null && this.left.data == node.getData()) {
            this.left = null;
            return;
        }
        //3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if(this.right != null && this.right.data == node.getData()) {
            this.right = null;
            return;
        }
        //4.我们就需要向左子树进行递归删除
        if(this.left != null) {
            this.left.delNode(node);
        }
        //5.则应当向右子树进行递归删除
        if(this.right != null) {
            this.right.delNode(node);
        }
    }



    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
