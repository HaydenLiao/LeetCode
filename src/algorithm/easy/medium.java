package algorithm.easy;

public class medium {
    public static void main(String[] args){
        medium t=new medium();
        String v1="1.01";
        String v2="1.001";
        System.out.println(t.compareVersion(v1,v2));

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
        int[] v1=convertCompareVersion(version1);
        int[] v2=convertCompareVersion(version2);
        int distance=Math.abs(v1.length-v2.length);
        int l=0;
        boolean v1longer=false;
        boolean equal=false;
        if(v1.length>v2.length){
            l=v1.length;
            v1longer=true;
        }
        else
            l=v2.length;
        int[] temp=new int[l];
        if(v1longer==true){
            for(int i=0;i<v2.length;i++){
                temp[i]=v2[i];
            }
        }
        else if(l==v2.length&&l==v1.length){
            equal=true;
        }
        else if(v1longer==false&&equal==false){
            for(int i=0;i<v1.length;i++){
                temp[i]=v1[i];
            }
        }

        for(int i=0;i<l;i++){
            if(v1longer==true){
                if(v1[i]>temp[i]){
                    return 1;
                }else if(v1[i]<temp[i]){
                    return -1;}
            }
            else if(v1longer==false&&equal==true){
                if(v1[i]>v2[i]){
                    return 1;
                }else if(v1[i]<v2[i]){
                    return -1;
                }
            }
            if(v1longer==false&&equal==false){
                if(temp[i]>v2[i]){
                    return 1;
                }else if(temp[i]<v2[i]){
                    return -1;
                }
            }
        }

        return 0;

    }
    public int[] convertCompareVersion(String version){
        /**
         * String.split 分割特殊字符需要转义
         */
        String[] stringarr=version.split("\\.");
        int[] arr=new int[stringarr.length];
        for(int i=0;i<stringarr.length;i++){
            arr[i]=Integer.parseInt(stringarr[i]);
        }
        return arr;
    }

}
