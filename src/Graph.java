
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    private HashMap<String, Node> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public void addNode(String name) {
        nodes.put(name, new Node(name));
    }

    public void addDirectedEdge(String node1, String node2) {
        Node n1 = getNode(node1);
        Node n2 = getNode(node2);
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String node1, String node2) {
        Node n1 = getNode(node1);
        Node n2 = getNode(node2);
        //System.out.println("Adding neighbors...");
        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
    }

    public Node getNode(String name) {
        return nodes.get(name); // HashMap automatically returns null if it does not exist
    }

    public class Node {
        private String name;
        private HashMap<String, Node> neighbors;

        private Node(String name) {
            neighbors = new HashMap<>();
            this.name = name;
        }

        private void addNeighbor(Node n) {
            //System.out.println("Adding neighbor " + n.getName() + "  to " + this.getName());
            neighbors.put(n.getName(), n);
        }

        public String getNeighborNames() {
            String output = "";
            for (String name : neighbors.keySet()) {
                output += neighbors.get(name).getName();
                //System.out.println(neighbors.get(name).getName());
                output += "\t";
            }
            return output;
        }

        public Node getNeighbor(String name) {
            return neighbors.get(name);
        }

        public String getName() {
            return name;
        }

        public boolean hasNeighbor(String room) {
            if (getNeighbor(room) == null) return false;
            return true;
        }
    }

}
