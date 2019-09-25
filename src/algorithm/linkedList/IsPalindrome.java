package algorithm.linkedList;

import java.util.ArrayList;

/*
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false

示例 2:

输入: 1->2->2->1
输出: true

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

 */
public class IsPalindrome {
    public static void main(String[] args) {

    }
    /*
    思路一：list或数组来协助
    思考：不论怎么样，要比较大小，必须要要遍历
     */
    public static boolean solution(ListNode head){
        int size=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(null!=head){
            list.add(head.val);
            size++;
            head=head.next;
        }
        for(int i=0;i<size/2+1;i++){
            if(list.get(i)!=list.get(size-i)){
                return false;
            }
        }
        return true;
    }
/*
思路：双指针
 */
    public static boolean solution2(ListNode head){
        int size=0;
        ListNode fast=head;
        ListNode slow=null;
        while(null!=head){
            size++;
            head=head.next;
        }
        for(int i=0;i<size/2;i++){
            /*
            fast先到下一个站点，存tmp。之后用fast来反转方向。
            反转完，归还fast的新值。
             */
            ListNode tmp = fast.next;
            fast.next=slow;
            slow=fast;
            fast=tmp;
        }
        if((size&1)!=0) fast=fast.next;
        while(null!=fast){
            if(slow.val!=fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
}
