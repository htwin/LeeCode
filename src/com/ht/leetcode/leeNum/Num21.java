package com.ht.leetcode.leeNum;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Num21 {


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode preHead = new ListNode(-1);

        ListNode pre = preHead;
        while (l1!=null&&l2!=null){

            if(l1.val<=l2.val){

                pre.next = l1;
                l1 = l1.next;


            }else{
                pre.next = l2;
                l2 = l2.next;
            }

            pre = pre.next;

        }

        if(l1!=null){
            pre.next = l1;
        }
        if(l2!=null){
            pre.next = l2;
        }

        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(l1, l2);

        while (listNode != null) {
            System.out.print(listNode.val + "-");
            listNode = listNode.next;
        }
    }

}
