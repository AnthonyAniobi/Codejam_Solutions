package solution2022.qualification_round;

import java.util.Scanner;

class PunchedCards {
    static String borderLine(int columns, boolean isFirst){
        String[] firstLine = new String[columns];
        for(int i=0; i<columns; i++){
            firstLine[i]= "-";
        }
        if(isFirst){
            firstLine[0] = "..";
            String result = String.join("+", firstLine);
            return String.format("%s+", result);
        }else{
            String result = String.join("+", firstLine);
            return String.format("+%s+", result);
        }
    }

    static String punchLine(int columns, boolean isFirst) {
        String[] initialPunch = new String[columns];
        for (int i = 0; i < columns; i++) {
            initialPunch[i] = ".";
        }
        String result = String.join("|", initialPunch);
        if(isFirst){
            return String.format(".%s|", result);
        }else {
            return String.format("|%s|", result);
        }
    }

    static void solve(int caseNum, int row, int column){
        System.out.println(String.format("Case #%d:", caseNum));
        for(int r = 0; r<row; r++){
            System.out.println(borderLine(column, r==0));
            System.out.println(punchLine(column, r==0));
        }
        System.out.println(borderLine(column, false));
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        for(int i=0; i< testCases; i++){
            int row = input.nextInt();
            int column = input.nextInt();
            solve(i+1, row, column);
        }
    }
}
