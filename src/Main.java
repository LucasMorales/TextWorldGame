
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("hall");
        g.addNode("closet");
        g.addNode("dungeon");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");



        // game loop code
/*

        Node currentRoom = root;
        String userResponse = "";
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("You are in the " + currentRoom.getName());
            System.out.println("You can go to the: " + currentRoom.getNeighborNames());
            System.out.println("Choose a room to enter and type its name: ");
            userResponse = in.nextLine();

            Node nextRoom = currentRoom.getNeighbor(userResponse);
            if (nextRoom == null) {
                System.out.println("This room cannot be entered or does not exist: " + userResponse);
            } else {
                currentRoom = nextRoom;
            }

        } while (!userResponse.equals("quit"));
*/

    }
}
