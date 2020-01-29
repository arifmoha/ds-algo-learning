package ds.graph;

import ds.graph.models.Vertex;

import java.util.*;

public class Graph {

    private int vertexCount;
    private boolean[][] adjMatrix; // List<List<boolean>>
    private List<Vertex> vertices;

    public Graph(int vertexCount){
       this.vertexCount = vertexCount;
       init();
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public List<Vertex> getVertices(){
        return vertices;
    }

    private void init(){
        adjMatrix = new boolean[vertexCount][vertexCount];
        vertices = new ArrayList<>(vertexCount);

        for(int row=0; row < vertexCount; row++){
            for(int col=0; col < vertexCount; col++){
                adjMatrix[row][col] = false;
            }
        }
    }

    public void addVertex(char label){
        vertices.add(new Vertex(label, false));
    }

    public void displayVertex(int v){
        System.out.println("The Visited Vertex is: "+v);
    }

    public void addEdge(int source, int destination){
        adjMatrix[source][destination] = true;
        adjMatrix[destination][source] = true;
    }

    public void addDirectedEdge(int source, int destination){
        adjMatrix[source][destination] = true;
    }

    public void removeEdge(int source, int destination){
        adjMatrix[source][destination] = false;
        adjMatrix[destination][source] = false;
    }

    public boolean isEdge(int source, int destination){
        return adjMatrix[source][destination] || adjMatrix[destination][source];
    }

    public List<Character> dfs_iterative(int v){
        List<Character> pathList = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        vertices.get(v).isVisited = true;
        pathList.add(vertices.get(v).label);

        while(!stack.isEmpty()){
           int adjVertex = getUnVisitedAdjVertex(stack.peek());
           if(adjVertex == -1){
               stack.pop();
           }
           else{
               stack.push(adjVertex);
               vertices.get(adjVertex).isVisited = true;
               pathList.add(vertices.get(adjVertex).label);
           }
        }

        return pathList;
    }

    public List<Character> dfs_recursive(int v){
        return dfs_recursive(v, new ArrayList<>());
    }

    private List<Character> dfs_recursive(int v, List<Character> pathList){
        vertices.get(v).isVisited = true;
        pathList.add(vertices.get(v).label);

        for(int i=0; i < vertexCount; i++){
            if(adjMatrix[v][i] && !vertices.get(i).isVisited){
                dfs_recursive(i, pathList);
            }
        }

        return pathList;
    }

    public List<Character> bfs(int v){
        List<Character> pathList = new ArrayList<>();
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(v);
        vertices.get(v).isVisited = true;
        pathList.add(vertices.get(v).label);

        while (!Q.isEmpty()){
            int cv = Q.poll();
            while(getUnVisitedAdjVertex(cv)!= -1){
                int av = getUnVisitedAdjVertex(cv);
                Q.add(av);
                vertices.get(av).isVisited = true;
                pathList.add(vertices.get(av).label);
            }
        }

        return pathList;
    }

    private int getUnVisitedAdjVertex(int v){
        for(int i=0; i < vertexCount; i++){
            if(adjMatrix[v][i] && !vertices.get(i).isVisited){
                return i;
            }
        }

        return -1;
    }

    public List<Character> getArticulationPoints(int vertex){

        List<Character> articulationPoints = new ArrayList<>();

        dfs(vertex,
                1,
                new ArrayList<>(Collections.nCopies(vertexCount, -1)),
                new ArrayList<>(Collections.nCopies(vertexCount, -1)),
                new ArrayList<>(Collections.nCopies(vertexCount, -1)),
                articulationPoints);

        return articulationPoints;

    }

    private void dfs(int v,
                     int time,
                     List<Integer> discoveryTime,
                     List<Integer> lowTime,
                     List<Integer> parent,
                     List<Character> articulationPoints){

        vertices.get(v).isVisited = true;
        discoveryTime.set(v, time);
        lowTime.set(v, time);

        int child = 0;
        for(int adj=0; adj < vertexCount; adj++){
            // if adj is true and visited is false
            if(adjMatrix[v][adj]){
                if(!vertices.get(adj).isVisited){
                    child++;
                    parent.set(adj, v);
                    dfs(adj, time+1, discoveryTime, lowTime, parent, articulationPoints);
                    lowTime.set(v, Math.min(lowTime.get(v), lowTime.get(adj)));

                    if(isArticulationPoint(discoveryTime, lowTime, parent, v, adj, child)){
                        articulationPoints.add(vertices.get(v).label);
                    }
                }else{
                    if(parent.get(v) != adj){
                        lowTime.set(v, Math.min(lowTime.get(v), discoveryTime.get(adj)));
                    }
                }
            }
        }
    }

    private boolean isArticulationPoint(List<Integer> discoveryTime,
                                        List<Integer> lowTime,
                                        List<Integer> parent,
                                        int vertex,
                                        int adjVertex,
                                        int child){
        if(parent.get(vertex) == -1 && child > 1){
          return true;
        }

        if(parent.get(vertex) != -1 && discoveryTime.get(vertex) <= lowTime.get(adjVertex)){
          return true;
        }

        return false;
    }

    public List<Character> topologicalSort(){
        List<Integer> inDegree = new ArrayList<>(Collections.nCopies(vertexCount, 0));
        List<Character> sortedList = new ArrayList<>();

        for(int v=0; v < vertexCount; v++){
            for(int adj=0; adj < vertexCount; adj++){
                if(adjMatrix[v][adj]){
                   inDegree.set(adj, inDegree.get(adj)+1);
                }
            }
        }

        Queue<Integer> Q = new ArrayDeque<>();

        for(int v=0; v < vertexCount; v++){
            if(inDegree.get(v) == 0){
                Q.add(v);
            }
        }

        while(!Q.isEmpty()){
            int v = Q.remove();
            sortedList.add(vertices.get(v).label);

            for(int adj=0; adj < vertexCount; adj++){
                if(adjMatrix[v][adj]){
                    inDegree.set(adj, inDegree.get(adj)-1);

                    if(inDegree.get(adj) == 0){
                        Q.add(adj);
                    }
                }
            }
        }

        return sortedList;
    }
}
