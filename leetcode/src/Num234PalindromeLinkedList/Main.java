package Num234PalindromeLinkedList;


/**
 * Created by silence on 2017/3/19.
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(1);
        System.out.println(System.currentTimeMillis());
        System.out.println(new Solution().isPalindrome(head));
        System.out.println(System.currentTimeMillis());
    }
}
