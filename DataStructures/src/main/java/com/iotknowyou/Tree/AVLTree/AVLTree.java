package com.iotknowyou.Tree.AVLTree;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 **/
public class AVLTree<T extends Comparable<T>> {

    /** TODO  对树进行 平衡操作时，存在问题。   */
    /**
     * 根结点
     */
    private AVLTreeNode<T>   mRoot;

    /*
     * 获取树的高度
     */
    private int height(AVLTreeNode<T> tree) {
        if (tree != null)
            return tree.height;

        return 0;
    }

    public int height() {
        return height(mRoot);
    }

    /*
     * LL：左左对应的情况(左单旋转)。
     *
     * 返回值：旋转后的根节点
     */

    /**
     * LL：左左对应的情况(左单旋转)。
     *
     * @param k2
     * @return 旋转后的根节点
     */
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2) {
        AVLTreeNode<T> k1;

        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;

        return k1;
    }

    /**
     * 右右对应的情况(右单旋转)。
     *
     * @param k1
     * @return 旋转后的根节点
     */
    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> k1) {
        AVLTreeNode<T> k2;

        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;

        return k2;
    }


    /**
     * LR：左右对应的情况(左双旋转)。
     *
     * @param k3
     * @return 旋转后的根节点
     */
    private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> k3) {
        k3.left = rightRightRotation(k3.left);

        return leftLeftRotation(k3);
    }

    /**
     * RL：右左对应的情况(右双旋转)。
     *
     * @param k1
     * @return 旋转后的根节点
     */
    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k1) {
        k1.right = leftLeftRotation(k1.right);

        return rightRightRotation(k1);
    }


    public void insert(T key) {
        mRoot = insert(mRoot, key);
    }

    /**
     * 将结点插入到AVL树中，并返回根节点
     *
     * @param tree AVL树的根结点
     * @param key  插入的结点的键值
     * @return 根节点
     */
    private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
        if (tree == null) {
            // 新建节点
            return tree = new AVLTreeNode<T>(key, null, null);

        }

        int cmp = key.compareTo(tree.element);
        if (cmp < 0) {// 将key插入到"tree的左子树"的情况
            tree.left = insert(tree.left, key);

        } else if (cmp > 0) { // 将key插入到"tree的右子树"的情况
            tree.right = insert(tree.right, key);
        }

//        return tree;
        return balance(tree);
    }


    private static final int ALLOWED_IMBALANCE = 1;

    private AVLTreeNode<T> balance(AVLTreeNode<T> tree) {
        if (tree == null) {
            return tree;
        }
        // 插入节点后，若AVL树失去平衡，则进行相应的调节。
        if (height(tree.left) - height(tree.right) > ALLOWED_IMBALANCE) {

            if (height(tree.left.left) >= height(tree.left.right)) {
                leftLeftRotation(tree);
            } else {
                leftRightRotation(tree);
            }
        } else if (height(tree.right) - height(tree.left) > ALLOWED_IMBALANCE) {
            if (height(tree.right.right) >= height(tree.right.left)) {
                rightRightRotation(tree);
            } else {
                rightLeftRotation(tree);
            }
        }
        tree.height = Math.max(height(tree.left), height(tree.right)) + 1;

        return tree;
    }

    public void remove(T key) {
        AVLTreeNode<T> z;

        if ((z = search(mRoot, key)) != null)
            mRoot = remove(mRoot, z);
    }

    /*
     * (递归实现)查找"AVL树x"中键值为key的节点
     */
    private AVLTreeNode<T> search(AVLTreeNode<T> x, T key) {
        if (x == null)
            return x;

        int cmp = key.compareTo(x.element);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public AVLTreeNode<T> search(T key) {
        return search(mRoot, key);
    }

    /**
     * 删除结点(z)，返回根节点
     *
     * @param tree AVL树的根结点
     * @param z    待删除的结点
     * @return 根节点
     */
    private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> z) {
        if (tree == null)
            return tree;

        int cmp = z.element.compareTo(tree.element);
        if (cmp > 0) {
            tree.right = remove(tree.right, z);
        } else if (cmp < 0) {
            tree.left = remove(tree.left, z);
        } else if (tree.left != null && tree.right != null) {
            tree.element = findMin(tree.right).element;
            tree.right = remove(tree.element, tree.right);
        } else {
            tree = (tree.left != null) ? tree.left : tree.right;
        }
        return balance(tree);
    }

    private AVLTreeNode<T> findMin(AVLTreeNode<T> node) {
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    public AVLTreeNode<T> remove(T t, AVLTreeNode<T> node) {
        if (node == null) {
            return node;
        }
        int compareResult = t.compareTo(node.element);
        if (compareResult > 0) {
            node.right = remove(t, node.right);
        } else if (compareResult < 0) {
            node.left = remove(t, node.left);
        } else if (node.left != null && node.right != null) {
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;

    }

    /**
     * 打印"二叉查找树"
     *
     * @param key        -- 节点的键值
     * @param direction  --  0，表示该节点是根节点;
     *                      -1，表示该节点是它的父结点的左孩子;
     *                      1，表示该节点是它的父结点的右孩子。
     */
    private void print(AVLTreeNode<T> tree, T key, int direction) {
        if(tree != null) {
            if(direction==0)    // tree是根节点
                System.out.printf("%2d is root\n", tree.element, key);
            else                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.element, key, direction==1?"right" : "left");

            print(tree.left, tree.element, -1);
            print(tree.right,tree.element,  1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.element, 0);
    }

    //前序遍历
    public void preOrder() {
        if(this.mRoot != null) {
            this.mRoot.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if(this.mRoot != null) {
            this.mRoot.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder() {
        if(this.mRoot != null) {
            this.mRoot.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

}
