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


    //剑指 Offer 04. 二维数组中的查找
    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 思路：1.暴力法遍历O(MN)
     * 2.线性查找O(M+N)
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i=matrix.length-1;
        int j=0;
        boolean flag=false;
        while(i>=0&&j<=matrix[0].length-1){
            if(matrix[i][j]==target){
                flag=true;
                break;
            }
            if(matrix[i][j]>target){
                i--;
                continue;//要有continue，或者要用else if 去写
            }
            if(matrix[i][j]<target){
                j++;
                continue;
            }
        }
        return flag;
    }


    //剑指 Offer 35. 复杂链表的复制

    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。
     * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
     * 还有一个 random 指针指向链表中的任意节点或者 null。
     *
     * 解题思路：recursion+hashmap
     */
    //注意此HashMap要在method外面建，否则会导致递归创建很多个hanshmap！！！！！！
    Map<Node,Node> cacheNode=new HashMap<Node,Node>();//存储链表的原节点以及新拷贝的节点
    public Node copyRandomList(Node head) {

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
