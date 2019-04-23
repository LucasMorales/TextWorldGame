public abstract class Creature {

    String name, description;
    Graph.Room currentRoom;

    public Creature(String name, String description) {}

    public abstract void act();

    public Graph.Room getRoom() {
        return currentRoom;
    }

    public void moveToRoom(Graph.Room next) {
        currentRoom = next;
    }

}
