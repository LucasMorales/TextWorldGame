
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<Node>();
    }

    public void addNode(String name) {
        nodes.add(new Node(name));
    }

    public void addDirectedEdge(String node1, String node2) {
        Node n1 = getNode(node1);
        Node n2 = getNode(node2);
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String node1, String node2) {
        Node n1 = getNode(node1);
        Node n2 = getNode(node2);
        n1.addNeighbor(n2);
        n2.addNeighbor(n1);

    }

    public Node getNode(String name) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getName() == name) return nodes.get(i);
        }
        return null;
    }


    public class Node {
        private String name;
        private ArrayList<Node> neighbors;

        private Node(String name) {
            neighbors = new ArrayList<Node>();
            this.name = name;
        }

        private void addNeighbor(Node n) {
            neighbors.add(n);
        }

        public String getNeighborNames() {
            String names = "";
            for (Node n : neighbors) {
                names += n.getName();
                names += "\t";
            }
            return names;
        }

        public Node getNeighbor(String name) {
            int indexOfN = -1;
            for (int i = 0; i < neighbors.size(); i++) {
                if (neighbors.get(i).getName().equals(name)) indexOfN = i;
            }
            if (indexOfN == -1) {
                System.out.println("no neighbor of this name: " + name);
                return null;
            }
            return neighbors.get(indexOfN);
        }

        public String getName() {
            return name;
        }
    }

}
