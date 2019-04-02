
import java.util.ArrayList;

public class Node {
    private String name;
    private ArrayList<Node> neighbors;

    public Node(String name) {
        neighbors = new ArrayList<Node>();
        this.name = name;
    }

    public void addNeighbor(Node n) {
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
