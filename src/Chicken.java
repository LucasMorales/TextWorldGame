public class Chicken extends Creature {

    public Chicken(String name, String description, Graph.Room startingRoom) {
        super(name, description, startingRoom);
    }

    @Override
    public void act() {
        Graph.Room nextRoom = currentRoom.getRandomNeighbor();
        if (nextRoom != null) this.moveToRoom(nextRoom);
    }
}
