package chapter4;

import java.util.*;

/*
Chapter 4
Question 1

Check if 2 nodes are connected.
Assumptions:
- graph is undirected
- a node is always connected to itself even if there is no (self-)loop
 */
public class BreadthFirstSearch {

    public boolean areNodesConnected(UndirectedGraph graph, Node startNode, Node endNode) throws UnknownNodeException {
        if (! graph.hasNode(startNode)) {
            return false;
        }
        if (! graph.hasNode(endNode)) {
            return false;
        }

        if (startNode == endNode) {
            return true;
        }

        Set<Node> visitedNodes = new HashSet<>();
        LinkedList<Node> nodes = new LinkedList<>(graph.getAdjacentNodes(startNode));
        while (! nodes.isEmpty()) {
            Node currentNode = nodes.removeFirst();
            if (currentNode == endNode) {
                return true;
            }
            if (visitedNodes.contains(currentNode)) {
                continue;
            }
            visitedNodes.add(currentNode);
            nodes.addAll(graph.getAdjacentNodes(currentNode));
        }

        return false;
    }
}
