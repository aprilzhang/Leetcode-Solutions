/**
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,0);
    }
    
    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry)
    {
        if(l1==null&&l2==null)
        {
            return carry == 0?null: new ListNode(carry);
        }
        final int value1 = l1==null?0:l1.val;
        final int value2 = l2==null?0:l2.val;
        final int sum = value1+value2+carry;
        final ListNode newNode = new ListNode(sum%10);
        newNode.next = addTwoNumbers(l1==null?null:l1.next,
                                    l2==null?null:l2.next,
                                    sum/10);
        return newNode;
    }
}