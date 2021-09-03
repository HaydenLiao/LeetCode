package algorithm.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class medium {
    public static void main(String[] args){
        medium t=new medium();
        String v1="1.01";
        String v2="1.001";
        System.out.println(t.compareVersion(v1,v2));

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
