package com.easy;

/**
 * 21. 合并两个有序链表
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class L21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }





    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode(0);
        ListNode cur =l3;
        while (l1!=null&&l2!=null)
        {
            if(l2.val>=l1.val)
            {
                cur.next = l1;
                cur=cur.next;
                l1=l1.next;
            }
            else
            {
                cur.next =l2;
                cur=cur.next;
                l2=l2.next;
            }


        }
        if (l1==null||l2==null) //有一个没处理完
        {
            if(l1==null)
                cur.next = l2;
            else
                cur.next =l1;
        }
        return l3.next;
    }



}
