package algorithm.easy;

import java.util.HashMap;

public class easy {
    public static void main(String[] args){

        System.out.println("hello world");
        easy t=new easy();
        t.test();
        int[] tw=new int[]{2,3};
        int[] ret=t.twoSum(new int[]{3,2,4}, 6);
        for(int c: ret){
            System.out.println(c);
        }

    }
    public int test(){
        System.out.println("hi");
        return 1;
    }

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
