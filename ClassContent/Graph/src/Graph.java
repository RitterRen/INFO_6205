import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;

public class Graph {
    public HashMap<String, Node> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addNode(String nodeName) {
        nodeName = nodeName.toLowerCase();
        if (graph.containsKey(nodeName)) return;

        Node node = new Node(nodeName);
        graph.put(nodeName, node);
    }

    public void printAllPaths(String source, String destin) {
        source = source.toLowerCase();
        destin = destin.toLowerCase();

        if(!graph.containsKey(source) || !graph.containsKey(destin)) return;

        LinkedList<String> path = new LinkedList<>();

    }

    private void printAllPaths(LinkedList<String> path, String current, String destin) {
        if (path.contains(current)) return;

        if (Objects.equals(destin, current)) {
            for (String str: path) {
                System.out.print(str + "->");
            }
        }

        path.add(current);

        Node node = graph.get(current);
        for (Edge edge: node.edges) {
            if (!graph.containsKey(edge.end)) {

            }
        }
    }

    // Union Find
    private void union(Node node1, Node node2) {
        Node parent1 = findParent(node1);
        Node parent2 = findParent(node2);

        if (parent1 == parent2) return;

        if (parent1.rank >= parent2.rank) {
            parent1.rank++;
            parent2.parent = parent1;
        }else {
            parent1.parent = parent2;
            parent2.rank++;
        }
    }

    private Node findParent(Node node) {
        if (node == node.parent) return node;

        return findParent(node.parent);
    }
}
