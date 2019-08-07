package chapter4;

import java.util.*;

public class UndirectedGraph {

    private Map<Node, Set<Node>> adjacencyList;

    public UndirectedGraph() {
        this.adjacencyList = new HashMap<Node, Set<Node>>();
    }

    public void addNode(Node node) {
        adjacencyList.put(node, new HashSet<Node>());
    }

    public void addEdge(Node sourceNode, Node targetNode) throws UnknownNodeException {
        if (! hasNode(sourceNode)) {
            throw new UnknownNodeException(sourceNode);
        }
        if (! hasNode(targetNode)) {
            throw new UnknownNodeException(targetNode);
        }
        adjacencyList.get(sourceNode).add(targetNode);
        adjacencyList.get(targetNode).add(sourceNode);
    }

    public Set<Node> getAdjacentNodes(Node node) throws UnknownNodeException {
        if (! hasNode(node)) {
            throw new UnknownNodeException(node);
        }

        return adjacencyList.get(node);
    }

    public boolean hasNode(Node node) {
        return adjacencyList.containsKey(node);
    }
}
