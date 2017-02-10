import java.util.*;

public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
        int tempDist = 0;
        int numBoom = 0;
        for (int i=0; i<points.length; i++){
            MyHashMap map = new MyHashMap();
            for (int j=0; j<points.length; j++){
                tempDist = getSquaredDistance(points[i],points[j]);
                if (map.containsKey(tempDist)){
                    int newVal = (int) (map.get(tempDist)) + 1;
                    map.put(tempDist, newVal);
                }else{
                    map.put(tempDist, 1);
                }
            }
            for (Object value: map.values()){
                int val = (int) value;
                System.out.println(val);
                numBoom += val*(val-1);
                System.out.println("numBoom " + numBoom);
                }
            }
            return numBoom;
        }
//

    private static int getSquaredDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }
}
