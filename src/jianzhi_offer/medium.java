package jianzhi_offer;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
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

    //剑指 Offer 32 - I. 从上到下打印二叉树
    /**
     *从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * BFS
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/solution/jian-zhi-offer-32-i-cong-shang-dao-xia-d-myp0/
     */
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        else{
            Queue<TreeNode> queue=new LinkedList<>();
            ArrayList<Integer> ans=new ArrayList<>();
            queue.offer(root);//用queue暂时储存当前需要遍历的节点。queue.offer()存储新的节点
            while(!queue.isEmpty()){
                TreeNode curr=queue.poll();//queue.poll()抛出队列最前节点，并将其暂时存储在curr中
                ans.add(curr.val);
                if (curr.left!=null) {
                    queue.offer(curr.left);//若当前节点存在左节点，压入queue中
                }
                if(curr.right!=null){
                    queue.offer(curr.right);//若当前节点存在右节点，压入queue中
                } }
            int[] ret=new int[ans.size()];
            for(int i=0;i<ret.length;i++){
                ret[i]=ans.get(i);
            }
            return ret;
        }
    }


    //剑指 Offer 32 - II. 从上到下打印二叉树 II
    /**
     *从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> ret=new ArrayList<>();
        if(root!=null){//此处要检查root是否为null再压入queue中
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for(int i=queue.size();i>0;i--){
                TreeNode node=queue.poll();
                temp.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            ret.add(temp);
        }
        return ret;
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
