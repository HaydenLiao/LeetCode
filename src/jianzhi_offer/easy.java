package jianzhi_offer;


import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


//剑指 Offer 09. 用两个栈实现队列
/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 */
class CQueue {
    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack2.empty()){
            return (stack2.pop());
        }
        else{
            if(stack1.empty()){
                return -1;
            }
            else{
                while(!stack1.empty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }

    }
}


    //剑指 Offer 30. 包含min函数的栈

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数
     * 在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
     */
    class MinStack {
        /**
         * Your MinStack object will be instantiated and called as such:
         * MinStack obj = new MinStack();
         * obj.push(x);
         * obj.pop();
         * int param_3 = obj.top();
         * int param_4 = obj.min();
         */

        private Stack<Integer> basicStack;
        private Stack<Integer> minStack;

        public MinStack() {
            basicStack=new Stack<>();
            minStack=new Stack<>();
        }

        public void push(int x) {
            basicStack.push(x);
            if(minStack.isEmpty()||minStack.peek()>=x){
                minStack.push(x);
            }
        }

        public void pop() {
            int p=basicStack.pop();
            if(minStack.peek().equals(p)){
                minStack.pop();
            }
        }

        public int top() {
            return basicStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }









public class easy {
    public static void main(String[] args) {
        easy t=new easy();
        int[] nums=new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[][] i=t.findContinuousSequence(9);
        for(int[] j :i){
            for(int k:j)
            System.out.println(k);
        }

    }

    //剑指 Offer 03. 数组中重复的数字

    /**
     * 找出数组中重复的数字。
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> unique=new HashSet<>();
        for(int c:nums){
            if(unique.contains(c)){
                return c;
            }
            else{
                unique.add(c);
            }
        }
        return -1;
    }


    //剑指 Offer 05. 替换空格
    /**
     *请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * @param  s
     * @return String
     */
    public String replaceSpace(String s) {
        String ret="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                ret=ret+"%20";
            }
            else{
                ret=ret+s.charAt(i);
            }
        }
        return ret;

    }

//剑指 Offer 06. 从尾到头打印链表

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     */
    public int[] reversePrint(ListNode head) {
        int l= getLength(head);
        int[] ret=new int[l];
        for(int i=l-1;i>=0;i--){
            ret[i]=head.val;
            head=head.next;
        }
        return ret;
    }

    public int getLength(ListNode head){
        int l=0;
        while(head!=null){
            l++;
            head=head.next;
        }
        return l;
    }

    //剑指 Offer 10- II. 青蛙跳台阶问题

    /**
     *一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if(n<=1){
            return 1;
        }
        int first=1;
        int second=1;
        int sum=0;
        for(int i=2;i<=n;i++){
            sum=(first+second)%1000000007;  //注意sum应该在此处取余，如果在return位置取余会导致sum太大溢出而变为负数
            first=second;
            second=sum;
        }
        return sum;
    }


    //剑指 Offer 11. 旋转数组的最小数字
    //https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
     *
     * 注意此数组为已排序数组，所以旋转之后定为递增序列
     *
     * 二分查找
     */
    public int minArray(int[] numbers) {
        int i=0,j=numbers.length-1;
        while(i<j){
            int m=(i+j)/2;
            if(numbers[m]>numbers[j]){
                i=m+1;
            }
            else if(numbers[m]<numbers[j]){
                j=m;
            }
            else
                j--;
        }
        return numbers[i];
    }

    //剑指 Offer 15. 二进制中1的个数
    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
     * https://baiducloud.tencent.com/developer/article/1338265
     */
    public int hammingWeight(int n) {
        int ret=0;
        for(int i=0;i<32;i++){   //输入为长度32的二进制串
            if((n & (1<<i)) !=0){     // &为bit operator，对两边的数进行对比计算： 1&1=1， 1&0=0， 0&1=0， 0&0=0
                ret++;                // << 为左移运算符，1<<i 为将1进行i次左移，eg： 1<<1 结果为 10(二进制中）
            }                         // 1<<i也会遇到负数，所以此处使用的是!=0而不是>0   使用1<<i;而不是使用n>>1,因为n>>1会遇到负数(反码)
        }
        return ret;
    }

    //剑指 Offer 18. 删除链表的节点
    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     */
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val){
            return head.next;
        }
        ListNode cur=head;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;//因为listnode没有prev，所以只能用next.next进行判断
                break;
            }
            cur=cur.next;
        }
        return head;
    }

    //剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     */
    public int[] exchange1(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int temp;
        while (i<j){
            if(nums[i]%2==0){//nums 为偶数
                temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                j--;
            }
            else{
                i++;
            }
        }
        return nums;
    }


    /**
     * 优化答案，在i，j位置上已经为奇偶数时跳过
     */
    public int[] exchange(int[] nums) {
        int i=0,j=nums.length-1,temp;
        while(i<j){
            while(i<j&&(nums[i]%2!=0)){
                i++;
            }
            while(i<j&&(nums[j]%2==0)){
                j--;
            }
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        return nums;
    }




    //剑指 Offer 22. 链表中倒数第k个节点
    /**
     * 输入一个链表，输出该链表中倒数第k个节点。
     * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        int l=0;
        ListNode node=null;
        for(node=head;node!=null;node=node.next){
            l++;
        }
        for(node=head;l>k;l--){
            node=node.next;
        }
        return node;
    }

    /**
     * 双指针解法，关键点在于fast指针先走k 步，还剩下 N-k步，
     * 第二次往前走的时候fast和low一起走，都走了N-k步之后 fast到达null，而low到达N-k即倒数第k个节点处
     * 只需要遍历一次
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast=head;
        ListNode low=head;
        while(k>0){
            fast=fast.next;
            k--;
        }
        while(fast!=null){
            fast=fast.next;
            low=low.next;
        }
        return low;
    }



    //剑指 Offer 24. 反转链表

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;

    }

    //剑指 Offer 25. 合并两个排序的链表
    /**
     *输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * 递归yyds！！！！！！！！！
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return l1==null? l2 :l1;
        }
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    //双指针，另创一个fakehead
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode fakeHead=new ListNode(0);
        ListNode cur=fakeHead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }
            else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next= l1==null? l2:l1;
        return fakeHead.next;
    }


    //剑指 Offer 27. 二叉树的镜像
    /**
     *请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * 递归！！！！！！！！！！
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode temp=root.left;
        root.left=mirrorTree(root.right);
        root.right=mirrorTree(temp);
        return root;
    }

    //剑指 Offer 28. 对称的二叉树
    /**
     *请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }
    boolean isSymmetricChild(TreeNode A,TreeNode B){
        if(A==null&&B==null){
            return true;
        }
        if(A==null||B==null){
            return false;
        }
        return ((A.val==B.val)&&isSymmetricChild(A.left,B.right)&&isSymmetricChild(A.right,B.left));
    }

    //剑指 Offer 39. 数组中出现次数超过一半的数字
    /**
     *数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 解法1：hashmap
     * 解法2：排序后返回处于中位的数字  Arrays.sort(nums); return nums[nums.length/2];
     * 解法3：摩尔投票法
     */
    public int majorityElement(int[] nums) {
        int vote=0;
        int x=0;
        for(int i:nums){
            if(vote==0){
                x=i;
            }
            vote += i==x? 1:-1;
        }
        return x;
    }
    public int majorityElement1(int[] nums) {
        HashMap<Integer,Integer> dict=new HashMap<>();
        int max=nums[0];
        for(int i:nums){
            if(!dict.containsKey(i)){
                dict.put(i,1);
            }
            else {
                dict.put(i,dict.get(i)+1);
                if(dict.get(i)>dict.get(max)){
                    max=i;
                }
            }
        }
        return max;
    }




    //剑指 Offer 40. 最小的k个数
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k+1);
    }



    //剑指 Offer 42. 连续子数组的最大和
    /**
     *输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     *
     */
    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int tempsum=nums[0];
        int maxsum=nums[0];
        for(int i=1;i<nums.length;i++){
            tempsum=Math.max(tempsum+nums[i], nums[i]);
            maxsum=Math.max(maxsum,tempsum);
        }
        return maxsum;
    }

    //剑指 Offer 50. 第一个只出现一次的字符
    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * @param s
     * @return
     */
//    public char firstUniqChar(String s) {
//        HashMap<Character,Boolean> dict=new HashMap<Character, Boolean>();
//        for(char c: s.toCharArray()){
//            dict.put(c,!dict.containsKey(c));
//        }
//        for(char c: s.toCharArray()){
//            if(dict.get(c)){
//                return c;
//            }
//        }
//        return ' ';
//    }

    /**
     * 用linkedeHashMap实现有序哈希表，第二次只需遍历dict，而非s
     */
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }

    //剑指 Offer 52. 两个链表的第一个公共节点
    /**
     * 输入两个链表，找出它们的第一个公共节点。
     *自己的解法，遍历A，B，求出其长度的差距。
     * 让长的那个先走gap步的距离，再判断两个node是否相等然后返回
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode node=null;
        ListNode temp=null;
        if(headA==null||headB==null){
            return node;
        }
        int lengthA=0;
        int lengthB=0;
        for(temp=headA;temp!=null;temp=temp.next){
            lengthA++;
        }
        for(temp=headB;temp!=null;temp=temp.next){
            lengthB++;
        }
        int gap=lengthA-lengthB;
        if(gap==0){
            while(headA!=null&&headB!=null){
                if(headA.equals(headB)){
                    return headA;
                }else {
                    headA=headA.next;
                    headB=headB.next;
                }
            }
            return null;
        }
        else if(gap>0){
            while(gap>0){
                headA=headA.next;
                gap--;
            }
            while(headA!=null&&headB!=null){
                if(!headA.equals(headB)){
                    headA=headA.next;
                    headB=headB.next;
                }else return headA;
            }
            return null;
        }
        else {
            while(gap<0){
                headB=headB.next;
                gap++;
            }
            while(headA!=null&&headB!=null){
                if(!headA.equals(headB)){
                    headA=headA.next;
                    headB=headB.next;
                }else return headA;
            }
            return null;
        }
    }

    /**
     *最优解答：
     * 假设A单独长的部分为a，B单独长的部分为b，共同长度为c
     * 从A开始遍历到结尾再从B出发走到node共走a+c+b步
     * 从B开始遍历到结尾再从A出发走到node共走b+c+a步
     * a+c+b==b+c+a
     * 若此时有共同节点，则返回，若无则返回null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA;
        ListNode B=headB;
        while (A!=B){
            A= A!=null? A.next: headB;
            B= B!=null? B.next:headA;
        }
        return A;
    }




    //剑指 Offer 53 - I. 在排序数组中查找数字 I
    /**
     * 统计一个数字在排序数组中出现的次数。
     * @param nums
     * @param target
     * @return
     */
//    public int search(int[] nums, int target) {
//        int count=0;
//        for(int i=0;i<nums.length;i++){
//            if(target<nums[i]){
//                break;
//            }
//            if(nums[i]==target){
//                count ++;
//            }
//        }
//        return count;
//    }
//

    /**
     * 二分查找边界
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        return binaryHelper(nums,target)-binaryHelper(nums,target-1);
    }
    int binaryHelper(int[] nums, int target){
        int i=0,j=nums.length-1;
        while (i <= j) {
            int mid=(j+i)/2;
            if(nums[mid]<=target){
                i=mid+1;
            }
            else
                j=mid-1;
        }
        return i;
    }


    //剑指 Offer 53 - II. 0～n-1中缺失的数字
    /**
     *
     一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * @param nums
     * @return int
     * 二分查找下标
     *
     */

    public int missingNumber(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid=(j+i)/2;
            if (mid==nums[mid]){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return i;

    }

    //剑指 Offer 54. 二叉搜索树的第k大节点
    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     *
     * 注意是第k大，非第k小
     */
    int i=0;
    int ret;
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k);
        return ret;
    }
    private void dfs(TreeNode node,int k){
        if(node==null||i==k){
            return ;
        }
        dfs(node.right,k);
        if(++i==k){
            ret=node.val;
            return;
        }
        dfs(node.left,k);
    }


    //剑指 Offer 55 - I. 二叉树的深度
    public int maxDepth(TreeNode root) {
        if(root!=null){
            return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
        }
        else {
            return 0;
        }
    }

    //剑指 Offer 55 - II. 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        return recur(root) !=-1;
    }
    public int recur(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=recur(root.left);
        if(left==-1) return -1;
        int right=recur(root.right);
        if(right==-1) return -1;
        return Math.abs(left-right)<2 ? Math.max(left,right)+1 : -1;
    }


    //剑指 Offer 57. 和为s的两个数字
    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
     * 如果有多对数字的和等于s，则输出任意一对即可。
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ret=new int[2];
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]>target){
                j--;
            }
            else if(nums[i]+nums[j]<target){
                i++;
            }
            else {
                ret[0]=nums[i];
                ret[1]=nums[j];
                break;
            }
        }
        return ret;
    }

    //剑指 Offer 57 - II. 和为s的连续正数序列
    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
     * 滑动窗口
     */
    public int[][] findContinuousSequence(int target) {
        int i=1;
        int j=1;
        int sum=0;
        List<int[]> res=new ArrayList<>();
        while(i<=target/2){
            if(sum<target){
                sum +=j;
                j++;
            }else if(sum>target){
                sum -=i;
                i++;
            }else{
                int[] arr=new int[j-i];
                for(int k=i;k<j;k++){
                    arr[k-i]=k;
                }
                res.add(arr);
                sum -=i;
                i++;
            }

        }
        return res.toArray(new int[res.size()][]);
    }


    //剑指 Offer 58 - I. 翻转单词顺序
    /**
     * 输入一个英文句子，翻转句子中单词的顺序，
     * 但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理
     */
    public String reverseWords(String s) {
        s=s.trim(); //去除开头和结尾的空格
        int j=s.length()-1,i=j;
        StringBuilder ret=new StringBuilder();
        while(i>=0){
            while(i>=0&&s.charAt(i)!=' '){//用i搜索单词
                i--;
            }
            ret.append(s.substring(i+1,j+1)+" ");//添加单词并添加空格
            while(i>=0&&s.charAt(i)==' '){//用i跳过空格
                i--;
            }
            j=i;
        }
        return ret.toString().trim();//将StringBuilder转换成string并且去除开头结尾的空格
    }


    //剑指 Offer 58 - II. 左旋转字符串

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        String ret="";
        for(int i=n;i<s.length();i++){
            ret=ret+s.charAt(i);
        }
        for(int i=0;i<n;i++){
            ret=ret+s.charAt(i);
        }
        return ret;

    }

    //剑指 Offer 61. 扑克牌中的顺子
    /**
     * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，
     * 即这5张牌是不是连续的。2～10为数字本身，
     * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
     * A 不能视为 14。
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        /**
         * 此题解题充分条件：max-min<5 且无重复元素
         */
        HashSet<Integer> num=new HashSet<>();
        int min=14;
        int max=0;
        for(int i:nums){
            if(i==0){//若i为大小王则跳过
                continue;
            }
            min=Math.min(min,i);
            max=Math.max(max,i);
            if(num.contains(i)){//若有重复元素则返回false
                return false;
            }
            num.add(i);
        }
        return max-min<5;
    }

    //剑指 Offer 65. 不用加减乘除做加法
    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
     */
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 转换成非进位和 + 进位
        return add(a ^ b, (a & b) << 1);
    }

    //剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 搜索树的特点为左小右大
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 迭代
         */
        while(root!=null){
            if(root.val>p.val&&root.val>q.val){//p,q都在搜索树root的左边
                root=root.left;
            }
            else if(root.val<p.val&&root.val<q.val){//p,q都在root右边
                root=root.right;
            }
            else break;
        }
        return root;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 递归
         */
        if(root.val>p.val&&root.val>q.val){//p,q都在搜索树root的左边
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val<p.val&&root.val<q.val){//p,q都在root右边
           return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }




    //剑指 Offer 68 - II. 二叉树的最近公共祖先
    //https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root; //如果树为空或者p，q为root则直接返回
        TreeNode left=lowestCommonAncestor(root.left,p,q); //遍历左子树，先找到排p或q则先返回哪一个
        TreeNode right=lowestCommonAncestor(root.right,p,q);//遍历右子树，先找到排p或q则先返回哪一个
        if(left==null) return right;//若左子树中不包括p或者q则返回右子树，右子树中先遍历到的那一个必定为最近公共祖先
        if(right==null) return left;//若左子树不为空，若右子树为空则p，q必定同在左子树中，左子树中先遍历到的那一个必定为最近公共祖先
        return root;//若左右子树都不为空则p，q分别在root的左右两侧，则root为最近公共祖先
    }










    /**
     *
     * 记得有mod
     * @param  n
     * @return int
     */
    public int fib(int n) {
        if(n<2){
            return n;
        }
        int f=0;
        int s=1;
        int target=1;
        final int MOD = 1000000007;
        for(int i=2;i<=n;i++){
            target=(f+s)%MOD;
            f=s;
            s=target;
        }
        return target;
    }







}