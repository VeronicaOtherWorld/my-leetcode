/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class LC0002_AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null, current = null;
		int carry = 0;
		int sum = 0;
		int val = 0;

		while(l1 != null || l2 != null){
			sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
			val = sum % 10;
			carry = sum / 10;

			if(head == null){
				head = new ListNode(val);
				current = head;
			} else {
				current.next = new ListNode(val);
				current = current.next;
			}
		}
		if(carry == 1){
			current.next = new ListNode(1);
		}
		return head;
	}
}