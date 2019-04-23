public abstract class Creature {

    String name, description;
    Graph.Room currentRoom;

    public Creature(String name, String description, Graph.Room startingRoom) {
        currentRoom = startingRoom;
    }

    public abstract void act();

    public Graph.Room getRoom() {
        return currentRoom;
    }

    public void moveToRoom(Graph.Room next) {
        currentRoom = next;
    }

}
