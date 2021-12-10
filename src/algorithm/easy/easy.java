package algorithm.easy;

import javax.swing.tree.TreeNode;
import java.util.*;


//single-linked list
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


public class easy {
    public static void main(String[] args){

        easy t=new easy();
        int[][] s= new int[][]{{1,2,10},{2,3,20},{2,5,25}};
        int n=5;

        int[] ans=t.corpFlightBookings(s,n);
        for(int i:ans){
            System.out.println(i);
        }

//        System.out.println(t.longestPalindrome(needle));

    }

    //88. 合并两个有序数组
    /**
     * 合并两个已经排序好的数组，使其合并之后仍然按照非递减顺序排列
     * 要求是在O(m+n)时间内完成
     * 第一思路：双指针,额外长度为o(m+n)的数组辅助
     * 升级题解思路：逆向双指针，这样就不需要多余的空间
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=nums1.length-1;
        int i=m-1;
        int j=n-1;
        while(k>=0){
            if(j>=0){
                if(i<0|| nums1[i]<nums2[j]){  //当i<0时无需再继续循环，nums1剩下的数字已经排好序了
                    nums1[k]=nums2[j];
                    j--;
                }else{
                    nums1[k]=nums1[i];
                    i--;
                }
                k--;
            }
            else break;
        }
    }




    //Question 1109.Corporate Flight Bookings
    /**
     * There are n flights that are labeled from 1 to n.
     *
     * You are given an array of flight bookings bookings, where bookings[i] = [firsti, lasti, seatsi] represents a booking for flights firsti through lasti (inclusive) with seatsi seats reserved for each flight in the range.
     *
     * Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.
     * eg:
     * Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
     * Output: [10,55,45,25,25]
     * Explanation:
     * Flight labels:        1   2   3   4   5
     * Booking 1 reserved:  10  10
     * Booking 2 reserved:      20  20
     * Booking 3 reserved:      25  25  25  25
     * Total seats:         10  55  45  25  25
     * Hence, answer = [10,55,45,25,25]
     *
     */
//    int[][] s= new int[][]{{1,2,10},{2,3,20},{2,5,25}};
//    int n=5;
    public int[] corpFlightBookings(int[][] bookings, int n) {
        /**
         * 第一遍解法：暴力遍历
         */
        int[] ans=new int[n];
        for(int i=0;i<bookings.length;i++){
            for(int j=bookings[i][0];j<=bookings[i][1];j++){
                ans[j-1]=ans[j-1]+bookings[i][2];
            }
        }
        return ans;
    }



    //Question 1480. Running Sum of 1d Array
    /**
     * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
     *
     * Return the running sum of nums.
     *
     * Input: nums = [1,2,3,4]
     * Output: [1,3,6,10]
     * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
     *
     * 自己的解法就是一位数组遍历，但是用了新数组进行储存，最好的方法是直接在原数组上进行修改返回
     */
//    public int[] runningSum(int[] nums) {
//        int[] runningSum=new int[nums.length];
//        runningSum[0]=nums[0];
//        for(int i=1;i<nums.length;i++){
//            runningSum[i]=runningSum[i-1]+nums[i];
//        }
//        return runningSum;
//    }
    public int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i];
        }
        return nums;
    }




    //Question 1588. Sum of All Odd Length Subarrays--------------------------------------------
    /**
     * Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
     *
     * A subarray is a contiguous subsequence of the array.
     *
     * Return the sum of all odd-length subarrays of arr.
     *
     */
//    int[] arr=new int[]{1,4,2,5,3};//Q1588
//    System.out.println(t.sumOddLengthSubarrays(arr));//Q1588---output:58

    public int sumOddLengthSubarrays(int[] arr) {
        int sum=0;
        int tempsum=0;
        int count=1;
        int[] temparr=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            temparr[i]=arr[i];
            sum=sum+arr[i];
        }
        while(count<=arr.length){
//            System.out.println(count);
            point:for(int i=0;i<arr.length-2;i++){
                if(i+2+count>arr.length){
                    break;
                }
                    tempsum=temparr[i]+arr[i+1+count-1]+arr[i+2+count-1];
                    temparr[i]=tempsum;
//                    System.out.println("temparr["+i+"]="+temparr[i]);
                    sum=sum+temparr[i];
//                    System.out.println(sum);
                    tempsum=0;
            }
//            System.out.println(count);

            count=count+2;
        }

        return sum;
    }




    /**
     * 4. 寻找两个正序数组的中位数
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空
     * @param nums1
     * @param nums2
     * @return double
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;
    }


    /**
     * 5. 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * @param s
     * @return string
     */
    public String longestPalindrome(String s) {
        if(s.length()<2)
            return s;
        String ret ="";

        int l=0;
        int r=0;
        for(int i=0;i<s.length()-1;i++){
            String temp=""+s.charAt(i);
            l=i;
            r=i+1;
            while(l>=0&&r<=s.length()-1){
                if(s.charAt(l)==s.charAt(r)){
                    l--;
                    r++;
                }
                else break;
            }
            temp=s.substring(l+1,r).length()>temp.length()?s.substring(l+1,r):temp;
            if(i>0){
                l=i-1;
                r=i+1;
                while(l>=0&&r<=s.length()-1){
                    if(s.charAt(l)==s.charAt(r)){
                        l--;
                        r++;
                    }
                    else break;
                }
                temp=temp.length()>=s.substring(l+1,r).length()?temp:s.substring(l+1,r);
            }
         ret=ret.length()>=temp.length()?ret:temp;
        }
        return ret;
    }



    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param s
     * @return int
     */
    public int lengthOfLongestSubstring(String s) {
        //时间复杂度O(n),空间复杂度O(n)(s中字母集的大小）
        //滑动窗口，将未重复字母加到set中并且右指针右移且更新ret值
        //当下一字母重复时，删除上一字符并重复检验
        int ret=0;
        Set<Character> temp=new HashSet<>();
        int end=-1;
        for(int i=0;i<s.length();i++){
            if(i!=0){
                temp.remove(s.charAt(i-1));
            }
            while (end+1<s.length()&&!temp.contains(s.charAt(end+1))){
                temp.add(s.charAt(end+1));
                end++;
            }
            ret=Math.max((end-i+1),ret);
        }
        return ret;
    }
//    public int lengthOfLongestSubstring(String s) {
//        //暴力解法
//        //时间复杂度O(n^2),空间复杂度O(n)
//        //可使用左右指针遍历，将时间复杂度降低到O(n)
//        //最后寻找窗口最大值也可以在一变循环中找出，无需额外比较
//        int ret=0;
//        Set<Character> temp=new HashSet<>();
//        int[] len=new int[s.length()];
//        for(int i=0;i<s.length();i++){
//            temp.add(s.charAt(i));
//            for(int j=i+1;j<s.length();j++){
//                if(temp.contains(s.charAt(j))){
//                    break;
//                }
//                else{
//                    temp.add(s.charAt(j));
//                }
//            }
//            len[i]=temp.size();
//            temp.clear();
//        }
//        for(int i=0;i<len.length;i++){
//            ret=Math.max(ret,len[i]);
//        }
//        return ret;
//    }


    /**
     * 辅助打印链表,与2.两数相加一起使用
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ListNode temp = listNode;
        while(temp != null){
            a.add(new Integer(temp.val));
            temp = temp.next;
        }
        Integer b ;
        for(int i=0; i<a.size()/2;i++){
            b = a.get(i);
            a.set(i, a.get(a.size()-i-1));
            a.set(a.size()-i-1,b);
        }
        return a;
    }


    /**
     * 2. 两数相加
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * @param l1
     * @param l2
     * @return linked-list
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //测试用例
        /**ListNode l1=new ListNode(9);
         ListNode l2=new ListNode(8);
         ListNode p=t.addTwoNumbers(l1,l2);
         System.out.println(t.printListFromTailToHead(p));
         */
        //时间复杂度O(max(m,n)),空间复杂度O(max(m,n))
        ListNode dummyHead = new ListNode(0);
        ListNode cur=dummyHead;
        int carry=0;          //carry:进位
        while(l1!=null||l2!=null){
            int p=l1!=null? l1.val : 0;//三元表达式
            int q=l2!=null? l2.val : 0;
            int sum=p+q+carry;
            cur.next=new ListNode(sum%10);
            carry=sum/10;
            cur=cur.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(carry>0){
            cur.next=new ListNode(carry);
        }
        return dummyHead.next;
    }




    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @param n
     * @return int
     */
    public int climbStairs(int n) {
        //时间复杂度O(n),空间复杂度O(1)
        //注意n=0时fn=1
        /*
        ！！！！！！！！！！！！！！！！！！！
        此处仍有两种方法未掌握，快速矩阵幂解法没看懂
         */
        int fn=0;
        int fn1=2;
        int fn2=1;
        if(n==1) return 1;
        if(n==2) return 2;
        int count=3;
        while(count<=n){
            fn=fn1+fn2;
            fn2=fn1;
            fn1=fn;
            count++;
        }
        return fn;
    }


    /**
     *69. x 的平方根
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     */
    public int mySqrt(int x) {
        //
        if(x==1) return 1;
        double xi=x;
        while (true){
            double xi1=(xi+x/xi)/2;
            if(Math.abs(xi1 - xi) < 1e-7){
                break;
            }
            xi=xi1;
        }
        return (int) xi;
    }

    /**
     * 58. 最后一个单词的长度
     给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
     如果不存在最后一个单词，请返回 0 。
     * @param s
     * @return int
     */
    public int lengthOfLastWord(String s) {
        //从左向右遍历（可用从右向左遍历，更省时间）
        //时间复杂度O(n),空间复杂度O(1)
        int loc=0;
        int len=0;
        if(s.length()<1) return len;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                loc=i+1;
            }
            else{
                len=i-loc+1;
            }
        }
        return len;
    }





    /**
     * 53. 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 未包括分治法
     * @param nums
     * @return int
     */
    public int maxSubArray(int[] nums) {
        // 动态规划，按正序很难求，但是可以反向想，以nums[i]结尾的最大子序和必定为max{nums[i],nums[i]+f(i-1)
        //时间复杂度O(n)
        //空间复杂度O(n)
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int ret=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
        }
        for(int i=1;i<dp.length;i++){
            ret=Math.max(ret,dp[i]);
        }
        return ret;
    }

//    public int maxSubArray(int[] nums) {
//        /**
//         * 分治法
//         */
//        return 0;
//    }




//Question 38--------------------------------------------
    public String countAndSay(int n) {
        /**
         *38. 外观数列
         * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
         * 使用递归
         * 时间复杂度O(n^2)
         * 空间复杂度O(1)
         */
        String s="1";
        if(n==1) return s;
        while (n>1){
            s=countAndSay(n-1);
            String ini="";
            int count=1;
            int j=0;
            for(int i=1;i<s.length();i++){
                if(s.charAt(i)==s.charAt(j)){
                    count++;
                }
                else{

                    ini=ini+count+s.charAt(j);
                    j=i;
                    count=1;
                }
            }
            ini=ini+count+s.charAt(s.length()-1);
            return ini;

        }
        return s;
    }

//    public String countAndSay(int n) {
//        /**
//         * 38. 外观数列
//         * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
//         * 使用helper
//         * 时间复杂度O(n^2)
//         * 空间复杂度O(1)
//         */
//        String ret="1";
//        if(n==1) return ret;
//        while (n>1){
//            ret=countAndSay_helper(ret);
//            n--;
//        }
//        return ret;
//    }
//
//    public String countAndSay_helper(String s){
//        String ret="";
//        int count=1;
//        int j=0;
//        for(int i=1;i<s.length();i++){
//            if(s.charAt(i)==s.charAt(j)){
//                count++;
//            }
//            else{
//
//                ret=ret+count+s.charAt(j);
//                j=i;
//                count=1;
//            }
//        }
//        ret=ret+count+s.charAt(s.length()-1);
//        return ret;
//    }

//Question 27--------------------------------------------
    public int removeElement(int[] nums, int val) {
        /**
         * 27. 移除元素
         * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
         * 时间复杂度O(n)
         * 空间复杂度O(1)
         */
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }

//    public int removeElement(int[] nums, int val) {
//        /**
//         * 27. 移除元素
//         * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//         * 时间复杂度O(n)
//         * 空间复杂度O(1)
//         */
//        int i=0;
//        int n=nums.length-1;
//        while(i<=n){
//            if(nums[i]==val){
//                nums[i]=nums[n];
//                n--;
//            }
//            else
//                i++;
//
//        }
//        return i;
//    }



//Question 35---------------------------------------------
    public int searchInsert(int[] nums, int target) {
        /**
         * 搜索插入位置
         * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
         * 二分法
         * 时间复杂度O(log(n))
         * 空间复杂度O(1)
         */
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target>nums[mid]){
                l=mid+1;
            }
            else
                r=mid-1;
        }
        return l;
    }

//    public int searchInsert(int[] nums, int target) {
//        /**
//         * 搜索插入位置
//         * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//         * 时间复杂度O(n)
//         * 空间复杂度O(1)
//         */
//        if(nums.length<1){
//            return 0;
//        }
//        for(int i=0;i<nums.length;i++){
//            if(target<nums[i]||target==nums[i]){
//                return i;
//            }
//        }
//        return nums.length;
//    }

//Question 28---------------------------------------------
    public int strStr(String haystack, String needle) {
        /**
         * 实现 strStr() 函数。
         * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
         *
         * 时间复杂度O(n)
         * 空间复杂度O(1)
         */
        if(needle.length()<1) return 0;
        if(haystack.length()<1) return -1;
        int needle_len=needle.length();
        for(int i=0;i<haystack.length()+1-needle_len;i++){
            if((haystack.charAt(i)==needle.charAt(0))&&haystack.substring(i,i+needle_len).equals(needle)){
                return i;
            }
        }
        return -1;
    }

//Question 26---------------------------------------------
    public int removeDuplicates(int[] nums) {
        /**
         * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
         * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
         * 时间复杂度O(n)
         * 空间复杂度O(1)
         * 双指针，自己的写法用了三指针，因为i++之后指向的是新的未重复元素，可省略insert这一指针
         */
        if(nums.length<2) return nums.length;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
//    public int removeDuplicates(int[] nums) {
//        /**
//         * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//         * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//         * 时间复杂度O(n)
//         * 空间复杂度O(1)
//         */
//        if(nums.length<2) return nums.length;
//        int tag1=0;
//        int tag2=1;
//        int insert=0;
//        while(tag2<nums.length){
//            if(nums[tag1]==nums[tag2]){
//                tag1=tag2;
//                tag2++;
//            }
//            else{
//                insert++;
//                nums[insert]=nums[tag2];
//                tag1=tag2;
//                tag2++;
//
//            }
//        }
//        return insert+1;
//    }


//Question 14---------------------------------------------
    public String longestCommonPrefix(String[] strs) {
        /**
         * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 "".
         * 此题注意字符串比较用.equals（）
         * 时间复杂度O(nm)
         * 空间复杂度O(1)
         */
        String ret="";
        if(strs.length<1) return ret;
        String first=strs[0];
        String temp="";
        fi:for(int i=1;i<strs[0].length()+1;i++){
            temp=strs[0].substring(0,i);
            for(int j=1;j<strs.length;j++){
                if(i>strs[j].length()||!strs[j].substring(0,i).equals(temp)){
                    break fi;
                }
                else
                    continue ;
            }
            ret=temp;
        }
        return ret;
    }

//Question 20---------------------------------------------
    public boolean isValid(String s) {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 注意空字符串可被认为是有效字符串。
     * 最好使用hashmap进行配对，不然对于多对匹配情况会非常麻烦
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     */
    if(s.length()<1) return true;
    boolean ret=false;
    HashMap<Character,Character> pair=new HashMap<>(){{
        put('(',')');
        put('{','}');
        put('[',']');
    }};
    Stack<Character> temp= new Stack();
    for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(pair.containsKey(c)){
            temp.push(pair.get(c));
        }
        else if(!temp.empty()&&pair.containsValue(c)&&c==temp.peek()){
            temp.pop();
        }
        else
            return false;
    }
    return temp.empty();
    }
//    public boolean isValid(String s) {
//        /**
//         * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//         * 注意空字符串可被认为是有效字符串。
//         *
//         * 时间复杂度O(n)
//         * 空间复杂度O(n)
//         *
//         */
//        if(s.length()<1) return true;
//        boolean ret=false;
//        Stack<Character> temp= new Stack();
//        for(int i=0;i<s.length();i++){
//            char c=s.charAt(i);
//            if(c=='('||c=='{'||c=='['){
//                temp.push(s.charAt(i));
//            }
//            else if(!temp.empty()&&((c==')'&&temp.peek()=='(')||(c=='}'&&temp.peek()=='{')||(c==']'&&temp.peek()=='['))){
//                temp.pop();
//            }
//            else
//                return ret;
//        }
//        if(temp.empty()) ret=true;
//        return ret;
//    }





//Question 9----------------------------------------------
    public boolean isPalindrome(int x) {
        /**
         * Question 9
         * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
         *
         * 时间复杂度O(log10(x))
         * 空间复杂度O(1)
         */
        if(x<0 || (x%10==0)&&x!=0) return false;//x以0结尾必false
        int rev=0;
        int pop=0;
        while(x>rev){
            pop=x%10;
            rev=rev*10+pop;
            x=x/10;
        }
        if(rev==x || rev/10==x) return true;
        return false;
        /*反转整个数字
        easy t=new easy();
        if(x<0) return false;
        if(x==t.reverse(x)) return true;
        return false;
         */
    }



//Question 7------------------------------------------------
    public int reverse(int x) {
        /**
         *
         * Qustion 7
         *
         * 时间复杂度O(log10(x))
         * 空间复杂度O(1)
         *
         * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
         * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
         */
        int ret=0;
//        int max_value= (int) (Math.pow(2,31)-1);//2147483647
//        int min_value= (int) Math.pow(-2,31);//-2147483648
        int max_value= Integer.MAX_VALUE;
        int min_value= Integer.MIN_VALUE;
        while(x!=0){
            int pop=x%10;
            x=x/10;
            if(ret>max_value/10 ||((ret==max_value/10)&&x>7)) return 0;
            if(ret<min_value/10 ||((ret==min_value/10)&&x<-8)) return 0;ret=ret*10+pop;

        }
        return ret;
    }



//Question 1------------------------------------------------------
    public int[] twoSum(int[] nums, int target){
        /**
         * Question 1
         *给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
         * 一遍hashmap，时间复杂度为O（n）
         *
         * 下面有暴力法，时间复杂度为O（n^2)
         */
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(i==0){
                map.put(nums[i],i);
            }
            else{
                int res=(target-nums[i]);
                if(map.containsKey(res)){
                    return new int[]{map.get(res),i};
                }
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

//    public int[] twoSum(int[] nums, int target) {
//        /**
//         * Question 1
//         * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//         * You may assume that each input would have exactly one solution, and you may not use the same element twice.
//         */
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]>target){
//                continue;
//            }
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]+nums[j]==target){
//                    return new int[]{i,j};
//                }
//            }
//
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }


//    606. 根据二叉树创建字符串

    public String tree2str(TreeNode root) {
        return "";

}
//1005. K 次取反后最大化的数组和

    /**
     * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
     *
     * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
     * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
     *
     * 以这种方式修改数组后，返回数组 可能的最大和 。
     * @param nums
     * @param k
     * @return int
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);//先将nums进行排序
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0&&k>0){//按照最大负数开始，将其一一变为正数，加上最大值
                nums[i]=-1*nums[i];
                k--;
            }
            sum=sum+nums[i];
        }
        Arrays.sort(nums);//再次进行排序判断最小值
        return sum-(k%2==0 ? 0 : 2*nums[0]);//若此时k依旧有剩余，进行判断并减去二倍最小值
    }


}
