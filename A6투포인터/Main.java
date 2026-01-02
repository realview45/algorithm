package A6투포인터;
//A02두수의 합 또는 차 문제풀이
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//연속된 부분 수열의 합 : 프로그래머스
public class Main {
    public static void main(String[] args) throws IOException {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        List<int[]> list = new ArrayList<>();
        while(start<=end&&end<sequence.length){
            if(sum==k){
                list.add(new int[]{start,end});
                start++;
            }else if(sum < k){
                end++;
                if(end==sequence.length)break;
                sum += sequence[end];
            }else if(sum > k){
                sum-=sequence[start];
                start++;
            }
//            if(sum>k){
//                sum-=sequence[start];
//                start++;
//                if(start > end) {
//                    end++;
//                    if(end==sequence.length) break;
//                    sum+=sequence[end];
//                }
//            }else{
//                if(sum==k){
//                    list.add(new int[]{start, end, end-start+1});
//                }
//                end++;
//                if(end==sequence.length) break;
//                sum+=sequence[end];
//            }
        }
        list.sort((o1,o2)->(o1[2]-o2[2]));
        System.out.println(Arrays.toString(list.get(0)));
    }
}

