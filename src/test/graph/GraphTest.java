package test.graph;

import ds.graph.Graph;
import ds.graph.models.Vertex;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testAddEdge(){
        Graph g = new Graph(4);
        assertFalse(g.isEdge(0,1));

        g.addEdge(0,1);
        assertTrue(g.isEdge(0,1));
        assertTrue(g.isEdge(1,0));
    }

    @Test
    void testRemoveEdge(){
        Graph g = new Graph(4);

        g.addEdge(0,1);
        assertTrue(g.isEdge(0,1));
        assertTrue(g.isEdge(1,0));

        g.removeEdge(0, 1);
        assertFalse(g.isEdge(0,1));
        assertFalse(g.isEdge(1,0));
    }

    @Test
    void testAddVertex(){
        Graph g = new Graph(3);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');

        List<Vertex> vertices = g.getVertices();

        assertEquals('A', vertices.get(0).label);
        assertEquals('B', vertices.get(1).label);
        assertEquals('C', vertices.get(2).label);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            assertEquals('C', vertices.get(3).label);
        });
    }

    @Test
    void testDFS_Iterative(){
        Graph g = new Graph(8);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');
        g.addVertex('H');


        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,7);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.addEdge(4,7);

        List<Character> pathList = g.dfs_iterative(0);

        List<Character> expected = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

        assertEquals(expected, pathList);
    }


    @Test
    void testDFS_Recursive(){
        Graph g = new Graph(8);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');
        g.addVertex('H');


        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,7);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.addEdge(4,7);

        List<Character> pathList = g.dfs_recursive(0);

        List<Character> expected = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

        assertEquals(expected, pathList);
    }

    @Test
    void testBFS(){
        Graph g = new Graph(8);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');
        g.addVertex('H');


        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,7);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.addEdge(4,7);

        List<Character> pathList = g.bfs(0);

        List<Character> expected = Arrays.asList('A', 'B', 'C', 'H', 'D', 'E', 'F', 'G');

        assertEquals(expected, pathList);
    }

    @Test
    void testArticulationPoints(){
        Graph g = new Graph(6);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');

        g.addEdge(0,1);
        g.addEdge(0,5);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(3,4);

        List<Character> points = g.getArticulationPoints(0);

        assertEquals(Arrays.asList('B', 'A'), points);
    }

    @Test
    void testArticulationPoints2(){
        Graph g = new Graph(8);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');
        g.addVertex('H');

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.addEdge(5,6);
        g.addEdge(5,7);

        List<Character> points = g.getArticulationPoints(0);

        assertEquals(Arrays.asList('F','E','D','C'), points);
    }


    @Test
    void testTopologicalSort(){
        Graph g=new Graph(6);

        g.addDirectedEdge(4, 5);
        g.addDirectedEdge(0, 1);
        g.addDirectedEdge(0, 2);
        g.addDirectedEdge(1, 2);
        g.addDirectedEdge(1, 3);
        g.addDirectedEdge(2, 3);
        g.addDirectedEdge(2, 4);

        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');

        List<Character> sortedList = g.topologicalSort();

        assertEquals(Arrays.asList('A','B','C','D', 'E', 'F'), sortedList);
    }

    @Test
    void testTopologicalSort2(){
        Graph g=new Graph(6);

        g.addDirectedEdge(0, 3);
        g.addDirectedEdge(1, 3);
        g.addDirectedEdge(3, 2);
        g.addDirectedEdge(5, 1);
        g.addDirectedEdge(5, 0);

        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');

        List<Character> sortedList = g.topologicalSort();

        assertEquals(Arrays.asList('E','F','A','B', 'D', 'C'), sortedList);
    }
}
