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
        System.out.println(t.fib(5));

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


    public ListNode getKthFromEnd(ListNode head, int k) {
        /**
         * ListNode head=new ListNode(1);
         *         ListNode n=head;
         *         head.next=new ListNode(2);
         *         head=head.next;
         *         head.next=new ListNode(3);
         *         head=head.next;
         *         head.next=new ListNode(4);
         *         head=head.next;
         *         head.next=new ListNode(5);
         *         head=head.next;
         *         head.next=new ListNode(6);
         *         int k=4;
         *         ListNode tar=t.getKthFromEnd(n,k);
         *         System.out.println(tar.val);
         */
        int n=0;
        ListNode target=null;
        for(target=head;target!=null;target=target.next){
            n++;
        }
        for(target=head;n>k;n--){
            target=target.next;
        }
        return target;
    }




}