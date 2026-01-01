package A4greedy;
import java.util.Arrays;
//greedy(탐욕법) : 현재로서 최적의 해를 선택했을 때, 전체의 최적해를 보장하는 알고리즘.
public class A01GreedyBasic {
    public static void main(String[] args) {
//        1,5,10,20원 짜리의 동전이 있을때, 이를 조합하여 99를 만들수 있는 조합중에 최소개수를 구하라.
        int[] arr = {10,1,5,20};
        int[] arr2 = {1,4,5};//이건 dp로 풀어야함
        int target =99;
        int total =0;
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=0;i--){
            int cnt=target/arr[i];
            total+=cnt;
            target-=cnt*arr[i];
        }
        System.out.println(total);
    }
}