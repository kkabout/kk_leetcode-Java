
package com.kkabout.leetcode.editor.cn;

/**
 * //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * //
 * // 示例：
 * //
 * // 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * //
 * //当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * //
 * //
 * // 说明：
 * //
 * // 给定的 n 保证是有效的。
 * //
 * // 进阶：
 * //
 * // 你能尝试使用一趟扫描实现吗？
 * // Related Topics 链表 双指针
 **/
public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
    }

    /**
     * Solution
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode preHead = new ListNode(0);
            preHead.next = head;
            ListNode pn = preHead;
            ListNode p = preHead;
            for (int i = 0 ; i < n + 1 ; i++) {
                if (pn == null) {
                    return preHead.next;
                }
                pn = pn.next;
            }
            while (pn != null) {
                pn = pn.next;
                p = p.next;
            }

            p.next = p.next.next;
            return preHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}