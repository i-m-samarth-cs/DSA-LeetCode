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
class Solution {
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> array=  new ArrayList<>();

        int length = 0;
        while(head!=null)
        {
            array.add(head);
            head = head.next;
            length++;
        }
        return array.get(length/2);
    }
}
