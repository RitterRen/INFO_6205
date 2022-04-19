import java.util.ArrayList;

public class Node {
    public String name;
    public ArrayList<Edge> edges;
    public Node parent;
    public int rank;

    public Node(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
        this.parent = this;
        this.rank = 1;
    }
}
