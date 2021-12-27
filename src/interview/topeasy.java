package interview;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class topeasy {
    public static void main(String[] args){
        topeasy t=new topeasy();
        System.out.println();

    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetricSubTree(root.left,root.right);
    }
    public boolean isSymmetricSubTree(TreeNode left,TreeNode right){
        if (left==null&&right==null) return true;
        if(left==null||right==null) return false;
        return (left.val==right.val)&&isSymmetricSubTree(left.left,right.right)&&isSymmetricSubTree(left.right,right.left);
    }



    //94. Binary Tree Inorder Traversal
    List<Integer> tree=new ArrayList<>();
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        if(root==null){
           return tree;
        }
        inorderTraversal(root.left);
        tree.add(root.val);
        inorderTraversal(root.right);
        return tree;
    }

    /**
     * 不使用全局变量的方法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        return inorder(root, res);
    }
    public List<Integer> inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
        return res;
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
