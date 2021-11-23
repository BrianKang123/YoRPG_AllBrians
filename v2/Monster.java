public class Monster extends Character {
    public Monster() {
        _hp = 150;
        _strength = 20 + (int) (Math.random() * 45); // [20,65)
        _defense = 20;
        _attack = 1;
    }
}