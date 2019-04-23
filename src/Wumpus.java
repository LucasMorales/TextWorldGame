public class Wumpus extends Creature {

    public Wumpus(String name, String description, Graph.Room startingRoom) {
        super(name, description, startingRoom);
    }

    @Override
    public void act() {
        Graph.Room possibleNextRoom = currentRoom.getRandomNeighbor();
        while (possibleNextRoom.hasPlayer()) {
            possibleNextRoom = currentRoom.getRandomNeighbor();
        }
        moveToRoom(possibleNextRoom);
    }
}
