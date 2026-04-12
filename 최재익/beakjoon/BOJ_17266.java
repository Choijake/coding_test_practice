import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17266 {
    static int N, M;
    static List<Integer> pos;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        pos = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int loc = Integer.parseInt(st.nextToken());
            pos.add(loc);
        }

        int lo = 0;
        int hi = N;
        while(lo+1 < hi){
            int mid = (lo+hi)/2;

            if(check(mid))hi=mid;
            else lo=mid;
        }

        System.out.print(hi);
    }

    static boolean check(int size){
        int coverEnd = 0;

        for (int p : pos) {
            int start = Math.max(p - size, 0);
            int end = Math.min(p + size, N);

            if(coverEnd<start)return false;

            coverEnd = Math.max(end, coverEnd);

            if(coverEnd>=N)break;
        }

        return coverEnd>=N;
    }
}
