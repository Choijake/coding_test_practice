import java.io.*;
import java.util.*;

public class BOJ_1120 {
    static int answer;
    static String a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = st.nextToken();
        b = st.nextToken();

        answer = Integer.MAX_VALUE;

        for(int i=0; i<=b.length()-a.length(); i++){
            int count = 0;
            for(int j=0; j<a.length(); j++){
                if(a.charAt(j)!=b.charAt(i+j))count++;
            }
            answer = Math.min(answer, count);
        }

        System.out.println(answer);
    }
}
