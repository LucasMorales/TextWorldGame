
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Node root = new Node("hall");

        root.addNeighbor(new Node("closet"));
        root.addNeighbor(new Node("bedroom"));

        root.getNeighbor("closet").addNeighbor(root);

        root.getNeighbor("bedroom").addNeighbor(new Node("bathroom"));
        root.getNeighbor("bedroom").getNeighbor("bathroom").addNeighbor(new Node("shower"));
        root.getNeighbor("bedroom").getNeighbor("bathroom").addNeighbor(new Node("secret dungeon"));
        root.getNeighbor("bedroom").getNeighbor("bathroom").getNeighbor("secret dungeon").addNeighbor(root);

        // game loop code

        Node currentRoom = root;
        String userResponse = "";
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("You are in the " + currentRoom.getName());
            System.out.println("You can go to the: " + currentRoom.getNeighborNames());
            System.out.print("Choose a room to enter and type its name: ");
            userResponse = in.nextLine();

            Node nextRoom = currentRoom.getNeighbor(userResponse);
            if (nextRoom == null) {
                System.out.println("This room cannot be entered or does not exist: " + userResponse);
            } else {
                currentRoom = nextRoom;
            }

        } while (!userResponse.equals("quit"));

    }
}
