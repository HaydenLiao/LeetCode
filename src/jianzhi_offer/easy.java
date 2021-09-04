package jianzhi_offer;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class easy {
    public static void main(String[] args) {
        easy t=new easy();
        System.out.println(t.fib(45));



    }
    public int fib(int n) {
        int f=0;
        int s=1;
        int target=1;
        final int MOD = 1000000007;
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        f=1;
        s=1;
        for(int i=2;i<n;i++){
            target=(f+s)%MOD;
            f=s;
            s=target;
        }
        return target;
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        /**
         * ListNode head=new ListNode(1);
         *         ListNode n=head;
         *         head.next=new ListNode(2);
         *         head=head.next;
         *         head.next=new ListNode(3);
         *         head=head.next;
         *         head.next=new ListNode(4);
         *         head=head.next;
         *         head.next=new ListNode(5);
         *         head=head.next;
         *         head.next=new ListNode(6);
         *         int k=4;
         *         ListNode tar=t.getKthFromEnd(n,k);
         *         System.out.println(tar.val);
         */
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