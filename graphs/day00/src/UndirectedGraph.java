import sun.plugin.dom.core.Node;
import sun.security.provider.certpath.Vertex;

import java.util.*;

public class UndirectedGraph implements Graph {

    int e;

    Map<Integer, List<Integer>> adjMap;

    ArrayList<Integer> vert;

    public UndirectedGraph(int n) {
        //O(v)
        adjMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjMap.put(i, new LinkedList<>());
        }
        vert = new ArrayList<>(adjMap.keySet());
    }

    @Override
    public void addEdge(int v, int w) {
        //O(1)
        this.e++;
        adjMap.get(v).add(w);
        adjMap.get(w).add(v);
    }

    @Override
    //O(1)
    public List<Integer> vertices() {
        return vert;
    }

    @Override
    //O(1)
    public int numVertices() {
        return vert.size();
    }

    @Override
    //O(1)
    public int numEdges() {
        return e;
    }

    @Override
    //O(1)
    public Iterable<Integer> getNeighbors(int v) {
        return adjMap.get(v);
    }

    @Override
    //O(e/v)
    public boolean hasEdgeBetween(int v, int w) {
        for (int element: getNeighbors(v)){
            if (element == w){
                return true;
            }
        }
        return false;
    }

}
