
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.init();
        Player p = new Player("Lucas", "a cool dude");
        p.setCurrentRoom(g.getRoom("hall"));

        // game loop code below

        String userResponse = "";
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("You are in the " + p.getCurrentRoom().getName() + ".");
            System.out.println("What do you want to do? Your options are:");
            System.out.println("[go to <roomName>]\t[look]\t[pick up <item>]\t[drop <item>]\t[add room <roomName>]\t[quit]");
            userResponse = in.nextLine();
            System.out.println();

            if (userResponse.indexOf("go to") == 0) { // indexOf in case there's a weirdly named place
                String roomReq = userResponse.substring(6);
                if (p.getCurrentRoom().hasNeighbor(roomReq)) {
                    p.setCurrentRoom(g.getRoom(roomReq));
                } else {
                    System.out.println("this room does not exist: " + roomReq);
                }

            } else if (userResponse.indexOf("look") == 0) {
                System.out.println("Your current room is described as " + p.getCurrentRoom().getDescription());
                p.getCurrentRoom().displayItems();
                System.out.println("Your room options are: " + p.getCurrentRoom().getNeighborNames() + "\n");

            } else if (userResponse.indexOf("pick up") == 0) {
                String itemReq = userResponse.substring(8);
                if (p.getCurrentRoom().hasItem(itemReq)) {
                    Item pickedUp = p.getCurrentRoom().removeItem(itemReq);
                    p.addItemToInventory(pickedUp);
                } else {
                    System.out.println("item does not exist here");
                }
                p.displayInventory();
            } else if (userResponse.indexOf("drop") == 0) {
                String itemDrop = userResponse.substring(5);
                if (p.hasItem(itemDrop)) {
                    Item movedItem = p.removeItemFromInventory(itemDrop);
                    p.getCurrentRoom().addItem(movedItem);
                } else {
                    System.out.println("item not in inventory");
                }
            } else if (userResponse.indexOf("add room") == 0) {
                String newRoomReq = userResponse.substring(9);
                g.addRoom(newRoomReq, "[ no description written ]");
                g.addUndirectedEdge(p.getCurrentRoom().getName(), newRoomReq);
                System.out.println(newRoomReq + " has been added as a room.\n");
                // this seems like a weird command, also ADD a checker to see if a room with that name exists already
            } else {
                System.out.println("What do you want to do?\t [go to <roomname>] [look] [add room <roomname>] [quit]");
            }

        } while (!userResponse.equals("quit"));

    }
}
