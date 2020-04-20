
package com.kkabout.leetcode.editor.cn;

/**
 * //反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * //
 * // 说明:
 * //1 ≤ m ≤ n ≤ 链表长度。
 * //
 * // 示例:
 * //
 * // 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * //输出: 1->4->3->2->5->NULL
 * // Related Topics 链表
 **/
public class P92ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
            public ListNode reverseBetween(ListNode head, int m, int n) {
                ListNode preHead = new ListNode(0);
                preHead.next = head;

                ListNode preStart = preHead, nextEnd = preHead;
                //移动指针
                for (int i = 0 ; i <= n; i++) {
                    if (i < m - 1) {
                        preStart = preStart.next;
                    }
                    if (i < n + 1) {
                        nextEnd = nextEnd.next;
                    }
                }

                //记录起始位置 翻转后起始位置变为末尾 用于链接后续节点
                ListNode start = preStart.next;

                //翻转待翻转区域
                ListNode pre = preStart.next;
                ListNode cur = pre.next;
                while (cur != nextEnd) {
                    ListNode next =  cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }

                //链接前后节点
                preStart.next = pre;
                start.next = nextEnd;

                return preHead.next;
            }

        }
//leetcode submit region end(Prohibit modification and deletion)

    }