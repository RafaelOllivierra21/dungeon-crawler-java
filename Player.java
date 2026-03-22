import java.util.ArrayList;

public class Player extends Entity{

    // declare inventory
    private ArrayList<Item> inventory;

    // constructor
    public Player (String name, int health, int attackPower){
        super (name, health, attackPower);
        this.inventory = new ArrayList<Item>();
    }

    @Override
    public String getType(){
        return "Player";
    }

    // returns inventory
    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    // add item to inventory and apply its effect to player
    public void addItem(Item item){
       if (item == null){
           return;
       }

        this.inventory.add(item);

        // check if item is lootable and apply effect
        if (item instanceof Lootable){
            Lootable loot = (Lootable) item;
            loot.use(this);
        }
    }

    public int getInventorySize(){
        return this.inventory.size();
    }

    // attacks target, reduces target's health and returns message
    public String attack(Entity target) {
        if (target == null){
            return "No Target to attack.";
        }

        target.takeDamage(this.getAttackPower());
        return this.getName() + " attacks " +
                target.getName() + " for " +
                this.getAttackPower() + " damage.";
    }
}
