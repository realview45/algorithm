package A1sort;
/* 내가만든 주석
알고리즘은 문제를 많이 풀 것 선택정렬, 버블정렬 나중에해보기
1.heap 자료구조로 만들기(하나씩 더하고 꺼내고를 반복)
2.하나씩 꺼내기 맨밑의 걸 위로 올려서 제일작은거랑 바꾸면서 내려가기(하향식 heapify) 힙 자료구조 맞추기-> 정렬 완성(nlogn)
3.하나씩 더하기 끝에 값 집어넣어서 부모노드랑 비교 작으면 바꾸기(nlogn)상향식 heapify

1.heap자료구조로 만들기 : 최초힙구성 nlogn(구현)
    2로 나누면 왼쪽 자식노드O 오른쪽 자식노드X 중앙근처부터 0까지 검사
    자식노드(2n+1, 2n+2)(중요)
    재귀호출(중요)

정렬 방법 끝노드에 작은 값 넣고 하향식 히피파이 계속하기

1.n개값 add : nlogn
2.n개값 꺼내기 : nlogn
3.최종적인 정렬 : nlogn
*/

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//"트리탐색 + 재귀적 호출"을 통한 힙정렬
public class A01HeapSort구현 {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
//        1.최초힙구성
//        1-1)부모노드(n/2)와 자식노드(n/2) 분리하여 부모노드를 대상으로 heapify
//        1-2)자식노드의 왼쪽노드 : 부모노드X2 + 1, 자식노드의 오른쪽노드 : 부모노드X2 + 2
//        1-3)heapify의 과정이 재귀호출로 이루어짐
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            //heapify(arr, i);//두자식 노드보다 크지작은지 확인해줘 자식 노드 작다면 자리 change해줘
//            heapify2(arr, i, arr.length);
//        }
//        System.out.println(Arrays.toString(arr));
//        //1 3 5 6 7 5 9 8 6
////        정렬하기
////        2.루트노드 와 최하위노드를 자리change해가면서 재heapify
////        2-1)자리change한 마지막노드는 heapify대상에서 제외
////        2-2)최소힙 -> 내림차순정렬, 최대힙 -> 오름차순정렬
//        for (int i = arr.length - 1; i >= 0; i--) {
//            int temp = arr[i];
//            arr[i] = arr[0];//마지막자리값 감소
//            arr[0] = temp;
//            heapify2(arr, 0, i);//전체길이감소
//        }
//        System.out.println(Arrays.toString(arr));

//        pq를 통한 정렬방법
//        pq를 가지고 직접 정렬을 수행하기보다는 지속적으로 값을 add하고 poll해나가는 상황에서 사용
//        최초힙구성 : n*logn
        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(7, 6, 5, 8, 3, 5, 9, 1, 6));
        System.out.println(pq);
        System.out.println(pq.poll());//poll의 복잡도 log(n)
        pq.add(2);//add의 복잡도 log(n)
    }
//    static void heapify(int[] arr, int parentIndex){
////        자식노드와의 비교. 만약, 자식노드가 더 작으면 자리 change
//        int leftIndex = parentIndex*2+1;
//        int rightIndex = parentIndex*2+2;
//        int minIdx = parentIndex;
////        가장 작은 index값 찾기
//        if(rightIndex<arr.length&&arr[rightIndex] < arr[parentIndex]){
//            minIdx = rightIndex;
//        }
//        if(leftIndex<arr.length&&arr[leftIndex] < arr[minIdx]){
//            minIdx = leftIndex;
//        }
////        가장 작은 index가 부모노드가 아니라면 자리 change 및 heapify호출
//        if(minIdx!=parentIndex){
//            int temp = arr[parentIndex];
//            arr[parentIndex] = arr[minIdx];
//            arr[minIdx] = temp;
//            heapify(arr, minIdx);
//        }

    /// /        자리가 change된다면, 재귀호출
    /// /        heapify(arr, 자식노드의index);
//    }
    static void heapify2(int[] arr, int parentIndex, int length) {
//        자식노드와의 비교. 만약, 자식노드가 더 작으면 자리 change
        int leftIndex = parentIndex * 2 + 1;
        int rightIndex = parentIndex * 2 + 2;
        int minIdx = parentIndex;
//        가장 작은 index값 찾기
        if (rightIndex < length && arr[rightIndex] < arr[parentIndex]) {
            minIdx = rightIndex;
        }
        if (leftIndex < length && arr[leftIndex] < arr[minIdx]) {
            minIdx = leftIndex;
        }
//        가장 작은 index가 부모노드가 아니라면 자리 change 및 heapify호출
        if (minIdx != parentIndex) {
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIdx];
            arr[minIdx] = temp;
            heapify2(arr, minIdx, length);
        }
//        자리가 change된다면, 재귀호출
//        heapify(arr, 자식노드의index);
    }
}
