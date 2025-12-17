import java.io.*;

public class BOJ_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder answer = new StringBuilder();
        String[] arr = input.split("\\.");

        for(int i=0; i<arr.length; i++){
            String str = arr[i];

            if(str.length()%2!=0){
                System.out.println(-1);
                return;
            }
            else if(str.length()%4==0){
                answer.append("AAAA".repeat(str.length()/4));
            }
            else {
                answer.append("AAAA".repeat(str.length()/4));
                answer.append("BB");
            }

            if(i!=arr.length-1)answer.append(".");
        }

        answer.append(".".repeat(input.length()-answer.toString().length()));

        System.out.println(answer);
    }
}
