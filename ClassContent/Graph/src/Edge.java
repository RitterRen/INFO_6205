public class Edge {

    public String start;
    public String end;
    public int weight;

    public Edge(String start, String end) {
        this.start = start;
        this.end = end;
        this.weight = 1;
    }

    public Edge(String start, String end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
