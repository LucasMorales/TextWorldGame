
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("hall");
        g.addNode("closet");
        g.addNode("dungeon");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");

        Graph.Node current = g.getNode("hall");

        // game loop code

        String userResponse = "";
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("You are in the " + current.getName() + ".");
            System.out.println("What do you want to do?\t [go to <roomname>] [look] [add room <roomname>] [quit]");
            userResponse = in.nextLine();

            if (userResponse.indexOf("go to") == 0) { // indexOf in case there's a weirdly named place
                String roomReq = userResponse.substring(6);
                if (current.getNeighbor(roomReq) != null) current = g.getNode(roomReq);

            } else if (userResponse.indexOf("look") == 0) {
                System.out.println("Your options are: " + current.getNeighborNames() + "\n");

            } else if (userResponse.indexOf("add room") == 0) {
                g.addNode(userResponse);
                g.addDirectedEdge(current.getName(), userResponse);
                System.out.println(userResponse + " has been added as a room.\n");

            } else {
                System.out.println("What do you want to do?\t [go to <roomname>] [look] [add room <roomname>] [quit]");
            }

        } while (!userResponse.equals("quit"));

    }
}
