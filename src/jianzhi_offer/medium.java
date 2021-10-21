package jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class medium {
    public static void main(String[] args){

    }


    //剑指 Offer 35. 复杂链表的复制

    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。
     * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
     * 还有一个 random 指针指向链表中的任意节点或者 null。
     *
     * 解题思路：recursion+hashmap
     */
    public Node copyRandomList(Node head) {
        Map<Node,Node> cacheNode=new HashMap<Node,Node>();//存储链表的原节点以及新拷贝的节点
        if(head==null){
            return null;
        }
        if(!cacheNode.containsKey(head)){//若hashMap中还没有创建过此节点
            Node copyNode=new Node(head.val);
            cacheNode.put(head,copyNode);
            copyNode.next=copyRandomList(head.next);//递归赋值此节点的next节点
            copyNode.random=copyRandomList(head.random);//递归肤质此节点的random节点
        }
        return cacheNode.get(head);
    }

}
