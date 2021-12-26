package interview;



import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class topeasy {
    public static void main(String[] args){
        topeasy t=new topeasy();
        System.out.println(t.isValidTwo("()"));

    }



    //70. Climbing Stairs
    public int climbStairs(int n) {
        if(n<=2)return n;
        int ret=0;
        int prev1=1,prev2=2;
        for(int i=3;i<=n;i++){
            ret=prev1+prev2;
            prev1=prev2;
            prev2=ret;
        }
        return ret;
    }
    public int climbStairsRecursion(int n) {
        if(n<=2)return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    //53. Maximum Subarray
    //DP
    public int maxSubArray(int[] nums) {
        int pre=0,max=nums[0];
        for(int i:nums){
            pre=Math.max(i+pre,i);
            max=Math.max(pre,max);
        }
        return max;
    }
    //brute force
    public int maxSubArraybad(int[] nums) {
        int max=nums[0];
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int tempmax=nums[i];
            temp[i]=nums[i];
            for(int j=i+1;j<nums.length;j++){
                tempmax=tempmax+nums[j];
                if(tempmax>temp[i]){
                    temp[i]=tempmax;
                }
            }
            if(temp[i]>max) max=temp[i];
        }
        return max;
    }

    //21. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return  list1;
        if(list1.val<= list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

//    20. Valid Parentheses
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        Stack<Character> content=new Stack<>();
        //hashmap initialize
        HashMap<Character,Character> dict=new HashMap<>(){
            {
                put(')', '(');
                put('}','{');
                put(']','[');
            }
        };
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(dict.containsKey(ch)){
                if(content.isEmpty()||content.peek()!=dict.get(ch)){
                    return false;
                }
                content.pop();
            }else {
                content.push(ch);
            }
        }
    return content.empty();
    }

    public boolean isValidTwo(String s) {
        while (s.contains("()")||s.contains("{}")||s.contains("[]")){
            if(s.contains("()")){
                s=s.replace("()","");
            }
            if(s.contains("{}")){
                s=s.replace("{}","");
            }
            if(s.contains("[]")){
                s=s.replace("[]","");
            }
        }
        return s.length()==0;
    }




}
