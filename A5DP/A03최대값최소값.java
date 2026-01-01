package A5DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class A03최대값최소값 {
    //    TODO: RGB거리(백준)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][]dp= new int[3][n+1];//칠한집, 비용
        int[][]arr= new int[3][n+1];//색, 드는 비용
        for(int i=1;i<=n;i++){
            var strA = br.readLine().split(" ");
            arr[0][i] = Integer.parseInt(strA[0]);
            arr[1][i] = Integer.parseInt(strA[1]);
            arr[2][i] = Integer.parseInt(strA[2]);
        }
        for(int i=1;i<=n;i++){
            //각 집을 0,1,2의 색으로 칠한 것에 대한 최소비용
            dp[0][i]= arr[0][i] + Math.min(dp[1][i-1],dp[2][i-1]);
            dp[1][i]= arr[1][i] + Math.min(dp[0][i-1],dp[2][i-1]);
            dp[2][i]= arr[2][i] + Math.min(dp[0][i-1],dp[1][i-1]);
        }
        System.out.println(Math.min(dp[0][n],Math.min(dp[2][n],dp[1][n])));

//        TODO : 정수삼각형, 1932 프로그래머스  , 2096 내려가기(백준)
    }
}