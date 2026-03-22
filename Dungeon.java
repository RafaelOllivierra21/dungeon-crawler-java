import java.util.ArrayList;

public class Dungeon {

    private ArrayList<Room> rooms;
    private Player player;
    private int currentRoomIndex;

    // constructor that accepts a player
    public Dungeon (Player player){
        this.rooms = new ArrayList<Room>();
        this.player = player;
        this.currentRoomIndex = 0;
    }

    // adds a room to dungeon
    public void addRoom (Room room){
        if (room == null){
            return;
        }
        this.rooms.add(room);
    }

    // return the player
    public Player getPlayer() {
        return this.player;
    }

    // returns rooms list
    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    // returns the room that the player is currently in
    public Room getCurrentRoom(){
        if (this.rooms.isEmpty()) {
            return null;
        }
        return this.rooms.get(this.currentRoomIndex);
    }

    // moves to next room only if current room is cleared
    public boolean moveToNextRoom(){
        if (this.currentRoomIndex < (this.rooms.size() - 1) && this.rooms.get(this.currentRoomIndex).isCleared()){
            this.currentRoomIndex ++;
            return true;
        }
        return false;
    }

    // runs one combat round
    public ArrayList<String> combatRound(){
        ArrayList<String> log = new ArrayList<String>();

        if (this.player == null || !this.player.isAlive()) {
            return log;
        }

        Room current = getCurrentRoom();
        if (current == null) {
            return log;
        }

        // return empty log if there are no alive enemies
        if (current.getAliveEnemies().isEmpty()) {
            return log;
        }

        // player attacks the first alive enemy
        Enemy target = current.getAliveEnemies().get(0);
        // add player's attack message to log
        log.add(this.player.attack(target));

        // each alive enemy attacks the player
        ArrayList<Enemy> aliveAfter = current.getAliveEnemies();
        for (int i = 0; i < aliveAfter.size(); i++) {
            // add each enemy's attack message
            log.add(aliveAfter.get(i).attack(this.player));
            // if player dies, stop immediately and add defeat message
            if (!this.player.isAlive()) {
                log.add(this.player.getName() + " has been defeated!");
                break;
            }
        }
        // Return the log
        return log;
    }

    // loots room if cleared and add items to player's inventory
    public ArrayList<Item> lootRoom(){
        ArrayList<Item> looted = new ArrayList<Item>();

        Room current = getCurrentRoom();
        if (current == null) {
            return looted;
        }

        if (!current.isCleared()) {
            return looted;
        }

        ArrayList<Item> roomLoot = current.getLoot();

        for (int i = 0; i < roomLoot.size(); i++) {
            Item item = roomLoot.get(i);
            this.player.addItem(item);
            looted.add(item);
        }

        current.clearLoot();    // clear all loot
        return looted;
    }

    // returns true if player dies
    public boolean isGameOver(){
        if (!this.player.isAlive()){
            return true;
        }
        return false;
    }

    // returns true if player is alive and clears last room
    public boolean isGameWon(){
        if (this.player.isAlive()){
            if(this.currentRoomIndex == this.rooms.size() - 1){
                if(this.rooms.get(this.currentRoomIndex).isCleared()){
                    return true;
                }
            }
        }
        return false;
    }
}
