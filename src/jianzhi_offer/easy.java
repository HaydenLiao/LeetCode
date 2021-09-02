package jianzhi_offer;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class easy {
    public static void main(String[] args) {
        easy t=new easy();
        ListNode head=new ListNode(1);
        ListNode n=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(4);
        head=head.next;
        head.next=new ListNode(5);
        head=head.next;
        head.next=new ListNode(6);
        int k=4;
        ListNode tar=t.getKthFromEnd(n,k);
        System.out.println(tar.val);


    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        int n=0;
        ListNode target=null;
        for(target=head;target!=null;target=target.next){
            n++;
        }
        for(target=head;n>k;n--){
            target=target.next;
        }
        return target;
    }




}