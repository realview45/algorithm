package A3bfs;

import java.util.*;

public class A02Bfs최단거리 {
    static List<List<Integer>> adjList= new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] nodes = {{0,1},{2,0},{1,3},{2,3},{2,4}};
        visited = new boolean[5];
        for (int i=0;i<5;i++){
            adjList.add(new ArrayList<>());
        }
        int target =4;
//        target까지 가는 최단거리
        for(int[] n : nodes){
            adjList.get(n[0]).add(n[1]);
            adjList.get(n[1]).add(n[0]);
        }
        for(List<Integer> l : adjList)
            l.sort(Comparator.naturalOrder());
        Queue<int[]> myQue = new LinkedList<>();
        //int[] distance = new int[5];
        myQue.add(new int[]{0,0});//int배열안에는 {노드번호, 거리}
        visited[0]=true;
        int answer = -1;
        loop1:
        while(!myQue.isEmpty()){
            int[] temp= myQue.poll();
            System.out.println(temp[0]);
//            if(temp[0]==target){
//                answer = temp[1];
//                break;
//            }
            for(int a : adjList.get(temp[0])){
                if(!visited[a]) {
//                    bfs에서 visited는 queue에 add하는 시점에 true세팅해야함
                    visited[a]=true;
                    //distance[a] = distance[temp[0]]+1;
                    myQue.add(new int[]{a,temp[1]+1});
                    if(a==target){//일반적
                        answer = temp[1]+1;
                        break loop1;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
