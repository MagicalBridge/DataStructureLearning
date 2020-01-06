public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        // 使用while循环的原因是链表中每一个元素都有可能是指定的元素
        while (head != null && head.val == val) {
            // 此时这个待删除的节点就是head
            ListNode delNode = head;

            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return head;
        }

        // 删除链表中间的元素

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
                System.out.println("");
            }
        }
        return head;
    }
}
