import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int health = 100;

    public Player(Room startRoom) {
        currentRoom = startRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getHealth() {
        return health;
    }

    public boolean moveNorth() {
        if (currentRoom.getNorth() == null) {
            return false;
        }

        currentRoom = currentRoom.getNorth();
        return true;
    }

    public boolean moveEast() {
        if (currentRoom.getEast() == null) {
            return false;
        }

        currentRoom = currentRoom.getEast();
        return true;
    }

    public boolean moveSouth() {
        if (currentRoom.getSouth() == null) {
            return false;
        }

        currentRoom = currentRoom.getSouth();
        return true;
    }

    public boolean moveWest() {
        if (currentRoom.getWest() == null) {
            return false;
        }

        currentRoom = currentRoom.getWest();
        return true;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item findItem(String shortName) {

        for (Item item : inventory) {
            if (item.getShortName().equals(shortName)) {
                return item;
            }
        }

        return null;
    }

    public Item takeItem(String shortName) {

        Item item = currentRoom.findItem(shortName);

        if (item != null) {
            currentRoom.removeItem(item);
            inventory.add(item);
            return item;
        }

        return null;
    }

    public Item dropItem(String shortName) {

        Item item = findItem(shortName);

        if (item != null) {
            inventory.remove(item);
            currentRoom.addItem(item);
            return item;
        }

        return null;
    }

    public EatResult eat(String shortName) {

        Item item = findItem(shortName);

        if (item == null) {
            item = currentRoom.findItem(shortName);
        }

        if (item == null) {
            return EatResult.NOT_FOUND;
        }

        if (!(item instanceof Food)) {
            return EatResult.NOT_FOOD;
        }

        Food food = (Food) item;
        health = health + food.getHealthPoints();

        inventory.remove(item);
        currentRoom.removeItem(item);

        return EatResult.EATEN;
    }

    public Item findItemAnywhere(String shortName) {

        Item item = findItem(shortName);

        if (item == null) {
            item = currentRoom.findItem(shortName);
        }

        return item;
    }
}
