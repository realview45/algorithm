package A6투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//정렬이 필요한 경우
//start<end의 조건
//start가 0부터 시작. end가 length-1부터 시작.
public class A02두수의합또는차 {
    public static void main(String[] args) throws IOException {
//        두수의 합 : 백준
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        var strA = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(strA[i]);
        }
        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());
        int start = 0;
        int end = arr.length-1;
        int cnt=0;
        while(start<end){
            if(arr[start]+arr[end]==x){
                cnt++;
                end--;
            }else if(arr[start]+arr[end]<x){
                start++;
            }else if(arr[start]+arr[end]>x){
                end--;
            }
        }
        System.out.println(cnt);
    }
}
// TODO 두수의 합 : 백준, 두용액(2470) 백준, 수고르기(2230) 백준
