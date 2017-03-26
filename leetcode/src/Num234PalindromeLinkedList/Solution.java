package Num234PalindromeLinkedList;

/**
 * Created by test on 2017/3/27.
 */

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        ListNode secondHead = null;
        if(fastNode == null)
            secondHead = slowNode;
        else
            secondHead = slowNode.next;
        secondHead = rotateList(secondHead);
        while(secondHead != null) {
            if(head.val != secondHead.val) {
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        // 第一次提交这里错误，因为这时候head是不为null，它还连接着后面，只是我们不在用了而已，
        // 所以上面只需要用secondHead判断结尾即可
        // 错误用例 [1, 1]
//        if(head != null || secondHead != null) return false;
        return true;
    }

    private ListNode rotateList(ListNode head) {
        ListNode moveToHead = head.next;
        ListNode temp;
        ListNode tail = head;
        while(moveToHead != null) {
            temp = moveToHead.next;
            // 第二次提交错误在这里，因为这里head已经更新成新的头结点了，
            // 所以这次不能用head，新建了tail保存原head
            // head.next = temp
            tail.next = temp;
            moveToHead.next = head;
            head = moveToHead;
            moveToHead = temp;
        }
        return head;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
