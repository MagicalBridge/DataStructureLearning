class Solution {
    public ListNode removeElements(ListNode head, int val) {

        // 首先创建一个虚拟的头结点, 对于虚拟头结点来说，对应的值是多少并不重要，因为我们永远不会
        // 访问它的值

        ListNode dummyHead = new ListNode(-1);

        // 新创建的虚拟头节点和原链表进行一个链接操作
        dummyHead.next = head;

        // 设置虚拟头结点的好处是 所有的节点都有前一个节点了 head 这个节点
        // 也不例外，这样就不需要对头结点做特殊处理了。从第一个元素之前的那个元素开始
        // 不停的去看下一个元素,是否是待删除的元素。
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        // 最后return 出去的元素是 dummyHead.next 而不是 dummyHead
        // 因为对于外部使用者来说，这个是不存在的
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6);
        System.out.println(res);
    }
}
