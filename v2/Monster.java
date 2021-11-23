public class Monster extends Character{
    private int health = 100;
    private int baseAttackDamage = 10;
    private int attackVariation = 2;

    public int getHealth() {
        return health;
    }

    public void loseHealth(int damage) {
        health = health - damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int attack(Protagonist p) {
        return super.attack(p);
    }


}
