package interview;



import java.util.*;
//303. Range Sum Query - Immutable
class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            sum[i+1]=sum[i]+nums[i];
        }
    }
    public int sumRange(int left, int right) {
        return sum[right+1]-sum[left];
    }
}

//232. Implement Queue using Stacks
class MyQueue {
    Stack<Integer> S1;
    Stack<Integer> S2;

    public MyQueue() {
        S1=new Stack<>();
        S2=new Stack<>();
    }

    public void push(int x) {
       S2.push(x);
    }
    public int pop() {
        if(S1.isEmpty()){
            while (!S2.isEmpty()){
                S1.push(S2.pop());
            }
        }
        return S1.pop();
    }
    public int peek() {
        if(S1.isEmpty()){
            while (!S2.isEmpty()){
                S1.push(S2.pop());
            }
        }
        return S1.peek();
    }

    public boolean empty() {
        return (S1.isEmpty()&&S2.isEmpty());
    }
}
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
//225. Implement Stack using Queues
class MyStack {
    Queue<Integer> Q1;
    Queue<Integer> Q2;

    public MyStack() {
        Q1=new LinkedList<>();
        Q2=new LinkedList<>();

    }

    public void push(int x) {
        Q2.offer(x);
        while (!Q1.isEmpty()){
            Q2.offer(Q1.poll());
        }
        Queue<Integer> temp=Q1;
        Q1=Q2;
        Q2=temp;

    }
    public int pop() {
        return Q1.poll();
    }

    public int top() {
        return Q1.peek();
    }

    public boolean empty() {
        return Q1.isEmpty();
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
        int[] nums=new int[]{0,1,2,4,5,7};
        String pa="abba";
        String s="dog cat cat dog";

        System.out.println(t.wordPattern(pa,s));

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

  //234. Palindrome Linked List
    //也可以用快慢指针，快指针到队尾时慢指针在最中间,然后用后半部分反转进行比较
  public boolean isPalindrome(ListNode head) {
        if (head==null) return true;
        List<Integer> list=new ArrayList<>();

        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        for(int i=0,j=list.size()-1;i<j;i++,j--){
            if(list.get(i)!=list.get(j)){
                return false;
            }
        }
        return true;
  }
  //292. Nim Game
    //n为4的倍数时必输
  public boolean canWinNim(int n) {
        return n%4!=0;
  }
  //290. Word Pattern
  public boolean wordPattern(String pattern, String s) {
        String[] splits=s.split(" ");
        if(pattern.length()!=splits.length) return false;
        HashMap<Character,String> pTos=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char p=pattern.charAt(i);
            String ss=splits[i];
            if(!pTos.containsKey(p)){
                if(!pTos.containsValue(ss)){
                    pTos.put(p,ss);
                }else return false;
            }else {
                if(!Objects.equals(pTos.get(p),ss)) return false;
            }
        }
        return true;
  }

  //278. First Bad Version
    //二分搜索
  public int firstBadVersion(int n) {
        int left=1;
        int right=n;
        while (left<right){
            int mid=left+(right-left)/2; //用left+right/2会超出时间限制
//            if(isBadVersion(mid)){
//                right=mid;
//            }else {
//                left=mid+1;
//            }
        }
        return left;
  }

  //263. Ugly Number n=2^x+3^y+5^z (x,y,z都为0时n=1，所以1也是ugly number)
  public boolean isUgly(int n) {
        if(n<=0){
            return false;
        }
        int[] factors=new int[]{2,3,5};
        for(int factor:factors){
            while (n%factor==0){
                n/= factor;
            }
        }
        return n==1;
  }




  //258. Add Digits
    /* 递归：
     *public int addDigits(int num) {
    if (num < 10) {
        return num;
    }
    int next = 0;
    while (num != 0) {
        next = next + num % 10;
        num /= 10;
    }
    return addDigits(next);
}
     */
  public int addDigits(int num) {
       int a=0;
       int ret=0;
       while(num>=10){
           ret=ret+num/10;
           num=num%10;
           if(num<10){
               ret=ret+num;
               num=ret;
               ret=0;
           }
       }
      return num;
  }

  //257. Binary Tree Paths
  public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths=new ArrayList<>();
        constructPath(root,"",paths);
        return paths;
  }
  public void constructPath(TreeNode root,String path, List<String> paths){
        if(root!=null){
            StringBuilder pathSB=new StringBuilder(path);
            pathSB.append(Integer.toString(root.val));
            if(root.left==null&&root.right==null){
                paths.add(pathSB.toString());
            }else {
                pathSB.append("->");
                constructPath(root.left,pathSB.toString(),paths);
                constructPath(root.right,pathSB.toString(),paths);
            }
        }
  }


  //242. Valid Anagram
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] dictionary=new int[26];
        for(int i=0;i<s.length();i++){
            dictionary[s.charAt(i)-'a']++;
            dictionary[t.charAt(i)-'a']--;
        }
        for (int i=0;i<26;i++){
            if (dictionary[i] !=0){
                return false;
            }
        }
        return true;
    }

  //237. Delete Node in a Linked List
  public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
  }

  //235. Lowest Common Ancestor of a Binary Search Tree
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor=root;
        while (true){
            if(p.val<ancestor.val&&q.val<ancestor.val){
                ancestor=ancestor.left;
            }else if(p.val>ancestor.val&&q.val>ancestor.val){
                ancestor=ancestor.right;
            }else{
                break;
            }
        }
        return ancestor;
  }


  //228. Summary Ranges
    public List<String> summaryRanges(int[] nums) {
        List<String> ret=new ArrayList<>();
        for(int i=0;i<nums.length;){
            int j=i;
            while(j+1<nums.length&&nums[j]+1==nums[j+1]){
                j++;
            }
            if(i==j){
                ret.add(nums[i]+"");
            }else {
                ret.add(nums[i]+"->"+nums[j]);
            }
            i=j+1;
        }
        return ret;
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

    //111. Minimum Depth of Binary Tree
    //要注意一边子节点为空的情况
    public int minDepth(TreeNode root) {
      if(root==null) return 0;
      if(root.left==null&&root.right==null)return 1;
      int left=minDepth(root.left);
      int right=minDepth(root.right);
      return (left==0||right==0)? left+right+1: Math.min(left,right)+1;
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
    //202. Happy Number
    //https://leetcode-cn.com/problems/happy-number/
    public boolean isHappy(int n) {

        return false;
    }
    //219. Contains Duplicate II
    //sliding window
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<=1)return false;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i< nums.length;i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
    public boolean containsNearbyDuplicateHashMap(int[] nums, int k) {
        if(nums.length<=1)return false;
        HashMap<Integer,Integer> dict=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(dict.containsKey(nums[i])&&(i-dict.get(nums[i])<=k)) {
               return true;
            }
            else dict.put(nums[i],i);
        }
        return false;
    }

    //217. Contains Duplicate
    //用stream直接一行返回
    // return IntStream.of(nums).distinct().count() != nums.length;
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> dict=new HashSet<>();
        for(int i:nums){
            //dict.add(): 当不含有元素i时返回false；
            if(!dict.add(i)) return true;
           /* if(dict.contains(i)) return true;
            dict.add(i);
            */
        }
        return false;
    }

    //205. Isomorphic Strings
    //注意s到t和t到s都应该有映射
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character,Character> s2t=new HashMap<>();
        HashMap<Character,Character> t2s=new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char si=s.charAt(i);
            char ti=t.charAt(i);
            if((s2t.containsKey(si)&&s2t.get(si)!=ti)||(t2s.containsKey(ti)&&t2s.get(ti)!=si)){
                return false;
            }
            s2t.put(si,ti);
            t2s.put(ti,si);
        }
        return true;
    }


    //203. Remove Linked List Elements
    public ListNode removeElementsRecur(ListNode head, int val) {
        if (head==null) return null;
        head.next=removeElementsRecur(head.next,val);
        return head.val==val? head.next:head;
    }
    public ListNode removeElementsIterate(ListNode head, int val) {
        ListNode ret=new ListNode();
        ret.next=head;
        ListNode pre=ret;
        while (head!=null){
            if(head.val==val){
                pre.next=head.next;
                head=pre.next;
            }
            else {
            pre=pre.next;
            head=pre.next;}
        }
        return ret.next;
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
