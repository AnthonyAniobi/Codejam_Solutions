package solution2022.qualification_round;

import java.util.*;

public class ChainReactions {
    private class Node{
        public Node(int pointer){this.pointer= pointer;}
        public Node(int pointer, int value){this.pointer= pointer;this.value=value;}
        void setPointer(int pointer){this.pointer = pointer;}
        int pointer;
        int value;

        @Override
        public int hashCode() {
            return Integer.parseInt(String.format("%d000%d", pointer*3, value));
        }

        @Override
        public String toString() {
            return String.format("%d: %d", this.pointer, this.value);
        }
    }

    static private Node minNode(List<Node> nodes){
        Node minNode = nodes.stream().findFirst().get();
        for(int i = 0; i<= nodes.size(); i++){
            if(minNode.value > nodes.get(i).pointer){
                minNode = nodes.get(i);
            }
        }
        return minNode;
    }
    static private Node maxNode(List<Node> nodes){
        Node maxNode = nodes.stream().findFirst().get();
        for(int i = 0; i<= nodes.size(); i++){
            if(maxNode.value < nodes.get(i).pointer){
                maxNode = nodes.get(i);
            }
        }
        return maxNode;
    }
    static private int sumNodes(List<Node> nodes){
        int result = 0;
        for(int i = 0; i<= nodes.size(); i++){
            result += nodes.get(i).value;
        }
        return result;
    }
    private static List<Integer> dataList = new ArrayList<Integer>();
    private static HashSet<Integer> setList = new HashSet<Integer>();
    private static List<Integer> tempDataList = new ArrayList<Integer>();

    private static void solve(int testCase, TreeMap<Integer, List<Integer>> data){
        System.out.println(data);
        int result = 0;
        TreeMap<Integer, List<Integer>> tempData = data;
        while(!tempData.isEmpty()){
            List<Integer> _current = new ArrayList<Integer>();
            List<Integer> _keys = tempData.keySet().stream().toList();
            for(int i:_keys){
                List<Integer> currentList = tempData.get(i);
                _current.add(currentList.stream().findFirst().get()); // add the first item in list
                tempData.put(i, currentList.subList(1, currentList.size()));
                if(tempData.get(i).isEmpty()){
                    tempData.remove(i);
                }
            }
//            System.out.println(_current);
            result += Collections.max(_current);
        }
        System.out.println(String.format("Case #%d: %d", testCase+1, result));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();
        for(int t=0; t< testCase; t++){
            int numModules = input.nextInt();
            int[] values = new int[numModules];
            TreeMap<Integer, List<Integer>> data = new TreeMap<Integer, List<Integer>>();
            int[] pointers = new int[numModules];
            for(int nm=0; nm<numModules; nm++){
                values[nm] = input.nextInt();
            }
            for(int nm=0; nm<numModules; nm++){
                int currentKey = input.nextInt();
                if(data.containsKey(currentKey)){
                    List<Integer> previousValue = data.get(currentKey);
                    previousValue.add(values[nm]);
                    data.put(currentKey, previousValue); // update data map
                }else{
                    List<Integer> currentValue = new ArrayList<Integer>();
                    currentValue.add(values[nm]);
                    data.put(currentKey, currentValue); // update data map
                }
            }
            for(int i=0; i<data.size(); i++){
                List<Integer> currentItem = data.get(i);
                data.put(i, currentItem.stream().sorted().toList());
            }
            solve(t, data);
        }
    }
}
