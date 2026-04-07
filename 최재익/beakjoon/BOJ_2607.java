import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2607 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())-1;

        String base = br.readLine();

        int answer = 0;
        for(int i=0; i<N; i++){
            String target = br.readLine();
            int[] word = new int[26];

            int same = 0;
            for(int j=0; j<base.length(); j++){
                word[base.charAt(j)-'A']++;
            }

            for(int j=0; j<target.length(); j++){
                int idx = target.charAt(j)-'A';

                if(word[idx]>0){
                    word[idx]--;
                    same++;
                }
            }

            if(base.length()==target.length() && (same==base.length() || same==base.length()-1))answer++;
            else if(base.length()==target.length()-1 && same==target.length()-1)answer++;
            else if(base.length()-1==target.length() && same==target.length())answer++;
        }

        System.out.println(answer);
    }
}
