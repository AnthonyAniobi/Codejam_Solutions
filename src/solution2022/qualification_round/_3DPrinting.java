package solution2022.qualification_round;

import java.util.Arrays;
import java.util.Scanner;

public class _3DPrinting {
    static int[] minList(int[][] values){
        int[] resultList = new int[4];
        for(int i =0; i<4; i++){
            int minValue = Integer.MAX_VALUE;
            for(int j=0; j<3; j++){
                if(values[j][i] < minValue){
                    minValue = values[j][i];
                }
            }
            resultList[i] = minValue;
        }
        return resultList;
    }

    static String solve(int[][] data){
        int[] allList = minList(data);
        int sumList = Arrays.stream(allList).sum();
        if(sumList < 1000000){
            return "IMPOSSIBLE";
        }else{
            int sumToRemove = sumList - 1000000;
            for(int i = 0; i<4; i++){
                if(sumToRemove ==0){
                    break;
                }
                if(allList[i]<=1){
                    continue;
                }
                if(allList[i] >= sumToRemove){
                    allList[i] = allList[i]-sumToRemove;
                    break;
                }else{
                    sumToRemove -= allList[i];
                    allList[i] = 0;
                }
            }
            String[] resultList = new String[4];
            for(int i =0; i<4; i++){
                resultList[i] = String.format("%s",allList[i]);
            }
            return String.join(" ", resultList);
        }
    }

    static void parseInput(int caseName, int[][] data){
        String result = solve(data);
        System.out.println(String.format("Case #%d: %s", caseName+1, result));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();
        for(int t= 0; t<testCase; t++){
            int[][] data =new int[3][4];
            for(int i=0; i<3; i++){
                for(int j=0; j<4; j++){
                    data[i][j] = input.nextInt();
                }
            }
            parseInput(t, data);
        }
    }
}