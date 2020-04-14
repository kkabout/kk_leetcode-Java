
package com.kkabout.leetcode.editor.cn;
/**
 //给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

 **/
public class P24SwapNodesInPairs{
  public static void main(String[] args) {
       Solution solution = new P24SwapNodesInPairs().new Solution();
  }
  /**
  * Solution
  */

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        //遍历指针
        ListNode p = preHead;
        while (head != null && head.next != null) {
            //单数节点
            ListNode first = head;
            //双数节点
            ListNode second = head.next;

            //交换
            p.next = second;
            first.next = second.next;
            second.next = first;

            //移动指针
            p = first;

            head = first.next;
        }

        return preHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}