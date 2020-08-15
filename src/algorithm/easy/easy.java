package algorithm.easy;

import java.util.HashMap;
import java.util.Stack;

public class easy {
    public static void main(String[] args){

        easy t=new easy();
        String s= "{{()}}";
        System.out.println(t.isValid(s));

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
}
