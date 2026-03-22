public class Sword extends Item implements Lootable{

    private int bonusDamage;

    public Sword (String name, String description, int bonusDamage){
        super (name, description);
        this.bonusDamage = bonusDamage;
    }

    public int getBonusDamage(){
        return this.bonusDamage;
    }

    @Override
    public void use (Player player){
        if (player == null){
            return;
        }

        player.setAttackPower(player.getAttackPower() + this.bonusDamage);
    }
}
