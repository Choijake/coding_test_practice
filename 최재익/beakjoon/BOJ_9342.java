import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class BOJ_9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Pattern p = Pattern.compile("^[A-F]?A+F+C+[A-F]?$");

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            String s = br.readLine();
            if(p.matcher(s).matches())sb.append("Infected!\n");
            else sb.append("Good\n");
        }

        System.out.println(sb.toString());
    }
}
