
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("hall", "a long, dank hallway");
        g.addNode("bedroom", "where ya go to sleep");
        g.addNode("bathroom", "where ya go to poo");
        g.addNode("closet", "where ya clothes are");
        g.addNode("dungeon", "scary bad bad");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "bedroom");
        g.addUndirectedEdge("bedroom", "closet");
        g.addDirectedEdge("bedroom", "bathroom");

        Graph.Node current = g.getNode("hall");

        // game loop code

        String userResponse = "";
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("You are in the " + current.getName() + ".");
            System.out.println("What do you want to do? Your options are:");
            System.out.println("[go to <roomname>]\t[look]\t[add room <roomname>]\t[quit]");
            userResponse = in.nextLine();
            System.out.println();

            if (userResponse.indexOf("go to") == 0) { // indexOf in case there's a weirdly named place
                String roomReq = userResponse.substring(6);
                if (current.hasNeighbor(roomReq)) {
                    current = g.getNode(roomReq);
                } else {
                    System.out.println("this room does not exist: " + roomReq);
                }

            } else if (userResponse.indexOf("look") == 0) {
                System.out.println("Your current room is " + current.getDescription());
                System.out.println("Your room options are: " + current.getNeighborNames() + "\n");

            } else if (userResponse.indexOf("add room") == 0) {
                String newRoomReq = userResponse.substring(9);
                g.addNode(newRoomReq, "no description written");
                g.addUndirectedEdge(current.getName(), newRoomReq);
                System.out.println(newRoomReq + " has been added as a room.\n");

            } else {
                System.out.println("What do you want to do?\t [go to <roomname>] [look] [add room <roomname>] [quit]");
            }

        } while (!userResponse.equals("quit"));

    }
}
