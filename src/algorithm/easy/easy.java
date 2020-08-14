package algorithm.easy;

import java.util.HashMap;

public class easy {
    public static void main(String[] args){

        easy t=new easy();
//        int[] tw=new int[]{2,3};
//        int[] ret=t.twoSum(new int[]{3,2,4}, 6);
//        for(int c: ret){
//            System.out.println(c);
//        }
        System.out.println(t.reverse(-325));
//        String s="assfefge";
//        System.out.println(s.substring(0,3));

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
         *
         * Question 1
         *
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
