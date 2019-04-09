import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private String name;
    private String description;
    private Graph.Room currentRoom;
    private HashMap<String, Item> inventory;

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
    public void displayInventory() {
        for (String s : inventory.keySet()) {
            System.out.print("You have: " + "\n" + inventory.get(s) + "\t");
        }
        System.out.println();
    }
    public Graph.Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Graph.Room newRoom) {
        this.currentRoom = newRoom;
    }




}
