package A2dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A02이차원배열의완전탐색 {
    public static void main(String[] args) {
//         일반적으로 2차원의 지도는 2차원 배열 형태로 주어짐
//        갈 수 있는 곳, 갈 수 없는 곳, 출발지, 도착지 등이 숫자값으로 구분
        int[][] arr = { {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 2, 1},
                        {1, 1, 1, 1}};
        int[] current = {0,0};
        dfs(arr, current);
    }
    static void dfs(int[][] arr, int[] current){
//    가는 방법이 일반적으로 "상,하,좌,우"로 주어지거나 대각선까지 추가되는 경우 있음.
//    위로 이동 : {x-1, y}
//    아래로 이동 : {x+1, y}
//    왼쪽으로 이동 : {x, y-1}
//    오른쪽으로 이동 : {x, y+1}
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int k=0;k<4;k++){
            int nx = current[0] + dx[k];
            int ny = current[1] + dy[k];
            if(nx>=0 && ny>=0 && nx<arr.length && ny<arr[0].length){
                dfs(arr, new int[]{nx,ny});
            }
        }
    }
}
//관련 문제풀이 : 숫자판점프-백준 방문했던 것을 피하는 코드 없이 dfs돌림
//package 숫자판점프2210;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//public class Main {
//    static int[][] arr;
//    static boolean[][] visited;
//    static int n=5;
//    static Set<List<Integer>> answer2 = new HashSet<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        arr= new int[n][n];
//        visited = new boolean[n][n];
//        for(int i=0;i<n;i++){
//            var strA = br.readLine().split(" ");
//            for(int j=0;j<n;j++){
//                arr[i][j] = Integer.parseInt(strA[j]);
//            }
//        }
//        dfsAll();
//        System.out.println(answer2.size());
//        br.close();
//    }
//    static void dfsAll(){
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                dfs(i,j, new ArrayList<>());
//            }
//        }
//    }
//    static int[] dr = {0,0,1,-1}; static int[] dc = {1,-1,0,0};
//    static void dfs(int r, int c, List<Integer> temp2){//매개변수로 리스트를 쓰려면
//        temp2.add(arr[r][c]);
//        if(temp2.size()==6){
//            answer2.add(new ArrayList<>(temp2));//return시
//            temp2.remove(temp2.size() - 1);
//            return;
//        }
//        for(int i=0;i<4;i++){
//            int nr = r+dr[i];
//            int nc = c+dc[i];
//            if(nr>=0&&nc>=0&&nr<n&&nc<n){
//                dfs(nr,nc,temp2);
//            }
//        }
//        temp2.remove(temp2.size() - 1);//여기로 못오므로 remove를 둘다 해줘야함!
//    }
//}