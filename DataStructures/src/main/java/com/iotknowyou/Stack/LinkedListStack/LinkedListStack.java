package com.iotknowyou.Stack.LinkedListStack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  使用单链表的方式实现 栈
 * @updateRemark
 * @createDate 2020/4/17 16:08
 * @updateDate 2020/4/17 16:08
 **/
public class LinkedListStack<E> implements Iterable<E>{

    // 定义栈顶节点
    private Node<E> firstNode;
    // 栈中的节点个数
    private int N;


    // 判断是否为空栈
    public boolean isEmpty(){
        return N==0;
    }

    // 栈中节点个数
    public int size(){
        return N;
    }

    // 入栈
    public void push(E item){
        Node<E> oldFirst = firstNode;
        firstNode = new Node<>();
        firstNode.next = oldFirst;
        firstNode.item = item;
        N++;
    }

    // 出栈
    public E pop(){
        E item = firstNode.item;
        firstNode = firstNode.next;
        N--;
        return item;
    }

    // 栈顶节点信息
    public E peek() {
        if (isEmpty()){
            throw new NoSuchElementException("Stack underflow");
        }
        return firstNode.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }


    /**
     * 自定义一个迭代器类实现hashNext和next方法，并将其作为LinkedListStack的内部类
     */
    private class ListIterator implements Iterator<E> {

        private Node<E> current = firstNode;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {}
    }

}
