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
        medium m=new medium();
        int[] array=new int[]{7,2,9,1,10};
        int i=m.maxProfit(array);
        System.out.println(i);

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


    //剑指 Offer 26. 树的子结构
    /**
     *输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
     *
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null||A==null){
            return false;
        }
        return(recur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));

    }
    boolean recur(TreeNode A,TreeNode B){
        if(B==null)//在issubstructure里面已经判断过B是否为空节点了，所以此处root必定不为空
            return true;
        if(A==null||(A.val!=B.val)){
            return false;
        }
        return recur(A.left,B.left)&&recur(A.right,B.right);
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



    //剑指 Offer 32 - III. 从上到下打印二叉树 III
    /**
     *请实现一个函数按照之字形顺序打印二叉树，
     * 即第一行按照从左到右的顺序打印，
     * 第二层按照从右到左的顺序打印，
     * 第三行再按照从左到右的顺序打印，其他行以此类推。
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/mian-shi-ti-32-iii-cong-shang-dao-xia-da-yin-er--3/
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        boolean leftToRight=true;
        if(root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            Stack<TreeNode> helper=new Stack<>();
            for(int i=queue.size();i>0;i--){
                TreeNode node= queue.poll();
                temp.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            if(!leftToRight){
                Collections.reverse(temp);
            }
            ans.add(temp);
            leftToRight=!leftToRight;
        }
        return ans;
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

    //剑指 Offer 63. 股票的最大利润

    /**
     *假设把某股票的价格按照时间先后顺序存储在数组中，
     * 请问买卖该股票一次可能获得的最大利润是多少？
     */
    public int maxProfit(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int min=prices[0];
        int curprof=0;
        for(int i=1;i<prices.length;i++){
            min=Math.min(prices[i],min);
            curprof=Math.max(curprof,prices[i]-min);
//          if( prices[i]-min>curprof ){
//             curprof=prices[i]-min;
//            }
//          if(prices[i]<min){
//              min=prices[i];
//          }
        }
        return curprof;
    }

}
