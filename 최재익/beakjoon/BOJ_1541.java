import java.io.*;
import java.util.*;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("-");

        int answer = 0;
        for(int i=0; i<input.length; i++){
            String[] add = input[i].split("\\+");

            int tmp = 0;
            for(int j=0; j<add.length; j++){
                tmp += Integer.parseInt(add[j]);
            }

            if(i==0)answer+=tmp;
            else answer-=tmp;
        }

        System.out.print(answer);
    }
}
