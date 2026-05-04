import java.util.*;

class LT_2017 {
    public long gridGame(int[][] grid) {
        long[][] prefixSum = new long[grid.length][grid[0].length];

        prefixSum[0][0] = grid[0][0];
        prefixSum[1][0] = grid[1][0];

        for(int i=1; i<grid[0].length; i++){
            prefixSum[0][i] = prefixSum[0][i-1] + grid[0][i];
            prefixSum[1][i] = prefixSum[1][i-1] + grid[1][i];
        }

        long topSum = prefixSum[0][grid[0].length-1];
        long downSum = prefixSum[1][grid[0].length-1];

        //red
        long subRed = Long.MAX_VALUE;
        int redDownPoint = 0;
        for(int i=0; i<grid[0].length; i++){
            int cursor = i;

            long topPoint = prefixSum[0][cursor];
            long downPoint = (cursor!=0)?prefixSum[1][grid[0].length-1]-prefixSum[1][cursor-1]:prefixSum[1][grid[0].length-1];

            long point = Math.max(topSum-topPoint, downSum-downPoint);
            if(point < subRed){
                subRed = point;
                redDownPoint = cursor;
            }
        }

        System.out.println("빨간색이 내려가는 위치 : "+redDownPoint);

        //update map
        for(int col=0; col<=redDownPoint; col++){
            grid[0][col] = 0;
        }

        for(int col=redDownPoint; col<grid[0].length; col++){
            grid[1][col] = 0;
        }

        prefixSum[0][0] = grid[0][0];
        prefixSum[1][0] = grid[1][0];

        for(int i=1; i<grid[0].length; i++){
            prefixSum[0][i] = prefixSum[0][i-1] + grid[0][i];
            prefixSum[1][i] = prefixSum[1][i-1] + grid[1][i];
        }

        System.out.println("내려간 후 결과");
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(prefixSum[i][j]+" ");
            }
            System.out.println();
        }

        //blue
        long bluePoint = 0;
        for(int i=0; i<grid[0].length; i++){
            int cursor = i;

            long point = 0;
            point += prefixSum[0][cursor];

            long downPoint = (cursor!=0)?prefixSum[1][grid[0].length-1]-prefixSum[1][cursor-1]:prefixSum[1][grid[0].length-1];
            point += downPoint;

            if(point > bluePoint){
                bluePoint = point;
            }
        }

        return bluePoint;
    }
}