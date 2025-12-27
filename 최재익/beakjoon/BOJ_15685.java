import java.io.*;
import java.util.*;

public class BOJ_15685 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        visited = new boolean[101][101];
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            drawDragonCurve(x,y,d,g);
        }

        System.out.println(count());
    }

    static void drawDragonCurve(int x, int y, int d, int g){
        List<Integer> dirs = new ArrayList<>();

        dirs.add(d);

        for(int gen=1; gen<=g; gen++){
            for(int i=dirs.size()-1; i>=0; i--){
                dirs.add((dirs.get(i)+1)%4);
            }
        }

        visited[y][x] = true;
        for(int dir : dirs){
            x += dx[dir];
            y += dy[dir];
            visited[y][x] = true;
        }
    }

    static int count(){
        int count = 0;

        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(visited[i][j] &&
                    visited[i+1][j] &&
                    visited[i][j+1] &&
                    visited[i+1][j+1]
                ){
                    count++;
                }
            }
        }

        return count;
    }
}
