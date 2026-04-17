import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1522 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int windowSize = 0;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='a'){
                windowSize++;
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<input.length(); i++){
            int count = 0;

            for(int j=0; j<windowSize; j++){
                int idx = (i+j)%input.length();
                if(input.charAt(idx) == 'b')count++;
            }

            answer = Math.min(answer, count);
        }

        System.out.print(answer);
    }
}
