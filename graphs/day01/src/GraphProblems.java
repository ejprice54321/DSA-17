import java.util.*;

public class GraphProblems {

    public static boolean connected(Graph g, int v, int u) {
        GraphProblems test = new GraphProblems();
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> stack = new LinkedList<>();

        if (test.depthFirstSearch(g,v,visited, stack).contains(u)){
            return true;
        }
        return false;
    }

    public static List<Integer> topologicalOrder(Digraph g) {
        GraphProblems test = new GraphProblems();
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> topoList = new LinkedList<>();

        for (int vertex: g.vertices()){
            if (!topoList.contains(vertex)){
                topoList = test.depthFirstSearch(g,vertex, visited, topoList);
            }
        }
        return topoList;
    }

    public static LinkedList<Integer> depthFirstSearch (Graph g, int v, Set<Integer> visited, LinkedList<Integer> stack){
        visited.add(v);
        for (int neighbor: g.getNeighbors(v)){
            if (!visited.contains(neighbor)){
                depthFirstSearch(g, neighbor, visited, stack);
            }
        }
        stack.addFirst(v);
        return stack;
    }

    public static boolean cycleDFS (Graph g, int v, int parent, LinkedList<Integer> visited) {
        visited.add(v);
        for (int neighbor : g.getNeighbors(v)) {
            if (!visited.contains(neighbor)) {
                return cycleDFS(g, neighbor, v, visited);
            } else if (neighbor != parent){
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(UndirectedGraph g) {
        GraphProblems test = new GraphProblems();
        LinkedList<Integer> visited = new LinkedList<>();
        int parent = -1;

        for (int vertex: g.vertices()) {
            if (!visited.contains(vertex)) {
                if (test.cycleDFS(g, vertex, parent, visited)) {
                    return true;
                }
                parent = vertex;
            }
        }
        return false;
    }

}