package A5DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//이해못함아직
//배낭문제 : 여러개의 선택대상이 있고, 전체자원한도내에서 선택조합을 구성하여 최대값/최소값을 구하는 문제
public class A05배낭문제 {
//    주어진 데이터를 1번만 사용가능
//    평범한 배낭 - 백준, 벼락치기(14728) - 백준

//    주어진 데이터를 여러번 사용가능
//    호텔 - 백준
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strA = br.readLine().split(" ");

        int N = Integer.parseInt(strA[0]);
        int K = Integer.parseInt(strA[1]);
        int[][] arr=new int[N][2];
        int[] dp = new int[K+1];
        for(int i=0;i<N;i++){
            String[] strA2 = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(strA2[0]);
            arr[i][1] = Integer.parseInt(strA2[1]);
        }
//        //가방이 7개가있다 각 가방에 그때그때의 최대값 기록
//        //전체 대상 arr값을 가지고 최대값 확정
//        for(int i=0;i<arr.length;i++){
////            맨 끝에
//            //처음부터하면 마치 두번쓰인 것처럼
//            for(int j=K;j>=arr[i][0];j--){   //무게값 빼기
//                dp[j] = Math.max(dp[j],dp[j-arr[i][0]]+arr[i][1]);
//            }
//        }

        for(int i=0;i<arr.length;i++){
//            맨 끝에
            //처음부터하면 마치 두번쓰인 것처럼
            for(int j=arr[i][0];j<=K;j++){   //무게값 빼기
                dp[j] = Math.max(dp[j],dp[j-arr[i][0]]+arr[i][1]);
            }
        }
//
        System.out.println(Arrays.toString(dp));
    }
}
