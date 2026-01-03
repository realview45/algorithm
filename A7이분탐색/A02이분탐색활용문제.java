package A7이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A02이분탐색활용문제 {
//    이분탐색문제는 이분탐색의 대상을 어떤것으로 설정할지가 핵심
    public static void main(String[] args) throws IOException {
//        예산 2512번 : 백준 =>상한액을 이분탐색 대상으로 선정. 계산한 값이 총예산보다 작거나 같으면 answer 세팅
//        과자나눠주기 : 백준 =>과자길이를 이분탐색의 대상으로 선정. 계산한 값이 조카의 사람수보다 크거나 같으면 answer 세팅
//        입국심사 : 백준

//        이분탐색의 대상 : 상한액
//        상한액에 대한 모든요청 <= 예산총액 일경우만 answer update
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        var strA = br.readLine().split(" ");
        int start=0;
        int end=0;
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(strA[i]);
            end = Math.max(end,arr[i]);
        }
        int m = Integer.parseInt(br.readLine());
        int answer =-1;
        while(start<=end){
            int mid = (start+end)/2;
            int sum=0;
            for(int i=0;i<n;i++){
                int num = Math.min(mid, arr[i]);
                sum+=num;
            }
            if(sum<m){
                start = mid+1;
                answer = mid;
            }
            else if(sum>m){
                end = mid-1;
            }
            else if(sum==m){
                answer = mid;
                break;
            }
        }
//        for(int i=0;i<=end;i++){
//            int total =0;
//            for(int j=0;j<arr.length;j++){
//                total += (arr[j] > i? i : arr[j]);
//            }
//            if(total<M){
//                answer = i;
//            }else if(total>M){
//
//            }else if(total==M){
//                answer = i;
//                break;
//            }
//            System.out.println(total);
//        }
//        System.out.println(answer);
        System.out.println(answer);
    }
}