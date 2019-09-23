package algorithm.linkedList;
/*
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 */
public class ReverseList {
    public static void main(String[] args) {

    }
    /*
    思路一：双指针迭代
    执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
    内存消耗 :36.6 MB, 在所有 Java 提交中击败了55.24%的用户
     */
    public static ListNode solution(ListNode head){
        if(null==head) return null;
        if(null==head.next) return head;
        //fast从第二个开始
        ListNode fast=head.next;
        ListNode slow=head;
        while(null!=fast){
            ListNode tmp=fast.next;
            fast.next=slow;
            slow=fast;
            fast=tmp;
        }
        head.next=null;
        return fast;
    }
    /*
    思路二，一次遍历一个节点。超时了！
    思想和官方的迭代类似的，但是我写的丑陋
     */
    public static ListNode solution2(ListNode head){
        if(null==head) return null;
        if(null==head.next) return head;
        ListNode cursor=head;
        ListNode newhead=getNewHead(cursor);
        while(head!=newhead){
            newhead=getNewHead(cursor);
            cursor=head;
        }
        return newhead;
    }
    public static ListNode getNewHead(ListNode cursor){
        ListNode newhead=null;
        while(null!=cursor.next.next){
            newhead=cursor.next;
            newhead.next=cursor;
            cursor=cursor.next;
        }
        cursor=null;
        return newhead;
    }
    /*
    官方迭代
     */
    public ListNode solution3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = solution3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
