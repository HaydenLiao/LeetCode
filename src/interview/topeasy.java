package interview;



import java.util.*;
class MinStack {
    Deque<Integer> basicStack;
    Deque<Integer> minStack;
    public MinStack() {
        basicStack=new LinkedList<Integer>();
        minStack=new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        basicStack.push(val);
        minStack.push(Math.min(val,minStack.peek()));
    }

    public void pop() {
        basicStack.pop();
        minStack.pop();
    }

    public int top() {
        return basicStack.peek();
    }

    public int getMin() {
        return minStack.peek();

    }
}

public class topeasy {
    public static void main(String[] args){
        topeasy t=new topeasy();
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);


        System.out.println(t.isBalanced(root));

    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

  //
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;
        root1.left=mergeTrees(root1.left,root2.left);
        root1.right=mergeTrees(root1.right,root2.right);
        root1.val=root1.val+root2.val;
        return root1;
  }
  //543. Diameter of Binary Tree
    int maxd=0;
  public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) return 0;
        longestDepth(root);
        return maxd;
  }
  public int longestDepth(TreeNode root){
        if(root==null) return 0;
        int left=longestDepth(root.left);
        int right=longestDepth(root.right);
        maxd=Math.max(maxd,left+right);
        return 1+Math.max(left,right);
  }



    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);

    }

  //
  public List<Integer> findDisappearedNumbers(int[] nums) {
      List<Integer> ret=new ArrayList<>();
      int len=nums.length;
      for(int i:nums){
          int x=(i-1)%len;
          nums[x]=nums[x]+len;
      }
      for(int i=0;i<len;i++){
          if(nums[i]<=len){
              ret.add(i+1);
          }
      }
      return  ret;
  }
  //268. Missing Number
  public int missingNumber(int[] nums) {
      int n=nums.length+1;
      int sum=n*(n-1)/2;
      for(int i:nums){
          sum=sum-i;
      }
      return sum;
  }

  public List<Integer> findDisappearedNumbersq(int[] nums) {
        List<Integer> ret=new ArrayList<>();
        boolean[] appeared=new boolean[nums.length];
        for(int i: nums){
            appeared[i-1]=true;
        }
        for(int i=0;i<nums.length;i++){
            if(appeared[i]==false){
                ret.add(i+1);
            }
        }
        return  ret;
  }


  //283. Move Zeroes
  public void moveZeroes(int[] nums) {
        int i=0,j=0;
        int len=nums.length;
        outer:
       while (true){
           while (nums[i]!=0){
               i++;
               if(i==len) break outer;
           }
           while ((nums[j]==0||(j<=i))) {
               j++;
               if (j==len) break outer;
           }
           int temp=nums[i];
           nums[i]=nums[j];
           nums[j]=temp;
       }
  }

  //226. Invert Binary Tree
//    recursion
    public TreeNode invertTree(TreeNode root) {
        while(root==null){
            return root;
        }
        TreeNode right=invertTree(root.left);
        TreeNode left=invertTree(root.right);
        root.right=right;
        root.left=left;
        return root;
    }

    //110. Balanced Binary Tree
    //自底向上剪枝
    public boolean isBalanced(TreeNode root) {
      return recur(root)!=-1;
    }
    public int recur(TreeNode root){
      if(root==null) return 0;
      int left=recur(root.left);
      if(left==-1) return -1;
      int right=recur(root.right);
      if(right==-1) return -1;
      return Math.abs(left-right)<=1? Math.max(left,right)+1:-1;
    }

    //自顶向下暴力法
    public boolean isBalancedBruteForce(TreeNode root) {
      if(root==null)return true;
      return isBalancedBruteForce(root.left)&&isBalancedBruteForce(root.right)&&(Math.abs(depth(root.left)-depth(root.right))<=1);
    }
    public int depth(TreeNode root){
      if(root==null)return 0;
      return Math.max(1+depth(root.left),1+depth(root.right));
    }


  //不可以简单的用stack，本身的next会形成loop

    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode current=head;
        while(current!=null){
            ListNode temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
        return prev;
    }

//  169. Majority Element
//    排序后取中位数
    //hashmap
    //moore voting
    public int majorityElement(int[] nums) {
        int ret=0;
        HashMap<Integer,Integer> dict=new HashMap<>();
        for(int i:nums){
            if(!dict.containsKey(i)){
                dict.put(i,1);
            }else{
                dict.put(i,dict.get(i)+1);
            }
            if(dict.get(i)>nums.length/2){
                ret=i;
                break;
            }
        }
        return ret;
    }

  //160. Intersection of Two Linked Lists
    /**
     * hashset store visted ListNode
     * No need to know the length of two lists
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode a=headA,b=headB;
        while(a!=b){
            a= a==null? headB:a.next;
            b= b==null? headA:b.next;
        }
        return a;
    }


  //141. Linked List Cycle
  public boolean hasCycle(ListNode head) {
        ListNode low=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(low==fast){
                return true;
            }
        }
        return false;
  }
    /**
     * hashset
     */
  public boolean hasCycleHash(ListNode head) {
      HashSet<ListNode> seen=new HashSet<>();
      while(head.next!=null){
          if(!seen.contains(head)){
              seen.add(head);
              head=head.next;
          }else{
              return true;
          }
      }
        return false;
  }

  //121. Best Time to Buy and Sell Stock

    /**
     *实质上是DP
     * 对方法二的另一种解释： 方法二可以看做一种动态规划，只不过对空间复杂度进行了优化。考虑每次如何获取最大收益？第i天的最大收益只需要知道前i天的最低点就可以算出来了。而第i天以前（包括第i天）的最低点和i-1天的最低点有关，至此我们的动态方程就出来了。
     * dp[i] = min(d[i-1],prices[i])
     * 其中dp[0]=prices[0],然后动态计算之后的就可以了。 得到了前i天的最低点以后，只需要维护一个max用来保存最大收益就可以了。 这个时候是空间复杂度O（n）的动态规划，代码如下：
     //dp[i]表示截止到i，价格的最低点是多少   dp[i]=min(dp[i-1],nums[i])
     int max = 0;
     int[] dp = new int[prices.length];
     dp[0] = prices[0];
     for (int i = 1; i < prices.length; i++) {
     dp[i] = (dp[i - 1] < prices[i]) ? dp[i - 1] : prices[i];
     max = (prices[i] - dp[i]) > max ? prices[i] - dp[i] : max;
     }
     return max;

     */
  public int maxProfit(int[] prices) {
        int retMax=0;
        int timeToBuy=prices[0];
        for(int i:prices){
            if(i<timeToBuy){
                timeToBuy=i;
            }
            retMax= Math.max(retMax,i-timeToBuy);
        }
        return retMax;
  }
  //  136. Single Number
    /**
     * https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
     * 异或运算有a⊕a=0
     */
    public int singleNumber(int[] nums) {
      int ret=0;
      for(int i:nums){
          ret=ret^i;
      }
      return ret;
    }

  //104. Maximum Depth of Binary Tree
  public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else{
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }
  }
  //100. Same Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null&&q!=null)return false;
        if(q==null&&p!=null)return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }


  //
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetricSubTree(root.left,root.right);
    }
    public boolean isSymmetricSubTree(TreeNode left,TreeNode right){
        if (left==null&&right==null) return true;
        if(left==null||right==null) return false;
        return (left.val==right.val)&&isSymmetricSubTree(left.left,right.right)&&isSymmetricSubTree(left.right,right.left);
    }



    //94. Binary Tree Inorder Traversal
    List<Integer> tree=new ArrayList<>();
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        if(root==null){
           return tree;
        }
        inorderTraversal(root.left);
        tree.add(root.val);
        inorderTraversal(root.right);
        return tree;
    }

    /**
     * 不使用全局变量的方法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        return inorder(root, res);
    }
    public List<Integer> inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
        return res;
    }



    //70. Climbing Stairs
    public int climbStairs(int n) {
        if(n<=2)return n;
        int ret=0;
        int prev1=1,prev2=2;
        for(int i=3;i<=n;i++){
            ret=prev1+prev2;
            prev1=prev2;
            prev2=ret;
        }
        return ret;
    }
    public int climbStairsRecursion(int n) {
        if(n<=2)return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    //53. Maximum Subarray
    //DP
    public int maxSubArray(int[] nums) {
        int pre=0,max=nums[0];
        for(int i:nums){
            pre=Math.max(i+pre,i);
            max=Math.max(pre,max);
        }
        return max;
    }
    //brute force
    public int maxSubArraybad(int[] nums) {
        int max=nums[0];
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int tempmax=nums[i];
            temp[i]=nums[i];
            for(int j=i+1;j<nums.length;j++){
                tempmax=tempmax+nums[j];
                if(tempmax>temp[i]){
                    temp[i]=tempmax;
                }
            }
            if(temp[i]>max) max=temp[i];
        }
        return max;
    }

    //21. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return  list1;
        if(list1.val<= list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

//    20. Valid Parentheses
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        Stack<Character> content=new Stack<>();
        //hashmap initialize
        HashMap<Character,Character> dict=new HashMap<>(){
            {
                put(')', '(');
                put('}','{');
                put(']','[');
            }
        };
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(dict.containsKey(ch)){
                if(content.isEmpty()||content.peek()!=dict.get(ch)){
                    return false;
                }
                content.pop();
            }else {
                content.push(ch);
            }
        }
    return content.empty();
    }

    public boolean isValidTwo(String s) {
        while (s.contains("()")||s.contains("{}")||s.contains("[]")){
            if(s.contains("()")){
                s=s.replace("()","");
            }
            if(s.contains("{}")){
                s=s.replace("{}","");
            }
            if(s.contains("[]")){
                s=s.replace("[]","");
            }
        }
        return s.length()==0;
    }




}
