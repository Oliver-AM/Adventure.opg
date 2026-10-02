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
        }
        else {
            IO.println("You are carrying:");

            for (Item item : player.getInventory()) {
                IO.println(item.getLongName());
            }
        }

        if (player.getEquippedWeapon() != null) {
            IO.println("Equipped: " + player.getEquippedWeapon().getLongName());
        }
    }

    public void printHealth(Player player) {
        IO.println("health: " + player.getHealth());
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

    public void printCannotEat(String itemName) {
        IO.println("There is nothing like " + itemName + " to eat around here");
    }

    public void printNotFood(Item item) {
        IO.println("You cannot eat the " + item.getLongName());
    }

    public void printEaten(Food food) {
        IO.println("You eat the " + food.getLongName());
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
        IO.println("health");
        IO.println("eat <item>");
        IO.println("help");
        IO.println("exit");
        IO.println("equip <weapon>");
        IO.println("attack");
    }

    public void printUnknownCommand() {
        IO.println("I don't understand that command.");
    }

    public void printGoodbye() {
        IO.println("Goodbye!");
    }

    public void printEquipNotFound(String itemName) {
        IO.println("You don't have anything like " + itemName + " in your inventory");
    }

    public void printNotWeapon(Item item) {
        IO.println(item.getLongName() + " is not a weapon");
    }

    public void printEquipped(Item item) {
        IO.println("You have equipped " + item.getLongName());
    }

    public void printNoWeapon() {
        IO.println("You have no weapon equipped.");
    }

    public void printCannotAttack() {
        IO.println("You cannot attack with your weapon.");
    }

    public void printAttack(Weapon weapon, int remainingUses) {

        if (remainingUses == -1) {
            IO.println("You swing the " + weapon.getLongName() + " at the empty air.");
        }
        else {
            IO.println("You fire the " + weapon.getLongName() + " into the empty air. " + remainingUses + " shots left.");
        }
    }
}
