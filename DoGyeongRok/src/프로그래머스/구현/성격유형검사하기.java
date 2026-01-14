package 프로그래머스.구현;

// 2025-06-25
// https://school.programmers.co.kr/learn/courses/30/lessons/118666

public class 성격유형검사하기 {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            int[][] arr = new int[4][2];
            // R T
            // C F
            // J M
            // A N
            for(int i = 0; i < survey.length; i++) {
                int score = 0;
                if (choices[i] <= 3) score = 4 - choices[i];
                else if (choices[i] >= 5) score = choices[i] - 4;

                switch(survey[i]) {
                    case "RT":
                        if(choices[i] <= 3) {
                            arr[0][0] += score;
                        }else if(choices[i] >= 5) {
                            arr[0][1] += score;
                        }
                        break;
                    case "TR":
                        if(choices[i] <= 3) {
                            arr[0][1] += score;
                        }else if(choices[i] >= 5) {
                            arr[0][0] += score;
                        }
                        break;
                    case "CF":
                        if(choices[i] <= 3) {
                            arr[1][0] += score;
                        }else if(choices[i] >= 5) {
                            arr[1][1] += score;
                        }
                        break;
                    case "FC":
                        if(choices[i] <= 3) {
                            arr[1][1] += score;
                        }else if(choices[i] >= 5) {
                            arr[1][0] += score;
                        }
                        break;
                    case "JM":
                        if(choices[i] <= 3) {
                            arr[2][0] += score;
                        }else if(choices[i] >= 5) {
                            arr[2][1] += score;
                        }
                        break;
                    case "MJ":
                        if(choices[i] <= 3) {
                            arr[2][1] += score;
                        }else if(choices[i] >= 5) {
                            arr[2][0] += score;
                        }
                        break;
                    case "AN":
                        if(choices[i] <= 3) {
                            arr[3][0] += score;
                        }else if(choices[i] >= 5) {
                            arr[3][1] += score;
                        }
                        break;
                    case "NA":
                        if(choices[i] <= 3) {
                            arr[3][1] += score;
                        }else if(choices[i] >= 5) {
                            arr[3][0] += score;
                        }
                        break;
                }
            }

            String answer = "";

            for(int i = 0; i < 4; i++) {
                if(arr[i][0] == arr[i][1]) {
                    if(i == 0) {
                        answer += "R";
                    }else if(i == 1) {
                        answer += "C";
                    }else if(i == 2) {
                        answer += "J";
                    }else if(i == 3) {
                        answer += "A";
                    }
                }else {
                    int f = arr[i][0];
                    int s = arr[i][1];
                    if(f > s) {
                        if(i == 0) {
                            answer += "R";
                        }else if(i == 1) {
                            answer += "C";
                        }else if(i == 2) {
                            answer += "J";
                        }else if(i == 3) {
                            answer += "A";
                        }
                    }else {
                        if(i == 0) {
                            answer += "T";
                        }else if(i == 1) {
                            answer += "F";
                        }else if(i == 2) {
                            answer += "M";
                        }else if(i == 3) {
                            answer += "N";
                        }
                    }
                }
            }

            return answer;
        }
    }

}
