import java.util.*;
import java.lang.*;
import java.io.*;

public class BOJ_1497 {
    static int max;
    static List<String[]> guitars;
    static boolean[] checked;
    static int N, M;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        guitars = new ArrayList<>();
        for(int i=0; i<N; i++){
            guitars.add(br.readLine().split(" "));
        }

        answer = -1;
        max = 0;
        for(int i=1; i<=N; i++){
            checked = new boolean[N];
            permutation(0, i, 0);
        }

        System.out.print(answer);
    }

    static void permutation(int depth, int end, int start){

        if(depth == end){
            int count = 0;
            char[] res = new char[M];
            for(int idx=0; idx<N; idx++){
                if(checked[idx]) {
                    for(int j=0; j<M; j++){
                        char ch = guitars.get(idx)[1].toCharArray()[j];

                        if(res[j]=='Y')continue;

                        if(ch=='Y')count++;
                        res[j] = ch;
                    }
                }
            }

            //System.out.println(end + ": " + String.valueOf(res));

            if(count>max) {
                max = count;
                answer = end;
            }

            return;
        }

        for(int i=start; i<N; i++){
            checked[i] = true;
            permutation(depth+1, end, i+1);
            checked[i] = false;
        }
    }
}
/**
 * 4 5
 * GIBSON YYYNN
 * FENDER YYNNY
 * EPIPHONE NNNYY
 * ESP YNNNN
 */
