import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2170 {
    static class Segment implements Comparable<Segment>{
        int s;
        int e;

        public Segment(int s, int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Segment o){
            if(this.s!=o.s)return this.s-o.s;
            return o.e-this.e;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Segment[] segs = new Segment[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            segs[i] = new Segment(a, b);
        }

        Arrays.sort(segs);

        int curStart = segs[0].s;
        int curEnd = segs[0].e;
        int answer = 0;

        for(int i=1; i<segs.length; i++){
            int start = segs[i].s;
            int end = segs[i].e;

            if(curEnd<start){
                answer += (curEnd-curStart);
                curStart = start;
                curEnd = end;
                continue;
            }

            if(end>curEnd){
                curEnd = end;
            }
        }

        answer += (curEnd-curStart);
        System.out.print(answer);
    }
}
