import java.util.*;

public class ShortestPath {

    public static List<Integer> shortestPath(Graph g, int v, int w) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> l = new LinkedList<>();
        boolean flag = true;

        q.offer(v);
        map.put(v,0);
        while (!q.isEmpty()){
                int m = q.poll();
                for (int neighbor: g.getNeighbors(m)) {
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, map.get(m) + 1);
                        q.offer(neighbor);
                    }
            }
        }
        if (!map.containsKey(v) || !map.containsKey(w)){
            return null;
        }
        int temporary = w;
        l.add(w);
        while (temporary != v){
            for (int next: g.getNeighbors(temporary)){
                if ((map.get(next) < map.get(temporary)) && flag){
                    l.addFirst(next);
                    flag = false;
                    temporary = next;
                }
            }
            flag = true;
        }
        return l;
    }

    public static int distanceBetween(Graph g, int v, int w) {
        if (shortestPath(g,v,w) != null) {
            return shortestPath(g, v, w).size() - 1;
        }
        return -1;
    }

}