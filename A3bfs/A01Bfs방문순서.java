package A3bfs;

import java.util.*;

public class A01Bfs방문순서 {
    static List<List<Integer>> adjList= new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] nodes = {{0,1},{2,0},{1,3},{2,3},{2,4}};
        visited = new boolean[5];
        for (int i=0;i<5;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] n : nodes){
            adjList.get(n[0]).add(n[1]);
            adjList.get(n[1]).add(n[0]);
        }
        for(List<Integer> l : adjList)
            l.sort(Comparator.naturalOrder());
        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(0);
        visited[0]=true;
        while(!myQue.isEmpty()){
            int temp= myQue.poll();
            System.out.println(temp);
            for(int a : adjList.get(temp)){
                if(!visited[a]) {
//                    bfs에서 visited는 queue에 add하는 시점에 true세팅해야함
                    visited[a]=true;
                    myQue.add(a);
                }
            }
        }
    }
}
