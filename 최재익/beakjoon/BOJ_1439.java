import java.io.*;
import java.util.*;

public class BOJ_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[] count = new int[2];
        int cursor = Integer.parseInt(String.valueOf(input.charAt(0)));
        for(int i=0; i<input.length(); i++){
            int num = Integer.parseInt(String.valueOf(input.charAt(i)));
            if(num != cursor){
                count[cursor]++;
                cursor = num;
            }
        }
        count[cursor]++;

        System.out.print(Math.min(count[0], count[1]));
    }
}