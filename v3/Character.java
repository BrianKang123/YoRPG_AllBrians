public class Character {
  protected int _hp;
  protected int _strength;
  protected int _defense;
  protected double _attack;

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
    int damage = (int)( (_strength * _attack) - enemy.getDefense() );

    if ( damage < 0 ) {
      damage = 0;
    }

    enemy.lowerHP(damage);
    return damage;
  }

  public int getHealth() {
    return _hp;
  }
}
