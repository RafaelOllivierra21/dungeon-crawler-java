public class Boss extends Enemy{

    public Boss (String name, int health, int attackPower){
        super (name, health, attackPower);
    }

    @Override
    public String getType(){
        return "Boss";
    }

    // attacks target, reduces target's health by 2 times atk and returns message
    @Override
    public String attack(Entity target) {
        if (target == null){
            return "No Target to attack.";
        }

        int damage = 2 * this.getAttackPower();
        target.takeDamage(damage);
        return this.getName() + " attacks " +
                target.getName() + " for " +
                damage + " damage.";
    }
}
