package A2dfs;
//백트래킹은 뒤에 쫒아가면서 앞에서 더했던 값을 제거하는 것 앞에서 add, true, 뒤에서 remove, false
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A03Dfs모든경우의수와백트래킹 {
    // 모든 경우의 수를 리스트에 담고자 함.
    static List<List<Integer>> adjList = new ArrayList<>();
    static List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) {
        int[][] nodes = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {4, 5}, {3, 6}, {3, 7}, {4, 8}, {4, 9}, {5, 10}};

        for (int i = 0; i < 11; i++) {
            adjList.add(new ArrayList<>());
        }

        // 여기서는 1번이 root node라고 가정했기 때문에, visited를 제외하고 단방향 노드로 설계했다.
        // 즉, 단방향설계에서는 방문처리 배열을 관리할 필요가 없음
        for (int[] n : nodes) {
            adjList.get(n[0]).add(n[1]);
        }
        for (List<Integer> l : adjList) {
            l.sort(Comparator.naturalOrder());
        }

        dfs(1, new ArrayList<>());
        System.out.println(answer);
    }

    // answer 에 담겨야할 값
    // [[1,2,4,8],[1,2,4,9],[1,2,5,10],[1,3,6],[1,3,7]]
    // KP) answer에 언제 담느냐, remove는 언제 하느냐
    static void dfs(int start, List<Integer> temp) {
        temp.add(start);
        if (adjList.get(start).isEmpty()) {
            answer.add(new ArrayList<>(temp));
        }
        for (int target : adjList.get(start)) {
            dfs(target, temp);
            temp.remove(temp.size() - 1);
        }
    }

    static void dfs2(int start, List<Integer> temp) {
        temp.add(start);
        if (adjList.get(start).isEmpty()) {
            answer.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
        }
        for (int target : adjList.get(start)) {
            dfs(target, temp);
        }
        temp.remove(temp.size() - 1);
    }
    // 관련문제(완전탐색 && 백트래킹) : 피로도 - 프로그래머스
    // https://school.programmers.co.kr/learn/courses/30/lessons/87946
}
//
//package A2dfs;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//public class A03Dfs모든경우의수와백트래킹 {
//    static List<List<Integer>> adjList= new ArrayList<>();
//    static List<List<Integer>> answer = new ArrayList<>();
//    static boolean[] visited;
//    public static void main(String[] args) {
//        int[][] nodes = {{0,1},{2,0},{1,3},{2,3},{2,4}};
//        visited = new boolean[5];
//        for (int i=0;i<5;i++){
//            adjList.add(new ArrayList<>());
//        }
//        for (int i=0;i<11;i++){
//            answer.add(new ArrayList<>());
//        }
////        여기서는 1번이 루트노드라고 가정했기에, visited를 제외하고 단방향 노드로 설계.
//        for(int[] n : nodes){
//            adjList.get(n[0]).add(n[1]);
//        }
//        for(List<Integer> l : adjList)
//            l.sort(Comparator.naturalOrder());
//        dfs(1, new ArrayList<>());
//        System.out.println(answer);
//    }
////    answer : [[1,2,4,8], [1,2,4,9], [1,2,5,10], [1,3,6], [1,3,7]]
//    static void dfs(int start, List<Integer>temp){
//        temp.add(start);
//        if(adjList.get(start).isEmpty()){
//            answer.add(new ArrayList<>(temp));
//        }
//        for(int target : adjList.get(start)){
//            dfs(target,temp);
//            temp.remove((temp.size()-1));
//        }
//    }
//}
////관련문제(완전탐색&&백트래킹) : 피로도 - 프로그래머스

