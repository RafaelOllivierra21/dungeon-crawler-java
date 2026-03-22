import java.util.ArrayList;

public class Room {

    private String name;
    private ArrayList<Enemy> enemies;
    private ArrayList<Item> loot;

    // constructor
    public Room (String name){
        this.name = name;
        this.enemies = new ArrayList<Enemy>();
        this.loot = new ArrayList<Item>();
    }

    // return room name
    public String getName() {
        return this.name;
    }

    // add enemy to the room
    public void addEnemy (Enemy enemy){
        if (enemy == null){
            return;
        }
        this.enemies.add(enemy);
    }

    // add loot to the room
    public void addLoot (Item item){
        if (item == null){
            return;
        }
        this.loot.add(item);
    }

    // return enemies list
    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    // return loot list
    public ArrayList<Item> getLoot() {
        return this.loot;
    }

    // return only enemies that are alive
    public ArrayList<Enemy> getAliveEnemies() {
        ArrayList<Enemy> alive = new ArrayList<Enemy>();

        for (int i = 0; i < this.enemies.size(); i++) {
            if (this.enemies.get(i).isAlive()) {
                alive.add(this.enemies.get(i));
            }
        }
        return alive;
    }

    // return true if all enemies are dead
    public boolean isCleared() {
        for (int i = 0; i < this.enemies.size(); i++) {
            if (this.enemies.get(i).isAlive()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Room: " + this.name +
                " [Enemies: " + this.enemies.size() +
                ", Loot: " + this.loot.size() + "]";
    }

    // clears all loot in room once collected
    public void clearLoot(){
        this.loot.clear();
    }
}