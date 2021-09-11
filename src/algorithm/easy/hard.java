package algorithm.easy;

public class hard {
    public static void main(String[] args){
        hard t=new hard();
//        t.findIntegers(3);
        System.out.println(t.findIntegers(5));

    }



    //Q600. Non-negative Integers without Consecutive Ones
    /**
     * Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.
     */
    public int findIntegers(int n) {
        int count=0;
        boolean consecutive=false;
        for(int i=0;i<=n;i++){
            consecutive=convertAndCheck(i);
            if(consecutive==true){
                count++;
            }
        }
        return n+1-count;
    }

    public boolean convertAndCheck(int n){
        String binaryString= "";
        int count=0;
        while(n!=0){
            binaryString= n%2+binaryString;
//            System.out.println(binaryString);
            n = n/2;
            count++;
            if(count>1){
                boolean b1=binaryString.charAt(0)=='1';
                boolean b2=binaryString.charAt(1)=='1';
//                System.out.println(b1&&b2);
                if(b1&&b2){
                    return true;
                }
            }
        }
//        System.out.println(binaryString);
        return false;
    }


}
