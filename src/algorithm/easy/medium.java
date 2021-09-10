package algorithm.easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class medium{
    public static void main(String[] args){
        medium t=new medium();
        int[] chalk=new int[]{3,4,1,2};
        int k=27;
        System.out.println(t.chalkReplacer(chalk,k));
    }


    //Q1894. Find the Student that Will Replace the Chalk

    /**
     *https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
     *
     * @param chalk
     * @param k
     * @return
     */
    public int chalkReplacer(int[] chalk, int k) {
        long round=0;
        for(int i=0;i<chalk.length;i++){
            round=round+chalk[i];
        }
        k= (int) (k%round);
        for(int i=0;i<chalk.length;i++){
            if(k<chalk[i]){
                return i;
            }
            else
                k=k-chalk[i];
        }
        return 0;
    }



    //Q470. Implement Rand10() Using Rand7()
    /**
     * Given the API rand7() that generates a uniform random integer in the range [1, 7], write a function rand10() that generates a uniform random integer in the range [1, 10]. You can only call the API rand7(), and you shouldn't call any other API. Please do not use a language's built-in random API.
     *
     * Each test case will have one internal argument n, the number of times that your implemented function rand10() will be called while testing. Note that this is not an argument passed to rand10().
     *
     * 详解见：
     * https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/cong-zui-ji-chu-de-jiang-qi-ru-he-zuo-dao-jun-yun-/
     *
     * @return int
     */
    public int rand10() {
        while(true){
            int a=rand7();
            int b=rand7();
            int sum=(a-1)*7+b;//随机等概率生成1-49，即rand49
            if(sum<=40){
                return sum%10+1;//将1-40取余等概率返回1-10， 41-49拒绝采样
            }
            a=sum-40;//rand9
            b=rand7();
            sum=(a-1)*7+b;//rand63
            if(sum<=60){
                return sum%10+1;//将1-60取余等概率返回1-10， 61-63拒绝采样
            }
            a=sum-60;//rand3
            b=rand7();
            sum=(a-1)*7+b;//rand21
            if(sum<=20){
                return sum%10+1;//1-20等概率返回1-10，21拒绝采样
            }
        }

    }
    public int rand7(){
        Random random=new Random();
        return random.nextInt(7)+1;
    }



    //面试题 17.14. Smallest K LCCI
    /**
     * Design an algorithm to find the smallest K numbers in an array.
     * Input:  arr = [1,3,5,7,2,4,6,8], k = 4
     * Output:  [1,2,3,4]
     *
     * 此题可直接用Arrays.sort()进行排序后返回
     */

    public int[] smallestK(int[] arr, int k) {
        int[] ret=new int[k];
        Arrays.sort(arr);
        for(int i=0;i<k;i++){
            ret[i]=arr[i];
        }
        return ret;

    }




    //Q165. Compare Version Numbers
    /**
     * Given two version numbers,version1 and version2, compare them.
     *
     * Version numbers consist of one or more revisions joined by a dot'.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
     *
     * To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
     *
     * Return the following:
     *
     * If version1 < version2, return -1.
     * If version1 > version2, return 1.
     * Otherwise, return 0.
     */
//
//    String v1="1.01";
//    String v2="1.001";

    public int compareVersion(String version1, String version2) {
        /**
         * 官方解法版本，简化了额外储存string arr的空间
         * 分割需要注意转义字符
         */
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        for(int i=0;i<v1.length||i<v2.length;i++){
            int x=0;
            int y=0;
            if(i<v1.length){
                x=Integer.parseInt(v1[i]);
            }
            if(i<v2.length){
                y=Integer.parseInt(v2[i]);
            }
            if(x>y){
                return 1;
            }
            if(x<y){
                return -1;
            }
        }
        return 0;
    }
}
