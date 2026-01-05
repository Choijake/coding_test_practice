import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18808 {
    static int N, M, K;
    static List<Sticker> list;
    static boolean[][] attached;
    static int answer;

    static class Sticker{
        int h;
        int w;
        int[][] shape;

        Sticker(int h, int w, int[][] shape){
            this.h = h;
            this.w = w;
            this.shape = shape;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        attached = new boolean[N][M];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int[][] shape = new int[h][w];

            for(int r=0; r<h; r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<w; c++){
                    shape[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            list.add(new Sticker(h, w, shape));
        }

        answer = 0;

        explore(0);

        System.out.println(answer);
    }

    static void explore(int depth){
        if(depth==list.size()){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(attached[i][j])answer++;
                }
            }
            return;
        }

        Sticker sticker = list.get(depth);

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(sticker.h>(N-i) || sticker.w>(M-j))continue;
                if(!attach(i, j, sticker))continue;
                explore(depth+1);
                return;
            }
        }

        for(int r=0; r<3; r++){
            sticker = rotate(sticker);

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(sticker.h>(N-i) || sticker.w>(M-j))continue;
                    if(!attach(i, j, sticker))continue;
                    explore(depth+1);
                    return;
                }
            }
        }

        explore(depth+1);
    }

    static Sticker rotate(Sticker sticker){
        int[][] rShape = new int[sticker.w][sticker.h];
        for(int r=0; r<sticker.h; r++){
            for(int c=0; c<sticker.w; c++){
                rShape[c][sticker.h-r-1] = sticker.shape[r][c];
            }
        }

        return new Sticker(sticker.w, sticker.h, rShape);
    }

    static boolean attach(int row, int col, Sticker sticker){
        for(int r=0; r<sticker.h; r++){
            for(int c=0; c<sticker.w; c++){
                if(sticker.shape[r][c] == 1 && attached[row+r][col+c])
                    return false;
            }
        }

        for(int r=0; r<sticker.h; r++){
            for(int c=0; c<sticker.w; c++){
                if(sticker.shape[r][c] == 1) {
                    attached[row+r][col+c] = true;
                }
            }
        }

        return true;
    }
}
