package solution2022.qualification_round;

import java.util.Arrays;
import java.util.Scanner;

public class D1000000 {

    private static void solve(int testCase, int numTiles, int[] tiles){
        int[] sortedList = Arrays.stream(tiles).sorted().toArray();
        int resultCount = 0;
        for(int i=0; i< numTiles; i++){ //4, 4, 4, 4, 5, 5
            if(sortedList[i]<=resultCount){

            }
            else{
                resultCount++;
            }
        }
        System.out.println(String.format("Case #%d: %d", testCase+1, resultCount));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();
        for(int t =0; t<testCase; t++){
            int numTile = input.nextInt();
            int[] tiles = new int[numTile];
            for(int nt =0; nt<numTile; nt++){
                tiles[nt] = input.nextInt();
            }
            solve(t, numTile, tiles);
        }
    }
}
