import java.io.*;
import java.util.*;

public class BOJ_16719 {
    static StringBuilder answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        answer = new StringBuilder();
        visited = new boolean[input.length()];

        zoac(0, input.length()-1, input);

        System.out.print(answer);
    }

    static void zoac(int start, int end, String input){
        if(start>end)return;

        int idx=start;
        for(int i=start; i<=end; i++){
            if(input.charAt(i)<input.charAt(idx))idx=i;
        }

        visited[idx] = true;
        for(int i=0; i<input.length(); i++){
            if(visited[i])answer.append(input.charAt(i));
        }

        answer.append("\n");

        zoac(idx+1, end, input);
        zoac(start, idx-1, input);
    }
}
