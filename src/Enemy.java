public class Enemy {

    private String shortName;
    private String longName;
    private String description;
    private int health;
    private Weapon weapon;
    private Room room;

    public Enemy(String shortName, String longName, String description, int health, Weapon weapon, Room room) {
        this.shortName = shortName;
        this.longName = longName;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
        this.room = room;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Room getRoom() {
        return room;
    }

    public boolean hit(int damage) {

        health = health - damage;

        return health <= 0;
    }

    public int attack() {
        if (weapon.canUse()) {
            return weapon.use();
        }

        return -1;
    }

    public void die() {
        room.addItem(weapon);
        room.removeEnemy(this);
    }

    public boolean attackPlayer(Player player) {
        if (!weapon.canUse()) {
            return false;
        }

        weapon.use();
        return player.hit(weapon.getDamage());
    }
}