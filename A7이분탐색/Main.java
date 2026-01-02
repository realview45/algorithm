package A7이분탐색;

import java.io.*;
import java.util.Arrays;

//이분탐색문제는 이분탐색의대산을 어떤것으로 설정할지가 핵심
//1. 이분탐색의 대상: 상한액
//2. 상한액모든요청 == 예산총액일 경우만
public class Main {
    //    예산: 백준
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        String[] st = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        /// //
        int start = arr[0];
        int end = arr[arr.length - 1];
        int answer = -1;

        while (start <= end) {
            int sum = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                int num = arr[i];
                if (arr[i] > mid) {
                    num = mid;
                    sum += num;
                } else {
                    sum += arr[i];
                } //더한 수
            }
            if (sum == M) {
                answer = mid;
                break;
            } else if (sum < M) {
                start = mid + 1;
                answer = mid;
            } else if (sum > M) {
                end = mid - 1;
            }
        }

        System.out.println(answer);

    }
}