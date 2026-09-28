public class Adventure {

    private UserInterface ui;
    private Map map;
    private Player player;

    public Adventure() {
        ui = new UserInterface();
        map = new Map();
        player = new Player(map.getStartRoom());
    }

    public void startGame() {

        ui.printRoom(player.getCurrentRoom());

        boolean running = true;

        while (running) {

            String command = ui.getCommand();

            if (command.equals("exit")) {
                running = false;
            }

            else if (command.equals("help")) {
                ui.printHelp();
            }

            else if (command.equals("look")) {
                ui.printRoom(player.getCurrentRoom());
            }

            else if (command.equals("inventory") || command.equals("inv")) {
                ui.printInventory(player);
            }

            else if (command.startsWith("take ")) {

                String itemName = command.substring(5);

                Item item = player.takeItem(itemName);

                if (item != null) {
                    ui.printTaken(item);
                }
                else {
                    ui.printCannotTake(itemName);
                }
            }

            else if (command.startsWith("drop ")) {

                String itemName = command.substring(5);

                Item item = player.dropItem(itemName);

                if (item != null) {
                    ui.printDropped(item);
                }
                else {
                    ui.printCannotDrop(itemName);
                }
            }

            else if (command.equals("go north")) {
                if (player.moveNorth()) {
                    ui.printRoom(player.getCurrentRoom());
                } else {
                    ui.printCannotGoThatWay();
                }
            }

            else if (command.equals("go east")) {
                if (player.moveEast()) {
                    ui.printRoom(player.getCurrentRoom());
                } else {
                    ui.printCannotGoThatWay();
                }
            }

            else if (command.equals("go south")) {
                if (player.moveSouth()) {
                    ui.printRoom(player.getCurrentRoom());
                } else {
                    ui.printCannotGoThatWay();
                }
            }

            else if (command.equals("go west")) {
                if (player.moveWest()) {
                    ui.printRoom(player.getCurrentRoom());
                } else {
                    ui.printCannotGoThatWay();
                }
            }

            else {
                ui.printUnknownCommand();
            }
        }

        IO.println("Goodbye!");
    }


}
