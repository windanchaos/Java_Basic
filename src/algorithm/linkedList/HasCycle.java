package algorithm.linkedList;

import java.util.HashMap;
import java.util.HashSet;

/*

给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

题意要看图
 https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/46/
 */
public class HasCycle {
    public static void main(String[] args) {

    }
    /*
    用hashmap，可以甚至可以直接返回索引。
    执行用时 :6 ms, 在所有 Java 提交中击败了25.67% 的用户
    内存消耗 :38 MB, 在所有 Java 提交中击败了95.43%的用户
     */
    public static boolean solution(ListNode head){
        if(null==head||null==head.next) return false;
        HashSet<ListNode> set=new HashSet<>();
        //记录索引
        int i=-1;
        while(null!=head.next && !set.contains(head)){
            i++;
            set.add(head);
            head=head.next;
        }
        if(set.contains(head)) return true;
        else return false;
    }
    /*
    龟兔赛跑原理，快的总会追上慢的。。我很奇怪这种算法竟然更快。
    hash在加数据的时候，会计算hash值，然后检查是否有这个hash值了。大概是消耗在这里。
    执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
    内存消耗 :37.5 MB, 在所有 Java 提交中击败了96.86%的用户
     */
    public static boolean solution2(ListNode head){
        if(null==head||null==head.next) return false;
        ListNode fast=head.next;
        ListNode slow=head;
        while(slow!=fast){
            //判定空的顺序对结果有影响，判断句中有先后关系，这里fast.next依赖fast不为空，需要fast在前。
            if(null==fast||null==fast.next) return false;
            fast=fast.next;
            if(fast==slow) return true;
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    }
    /*
    官方
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
