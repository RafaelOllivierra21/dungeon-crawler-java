public class Enemy extends Entity{

    public Enemy (String name, int health, int attackPower){
        super (name, health, attackPower);
    }

    @Override
    public String getType(){
        return "Enemy";
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
