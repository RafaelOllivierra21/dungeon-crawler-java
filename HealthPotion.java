public class HealthPotion extends Item implements Lootable{

    private int healAmount;

    public HealthPotion (String name, String description, int healAmount){
        super (name, description);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return this.healAmount;
    }

    @Override
    public void use (Player player){
        if (player == null){
            return;
        }

        player.setHealth(player.getHealth() + this.healAmount);
    }
}
