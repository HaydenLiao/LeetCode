package basic;

public class sort {
    public static void main(String[] args){
        sort s=new sort();
        int[] nums=new int[]{1,4,2,9,5};
        s.quickSort(nums,0,nums.length-1);
        for(int i:nums){
            System.out.println(i);
        }

    }


    /**
     * 快速排序
     *  average time complexity is O(nlogn)
     *  worst time complexity is O(n^2)
     * https://blog.csdn.net/weixin_42643931/article/details/107430790
     */
    public void quickSort(int[] nums, int low,int high){
        if(nums.length<=0){
            return;
        }
        if(low>=high){
            return;
        }
        int left=low;
        int right=high;
        int temp=nums[left];
        while(left<right){
            while(left<right && nums[right]>=temp){
                right--;
            }
            nums[left]=nums[right];
            while(left<right && nums[left]<=temp){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=temp;
        quickSort(nums,low,left-1);
        quickSort(nums,left+1,high);
    }

}
