public class Map {

    private Room startRoom;

    public Map() {

        Room room1 = new Room("Room 1",
                "A dark entrance with cold air coming from deeper inside.");

        Room room2 = new Room("Room 2",
                "Water drips from the ceiling somewhere in the dark.");

        Room room3 = new Room("Room 3",
                "A narrow room with strange markings on the walls.");

        Room room4 = new Room("Room 4",
                "A large cave with an old wooden table.");

        Room room5 = new Room("Room 5",
                "A mysterious chamber glowing with a faint blue light.");

        Room room6 = new Room("Room 6",
                "A dusty room filled with broken pieces of stone.");

        Room room7 = new Room("Room 7",
                "A cold passage where you hear something moving nearby.");

        Room room8 = new Room("Room 8",
                "A quiet chamber with an ancient door.");

        Room room9 = new Room("Room 9",
                "A huge underground hall with a strange smell.");

        room1.setEast(room2);
        room2.setWest(room1);

        room2.setEast(room3);
        room3.setWest(room2);

        room1.setSouth(room4);
        room4.setNorth(room1);

        room2.setSouth(room5);
        room5.setNorth(room2);

        room3.setSouth(room6);
        room6.setNorth(room3);

        room4.setEast(room5);
        room5.setWest(room4);

        room5.setEast(room6);
        room6.setWest(room5);

        room4.setSouth(room7);
        room7.setNorth(room4);

        room5.setSouth(room8);
        room8.setNorth(room5);

        room6.setSouth(room9);
        room9.setNorth(room6);

        // Items

        room1.addItem(new Item("watch", "an old watch that still follows the clock?"));

        room1.addItem(new Item("coins", "some gold coins"));

        room2.addItem(new Item("key", "an old rusty key"));

        room4.addItem(new Item("map", "an old treasure map"));

        room5.addItem(new Item("sword", "an old sword"));

        room5.addItem(new MeleeWeapon("sword", "a rusty sword"));
        room5.addItem(new RangedWeapon("revolver", "a dusty revolver", 6));

        room8.addItem(new Item("book", "an old book"));

        Food bread = new Food("bread", "a loaf of bread", 10);
        Food mushroom = new Food("mushroom", "a mysterious glowing mushroom", -50);

        room1.addItem(bread);
        room2.addItem(mushroom);

        startRoom = room1;
    }

    public Room getStartRoom() {
        return startRoom;
    }

}
