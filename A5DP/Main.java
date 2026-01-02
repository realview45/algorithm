package A5DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][]triangle = new int[n][];
        for(int i=0;i<n;i++) {
            var strA = br.readLine().split(" ");
            triangle[i]=new int[strA.length];
            for(int j=0;j<strA.length;j++) {
                triangle[i][j] = Integer.parseInt(strA[j]);
            }
        }
        int answer = 0;
        int[] dp2 = new int[1];
        //3) 이를 층마다 반복한다.
        for(int i=0;i<triangle.length;i++){
            int[] dp = new int[triangle[i].length];
            for(int j=0;j<triangle[i].length;j++){
                if(j==0){//1-1단, 맨 왼쪽이나 오른쪽 값이라면 왼쪽값,
                    dp[j]=triangle[i][j] + dp2[j];
                }//1-1오른쪽값이 없으므로 있는 dp배열에 더해준다.
                else if(j==triangle[i].length-1){
                    dp[j]=triangle[i][j] + dp2[j-1];
                }
                else {//1각 층마다 그 크기만큼의 dp를 만들고 윗값의 dp2값(두가지 값 중에 큰값)과 자신을 더한 수를 dp배열(그층 까지의 최대값)에 저장한다.
                    dp[j]=triangle[i][j] + Math.max(dp2[j-1],dp2[j]);
                }
                answer = Math.max(answer, dp[j]);
            }
            //2) dp값들을 dp2값에 저장해준다.
            dp2 = Arrays.copyOf(dp,dp.length);
        }
        System.out.println(answer);
    }
}
