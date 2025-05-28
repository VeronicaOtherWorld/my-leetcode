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

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class LC86_PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode leftHead = null, leftTail = null;
		ListNode rightHead = null, rightTail = null;
		ListNode next = null;

		while(head != null){
			next = head.next;
			head.next = null;
			if(head.val < x){
				if(leftHead == null){
					leftHead = head;
				} else {
					leftTail.next = head;
				}
				leftTail = head;
			} else {
				if(rightHead == null){
					rightHead = head;
				} else {
					rightTail.next = head;
				}
				rightTail = head;
			}
			head = next;
		}
		if(leftHead == null) return rightHead;
		leftTail.next = rightHead;
		return leftHead;

	}
}