import java.util.List;
import java.util.Map;

public class Problems {

    public static Map<Integer, Integer> getCountMap(int[] arr) {
        MyLinearMap myMap =  new MyLinearMap();
        for (int i=0; i<arr.length; i++){
            int currentKey = arr[i];
            if (!myMap.containsKey(currentKey)){
                myMap.put(currentKey, 1);
            } else { // do i need to increase a counter, or can i alter the value
                int count = (int) myMap.get(currentKey);
                count ++;
                myMap.put(currentKey, count);
            }
        }
        return myMap;
    }

    public static List<Integer> removeKDigits(int[] num, int k) {
        // TODO: your code here
        return null;
    }
//
//    public static int sumLists(Node<Integer> h1, Node<Integer> h2) {
//        // TODO: your code here
//        return 0;
//    }

}
