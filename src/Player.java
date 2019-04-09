import java.util.ArrayList;

public class Player {
    private String name;
    private String description;
    private Graph.Room currentRoom;

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private void addItem(Item item) {}
    private Item removeItem(String name) {
        return null;
    }
    public ArrayList<Item> getItems() {
        return null;
    }
    public void displayInventory() {}
    public Graph.Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Graph.Room newRoom) {
        this.currentRoom = newRoom;
    }




}
