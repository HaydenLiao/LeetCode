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
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String s="ABCCEDASA";
        boolean b=m.exist(board,s);
        int i=m.maxProfit(array);
        System.out.println(b);

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

    //剑指 Offer 12. 矩阵中的路径
    /**
     *给定一个m x n 二维字符网格board 和一个字符串单词word 。
     * 如果word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
     * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     */

    /**
     *思路：DFS
     */
    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board,char[] words, int i,int j, int k){  //k为已匹配的字母的个数
        if(i>=board.length|| i<0 || j>=board[0].length || j<0
            || board[i][j] != words[k]){       //若i，j越界或者第k个字母不匹配则返回false
            return false;
        }
        if(k==words.length-1){  //在上一步已经判断过k位置上的字母匹配且已经全部匹配完成
            return true;
        }
        board[i][j]='\0';  //走过的路赋值为/0，但与null不一样
        boolean ret=dfs(board,words,i-1,j,k+1) ||
                    dfs(board,words,i+1,j,k+1) ||
                    dfs(board,words,i,j-1,k+1) ||
                    dfs(board,words,i,j+1,k+1) ;
        //回溯，恢复原来字符
        board[i][j]=words[k];    /** 为什么这里要恢复？ ,因为若是此次匹配失败则复原通过路径上的所有位置，
         否则返回ret之后会判断主函数是否能返回true
         */

        return ret;
    }

    //剑指 Offer 13. 机器人的运动范围

    /**
     *地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，
     * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
     * 也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
     * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     */
    /**
     * DFS
     * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
     */
    int m,n;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m=m;
        this.n=n;
        visited=new boolean[m][n];
        return dfs(0,0,k);
    }
    private int dfs(int i,int j,int k){
        if( i>=m || j>=n                //i,j越界
            ||visited[i][j]==true     //i,j位置以前访问过
            || sum(i,j)>k)            //数位和大于k
        {return 0;}
        visited[i][j]=true;           //将此格标注为已访问过
        return 1+dfs(i+1,j,k)+dfs(i,j+1,k);    //继续访问下面和右边的格子
    }

    private int sum(int i,int j){  //计算i，j的位数和
        int sum=0;
        while(i!=0){
            sum=sum+i%10;
            i=i/10;
        }
        while(j!=0){
            sum=sum+j%10;
            j=j/10;
        }
        return sum;
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

    //剑指 Offer 34. 二叉树中和为某一值的路径

    /**
     *给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     */
    LinkedList<Integer> path=new LinkedList<>();
    LinkedList<List<Integer>> ret=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfspathSum(root,target);
        return ret;
    }
    private void dfspathSum(TreeNode node,int target){
        if(node==null){
            return;
        }
        path.add(node.val);
        target=target-node.val;
        if(target==0 && node.left==null && node.right==null){
            ret.add(new LinkedList(path));
        }
        dfspathSum(node.left,target);
        dfspathSum(node.right,target);
        path.removeLast();
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


    //剑指 Offer 36. 二叉搜索树与双向链表
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     */
    class Node36 {
        public int val;
        public Node36 left;
        public Node36 right;

        public Node36() {}

        public Node36(int _val) {
            val = _val;
        }

        public Node36(int _val,Node36 _left,Node36 _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    Node36 head,pre;
    public Node36 treeToDoublyList(Node36 root) {
        if(root ==null){
            return null;
        }
        dfsNode(root);
        head.left=pre;
        pre.right=head;
        return head;
    }

    void dfsNode(Node36 cur){
       if(cur==null){
           return;
       }
       dfsNode(cur.left);
       if(pre != null){
           pre.right=cur;
       }
       else
           head=cur;
       cur.left=pre;
       pre=cur;
       dfsNode(cur.right);
    }



    //剑指 Offer 45. 把数组排成最小的数
    public String minNumber(int[] nums) {
        String[] str=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i]=String.valueOf(nums[i]);
        }
        quickSort(str,0,nums.length-1);
        StringBuilder ret=new StringBuilder();
        for(String s:str){
            ret=ret.append(s);
        }
        return ret.toString();
    }
    public void quickSort(String[] strs, int low, int high){
        if(low<high){
            int middle=getMiddle(strs,low,high);
            quickSort(strs,low,middle-1);
            quickSort(strs,middle+1,high);
        }
    }

    public int getMiddle(String[] strs,int low,int high){
        String temp=strs[low];
        while(low<high){
            while(low<high && (strs[high]+temp).compareTo(temp+strs[high])>=0){
                high--;
            }
            strs[low]=strs[high];
            while(low<high && (strs[low]+temp).compareTo(temp+strs[low])<=0){
                low++;
            }
            strs[high]=strs[low];
        }
        strs[low]=temp;
        return low;
    }

    //剑指 Offer 41. 数据流中的中位数
    //https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
    class MedianFinder {
        Queue<Integer>A,B;
        /** initialize your data structure here. */
        public MedianFinder() {
            A=new PriorityQueue<>();//小顶堆，保存数较大的一半数字
            B=new PriorityQueue<>((x,y)->(y-x));//大顶堆，保存较小的一半数字
        }

        public void addNum(int num) {
            if(A.size()!=B.size()){
                A.add(num);
                B.add(A.poll());
            }else{
                B.add(num);
                A.add(B.poll());
            }
        }
        public double findMedian() {
            return A.size()==B.size()? (A.peek()+B.peek())/2.0 : A.peek();
        }
    }




    //剑指 Offer 46. 把数字翻译成字符串
    /**
     *给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     */
    public int translateNum(int num) {
        if(num<10){
            return 1;
        }
        String s=""+num;
        int[] dp=new int[s.length()];
        dp[0]=1;

        for(int i=1;i<s.length();i++){
            String helper="";
            helper=helper+s.charAt(i-1)+s.charAt(i);
            int helpnum=Integer.parseInt(helper);
           if(i==1){
               if(helpnum>=10&&helpnum<=25){
                   dp[i]=2;
               }
               else {
                   dp[i]=1;
               }
               continue;
           }
            if(helpnum>=10&&helpnum<=25){
                dp[i]=dp[i-1]+dp[i-2];
            }
            else{
                dp[i]=dp[i-1];
            }
        }
        return dp[s.length()-1];
    }

    //https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
    public int translateNumBetterSolution(int num) {
        int a=1,b=1;
        int x,y=num%10;//相当于取第i-1位数值
        while(num!=0){
            num =num/10; //减小num
            x = num%10; //相当于取第i位数
            int temp=10*x+y;
            int c= temp>=10&&temp <=25? a+b : a;
            b=a;
            a=c;
            y=x;
        }
        return a;
    }


    //剑指 Offer 47. 礼物的最大价值
    /**
     *在一个 m*n 的棋盘的每一格都放有一个礼物，
     * 每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，
     * 并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，
     * 请计算你最多能拿到多少价值的礼物？
     */
    public int maxValue(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for(int i=1;i<grid.length;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<grid[0].length;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j]=Math.max(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];

    }

    //剑指 Offer 48. 最长不含重复字符的子字符串
    /**
     *请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/
     */
    public int lengthOfLongestSubstring(String s) {
        int temp=0;
        int max=0;
        HashMap<Character,Integer> dict=new HashMap();//创建HashMap存储字符
        for(int j=0;j<s.length();j++){
            int i=dict.getOrDefault(s.charAt(j),-1);//获取在j位置上字符之前出现的位置，若未出现过，默认为-1
            dict.put(s.charAt(j),j);//更新j位置上字符的哈希表
            temp= temp<j-i? temp+1 :j-i;//动态转移方程的判断 DP[j]
            max=Math.max(temp,max);// max(DP[j],DP[j-1])
        }
        return max;
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

    //剑指 Offer 64. 求1+2+…+n
    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean x=n>1 && (n=n+sumNums(n-1))>0;
        return n;
    }



}


