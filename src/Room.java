import java.util.ArrayList;

public class Room {
    private String name;
    private String description;

    private Room north;
    private Room east;
    private Room south;
    private Room west;

    private ArrayList<Item> items = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setNorth(Room room) {
        north = room;
    }

    public Room getNorth() {
        return north;
    }

    public void setEast(Room room) {
        east = room;
    }

    public Room getEast() {
        return east;
    }

    public void setSouth(Room room) {
        south = room;
    }

    public Room getSouth() {
        return south;
    }

    public void setWest(Room room) {
        west = room;
    }

    public Room getWest() {
        return west;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item findItem(String shortName) {

        for (Item item : items) {
            if (item.getShortName().equals(shortName)) {
                return item;
            }
        }

        return null;
    }
}
