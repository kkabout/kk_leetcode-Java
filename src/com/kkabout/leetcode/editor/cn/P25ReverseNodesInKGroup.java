
package com.kkabout.leetcode.editor.cn;

/**
 * //给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * //
 * // k 是一个正整数，它的值小于或等于链表的长度。
 * //
 * // 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 给你这个链表：1->2->3->4->5
 * //
 * // 当 k = 2 时，应当返回: 2->1->4->3->5
 * //
 * // 当 k = 3 时，应当返回: 3->2->1->4->5
 * //
 * //
 * //
 * // 说明：
 * //
 * //
 * // 你的算法只能使用常数的额外空间。
 * // 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * //
 * // Related Topics 链表
 **/
public class P25ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
    }
    /**
     * Solution
     */
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode preHead = new ListNode(0);
            preHead.next = head;
            ListNode pre = preHead;
            ListNode end = preHead;
            while (end.next != null) {
                //移动end
                for(int i = 0 ; i < k && end != null ; i++) {
                    end = end.next;
                }
                //如果剩余节点数不大于k 退出
                if (end == null) {
                    break;
                }
                //记录待翻转区域的开始节点
                ListNode start = pre.next;
                //记录待翻转区域的后继节点
                ListNode next = end.next;

                //截取待翻转区域
                end.next = null;

                //翻转待翻转区、拼接已翻转区域和待翻转区域
                pre.next = reverse(start);

                //拼接待翻转区域、已翻转区域、未翻转区域并移动待翻转区域
                start.next = next;
                pre = start;
                end = pre;
            }
            return preHead.next;
        }

        //leetcode 206 翻转链表
        public ListNode reverse(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}