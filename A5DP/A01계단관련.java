package A5DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A01계단관련 {
    public static void main(String[] args) throws IOException {
//        멀리 뛰기 : 프로그래머스
//        int n = 11;
////        n번째 자리의 경우의 수는 n-1번째의 경우의 수와 n-2번째 경우의 수의 합
//        int[] dp = new int[n+1];
//        if(n==1) dp[1]=1;
//        dp[1] = 1;
//        dp[2] = 2;
//        for(int i=3;i<dp.length;i++){
//            dp[i]=(dp[i-1]%1234567+dp[i-2]%1234567)%1234567;
//        }
//        System.out.println(Arrays.toString(dp));
//        계단 오르기 : 백준
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr =new int[N+1];
        int[] dp=new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(N==1) System.out.println(arr[1]);
        else if(N==2) System.out.println(arr[1]+arr[2]);
        else{
            dp[1]=arr[1]; dp[2] = arr[1]+arr[2];
//            dp[n] = max(dp[n-2]+arr[n], dp[n-3]+arr[n-1]+arr[n])
            for(int i=3;i<=N;i++){
                dp[i]=Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]);
            }
            System.out.println(dp[N]);
        }

    }
}