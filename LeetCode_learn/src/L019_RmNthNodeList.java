public class L019_RmNthNodeList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode p = start;
        ListNode q = start;
        start.next = head;
        while (n-- > 0 ){
            if (p.next != null)
                p = p.next;
            else
                return null;
        }
        while (p.next!=null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return start.next;
    }
}
