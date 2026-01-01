package A5DP;

import java.util.Arrays;

public class A02동전문제 {
    public static void main(String[] args) {
//        1,4,5원의 동전이 있을 때, 조합하여 13을 만들 수 있는 최소의 개수
        int[] arr = {1,4,5};
        int target = 13;
////        n원을 만드는 최소동전수 : min(dp[n-a], dp[n-b], dp[n-c])+1;
        //강사님코드
//        int[] dp = new int[target+1];
//        for(int i=1;i<=target;i++){
//            int min = Integer.MAX_VALUE;
//            for(int j=0;j<arr.length;j++){
//                if(i-arr[j]>=0 && dp[i-arr[j]] < min){
//                    min = dp[i-arr[j]];
//                }
//            }
//            dp[i] = min +1;
//        }
//        System.out.println(Arrays.toString(dp));

        //내코드
//        int[] dp=new int[target+1];
//        for(int i=1;i<=target;i++){
//            if(dp[i]==0)dp[i]=Integer.MAX_VALUE;
//            for(int j=0;j<arr.length;j++){
//                if(i-arr[j]>=0) {
//                    dp[i] = Math.min(dp[i],dp[i - arr[j]]+1);
//                }
//            }
//        }
//        System.out.println(Arrays.toString(dp));

//        1이 포함되지 않을 수 있고, target을 못 만들수도 있는 경우의 동전문제
//        TODO 동전2(2294) : 백준
    }
}
