public class Chicken extends Creature {

    public Chicken(String name, String description) {
        super(name, description);
    }

    @Override
    public void act() {
        Graph.Room nextRoom = currentRoom.getRandomNeighbor();
        if (nextRoom != null) this.moveToRoom(nextRoom);
    }
}
