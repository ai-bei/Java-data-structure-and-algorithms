package com.iotknowyou.LinkedList.CircleSingleLinkedList;

import org.junit.Test;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/16 13:17
 * @updateDate 2020/4/16 13:17
 **/
public class CircleSingleLinkedListTest {

    @Test
    public void test(){
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList<User>();
        circleSingleLinkedList.addNode(125);
        circleSingleLinkedList.showList();
        circleSingleLinkedList.countNodeOutIndex(1,2,125);
    }
}
