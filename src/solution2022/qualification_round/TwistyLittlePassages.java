package solution2022.qualification_round;

import java.util.*;

public class TwistyLittlePassages {

    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        int testCases = input.nextInt();
        Map<Integer, Integer> value = new TreeMap<Integer, Integer>();
        value.put(1,3);
        value.put(4,3);
        value.put(5,3);
        value.put(2,3);
        value.put(1,3);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(12);
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(8);
        list.add(0);
        System.out.println(list.subList(1, 1));
    }
}
