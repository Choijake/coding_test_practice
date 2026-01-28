import java.io.*;
import java.util.*;

public class BOJ_1713 {
    static class Candidate{
        int number;
        int count;
        int sequence;

        public Candidate(){}

        public Candidate(int number, int count, int sequence){
            this.number = number;
            this.count = count;
            this.sequence = sequence;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Candidate> pq = new PriorityQueue<>((o1, o2)->{
            if(o1.count != o2.count)return o1.count-o2.count;
            else return o1.sequence-o2.sequence;
        });

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int input = Integer.parseInt(st.nextToken());

            if(!pq.isEmpty()){
                boolean already = false;
                for(Candidate c : pq){
                    if(input == c.number){
                        Candidate tmp = c;
                        pq.remove(c);
                        tmp.count++;
                        pq.offer(tmp);
                        already = true;
                        break;
                    }
                }
                if(already)continue;
            }

            if(pq.size()==size){
                pq.poll();
            }

            pq.offer(new Candidate(input, 1, i));
        }

        List<Integer> answer = new ArrayList<>();
        for(Candidate c : pq){
            answer.add(c.number);
        }
        Collections.sort(answer);

        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i)+" ");
        }
    }
}
