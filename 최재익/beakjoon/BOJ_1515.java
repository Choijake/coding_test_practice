import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1515 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int number = 1;
        int idx = 0;

        for(int i=0; i<input.length(); i++){
            char target = input.charAt(i);
//            System.out.println("비교 숫자 : "+target+", i="+(i+1));

            boolean flag = false;
            while(true){
                char[] numberArr = String.valueOf(number).toCharArray();
//                System.out.println("기준 숫자 : "+number);

                if(numberArr[idx]==target){
//                    System.out.println("검증 : "+target+", "+number+"의 "+idx+"번 째 수");
                    if(i==input.length()-1)break;
                    flag = true;
                }

                if(idx==numberArr.length-1){
                    number++;
                    idx=0;
                }
                else idx++;

                if(flag)break;
            }
        }

        System.out.print(number);
    }
}
