//package A6투포인터;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
/// /정렬을 하면 안되는 경우
/// /start <= end의 조건
/// /start와 end가 같이 출발
//public class A03수열의범위 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        var strA = br.readLine().split(" ");
//        int n = Integer.parseInt(strA[0]);
//        long m = Long.parseLong(strA[1]);
//        long[] arr = new long[n];
//        var strA2 = br.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            arr[i] = Long.parseLong(strA2[i]);
//        }
//        int start = 0;
//        int end = 0;
//        long sum = arr[0];
//        long cnt = 0;
//        while (start <= end && end < arr.length) {
//            if(sum<m){
//                end++;
//                if(end<arr.length) sum+=arr[end];
//            }else {
//                if(sum==m) {cnt++;}
//                if(start==end){
//                    sum-=arr[start];
//                    start++;
//                    end++;
//                    if(end<arr.length) sum+=arr[end];
//                } else {
//                    sum-=arr[start];
//                    start++;
//                }
//            }
//        }
//        System.out.println(cnt);
//    }
//}
// 수들의합2(2003) : 백준
// 연속된부분수열의 합 : 프로그래머스


// x수열(2559) : 백준 n^2->n
package A6투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//정렬을 하면 안되는 경우
//start <= end의 조건
//start와 end가 같이 출발
public class A03수열의범위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var strA = br.readLine().split(" ");
        int n = Integer.parseInt(strA[0]);
        long m = Long.parseLong(strA[1]);
        long[] arr = new long[n];
        var strA2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(strA2[i]);
        }
        int start = 0;
        int end = 0;
        long sum = arr[start];
        long cnt = 0;
        while (start <= end && end < arr.length) {
            if (sum == m) {
                cnt++;
                end++;
                if (arr.length == end) break;
                sum += arr[end];
            } else if (sum < m) {
                end++;
                if (arr.length == end) break;
                sum += arr[end];
            } else if (sum > m) {
                sum -= arr[start];
                start++;
                if (start > end) {
                    end++;
                    if (arr.length == end) break;
                    sum += arr[end];
                }
            }
        }
//            if(sum<m){
//                end++;
//                if(end<arr.length) sum+=arr[end];
//            }else {
//                if(sum==m) {cnt++;}
//                if(start==end){
//                    sum-=arr[start];
//                    start++;
//                    end++;
//                    if(end<arr.length) sum+=arr[end];
//                } else {
//                    sum-=arr[start];
//                    start++;
//                }
//            }
        System.out.println(cnt);
    }
}
// TODO 수들의합2(2003) : 백준, 숫자의 표현
// x수열(2559) : 백준 n^2->n

// 일관된 방향으로 두포인터를 보낸다