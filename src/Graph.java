
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Graph {
    private HashMap<String, Room> rooms;
    private ArrayList<Creature> creatures;

    public Graph() {
        rooms = new HashMap<>();
    }

    public void init() {
        addRoom("hall", "a long, dank hallway");
        addRoom("bedroom", "where ya go to sleep");
        addRoom("bathroom", "where ya go to poo");
        addRoom("closet", "where ya clothes are");
        addRoom("dungeon", "scary bad bad");

        addDirectedEdge("hall", "dungeon");
        addUndirectedEdge("hall", "bedroom");
        addUndirectedEdge("bedroom", "closet");
        addDirectedEdge("bedroom", "bathroom");

        getRoom("bedroom").addItem(new Item("hat", "it looks nice"));
        getRoom("bedroom").addItem(new Item("cane", "for support and whacking others"));
        getRoom("dungeon").addItem(new Item("chains", "heavy, but useful"));

        getRoom("dungeon").addCreature(new Chicken("cluckers", "quite the clucker", getRoom("dungeon")));
        getRoom("dungeon").addCreature(new Chicken("paco", "likes tacos", getRoom("dungeon")));
        getRoom("closet").addCreature(new Wumpus("whammy", "carries a hammer", getRoom("closet")));

    }

    public void updateAllCreatures() {
        for (Creature c : creatures) {
            c.act();
        }
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
        private ArrayList<Creature> creatures;

        private Room(String name) {
            neighbors = new HashMap<>();
            this.name = name;
            items = new ArrayList<>();
        }

        private void addNeighbor(Room r) {
            neighbors.put(r.getName(), r);
        }

        private void addCreature(Creature c) {
            creatures.add(c);
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

        public Room getRandomNeighbor() {
            Set<String> keySet = neighbors.keySet();
            ArrayList<String> listOfKeys = new ArrayList<>(keySet);
            int ran = (int)(Math.random()*listOfKeys.size());
            String ranName = listOfKeys.get(ran);
            return neighbors.get(ranName);
        }

        public boolean hasPlayer() {
            return false;
            // unsure how to do this
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
