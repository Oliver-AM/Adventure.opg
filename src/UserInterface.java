public class UserInterface {

    public String getCommand() {
        return IO.readln("> ");
    }

    public void printRoom(Room room) {

        IO.println("You are in " + room.getName());
        IO.println(room.getDescription());

        if (room.getItems().isEmpty()) {
            return;
        }

        IO.println("Here you see:");

        for (Item item : room.getItems()) {
            IO.println(item.getLongName());
        }
    }

    public void printInventory(Player player) {

        if (player.getInventory().isEmpty()) {
            IO.println("You are not carrying anything.");
            return;
        }

        IO.println("You are carrying:");

        for (Item item : player.getInventory()) {
            IO.println(item.getLongName());
        }
    }

    public void printTaken(Item item) {
        IO.println("You have taken " + item.getLongName());
    }

    public void printDropped(Item item) {
        IO.println("You have dropped " + item.getLongName());
    }

    public void printCannotTake(String itemName) {
        IO.println("There is nothing like " + itemName + " to take around here");
    }

    public void printCannotDrop(String itemName) {
        IO.println("You don't have anything like " + itemName + " in your inventory");
    }

    public void printCannotGoThatWay() {
        IO.println("You cannot go that way");
    }

    public void printHelp() {
        IO.println("Available commands:");
        IO.println("go north");
        IO.println("go east");
        IO.println("go south");
        IO.println("go west");
        IO.println("look");
        IO.println("inventory");
        IO.println("take <item>");
        IO.println("drop <item>");
        IO.println("help");
        IO.println("exit");
    }

    public void printUnknownCommand() {
        IO.println("I don't understand that command.");
    }
}
