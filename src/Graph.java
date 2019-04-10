
import java.util.ArrayList;
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
        private ArrayList<Item> items;

        private Room(String name) {
            neighbors = new HashMap<>();
            this.name = name;
            items = new ArrayList<>();
        }

        private void addNeighbor(Room r) {
            neighbors.put(r.getName(), r);
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public void displayItems() {
            if (items.size() == 0) {
                System.out.println("no items in this room");
            } else {
                System.out.print("The items in this room are: ");
                for (int i = 0; i < items.size(); i++) {
                    System.out.print(items.get(i).getName() + "\t");
                }
                System.out.println();
            }
        }

        public void addItem(Item item) {
            items.add(item);
        }

        public Item removeItem(String name) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().equals(name)) return items.remove(i);
            }
            return null;
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

        public boolean hasItem(String itemReq) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().equals(itemReq)) return true;
            }
            return false;
        }
    }

}
