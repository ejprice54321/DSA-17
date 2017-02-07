import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problems {

    public static Map<Integer, Integer> getCountMap(int[] arr) {
        MyLinearMap myMap =  new MyLinearMap();
        for (int i=0; i<arr.length; i++){
            int currentKey = arr[i];
            if (!myMap.containsKey(currentKey)){
                myMap.put(currentKey, 1);
            } else {
                int count = (int) myMap.get(currentKey);
                count ++;
                myMap.put(currentKey, count);
            }
        }
        return myMap;
    }

    public static List<Integer> removeKDigits(int[] num, int k) {
        LinkedList<Integer> myList = new LinkedList<>();
        for (int i=0; i<num.length; i++) {
            while(!myList.isEmpty() && num[i] < (myList.getLast()) && k>0 ) {
                myList.removeLast();
                k--;
            }
            if (myList.size()<(num.length-k)){
                myList.addLast(num[i]);
            }

            } return myList;
        }



    public static int sumLists(Node<Integer> h1, Node<Integer> h2) {
        int h1size = 0;
        int h2size = 0;
        int sum1 = 0;
        int sum2 = 0;
        int power1;
        int power2;
        Node<Integer> count1 = h1;
        Node<Integer> count2 = h2;


        while (h1.next != null){
            h1 = h1.next;
            h1size++;
        }
        while (h2.next != null){
            h2 = h2.next;
            h2size++;
        }

        while (count1 != null){
            power1 = (int) Math.pow(10, h1size);
            sum1 += count1.data * power1;
            count1 = count1.next;
            h1size--;
        }

        while (count2 != null){
            power2 = (int) Math.pow(10, h2size);
            sum2 += count2.data * power2;
            count2 = count2.next;
            h2size--;
        }
        return sum1+sum2;
    }

}
