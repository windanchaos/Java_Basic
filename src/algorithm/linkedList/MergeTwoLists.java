package algorithm.linkedList;
/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/
 */
public class MergeTwoLists {
    public static void main(String[] args) {

    }
    public static ListNode solution(ListNode l1, ListNode l2){
        if(null==l1) return l2;
        if(null==l2) return l1;
        ListNode pre=new ListNode(Integer.MIN_VALUE);
        ListNode head=pre;
        while (null!=l1.next || null!=l2.next){
            if(l1.val<l2.val){
                pre.next=l1;
                l1=l1.next;
                pre=pre.next;
            }else {
                pre.next=l2;
                l2=l2.next;
                pre=pre.next;
            }
        }
        pre.next=l1!=null?l1:l2;
        return head.next;
    }
    /*
    官方
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
