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
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i=t.maxSubArray(nums);
        System.out.println(i);

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