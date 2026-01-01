package A5DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A04문자열수열 {
    public static void main(String[] args) throws IOException {
//        가장 긴 증가하는 부분 수열(11053) : 백준
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strA = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(strA[i]);
        }
        int[] dp =new int[N];
        dp[0]=1;
        for(int i=1;i<N;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    max = Math.max(dp[j]+1,max);
                }
            }
            dp[i]=max;
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
        //Arrays.sort(dp);
        //System.out.println(dp[N-1]);

//        TODO 가장 긴 증가하는 부분 수열4 : 백준(DP+역추적)
//        => 별도의 배열을 하나 더 만들어서, 직전의 값(index)을 기록.
    }
}
//역추적 문제들 더 풀어보기
//스프링 들어가긴 전까지 알고리즘
//후에 알고리즘 스터디 끝 혼자 풀어보기 토요일 두문제, 일요일 두문제