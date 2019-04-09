
import java.util.HashMap;

public class Graph {
    private HashMap<String, Room> rooms;

    public Graph() {
        rooms = new HashMap<>();
    }

    public void addRoom(String name, String description) {
        rooms.put(name, new Room(name));
        rooms.get(name).setDescription(description);
    }

    public void addDirectedEdge(String room1, String room2) {
        Room r1 = getRoom(room1);
        Room r2 = getRoom(room2);
        r1.addNeighbor(r2);
    }

    public void addUndirectedEdge(String room1, String room2) {
        Room r1 = getRoom(room1);
        Room r2 = getRoom(room2);
        r1.addNeighbor(r2);
        r2.addNeighbor(r1);
    }

    public Room getRoom(String name) {
        return rooms.get(name); // HashMap automatically returns null if it does not exist
    }

    public class Room {
        private String name;
        private HashMap<String, Room> neighbors;
        private String description;

        private Room(String name) {
            neighbors = new HashMap<>();
            this.name = name;
        }

        private void addNeighbor(Room r) {
            neighbors.put(r.getName(), r);
        }

        private void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public String getNeighborNames() {
            String output = "";
            for (String name : neighbors.keySet()) {
                output += neighbors.get(name).getName();
                output += "\t";
            }
            return output;
        }

        public Room getNeighbor(String name) {
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
