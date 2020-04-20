
package com.kkabout.leetcode.editor.cn;

/**
 * //给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * //
 * // 示例 1:
 * //
 * // 输入: 1->2->3->4->5->NULL, k = 2
 * //输出: 4->5->1->2->3->NULL
 * //解释:
 * //向右旋转 1 步: 5->1->2->3->4->NULL
 * //向右旋转 2 步: 4->5->1->2->3->NULL
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: 0->1->2->NULL, k = 4
 * //输出: 2->0->1->NULL
 * //解释:
 * //向右旋转 1 步: 2->0->1->NULL
 * //向右旋转 2 步: 1->2->0->NULL
 * //向右旋转 3 步: 0->1->2->NULL
 * //向右旋转 4 步: 2->0->1->NULL
 * // Related Topics 链表 双指针
 **/
public class P61RotateList {
    public static void main(String[] args) {
        Solution solution = new P61RotateList().new Solution();
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
        //把末尾x个节点调换到开头 注意边界条件判断
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0 || head.next == null) {
                return head;
            }
            int len = 0;
            ListNode preHead = new ListNode(0);
            preHead.next = head;
            while (head != null) {
                head = head.next;
                len++;
            }
            int x = k % len;

            if (x == 0) {
                return preHead.next;
            }

            //双指针定位x到末尾的节点
            ListNode preStart = preHead , end = preHead;
            for (int i = 0; i < len; i++) {
                end = end.next;
                if (i >= x) {
                    preStart = preStart.next;
                }
            }

            //将x到末尾的节点拼接到头部
            ListNode newHead = preStart.next;
            preStart.next = null;
            end.next = preHead.next;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}