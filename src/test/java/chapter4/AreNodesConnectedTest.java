package chapter4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AreNodesConnectedTest {

    @Test
    void testSingleNodeIsConnectedToItself() throws UnknownNodeException {
        BreadthFirstSearch search = new BreadthFirstSearch();
        Node node = new Node("");
        UndirectedGraph graph = new UndirectedGraph();
        graph.addNode(node);

        Assertions.assertTrue(search.areNodesConnected(graph, node, node));
    }

    @Test
    void testThatIslandsAreNotConnected() throws UnknownNodeException {
        BreadthFirstSearch search = new BreadthFirstSearch();
        Node startNode = new Node("");
        Node endNode = new Node("");
        UndirectedGraph graph = new UndirectedGraph();
        graph.addNode(startNode);
        graph.addNode(endNode);

        Assertions.assertFalse(search.areNodesConnected(graph, endNode, startNode));
    }

    @Test
    void testThatDirectNeighboursAreConnected() throws UnknownNodeException {
        BreadthFirstSearch search = new BreadthFirstSearch();
        Node startNode = new Node("start");
        Node endNode = new Node("end");
        UndirectedGraph graph = new UndirectedGraph();
        graph.addNode(startNode);
        graph.addNode(endNode);
        graph.addEdge(startNode, endNode);

        Assertions.assertTrue(search.areNodesConnected(graph, endNode, startNode));
    }

    @Test
    void testThatInDirectNeighboursAreConnected() throws UnknownNodeException {
        BreadthFirstSearch search = new BreadthFirstSearch();
        Node startNode = new Node("start");
        Node endNode = new Node("end");
        Node firstIntermediateNode = new Node("1");
        Node secondIntermediateNode = new Node("2");
        UndirectedGraph graph = new UndirectedGraph();
        graph.addNode(startNode);
        graph.addNode(endNode);
        graph.addNode(firstIntermediateNode);
        graph.addNode(secondIntermediateNode);
        graph.addEdge(startNode, firstIntermediateNode);
        graph.addEdge(firstIntermediateNode, secondIntermediateNode);
        graph.addEdge(secondIntermediateNode, endNode);

        Assertions.assertTrue(search.areNodesConnected(graph, startNode, endNode));
    }
}
