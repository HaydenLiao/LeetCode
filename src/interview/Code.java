package interview;

import java.util.HashMap;

public class Code {
    public static void main(String[] args){
        Code c=new Code();

    }
    public  int firstUniqueChar(String s){
        HashMap<Character,Integer> dictionary=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            dictionary.put(c,dictionary.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(dictionary.get(c)==1) return i;
        }

        return -1;
    }

    public ListNode reverseLinkedList(ListNode head){
        ListNode prev=new ListNode();
        ListNode later=head.next;
        while (head!=null){
            head.next=prev;
            prev=head;
            head=later;
            if(later!=null){
                later=later.next;
            }
        }
        return prev;
    }


}
