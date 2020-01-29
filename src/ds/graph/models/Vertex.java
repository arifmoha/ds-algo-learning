package ds.graph.models;

public class Vertex{
    public boolean isVisited;
    public char label;

    public Vertex(char label, boolean isVisited){
        this.label = label;
        this.isVisited = isVisited;
    }
}
