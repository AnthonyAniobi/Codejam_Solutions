package solution2022.round1A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoubleOrOneThing {
    private static void solve(int testCase, String data){
        int stringLength = data.length();
        List<String> result = new ArrayList<String>();
        for(int i =0; i< stringLength; i++){
            if(i >= stringLength-1){
                result.add(Character.toString(data.charAt(i)));
            }else{
                char first = data.charAt(i);
                char second = data.charAt(i+1);
                if(i+2 == stringLength-1){
                    char third = data.charAt(i+2);
                    if(first == second && first != third && first < third){
                        result.add(Character.toString(data.charAt(i)));
                    }
                }
                if(first < second){
                    result.add(Character.toString(data.charAt(i)));
                }
                result.add(Character.toString(data.charAt(i)));
            }
        }
        String resultString = String.join("", result);
        System.out.println(String.format("Case #%d: %s", testCase+1, resultString));
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        for(int t=0; t<testCases; t++){
            solve(t, input.next());
        }
    }
}
