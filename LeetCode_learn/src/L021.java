import java.util.LinkedList;

public class L021 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode cur = new ListNode(0);
        ListNode l = cur;
        if(p == null && q == null)
            return null;
        while(p!=null && q!=null) {
            int x = p.val;
            int y = q.val;
            if(x <= y){
                l.val = x;
                p = p.next;
            }else{
                l.val = y;
                q = q.next;
            }
            l.next = new ListNode(0);
            l = l.next;
        }
        if (q != null){
            l.val = q.val;
            l.next = q.next;
        }
        if (p != null){
            l.val = p.val;
            l.next = p.next;
        }

        return cur;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode x = mergeTwoLists(l1, l2);
        while(x != null){
            System.out.println(x.val);
            x = x.next;
        }
    }
}
