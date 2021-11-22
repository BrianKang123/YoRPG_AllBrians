public class Character{
  private int _hp = 100;
  private int _strength = 10;
  private int _defense = 10;
  private double _attack = 0.9;

  // public Character (int hp, int strength, int defense, double attack){
  //   _hp = hp;
  //   _strength = strength;
  //   _defense = defense;
  //   _attack = attack;
  // }

  public boolean isAlive() {
    return _hp > 0;
  }

  public int getDefense() {
    return _defense;
  }

  public void lowerHP(int dmg) {
    _hp = _hp - dmg;
  }

  public int attack(Character enemy) {
    int damage = (int)((_strength * _attack) - enemy.getDefense());
    enemy.lowerHP(damage);
    return damage;
  }
}
