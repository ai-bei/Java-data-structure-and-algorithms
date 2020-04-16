package com.iotknowyou;

public class merge_two_sorted_lists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 当l1或者l2为空时，或者都为空时
        if(l1 == null && l2 == null){
            return null;
        }

        if(l1 == null && l2 != null){
            return l2;
        }

        if(l2 == null && l1 != null){
            return l1;
        }
        // 定义一个哨兵节点 ，头结点
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        // l1中的Node 和 l2中的Node 进行比较
        // 将值较小的 赋值给 prev.next
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            // prev 往后移动
            prev = prev.next;
        }

        // 链表为有序的，没有比较的直接拼接在后面
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }



    public static void main(String[] args) {

    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}