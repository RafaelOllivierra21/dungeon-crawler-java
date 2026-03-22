public abstract class Entity {
    // encapsulated attribute declaration
    private String name;
    private int health;
    private int attackPower;

    //constructor
    public Entity(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // accessor methods
    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    // mutator methods
    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    // returns true once entity health is above 0
    public boolean isAlive() {
        if (this.health > 0) {
            return true;
        }
        return false;
    }

    // reduces health by damage amount and maintains health to be above 0
    public void takeDamage(int damage) {
        if(damage < 0){     // avoid adding health by subtracting a negative number e.g. 2 - (-2) = 4
            damage = 0;
        }
        this.health = this.health - damage;

        if (this.health < 0) {
            this.health = 0;
        }
    }

    // abstract method
    public abstract String getType();

    @Override
    public String toString() {
        return "[" + getType() + "] " + this.name +
                " (HP: " + this.health +
                ", ATK: " + this.attackPower + ")";

    }
}
