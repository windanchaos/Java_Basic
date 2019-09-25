package algorithm.linkedList;

import java.util.ArrayList;

/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {
    /*
    好程序，要考虑边界
    已经战胜 99.26 % 的 java 提交记录
     */
    public static ListNode Solution(ListNode head, int n){
        ListNode pointer=head;
        ArrayList<ListNode> list=new ArrayList<>();
        if(n==0) return head;
        if(null==pointer || null==pointer.next) return null;
        while(null!=pointer){
            list.add(pointer);
            pointer=pointer.next;
        }
        if(n==list.size()) return head=head.next;
        if(n==1) list.get(list.size()-2).next=null;
        else list.get(list.size()-n-1).next=list.get(list.size()-n+1);
        return head;
    }
    /*
    学习先进的双指针
    执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗 :34.8 MB, 在所有 Java 提交中击败了86.85%的用户
     */
    public static ListNode Solution2(ListNode head, int n){
        ListNode fast=head;
        ListNode slow=head;
        while(n>0 && null!=fast){
            fast=fast.next;
            n--;
        }
        //fast到达最后一位后，它的next如果指向了null，即删除的是头指针。
        if(null==fast) return head.next;
        //继续遍历，用fast.next作界限，达到最后一位。是需要处理指针的位置。
        while(null!=fast.next){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
